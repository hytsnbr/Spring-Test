package com.hytsnbr.steam_tool.executor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hytsnbr.base_common.exception.common.SystemException;
import com.hytsnbr.steam_tool.constant.GenerateFileType;

public abstract sealed class AbstractCreator permits InterfaceCreator, RequestCreator, UrlListCreator {
    
    private static final String RESULT_DIR_PATH = "app/steam-tool/result/";
    
    private static final String TEMPLATE_PATH = "templates/";
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * ファイル生成実行
     *
     * @throws SystemException 処理中にエラーが発生した場合
     */
    abstract void execute() throws SystemException;
    
    /**
     * 生成先ディレクトリクリーンアップ
     *
     * @param generateFileType 生成ファイルタイプ
     *
     * @throws IOException クリーンアップ時にエラーが発生した場合
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    protected void cleanResultDirectory(GenerateFileType generateFileType) throws IOException {
        Path dir = Paths.get(RESULT_DIR_PATH + generateFileType.getGenerateDirName());
        if (Files.exists(dir)) {
            try (Stream<Path> stream = Files.walk(dir)) {
                if (Files.exists(dir)) {
                    stream.map(Path::toFile).forEach(File::delete);
                }
            }
        } else {
            Files.createDirectories(dir);
        }
    }
    
    /**
     * ファイル生成
     *
     * @param generateFileType 生成ファイルタイプ
     * @param fileName         生成ファイル名
     * @param context          {@link Context} Apache Velocity Context
     */
    protected void generateFiles(GenerateFileType generateFileType, String fileName, Context context) {
        Template template = this.getTemplate(generateFileType);
        
        Path path = Paths.get(RESULT_DIR_PATH + generateFileType.getGenerateDirName(), fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            if (Files.notExists(path)) {
                Files.createFile(path);
            }
            template.merge(context, bufferedWriter);
        } catch (Exception e) {
            logger.error(e);
            
            throw new SystemException(e.getMessage());
        }
    }
    
    /**
     * Apache Velocity テンプレート取得
     *
     * @param generateFileType 生成ファイルタイプ
     *
     * @return {@link Template} Apache Velocity Template
     */
    private Template getTemplate(GenerateFileType generateFileType) {
        return Velocity.getTemplate(TEMPLATE_PATH + generateFileType.getTemplateName(), StandardCharsets.UTF_8.name());
    }
}

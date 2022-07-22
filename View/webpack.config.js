// モジュール・プラグイン読み込み
const path = require("path");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const CssMinimizerPlugin = require("css-minimizer-webpack-plugin");
const Dotenv = require('dotenv-webpack');

// 出力先パス
const outputPath = path.resolve(__dirname, "dist");
// プロダクション環境か
const isProduction = process.env.NODE_ENV === "prod";
// ソースマップの利用有無(開発時はソースマップを利用しない)
const enabledSourceMap = isProduction;
// ソースマップが有効の場合は出力する
const sourceMapMode = enabledSourceMap ? "source-map" : "eval";

// 以下設定
module.exports = {
  // エントリポイント
  // 単一ファイル指定
  // entry: "./src/index.js",
  // 複数ファイル指定
  entry: {
    // エントリ名をつけて指定
    index: "./src/index.js",
    vendor: "./src/vendor.js",
  },
  // entity: [ "./src/index.js", "./src/vendor.js" ], // 複数ファイルをバンドルする場合

  // 出力ファイル設定
  output: {
    // ビルド時に出力先フォルダ内を削除
    clean: {
      // html ファイルは削除しない
      keep: /\.html/
    },
    //  出力先パス
    path: outputPath,
    // 出力ファイル名
    filename: 'js/[name].js',
    // アセットファイルの出力名を設定
    assetModuleFilename: "image/[name]-[hash][ext][query]",
  },

  // watch オプション付与時の設定
  watchOptions: {
    // 監視対象から除外するフォルダ・ファイル
    ignored: ["/node_modules/**"],
  },

  // webpack-dev-server 設定
  devServer: {
    static: {
      directory: path.join(outputPath),  // サーバ起動時の初期パス
    },
    compress: true, // 圧縮するか
    open: true, // サーバ起動時にWebページを開くか
    port: 9999  // サーバポート
  },

  module: {
    rules: [
      {
        // 対象となるファイルの拡張子(scss)
        test: /\.(scss|sass|css)$/,
        // Sassファイルの読み込みとコンパイル
        use: [
          // CSSファイルを書き出すオプションを有効にする
          {
            loader: MiniCssExtractPlugin.loader,
          },
          // CSSをバンドルするための機能
          {
            loader: "css-loader",
            options: {
              // オプションでCSS内のurl()メソッドを取り込まない
              // url: false,
              // ソースマップの利用有無
              sourceMap: enabledSourceMap,
              // 0 => ローダーなし（デフォルト）
              // 1 => postcss-loader;
              // 2 => postcss-loader, sass-loader
              importLoaders: 2,
            },
          },
          // PostCSSのための設定
          {
            loader: "postcss-loader",
            options: {
              // PostCSS側でもソースマップを有効にする
              sourceMap: enabledSourceMap,
            },
          },
          // Sassをバンドルするための機能
          {
            loader: "sass-loader",
            options: {
              // ソースマップの利用有無
              sourceMap: enabledSourceMap,
            },
          },
        ],
      },
      {
        // 対象拡張子: png, jpg(jpeg), svg, gif, webp
        test: /\.(png|jpg|jpeg|svg|gif|webp)$/,
        // 出力方法の設定
        type: "asset",
        parser: {
          dataUrlCondition: {
            maxSize: 4 * 1024,
          }
        }
      },
      {
        // 対象拡張子: js
        test: /\.js$/,
        use: [
          {
            // Babel を利用する
            loader: "babel-loader",
            // Babel のオプションを指定する
            options: {
              presets: [
                // プリセットを指定することで、ES2021 を ES5 に変換
                "@babel/preset-env",
              ],
            },
          },
        ],
      },
    ],
  },
  optimization: {
    //モードに関わらず常に圧縮を有効にする場合は指定
    // minimize: true,
    minimizer: [
      `...`,  //JavaScript の圧縮を有効に（デフォルトの圧縮の設定を適用）
      new CssMinimizerPlugin({
        parallel: true,  //ビルド速度を向上
      }),
    ],
  },
  plugins: [
    // CSSを別ファイルとして出力するプラグイン
    new MiniCssExtractPlugin({
      // 出力時のファイル名
      filename: "css/style.css",
    }),
    // .env読み込みプラグイン
    new Dotenv({
      path: path.resolve(__dirname, `.env.${process.env.NODE_ENV}`),
    }),
  ],

  // ソースマップ出力設定
  devtool: sourceMapMode,
};

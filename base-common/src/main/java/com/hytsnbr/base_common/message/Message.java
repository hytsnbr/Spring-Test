package com.hytsnbr.base_common.message;

public class Message {
    
    private final String msgKey;
    
    private final MessageType msgType;
    
    public Message(String msgKey) {
        this(msgKey, MessageType.NORMAL);
    }
    
    public Message(String msgKey, MessageType msgType) {
        this.msgKey = msgKey;
        this.msgType = msgType;
    }
    
    public static String getMessage() {
        // TODO: implements
        return "";
    }
    
    public MessageType getMessageType() {
        return msgType;
    }
}
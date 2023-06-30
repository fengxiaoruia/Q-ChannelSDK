package com.feng.enums;

public enum OpcodeEnum {

    DISPATCH(0, "服务端进行消息推送"),  // Receive
    HEARTBEAT(1, "客户端或服务端发送心跳"), // Send/Receive
    IDENTIFY(2, "客户端发送鉴权"), // Send
    RESUME(6, "客户端恢复连接"), // Send
    RECONNECT(7, "服务端通知客户端重新连接"), //Receive

    INVALID_SESSION(9, "当identify或resume的时候，如果参数有错，服务端会返回该消息"), // Receive

    HELLO(10, "当客户端与网关建立ws连接之后，网关下发的第一条消息"), //Receive

    HEARTBEAT_ACK(11, "当发送心跳成功之后，就会收到该消息"), //Receive/Reply

    HTTP_CALLBACK_ACK(12, "仅用于 http 回调模式的回包，代表机器人收到了平台推送的数据"); // Reply



    private final int code;
    private final String info;

    private OpcodeEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }

    public String getCodeToString() {
        return String.valueOf(this.code);
    }

    public static OpcodeEnum getEnumByKey(Integer code) {
        for (OpcodeEnum temp : OpcodeEnum.values()) {
            if (temp.getCode() == code) {
                return temp;
            }
        }
        return null;
    }

    public static String getEnumInfoByKey(Integer code) {
        for (OpcodeEnum temp : OpcodeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getInfo();
            }
        }
        return null;
    }
}

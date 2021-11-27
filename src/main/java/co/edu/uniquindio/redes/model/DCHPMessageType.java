package co.edu.uniquindio.redes.model;

public enum DCHPMessageType {
    REQUEST,
    RESPONSE;

    static DCHPMessageType of(byte type){
        switch (type){
            case 1: return REQUEST;
            case 2: return RESPONSE;
            default: throw new RuntimeException("Invalid DHCP Message Type ");
        }
    }
}

package co.edu.uniquindio.redes.model.dhcp.options;

import java.util.Arrays;

//https://www.rfc-editor.org/rfc/rfc1533.html
//https://www.rfc-editor.org/rfc/rfc2132.html
public enum DHCPOptionType {
    //53, 61, 55, 1, 3, 6, 51, 54.
    PAD(0,0),
    END(255,0),
    SUBNET_MASK(1,4),
    TIME_OFFSET(2,4),
    ROUTER(3,-1),
    TIME_SERVER_OPTION(4,-1),
    DOMAIN_SERVER(6,-1),
    HOST_NAME(12,-1),
    REQUEST_IP_ADDRESS(50,4),
    IP_ADDRESS_LEASE_TIME(51,4),
    DHCP_MESSAGE_TYPE(53,1),
    SERVER_IDENTIFIER(54,4),
    PARAMETER_REQUEST_LIST(55,-1),
    VENDOR_CLASS_IDENTIFIER(60,-1),
    CLIENT_IDENTIFIER(61,-1),
    AUTOCONFIGURATION(116,-1),
    UNKNOW(-1,-1);

    private byte code;
    private int length;

    DHCPOptionType(int code,int length) {
        this.code = (byte) code;
        this.length = length;
    }

    public static DHCPOptionType of(byte type){
        return Arrays.stream(values()).filter( t->t.code==type ).findAny().orElse(UNKNOW);
    }

    public byte getCode() {
        return code;
    }

    public int getLength() {
        return length;
    }

    public int getMinLength() {
        return isLengthFixed() ? 1 : 2;
    }

    public boolean isLengthFixed(){
        return length == 0;
    }

    public boolean isLengthVariable(){
        return length != 0;
    }
}

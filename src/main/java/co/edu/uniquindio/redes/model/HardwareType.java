package co.edu.uniquindio.redes.model;

import java.util.Arrays;

//http://www.networksorcery.com/enp/protocol/arp.htm#Hardware%20type
public enum HardwareType {
    ETHERNET(1),
    T_802_11(2),
    AMATEUR_RADIO_AX_25(3),
    PROTEON(4),
    CHAOS(5),
    IEEE_802(6),
    ARCNET(7),
    HYPERCHANNEL(8),
    LANSTAR(9),
    UNDEFINED(0);

    private byte code;

    HardwareType(int code) {
        this.code = (byte) code;
    }

    public static HardwareType of(byte type){
        return Arrays.stream(values()).filter( t->t.code==type ).findAny().orElseThrow(
                ()->{throw new RuntimeException("Invalid Hardware type");}
        );
    }
}

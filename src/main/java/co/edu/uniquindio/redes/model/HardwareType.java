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
    UNDEFINED(0),
    AUTONET_SHORT_ADDRESS(10),
    LOCALTALK(12),
    ULTRA_LINK(13),
    SMDS(14),
    FRAME_RELAY(15),
    ATM(16),
    HDLC(17),
    FIBRE_CHANNEL(18),
    SERIAL_LINE(20),
    MIL_STD_188_220(22),
    METRICOM(23),
    IEEE_1394_1995(24),
    MAPOS(25),
    TWINAXIAL(26),
    EUI_64(27),
    HIPARP(28),
    IP_AND_ARP_OVER_ISO_7816_3(29),
    ARPSEC(30),
    IPSEC_TUNNEL(31),
    INFINIBAND(32),
    CAI(33),
    WIEGAND_INTERFACE(34),
    PURE_IP(35),
    HW_EXP1(36),
    HW_EXP2(256),
    AETHERNET(257),
    RESERVED (65535);

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

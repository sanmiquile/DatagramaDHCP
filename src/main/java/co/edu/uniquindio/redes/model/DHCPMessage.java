package co.edu.uniquindio.redes.model;

import co.edu.uniquindio.redes.model.dhcp.options.DHCPOption;
import co.edu.uniquindio.redes.model.dhcp.options.DHCPOptionFactory;
import co.edu.uniquindio.redes.model.dhcp.options.DHCPOptionType;
import co.edu.uniquindio.redes.util.ByteUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class DHCPMessage {
    private final DataFrame dataFrame;
    private final DataGramaIP dataGramaIP;
    private final UDPSegment udpSegment;
    private final byte[] data;
    private final byte op;
    private final byte htype;
    private final DCHPMessageType messageType;
    private final HardwareType hardwareType;
    private final int hlen;
    private final byte[] xid;
    private final byte[] clientAddressIP;
    private final byte[] suAddressIP;
    private final byte[] siAddressIP;
    private final byte[] hardwareClientAddress;
    private final byte[] magicCokkie;
    private final Set<DHCPOption> options;

    public DHCPMessage(byte[] data) {
        dataFrame = new DataFrame(data);
        dataGramaIP = new DataGramaIP(dataFrame.getUserData());
        udpSegment = new UDPSegment(dataGramaIP.getUserData());
        this.data = Arrays.copyOf(udpSegment.getUserData(),udpSegment.getUserData().length);
        op = this.data[0];
        messageType = DCHPMessageType.of(op);
        htype = this.data[1];
        hardwareType = HardwareType.of(htype);
        hlen = Byte.toUnsignedInt( this.data[2] );
        xid = Arrays.copyOfRange(this.data,4,8);
        clientAddressIP = Arrays.copyOfRange(this.data,12,16);
        suAddressIP = Arrays.copyOfRange(this.data,16,20);
        siAddressIP = Arrays.copyOfRange(this.data,20,24);
        hardwareClientAddress = Arrays.copyOfRange(this.data,28,28+hlen);//44);
        //sname 64 bytes ... -> 108
        //file 128 byte ... -> 236
        //magic cokkie 4 bytes ... -> 240
        magicCokkie = Arrays.copyOfRange(this.data,236,240);
        int start = 240;
        options = new LinkedHashSet<>();
        while( start < this.data.length ){
            DHCPOption option = DHCPOptionFactory.create(DHCPOptionType.of(this.data[start]));
            start += option.readFrom(this.data,start);
            options.add( option );
        }
    }

    public int getLength(){
        return data.length;
    }

    public DCHPMessageType getMessageType() {
        return messageType;
    }

    public HardwareType getHardwareType() {
        return hardwareType;
    }

    public int getHlen() {
        return hlen;
    }

    public byte[] getXid() {
        return xid;
    }

    public String getXidString() {
        return ByteUtils.hexaToString(xid);
    }

    public byte[] getClientAddressIP() {
        return clientAddressIP;
    }

    public String getClientAddressIPString() {
        return ByteUtils.ipFormat(clientAddressIP);
    }

    public byte[] getSuAddressIP() {
        return suAddressIP;
    }

    public String getSuAddressIPString() {
        return ByteUtils.ipFormat(suAddressIP);
    }

    public byte[] getSiAddressIP() {
        return siAddressIP;
    }

    public String getSiAddressIPString() {
        return ByteUtils.ipFormat(siAddressIP);
    }

    public byte[] getHardwareClientAddress() {
        return hardwareClientAddress;
    }

    public String getHardwareClientAddressString() {
        return ByteUtils.hexaToString(hardwareClientAddress);
    }

    public String getMagicCokkie() {
        return ByteUtils.hexaToString(magicCokkie);
    }

    public Set<DHCPOption> getOptions() {
        return Collections.unmodifiableSet(options);
    }

    public String getDestinationMacAddress() {
        return dataFrame.getDestinationAddressString();
    }

    public String getSourceMacAddress() {
        return dataFrame.getSourceAddressString();
    }

    public String getSourceAddressIP() {
        return dataGramaIP.getSourceAddressIPString();
    }

    public String getDestinationAddressIP() {
        return dataGramaIP.getDestinationAddressIPString();
    }

    public int getSourcePort() {
        return udpSegment.getSourcePort();
    }

    public int getDestinationPort() {
        return udpSegment.getDestinationPort();
    }

    public int getUDPSegmentLength(){
        return udpSegment.getLength();
    }
}

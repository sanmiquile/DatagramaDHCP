package co.edu.uniquindio.redes.model;

import co.edu.uniquindio.redes.util.ByteUtils;

import java.util.Arrays;

public class DataFrame {
    private final byte[] data;
    private final byte[] destinationAddress;
    private final byte[] sourceAddress;
    private final byte[] userData;
//    private final byte[] fcs;

    public DataFrame(byte[] data) {
        this.data = Arrays.copyOf(data,data.length);
//        destinationAddress = ByteUtils.extract(data,0,6);
//        sourceAddress = ByteUtils.extract(data,6,6);
//        fcs = ByteUtils.extract(data,12,2);
//        userData = ByteUtils.extract(data,14,data.length - 14);
        destinationAddress = Arrays.copyOfRange(data,0,6);
        sourceAddress = Arrays.copyOfRange(data,6,12);
//        fcs = Arrays.copyOfRange(data,12,14);
        userData = Arrays.copyOfRange(data,14,data.length);
    }

    public byte[] getDestinationAddress() {
        return destinationAddress;
    }

    public String getDestinationAddressString() {
        return ByteUtils.hexaToString(destinationAddress);
    }

    public byte[] getSourceAddress() {
        return sourceAddress;
    }

    public String getSourceAddressString() {
        return ByteUtils.hexaToString(sourceAddress);
    }

    public byte[] getUserData() {
        return userData;
    }


}

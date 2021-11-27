package co.edu.uniquindio.redes.model;

import co.edu.uniquindio.redes.util.ByteUtils;

import java.util.Arrays;

public class UDPSegment {
    private final byte[] data;
    private final byte[] userData;
    private final int sourcePort;
    private final int destinationPort;
    private final int length;
    private final int checkSum;

    public UDPSegment(byte[] data) {
        this.data = Arrays.copyOf(data,data.length);
        sourcePort = ByteUtils.toInt( Arrays.copyOfRange(data,0,2) );
        destinationPort = ByteUtils.toInt( Arrays.copyOfRange(data,2,4) );
        length = ByteUtils.toInt( Arrays.copyOfRange(data,4,6) );
        checkSum = ByteUtils.toInt( Arrays.copyOfRange(data,6,8) );
        userData = Arrays.copyOfRange(data,8,data.length);
    }

    public int getSourcePort() {
        return sourcePort;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public int getLength() {
        return length;
    }

    public int getCheckSum() {
        return checkSum;
    }

    public byte[] getUserData() {
        return userData;
    }
}

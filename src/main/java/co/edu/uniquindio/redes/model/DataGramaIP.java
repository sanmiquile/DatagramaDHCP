package co.edu.uniquindio.redes.model;

import co.edu.uniquindio.redes.util.ByteUtils;

import java.util.Arrays;

public class DataGramaIP {
    private final byte[] data;
    private final byte[] sourceAddressIP;
    private final byte[] destinationAddressIP;
    private final byte[] userData;

    public DataGramaIP(byte[] data) {
        this.data = Arrays.copyOf(data,data.length);
        sourceAddressIP = Arrays.copyOfRange(data,12,16);
        destinationAddressIP = Arrays.copyOfRange(data,16,20);
//        userData = Arrays.copyOfRange(data,24,data.length);
        userData = Arrays.copyOfRange(data,20,data.length);
    }

    public byte[] getData() {
        return data;
    }

    public byte[] getSourceAddressIP() {
        return sourceAddressIP;
    }

    public String getSourceAddressIPString() {
        return ByteUtils.ipFormat(sourceAddressIP);
    }

    public byte[] getDestinationAddressIP() {
        return destinationAddressIP;
    }

    public String getDestinationAddressIPString() {
        return ByteUtils.ipFormat(destinationAddressIP);
    }

    public byte[] getUserData() {
        return userData;
    }
}

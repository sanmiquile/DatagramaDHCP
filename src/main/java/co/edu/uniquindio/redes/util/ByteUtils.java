package co.edu.uniquindio.redes.util;

import java.util.Objects;

import static java.lang.Byte.toUnsignedInt;

public final class ByteUtils {

    private ByteUtils() {
    }

    public static byte[] extract(byte[] source, int init, int length){
        byte[] data = new byte[length];
        for (int i = 0; i < length ; i++) {
            data[i] = source[i+init];
        }
        return data;
    }

    public static String toString(byte[] data){
        return new String(data);
    }

    public static int toInt(byte[]data){
        int value = 0;
        for (int i = 0; i < data.length; i++) {
            value = (value << 8) + Byte.toUnsignedInt(data[i]);
        }
        return value;
    }

    public static String hexaToString(byte[] data){
        return hexaToString(data,0);
    }

    public static String hexaToString(byte[] data,int start){
        StringBuilder result = new StringBuilder("0x");
        for (int i = start; i < data.length; i++) {
            result.append( String.format(" %02x",data[i]) );
        }
        return result.toString();
    }

    public static String ipFormat(byte[] data){
        assert data.length >=4;
        return String.format("%d.%d.%d.%d",toUnsignedInt(data[0]),toUnsignedInt(data[1]),toUnsignedInt(data[2]),toUnsignedInt(data[3]));
    }

    public static byte[] stringToByteArray(String text){
        text=text.replaceAll(" ","");
        byte[] data = new byte[text.length()/2];
        for(int i = 0, j = 0 ; i < data.length ; i++,j+=2 ){
            data[i] = (byte) Integer.parseInt( text.substring(j,j+2) ,16 );
        }
        return data;
    }
}

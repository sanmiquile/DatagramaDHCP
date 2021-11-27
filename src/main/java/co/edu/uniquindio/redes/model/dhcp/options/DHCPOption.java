package co.edu.uniquindio.redes.model.dhcp.options;

import co.edu.uniquindio.redes.util.ByteUtils;

import java.util.Arrays;

public class DHCPOption {
    protected final DHCPOptionType dhcpOptionType;
    protected byte[] data;
    protected int length;
    protected byte[] value;

    public DHCPOption(DHCPOptionType dhcpOptionType) {
        this.dhcpOptionType = dhcpOptionType;
    }

    public int readFrom(byte[] dataSource,int start){
        readLength( dataSource,start);
        data = Arrays.copyOfRange(dataSource,start,start+dhcpOptionType.getMinLength()+ getLength());
        if( dhcpOptionType.isLengthVariable() ){
            value = Arrays.copyOfRange(data,dhcpOptionType.getMinLength(),data.length);
        } else {
            value = null;
        }
        return data.length;
    }

    public int getLength(){
        return length;
    }

    private void readLength(byte[] dataSource, int start) {
        if( dhcpOptionType.isLengthVariable() ) {
            length = Byte.toUnsignedInt(dataSource[start + 1]);
        } else {
            length = 0;
        }
    }

    public DHCPOptionType getDhcpOptionType() {
        return dhcpOptionType;
    }

    public String getData(){
        return ByteUtils.hexaToString(data);
    }

    public String valueToString(){
        return  "\""+ByteUtils.hexaToString(value)+"\"";
    }

    public String toString(){
        String format = """
                {
                    data: %s
                    option: "%s",
                    length: %d,
                    value: %s
                }
                """;
        return String.format(format,getData(),dhcpOptionType.toString(),length,
                (value == null ?
                        "null"
                        :valueToString()
                ));
//        return dhcpOptionType + (data.length > 1 ? "{ length: "+Byte.toUnsignedInt(data[1])+ ", data: " +ByteUtils.hexaToString(data,2) + "}":"");
    }
}

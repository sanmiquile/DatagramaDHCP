package co.edu.uniquindio.redes.model.dhcp.options;

import co.edu.uniquindio.redes.model.HardwareType;
import co.edu.uniquindio.redes.util.ByteUtils;

import java.util.Arrays;

public class ClientIdentifierOption extends DHCPOption{
    private HardwareType type;
    private byte[] clientId;
    public ClientIdentifierOption(DHCPOptionType dhcpOptionType) {
        super(dhcpOptionType);
    }

    public HardwareType getType() {
        return type;
    }

    public String getClientId() {
        return ByteUtils.hexaToString(clientId);
    }

    @Override
    public int readFrom(byte[] dataSource, int start) {
        int result = super.readFrom(dataSource, start);
        type = HardwareType.of(value[0]);
        clientId = Arrays.copyOfRange(value,1,value.length);
        return result;
    }

    @Override
    public String valueToString() {
        return String.format("""
                {
                        type:   "%s",
                        value:  "%s"
                    }
                """, type.toString(), getClientId());
    }
}

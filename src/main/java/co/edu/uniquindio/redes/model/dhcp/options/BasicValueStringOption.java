package co.edu.uniquindio.redes.model.dhcp.options;

import co.edu.uniquindio.redes.util.ByteUtils;

public class BasicValueStringOption extends DHCPOption{
    public BasicValueStringOption(DHCPOptionType dhcpOptionType) {
        super(dhcpOptionType);
    }
    @Override
    public String valueToString() {
        return String.valueOf(ByteUtils.toString(value));
    }
}

package co.edu.uniquindio.redes.model.dhcp.options;

import co.edu.uniquindio.redes.util.ByteUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicValueNumberOption extends DHCPOption{
    public BasicValueNumberOption(DHCPOptionType dhcpOptionType) {
        super(dhcpOptionType);
    }
    @Override
    public String valueToString() {
        return String.valueOf(ByteUtils.toInt(value));
    }
}

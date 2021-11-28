package co.edu.uniquindio.redes.model.dhcp.options;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParameterRequestListOption extends DHCPOption{
    public ParameterRequestListOption(DHCPOptionType dhcpOptionType) {
        super(dhcpOptionType);
    }
    @Override
    public String valueToString() {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < value.length; i++) {
            values.add( String.valueOf(Byte.toUnsignedInt(value[i])) );
        }
        return "["+values.stream().collect(Collectors.joining(","))+"]";
    }
}

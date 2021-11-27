package co.edu.uniquindio.redes.model.dhcp.options;

import co.edu.uniquindio.redes.util.ByteUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicValueIpOption extends DHCPOption{
    public BasicValueIpOption(DHCPOptionType dhcpOptionType) {
        super(dhcpOptionType);
    }

    @Override
    public String valueToString() {
        List<String> ips = new ArrayList<>();

        for (int i = 0; i < value.length; i+=4) {
            ips.add("\""+ ByteUtils.ipFormat(Arrays.copyOfRange(value,i,i+4)) +"\"");
        }
        return "["+ips.stream().collect(Collectors.joining(","))+"]";
    }
}

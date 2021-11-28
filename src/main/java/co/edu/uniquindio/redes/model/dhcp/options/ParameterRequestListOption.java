package co.edu.uniquindio.redes.model.dhcp.options;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParameterRequestListOption extends DHCPOption{
    public ParameterRequestListOption() {
        super(DHCPOptionType.PARAMETER_REQUEST_LIST);
    }
    @Override
    public String valueToString() {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < value.length; i++) {
            values.add( DHCPOptionType.of( value[i] ).toString() );
        }
        return "["+values.stream().collect(Collectors.joining(","))+"]";
    }
}

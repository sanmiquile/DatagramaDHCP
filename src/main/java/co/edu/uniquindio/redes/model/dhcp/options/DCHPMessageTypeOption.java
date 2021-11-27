package co.edu.uniquindio.redes.model.dhcp.options;

import static co.edu.uniquindio.redes.model.dhcp.options.DHCPOptionType.DHCP_MESSAGE_TYPE;

public class DCHPMessageTypeOption extends DHCPOption{
    public DCHPMessageTypeOption() {
        super(DHCP_MESSAGE_TYPE);
    }

    @Override
    public String valueToString() {
        return switch (value[0]){
            case 1-> "DHCPDISCOVER";
            case 2-> "DHCPOFFER";
            case 3-> "DHCPREQUEST";
            case 4-> "DHCPDECLINE";
            case 5-> "DHCPACK";
            case 6-> "DHCPNAK";
            case 7-> "DHCPRELEASE";
            case 8-> "DHCPINFORM";
            default-> "NOT SUPORTED";
        };
    }
    
}

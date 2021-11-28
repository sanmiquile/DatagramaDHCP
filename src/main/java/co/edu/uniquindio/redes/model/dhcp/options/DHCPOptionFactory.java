package co.edu.uniquindio.redes.model.dhcp.options;

public final class DHCPOptionFactory {

    private DHCPOptionFactory() {
    }

    public static DHCPOption create(DHCPOptionType type){
        return switch (type) {
            case HOST_NAME -> new BasicValueStringOption(type);
            case PARAMETER_REQUEST_LIST -> new ParameterRequestListOption();
            case CLIENT_IDENTIFIER -> new ClientIdentifierOption(type);
            case IP_ADDRESS_LEASE_TIME -> new BasicValueNumberOption(type);
            case ROUTER, SUBNET_MASK, DOMAIN_SERVER, SERVER_IDENTIFIER, REQUEST_IP_ADDRESS -> new BasicValueIpOption(type);
            case END, PAD, UNKNOW, VENDOR_CLASS_IDENTIFIER, AUTOCONFIGURATION -> new DHCPOption(type);
            case DHCP_MESSAGE_TYPE -> new DCHPMessageTypeOption();
            default -> new DHCPOption(type);//throw new RuntimeException("DHCP Option type not supported");
        };
    }
}

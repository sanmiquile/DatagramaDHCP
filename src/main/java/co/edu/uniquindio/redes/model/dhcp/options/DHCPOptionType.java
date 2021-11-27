package co.edu.uniquindio.redes.model.dhcp.options;

import java.util.Arrays;

//https://www.rfc-editor.org/rfc/rfc1533.html
//https://www.rfc-editor.org/rfc/rfc2132.html
public enum DHCPOptionType {
    //53, 61, 55, 1, 3, 6, 51, 54.
    PAD(0,0),
    END(255,0),
    SUBNET_MASK(1,4),
    TIME_OFFSET(2,4),
    ROUTER(3,-1),
    TIME_SERVER_OPTION(4,-1),
    NAME_SERVER_OPTION(5,-1),
    DOMAIN_SERVER(6,-1),
    LOG_SERVER_OPTION(7,-1),
    COOKIE_SERVER_OPTION(8,-1),
    LPR_SERVER_OPTION(9,-1),
    IMPRESS_SERVER_OPTION(10,-1),
    RESOURCE_LOCATION(11,-1),
    HOST_NAME(12,-1),
    BOOT_FILE_SIZE(13,2),
    MERIT_DUMP_FILE(14,-1),
    DOMAIN_NAME(15,-1),
    SWAP_SERVER(16,4),
    ROOT_PATH(17,-1),
    EXTENSIONS_PATH(18,-1),
    IP_FORWADING_ENABLE(19,1),
    NON_LOCAL_SOURCE(20,1),
    POLICY_FILTRER_OPTION(21,-1),
    MAXIMUM_DATAGRAM(22,2),
    DEFAULT_IP(23,1),
    PATH_MTU_AGING(24,4),
    PATH_MTU_PLATEAU(25,-1),
    INTERFACE_MTU(26,2),
    ALL_SUBNETS(27,1),
    BROADCAST__ADDRESS(28,4),
    PERFORM_MASK_DISCOVERY(29,1),
    MASK_SUPPLIER(30,1),
    PERFOM_ROUTER(31,1),
    ROUTER_SOLICITATION(32,4),
    STATIC_ROUTER(33,-1),
    TRAILER_ENCAPSULATION(34,1),
    ARP_CACHE_TIMEOUT(35,4),
    ETHERNET_ENCAPSULATION(35,1),
    TCP_DEFAULT_TTL(37,1),
    TCP_KEEPALIVE_INTERVAL(38,4),
    TCP_KEEPALIVE_GARBAGE(39,1),
    NETWORK_INFORMATION_SERVICE(40,-1),
    NETWORK_INFORMATION_SERVERS(41,-1),
    NETWORK_TIME_PROTOCOL(42,-1),
    VENDOR_SPECIFIC_INFORMATION(43,-1),
    NETBIOS_OVER_TCP_DATAGRAM(45,-1),
    NETBIOS_OVER_TCP_NODE(46,1),
    NETBIOS_OVER_TCP_SCOPE(47,-1),
    X_WINDOWS_SYSTEM_FOND(48,-1),
    X_WINDOWS_SYSTEM_DISPLAY(49,-1),
    NIS_CLIENT_DOMAIN(64,-1),
    NIS_INFORMATION_SERVER(65,-1),
    MOBILE_IP_HOME_AGENT(68,-1),
    SMTP(69,-1),
    POP3(70,-1),
    NNTP(71,-1),
    WWW(72,-1),
    DEFAULT_FINGER_SERVER(73,-1),
    IRC(74,-1),
    STREET_TALK_SERVER(75,-1),
    STDA(76,-1),
    REQUEST_IP_ADDRESS(50,4),
    IP_ADDRESS_LEASE_TIME(51,4),
    OPTION_OVERLOAF(52,1),
    TFTP_SERVER(66,-1),
    BOOTFILE_NAME(67,-1),
    DHCP_MESSAGE_TYPE(53,1),
    SERVER_IDENTIFIER(54,4),
    PARAMETER_REQUEST_LIST(55,-1),
    MAXIMUM_DHCP_MESSAGE_SIZE(57,2),
    RENEWAL_T1(58,4),
    REBINDING_T2(59,4),
    VENDOR_CLASS_IDENTIFIER(60,-1),
    CLIENT_IDENTIFIER(61,-1),
    AUTOCONFIGURATION(116,-1),
    UNKNOW(-1,-1);


    private byte code;
    private int length;

    DHCPOptionType(int code,int length) {
        this.code = (byte) code;
        this.length = length;
    }

    public static DHCPOptionType of(byte type){
        return Arrays.stream(values()).filter( t->t.code==type ).findAny().orElse(UNKNOW);
    }

    public byte getCode() {
        return code;
    }

    public int getLength() {
        return length;
    }

    public int getMinLength() {
        return isLengthFixed() ? 1 : 2;
    }

    public boolean isLengthFixed(){
        return length == 0;
    }

    public boolean isLengthVariable(){
        return length != 0;
    }
}

package co.edu.uniquindio.redes;

import co.edu.uniquindio.redes.model.DHCPMessage;
import co.edu.uniquindio.redes.model.dhcp.options.DHCPOption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainApp {
    static byte[] data = {(byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, 0x00, 0x08, 0x74, 0x4f, 0x36, 0x23, 0x08, 0x00, 0x45, 0x00, 0x01, 0x48, (byte) 0xb3, 0x10, 0x00, 0x00, (byte) 0x80, 0x11,
            (byte) 0x86, (byte) 0x95, 0x00, 0x00, 0x00, 0x00, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, 0x00, 0x44, 0x00, 0x43, 0x01, 0x34, (byte) 0xe9, 0x7b, 0x01, 0x01, 0x06, 0x00, 0x3e, 0x5e,
            0x0c, (byte) 0xe3, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x08,
            0x74, 0x4f, 0x36, 0x23, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x63, (byte) 0x82, 0x53, 0x63, 0x35, 0x01, 0x01, 0x74, 0x01, 0x01,
            0x3d, 0x07, 0x01, 0x00, 0x08, 0x74, 0x4f, 0x36, 0x23, 0x32, 0x04, (byte) 0xc0, (byte) 0xa8, 0x01, 0x65, 0x0c, 0x04, 0x4e, 0x6f, 0x68, 0x6f, 0x3c, 0x08, 0x4d,
            0x53, 0x46, 0x54, 0x20, 0x35, 0x2e, 0x30, 0x37, 0x0b, 0x01, 0x0f, 0x03, 0x06, 0x2c, 0x2e, 0x2f, 0x1f, 0x21, (byte) 0xf9, 0x2b, (byte) 0xff, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("datamagra.dat");
//        Files.write(path,data);

        if( args.length > 0 ) {
            Path path = Paths.get(args[0]);
            data = Files.readAllBytes(path);
        }

        DHCPMessage dhcpMessage = new DHCPMessage(data);

        System.out.println( "Mac destino"+ dhcpMessage.getDestinationMacAddress() );

        System.out.println( "Mac fuente"+ dhcpMessage.getSourceMacAddress() );

        System.out.println("ip fuente "+dhcpMessage.getSourceAddressIP());

        System.out.println("ip destino "+dhcpMessage.getDestinationAddressIP());

        System.out.println("puerto origen "+dhcpMessage.getSourcePort());

        System.out.println("puerto destino "+dhcpMessage.getDestinationPort());

        System.out.println("longitud udp "+dhcpMessage.getUDPSegmentLength());

        System.out.println("longitud dhcp "+dhcpMessage.getLength());
        System.out.println("Tipo mensaje dhcp "+dhcpMessage.getMessageType());
        System.out.println("Tipo hardware "+dhcpMessage.getHardwareType());
        System.out.println("Tamaño de la dirección de hardware "+dhcpMessage.getHlen());
        System.out.println("XID "+dhcpMessage.getXidString());
        System.out.println("IP cliente "+dhcpMessage.getClientAddressIPString());
        System.out.println("IP SU "+dhcpMessage.getSuAddressIPString());
        System.out.println("Hardware Address Client "+dhcpMessage.getHardwareClientAddressString());
        System.out.println("Magic Cokkie "+dhcpMessage.getMagicCokkie());

        dhcpMessage.getOptions().stream().map(DHCPOption::toString).forEach(System.out::println);

    }

}

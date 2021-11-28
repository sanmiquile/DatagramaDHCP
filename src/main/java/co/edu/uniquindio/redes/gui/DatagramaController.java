package co.edu.uniquindio.redes.gui;


import co.edu.uniquindio.redes.model.DHCPMessage;
import co.edu.uniquindio.redes.model.dhcp.options.DHCPOption;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import co.edu.uniquindio.redes.util.ByteUtils;
import co.edu.uniquindio.redes.model.DataFrame;


public class DatagramaController {
    @FXML
    private TextArea datagramaText;

    @FXML
    private void  leerDatagrama(){


        byte[] data= ByteUtils.stringToByteArray(datagramaText.getText());


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








       /*
        String vistaActiva = "/fxml/resultadoData.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(vistaActiva));
        ScrollPane ventana = loader.load();
        DatragamaController controller = loader.getController();

        */


    }



}

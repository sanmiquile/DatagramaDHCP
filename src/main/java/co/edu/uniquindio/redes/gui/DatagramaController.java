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
    private TextArea resultadoText;

    @FXML
    private void  leerDatagrama(){

        byte[] data= ByteUtils.stringToByteArray(datagramaText.getText());


        DHCPMessage dhcpMessage = new DHCPMessage(data);

        resultadoText.setText( "Mac destino: "+ dhcpMessage.getDestinationMacAddress() +
                "\nip fuente: "+dhcpMessage.getSourceAddressIP()+
                "\nip destino: "+dhcpMessage.getDestinationAddressIP()+
                "\npuerto origen "+dhcpMessage.getSourcePort()+
                "\npuerto destino "+dhcpMessage.getDestinationPort()+
                "\nlongitud udp "+dhcpMessage.getUDPSegmentLength()+
                "\nlongitud dhcp "+dhcpMessage.getLength()+
                "\nTipo mensaje dhcp "+dhcpMessage.getMessageType()+
                "\nTipo hardware "+dhcpMessage.getHardwareType()+
                "\nTamaño de la dirección de hardware "+dhcpMessage.getHlen()+
                "\nXID "+dhcpMessage.getXidString()+
                "\nIP cliente "+dhcpMessage.getClientAddressIPString()+
                "\nIP SU "+dhcpMessage.getSuAddressIPString()+
                "\nHardware Address Client "+dhcpMessage.getHardwareClientAddressString()+
                "\nMagic Cokkie "+dhcpMessage.getMagicCokkie());

        dhcpMessage.getOptions().stream().map(DHCPOption::toString).forEach(System.out::println);



    }



}

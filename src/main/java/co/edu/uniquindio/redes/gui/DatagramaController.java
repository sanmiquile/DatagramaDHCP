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

        StringBuilder resultado = new StringBuilder();

        resultado.append( "Direccion MAC destino: "+ dhcpMessage.getDestinationMacAddress() +
                "\nDireccion MAC origen: "+ dhcpMessage.getSourceMacAddress()+
                "\nDireccion IP origen: "+dhcpMessage.getSourceAddressIP()+
                "\nDireccion IP destino: "+dhcpMessage.getDestinationAddressIP()+
                "\nNumero de puerto origen: "+dhcpMessage.getSourcePort()+
                "\nNumero de puerto destino: "+dhcpMessage.getDestinationPort()+
                "\nLongitud del segmento UDP: "+dhcpMessage.getUDPSegmentLength()+
                "\nLongitud del mensaje DHCP: "+dhcpMessage.getLength()+
                "\nTipo mensaje DHCP: "+dhcpMessage.getMessageType()+
                "\nTipo hardware de red: "+dhcpMessage.getHardwareType()+
                "\nTamaño de la direccion de hardware: "+dhcpMessage.getHlen()+
                "\nIdentificador de la transaccion: "+dhcpMessage.getXidString()+
                "\nDireccion IP cliente: "+dhcpMessage.getClientAddressIPString()+
                "\nSu direccion IP: "+dhcpMessage.getSuAddressIPString()+
                "\nDireccion Hardware Cliente: "+dhcpMessage.getHardwareClientAddressString()+
                "\nMagic Cokkie: "+dhcpMessage.getMagicCokkie());

        resultado.append("\nOpciones: \n");
        dhcpMessage.getOptions().stream().map(DHCPOption::toString).forEach(resultado::append);

        resultadoText.setText(resultado.toString());


    }



}

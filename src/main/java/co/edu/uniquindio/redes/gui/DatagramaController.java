package co.edu.uniquindio.redes.gui;


import co.edu.uniquindio.redes.model.DHCPMessage;
import co.edu.uniquindio.redes.model.dhcp.options.DHCPOption;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import co.edu.uniquindio.redes.util.ByteUtils;
import co.edu.uniquindio.redes.model.DataFrame;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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

        resultado.append( "Dirección MAC destino: "+ dhcpMessage.getDestinationMacAddress() +
                "\nDirección MAC origen: "+ dhcpMessage.getSourceMacAddress()+
                "\nDirección IP origen: "+dhcpMessage.getSourceAddressIP()+
                "\nDirección IP destino: "+dhcpMessage.getDestinationAddressIP()+
                "\nNúmero de puerto origen: "+dhcpMessage.getSourcePort()+
                "\nNúmero de puerto destino: "+dhcpMessage.getDestinationPort()+
                "\nLongitud del segmento UDP: "+dhcpMessage.getUDPSegmentLength()+
                "\nLongitud del mensaje DHCP: "+dhcpMessage.getLength()+
                "\nTipo mensaje DHCP: "+dhcpMessage.getMessageType()+
                "\nTipo hardware de red: "+dhcpMessage.getHardwareType()+
                "\nTamaño de la dirección de hardware: "+dhcpMessage.getHlen()+
                "\nIdentificador de la transacción: "+dhcpMessage.getXidString()+
                "\nDirección IP cliente: "+dhcpMessage.getClientAddressIPString()+
                "\nSu dirección IP: "+dhcpMessage.getSuAddressIPString()+
                "\nDirección Hardware Cliente: "+dhcpMessage.getHardwareClientAddressString()+
                "\nMagic Cokkie: "+dhcpMessage.getMagicCokkie());

        resultado.append("\nOpciones: \n");
        dhcpMessage.getOptions().stream().map(DHCPOption::toString).forEach(resultado::append);

        resultadoText.setText(resultado.toString());


    }
/*
    @FXML
    private void  leerArchivo() {

        Path path = Paths.get(args[0]);
        data = Files.readAllBytes(path);
        String texto = new String(data);

    }

      */

    }

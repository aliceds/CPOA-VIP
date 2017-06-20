/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPSClient;

/**
 *
 * @author Alice
 */
public class SourceFTPS {

    /**
     * renvoie un FTPS ftp avec les informations contenues dans connexionFTPS.properties
     * @return 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static FTPSClient getFTPS() throws FileNotFoundException, IOException {
        Properties props = new Properties();
        FileInputStream fichier = new FileInputStream("src/connexionFTPS.properties");
        props.load(fichier);
        FTPSClient ftp = new FTPSClient();
        ftp.connect(props.getProperty("host"), 990);
        ftp.login(props.getProperty("log"), props.getProperty("pass"));
        ftp.enterLocalPassiveMode();
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        return ftp;
    }
}

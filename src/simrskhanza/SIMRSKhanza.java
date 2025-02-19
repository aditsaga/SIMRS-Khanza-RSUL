/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simrskhanza;

import java.io.FileInputStream;
import java.util.Properties;
import usu.widget.util.WidgetUtilities;

/**
 *
 * @author khanzasoft
 */
public class SIMRSKhanza {
    private static final Properties propVer = new Properties();  
    private static final Properties propDatabase = new Properties();  
    public static String version;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            propVer.loadFromXML(new FileInputStream("setting/version.xml"));
            propDatabase.loadFromXML(new FileInputStream("setting/database.xml"));
        } catch (Exception e) {
            System.out.println("Notif Setting : "+e);
        }
        version = propVer.getProperty("VERSION");
        if(propDatabase.getProperty("AUTOUPDATESISTEM").equals("aktif")){
            try {
                if (!Update.getLatestVersion().equals(version) ) {
                    new UpdateInfo(Update.getWhatsNew());
                } else {
                    System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
                    WidgetUtilities.invokeLater(() -> {
                        splash utama=new splash();
                        utama.setVisible(true);
                    });                                                         
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        WidgetUtilities.invokeLater(() -> {
                   splash utama=new splash();
                   utama.setVisible(true);
        });
        }
    }
    
}

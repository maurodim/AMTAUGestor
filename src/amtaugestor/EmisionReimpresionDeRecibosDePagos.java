/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amtaugestor;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Administrador
 */
public class EmisionReimpresionDeRecibosDePagos extends Thread{
    private String cuotaNumero;
    private Integer numeroDeSocio;

    public void setCuotaNumero(String cuotaNumero) {
        this.cuotaNumero = cuotaNumero;
    }

    public void setNumeroDeSocio(Integer numeroDeSocio) {
        this.numeroDeSocio = numeroDeSocio;
    }
    public void run(){
                try {
            Date fecha=new Date();
   String fechaTitulo=String.valueOf(fecha);
    Map numeroCuota=new HashMap();
	
	   numeroCuota.put("cuotaN",this.cuotaNumero);
           numeroCuota.put("numSocio", this.numeroDeSocio);
   String master=System.getProperty("user.dir")+"//src//informes//ReimpresionRecibosDePago.jasper";
    String destino="C://AMTAUgestor//"+fechaTitulo+" Reimpresion de Recibos De Pago.pdf";
   Coneccion con=new Coneccion();
            Class.forName(con.getDriver());
            Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
            JasperReport reporte=(JasperReport) JRLoader.loadObject(master);
            JasperPrint jasperPrint=JasperFillManager.fillReport(reporte, numeroCuota,cnn);
            JRExporter exporter=new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(destino));
            exporter.exportReport();
            //cnn.close();
            
            File f=new File(destino);
            if(f.exists()){
                try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+destino);
                } catch (IOException ex) {
                    Logger.getLogger(EmisionReimpresionDeRecibosDePagos.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }
        } catch (JRException ex) {
            Logger.getLogger(EmisionReimpresionDeRecibosDePagos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmisionReimpresionDeRecibosDePagos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmisionReimpresionDeRecibosDePagos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author mauro
 */
public class EmisionContables extends Thread{
    private String fechaDesde;
    private String fechaHasta;
    Map numeroCuota=new HashMap();
    Connection cnn;
    public String getFechaDesde() {
        return fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }


    public void run(){
        try {
            Date fecha=new Date();
String fechaTitulo=String.valueOf(fecha);
//Map numeroCuota=new HashMap();
System.out.println(this.fechaDesde+" "+this.fechaHasta);
   numeroCuota.put("fechaDesde",this.fechaDesde);
   numeroCuota.put("fechaHasta",this.fechaHasta);
String master=System.getProperty("user.dir")+"//src//informes//INFORMES//ContablesLiquidacionBalance.jasper";
String destino="C://AMTAUgestor//Liquidacion de Balance.pdf";
Coneccion con=new Coneccion();
    Class.forName(con.getDriver());
    cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
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
                        realDeSocios();
                        totalDeSocios();
                    } catch (IOException ex) {
                        Logger.getLogger(EmisionContables.class.getName()).log(Level.SEVERE, null, ex);
                    }

            
    }   } catch (JRException ex) {
            Logger.getLogger(EmisionContables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmisionContables.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmisionContables.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void realDeSocios() throws JRException{
        String master=System.getProperty("user.dir")+"//src//informes//INFORMES//ContablesLiquidacionRealDeSocios.jasper";
String destino="C://AMTAUgestor//Liquidacion Real de Socios.pdf";
//Coneccion con=new Coneccion();
    //Class.forName(con.getDriver());
    //Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
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
                        Logger.getLogger(EmisionContables.class.getName()).log(Level.SEVERE, null, ex);
                    }

       
    }
    }
    public void totalDeSocios() throws JRException{
        String master=System.getProperty("user.dir")+"//src//informes//INFORMES//ContablesLiquidacionTotalDeSocios.jasper";
String destino="C://AMTAUgestor//Liquidacion Total de Socios.pdf";
//Coneccion con=new Coneccion();
    //Class.forName(con.getDriver());
    //Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
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
                        Logger.getLogger(EmisionContables.class.getName()).log(Level.SEVERE, null, ex);
                    }

       
    }
        

    }
}

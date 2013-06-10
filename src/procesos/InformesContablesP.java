/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import amtaugestor.Coneccion;
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
public class InformesContablesP extends Thread{
    private Integer tipoInforme;
    private Date fechaDesde;
    private Date fechaHasta;

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public void setTipoInforme(Integer tipoInforme) {
        this.tipoInforme = tipoInforme;
    }
    
    public synchronized void run(){
        try {
            Map listConsolidado=new HashMap();
    int num=0;
            //System.out.println("numero ingresado:"+numeroSolicitud);
    //Long numSol=numeroSolicitud;
    Coneccion con=new Coneccion();
    Class.forName(con.getDriver());
    Connection ch=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
    listConsolidado.put("fechaDesde",fechaDesde);
    listConsolidado.put("fechaHasta",fechaHasta);
    System.out.println(fechaDesde+" "+fechaHasta);
    String master=null;
    String destino=null;
    if(this.tipoInforme==1){
        master=System.getProperty("user.dir")+"//src//informesContables//ContablesLiquidacionRealDeSocios.jasper";
        System.out.println(master);
        destino="C://Informes//"+"informes cobranza real.pdf";
    }else{
        if(this.tipoInforme==2){
        master=System.getProperty("user.dir")+"//src//informesContables//ContablesLiquidacionTotalDeSocios.jasper";
            destino="C://Informes//"+"informes cobranza total.pdf";
        }else{
            master=System.getProperty("user.dir")+"//src//informesContables//ContablesLiquidacionBalance.jasper";
            destino="C://Informes//informes debe-haber.pdf";
        }
    }
    JasperReport reporte = null;
    try {
        reporte = (JasperReport)JRLoader.loadObject(master);
    } catch (JRException ex) {
        Logger.getLogger(InformesContablesP.class.getName()).log(Level.SEVERE, null, ex);
    }
    JasperPrint jasperPrint = null;
    try {
        jasperPrint = JasperFillManager.fillReport(reporte, listConsolidado,ch);
    } catch (JRException ex) {
        Logger.getLogger(InformesContablesP.class.getName()).log(Level.SEVERE, null, ex);
    }
            
      		JRExporter exporter=new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(destino));
            try {
                exporter.exportReport();
            } catch (JRException ex) {
                Logger.getLogger(InformesContablesP.class.getName()).log(Level.SEVERE, null, ex);
            }
             File f=new File(destino);
             if(f.exists()){
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+destino);
        } catch (IOException ex) {
            Logger.getLogger(InformesContablesP.class.getName()).log(Level.SEVERE, null, ex);
        }
}       } catch (SQLException ex) {
            Logger.getLogger(InformesContablesP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InformesContablesP.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }
}

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
 * @author USUARIO
 */
public class InLiqGral {
	private String fechaDesdeCobrador;
	private String fechaHastaCobrador;
	private String fechaDesdeVendedor;
	private String fechaHastaVendedor;
	private Integer numeroCobrador;
	private Integer numeroVendedor;
	private String nombreCobrador;
	private String nombreVendedor;

	public void setFechaDesdeCobrador(String fechaDesdeCobrador) {
		this.fechaDesdeCobrador = fechaDesdeCobrador;
	}

	public void setFechaDesdeVendedor(String fechaDesdeVendedor) {
		this.fechaDesdeVendedor = fechaDesdeVendedor;
	}

	public void setFechaHastaCobrador(String fechaHastaCobrador) {
		this.fechaHastaCobrador = fechaHastaCobrador;
	}

	public void setFechaHastaVendedor(String fechaHastaVendedor) {
		this.fechaHastaVendedor = fechaHastaVendedor;
	}

	public void setNombreCobrador(String nombreCobrador) {
		this.nombreCobrador = nombreCobrador;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public void setNumeroCobrador(Integer numeroCobrador) {
		this.numeroCobrador = numeroCobrador;
	}

	public void setNumeroVendedor(Integer numeroVendedor) {
		this.numeroVendedor = numeroVendedor;
	}
	public void GenerarReporteCobradores() throws ClassNotFoundException, SQLException, JRException, IOException{
	Date fecha=new Date();
       String fechaTitulo=String.valueOf(fecha);
       String master=System.getProperty("user.dir")+"//src//informes//ListadoSociosPorCobrador.jasper";
        String ruta=System.getProperty("user.dir")+"//src//informes//Listado de Socios.pdf";	
            Map cobrador=new HashMap();
		cobrador.put("numeroCobrador", this.numeroCobrador);
                System.out.println(this.numeroCobrador);
		Coneccion con=new Coneccion();
		Class.forName(con.getDriver());
		Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
		JasperReport reporte=(JasperReport) JRLoader.loadObject(master);
		JasperPrint jasperPrint=JasperFillManager.fillReport(reporte,cobrador,cnn);
		JRExporter exporter=new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(ruta));
		exporter.exportReport();
                File f=new File(ruta);
	   if(f.exists()){
		   Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ruta);
		   

	   }
	}
	public void GenerarReporteGeneral() throws ClassNotFoundException, SQLException, JRException{
	Date fecha=new Date();
       String fechaTitulo=String.valueOf(fecha);
       String master=System.getProperty("user.dir")+"//src//informes//ListadosDeSocios.jasper";
        String ruta=System.getProperty("user.dir")+"//src//informes//Listado de Socios.pdf";	
            Coneccion con=new Coneccion();
		Class.forName(con.getDriver());
		Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
		JasperReport reporte=(JasperReport) JRLoader.loadObject(master);
		JasperPrint jasperPrint=JasperFillManager.fillReport(reporte, null,cnn);
		JRExporter exporter=new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(ruta));
		exporter.exportReport();
	}
	public void GenerarReporteCobranzaPorFechas() throws ClassNotFoundException, SQLException, JRException, IOException{
	Date fecha1=new Date();
       String fechaTitulo=String.valueOf(fecha1);
       String master=System.getProperty("user.dir")+"//src//informes//ListadoCobranzaPorFechas.jasper";
        String ruta=System.getProperty("user.dir")+"//src//informes//Listado de cobranzas por fechas.pdf";	
            Map fecha=new HashMap();
		fecha.put("fechaDesde", this.fechaDesdeCobrador);
		fecha.put("fechaHasta",this.fechaHastaCobrador);
		Coneccion con=new Coneccion();
		Class.forName(con.getDriver());
		Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
		JasperReport reporte=(JasperReport) JRLoader.loadObject(master);
		JasperPrint jasperPrint=JasperFillManager.fillReport(reporte,fecha,cnn);
		JRExporter exporter=new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(ruta));
		exporter.exportReport();
                File f=new File(ruta);
	   if(f.exists()){
		   Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ruta);
		   

	   }
	}
        public void emitirListadoGeneralPorCobrador() throws ClassNotFoundException, SQLException, JRException, IOException{
                 //Calendar c2=new GregorianCalendar();
        Date fecha=new Date();
       String fechaTitulo=String.valueOf(fecha);
       String master=System.getProperty("user.dir")+"//src//informes//ListadoGeneralPorCobrador.jasper";
        String destino=System.getProperty("user.dir")+"//src//informes//Listado General de Socios Por Cobrador.pdf";
       Coneccion con=new Coneccion();
		Class.forName(con.getDriver());
		Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
		JasperReport reporte=(JasperReport) JRLoader.loadObject(master);
		JasperPrint jasperPrint=JasperFillManager.fillReport(reporte, null,cnn);
		JRExporter exporter=new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(destino));
		exporter.exportReport();
		//cnn.close();
		
		File f=new File(destino);
		if(f.exists()){
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+destino);
			
		}
        }
        public void emitirListadoCobranzaPorCobrador() throws ClassNotFoundException, SQLException, JRException, IOException{
            	Date fecha1=new Date();
       String fechaTitulo=String.valueOf(fecha1);
       String master=System.getProperty("user.dir")+"//src//informes//ListadoDeCobranzaPorCobrador.jasper";
        String ruta=System.getProperty("user.dir")+"//src//informes//Listado de cobranzas por cobrador.pdf";	
            Map fecha=new HashMap();
		fecha.put("fechaDesde", this.fechaDesdeCobrador);
		fecha.put("fechaHasta",this.fechaHastaCobrador);
                fecha.put("numeroCobrador",this.numeroCobrador);
		Coneccion con=new Coneccion();
		Class.forName(con.getDriver());
		Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
		JasperReport reporte=(JasperReport) JRLoader.loadObject(master);
		JasperPrint jasperPrint=JasperFillManager.fillReport(reporte,fecha,cnn);
		JRExporter exporter=new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(ruta));
		exporter.exportReport();
                File f=new File(ruta);
	   if(f.exists()){
		   Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ruta);
		   

	   }
        }
        
}

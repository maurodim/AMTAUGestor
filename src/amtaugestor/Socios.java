/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amtaugestor;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
public class Socios implements Procedimientos{
    private Integer numeroSolicitud;
    private Integer numeroCliente;
    private String apellido;
    private Date fechaDeAlta;
    private String numeroDocumento;
    private Date fechaNacimiento;
    private String domicilioParticular;
    private String localidad;
    private String codigoPostal;
    private String telefono;
    private String domicilioCobranza;
    private String telefonoCobranza;
    private String estadoDeSalud;
    private Integer numeroDePlan;
    private Integer numeroVendedor;
    private Integer numeroCobrador;
    private Integer cantidadAdherentes;
    private Integer numeroTitular;
    private Integer tipoCondicion;
    private String condicion;
    private String parentescoTitular;
    private String fechaCobro;
    private Integer medicinaIntegral;
    private Integer cantiMedicinaIntegral;
    private String carenciaMedicinaIntegral;
    private Integer velatorios;
    private Integer cantidadVelatorios;
    private String carenciaVelatorios;
    private Integer sepelio;
    private Integer cantidadSepelio;
    private String carenciaSepelio;
    private Integer emergencias;
    private Integer cantidadEmergencias;
    private String carenciaEmergencias;
    private Integer condicionSocio;
    private Date fechaModificacion;
    private Integer usuarioModificador;
    private Integer montoACobrar;
    private Date fechaBaja;
    private String motivoBaja;
    private String observaciones;
    private Integer liquidada;
    private Date fechaLiquidacion;
    private Integer numeroLiquidacion;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCantiMedicinaIntegral() {
        return cantiMedicinaIntegral;
    }

    public void setCantiMedicinaIntegral(Integer cantiMedicinaIntegral) {
        this.cantiMedicinaIntegral = cantiMedicinaIntegral;
    }

    public Integer getCantidadAdherentes() {
        return cantidadAdherentes;
    }

    public void setCantidadAdherentes(Integer cantidadAdherentes) {
        this.cantidadAdherentes = cantidadAdherentes;
    }

    public Integer getCantidadEmergencias() {
        return cantidadEmergencias;
    }

    public void setCantidadEmergencias(Integer cantidadEmergencias) {
        this.cantidadEmergencias = cantidadEmergencias;
    }

    public Integer getCantidadSepelio() {
        return cantidadSepelio;
    }

    public void setCantidadSepelio(Integer cantidadSepelio) {
        this.cantidadSepelio = cantidadSepelio;
    }

    public Integer getCantidadVelatorios() {
        return cantidadVelatorios;
    }

    public void setCantidadVelatorios(Integer cantidadVelatorios) {
        this.cantidadVelatorios = cantidadVelatorios;
    }

    public String getCarenciaEmergencias() {
        return carenciaEmergencias;
    }

    public void setCarenciaEmergencias(String carenciaEmergencias) {
        this.carenciaEmergencias = carenciaEmergencias;
    }

    public String getCarenciaMedicinaIntegral() {
        return carenciaMedicinaIntegral;
    }

    public void setCarenciaMedicinaIntegral(String carenciaMedicinaIntegral) {
        this.carenciaMedicinaIntegral = carenciaMedicinaIntegral;
    }

    public String getCarenciaSepelio() {
        return carenciaSepelio;
    }

    public void setCarenciaSepelio(String carenciaSepelio) {
        this.carenciaSepelio = carenciaSepelio;
    }

    public String getCarenciaVelatorios() {
        return carenciaVelatorios;
    }

    public void setCarenciaVelatorios(String carenciaVelatorios) {
        this.carenciaVelatorios = carenciaVelatorios;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Integer getCondicionSocio() {
        return condicionSocio;
    }

    public void setCondicionSocio(Integer condicionSocio) {
        this.condicionSocio = condicionSocio;
    }

    public String getDomicilioCobranza() {
        return domicilioCobranza;
    }

    public void setDomicilioCobranza(String domicilioCobranza) {
        this.domicilioCobranza = domicilioCobranza;
    }

    public String getDomicilioParticular() {
        return domicilioParticular;
    }

    public void setDomicilioParticular(String domicilioParticular) {
        this.domicilioParticular = domicilioParticular;
    }

    public Integer getEmergencias() {
        return emergencias;
    }

    public void setEmergencias(Integer emergencias) {
        this.emergencias = emergencias;
    }

    public String getEstadoDeSalud() {
        return estadoDeSalud;
    }

    public void setEstadoDeSalud(String estadoDeSalud) {
        this.estadoDeSalud = estadoDeSalud;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(String fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Date getFechaLiquidacion() {
        return fechaLiquidacion;
    }

    public void setFechaLiquidacion(Date fechaLiquidacion) {
        this.fechaLiquidacion = fechaLiquidacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getLiquidada() {
        return liquidada;
    }

    public void setLiquidada(Integer liquidada) {
        this.liquidada = liquidada;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getMedicinaIntegral() {
        return medicinaIntegral;
    }

    public void setMedicinaIntegral(Integer medicinaIntegral) {
        this.medicinaIntegral = medicinaIntegral;
    }

    public Integer getMontoACobrar() {
        return montoACobrar;
    }

    public void setMontoACobrar(Integer montoACobrar) {
        this.montoACobrar = montoACobrar;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public Integer getNumeroCobrador() {
        return numeroCobrador;
    }

    public void setNumeroCobrador(Integer numeroCobrador) {
        this.numeroCobrador = numeroCobrador;
    }

    public Integer getNumeroDePlan() {
        return numeroDePlan;
    }

    public void setNumeroDePlan(Integer numeroDePlan) {
        this.numeroDePlan = numeroDePlan;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getNumeroLiquidacion() {
        return numeroLiquidacion;
    }

    public void setNumeroLiquidacion(Integer numeroLiquidacion) {
        this.numeroLiquidacion = numeroLiquidacion;
    }

    public Integer getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud =Integer.parseInt(numeroSolicitud);
    }

    public Integer getNumeroTitular() {
        return numeroTitular;
    }

    public void setNumeroTitular(Integer numeroTitular) {
        this.numeroTitular = numeroTitular;
    }

    
    public Integer getNumeroVendedor() {
        return numeroVendedor;
    }

    public void setNumeroVendedor(Integer numeroVendedor) {
        this.numeroVendedor = numeroVendedor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getParentescoTitular() {
        return parentescoTitular;
    }

    public void setParentescoTitular(String parentescoTitular) {
        this.parentescoTitular = parentescoTitular;
    }

    public Integer getSepelio() {
        return sepelio;
    }

    public void setSepelio(Integer sepelio) {
        this.sepelio = sepelio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoCobranza() {
        return telefonoCobranza;
    }

    public void setTelefonoCobranza(String telefonoCobranza) {
        this.telefonoCobranza = telefonoCobranza;
    }

    public Integer getTipoCondicion() {
        return tipoCondicion;
    }

    public void setTipoCondicion(Integer tipoCondicion) {
        this.tipoCondicion = tipoCondicion;
    }

    public Integer getUsuarioModificador() {
        return usuarioModificador;
    }

    public void setUsuarioModificador(Integer usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public Integer getVelatorios() {
        return velatorios;
    }

    public void setVelatorios(Integer velatorios) {
        this.velatorios = velatorios;
    }
    
    public void cargarSocio(Long numeroSolicitud) throws ClassNotFoundException, SQLException{
        System.out.println("numero ingresado:"+numeroSolicitud);
	Long numSol=numeroSolicitud;
	Coneccion con=new Coneccion();
        Class.forName(con.getDriver());
        Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
        Statement s=cnn.createStatement();
        s.executeQuery("select * from amtau_socios where numeroSolicitud="+ numSol);
        ResultSet rs=s.getResultSet();
	while (rs.next())
	{
	this.numeroCliente=rs.getInt("numeroCliente");
        //this.numeroCliente=1;
	this.numeroSolicitud=rs.getInt("numeroSolicitud");
	//this.numeroSolicitud=numSol;
	this.apellido=rs.getString("apellido");
        //this.apellido="mauro";
	//this.apellido=rs.getString("apellido");
	}
        rs.close();
        cnn.close();
    }
    public Boolean existeSocio(String numeroSolicitud) throws ClassNotFoundException, SQLException{
        Boolean items;
        
        Coneccion con=new Coneccion();
        Class.forName(con.getDriver());
        Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
        Statement s=cnn.createStatement();
        ResultSet rs=s.executeQuery("select * from amtau_socios where numeroSolicitud="+ numeroSolicitud);
        //items++;
        if(rs != null)
        {
            items=false;
        }
        else{
        this.numeroCliente=rs.getInt("numeroCliente");
        this.numeroSolicitud=rs.getInt("numeroSolicitud");
        items=true;
        //this.apellido=rs.getString("apellido");
        }
        rs.close();
        cnn.close();
        return items;
    }
    public void leerNumeroTitular(String numeroSolicitud) throws ClassNotFoundException, SQLException
    {
        Coneccion con=new Coneccion();
        Class.forName(con.getDriver());
        Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
        Statement s=cnn.createStatement();
        ResultSet rs=s.executeQuery("select * from amtau_socios where numeroSolicitud="+ numeroSolicitud);
        this.numeroTitular=rs.getInt("numeroTitular");
        rs.close();
        cnn.close();
        //return this.numeroTitular;
    }
   public void ImprimirReporteListadoSocios() throws ClassNotFoundException, SQLException, JRException, IOException{
	   
	//Calendar c1=Calendar.getInstance();
        //Calendar c2=new GregorianCalendar();
        Date fecha=new Date();
       String fechaTitulo=String.valueOf(fecha);
       String master=System.getProperty("user.dir")+"//src//informes//ListadosDeSocios.jasper";
        String destino="C://AMTAUgestor//Listado de Socios.pdf";
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
   public void ImprimirReporteListadoAdherentesPorSocio() throws ClassNotFoundException, SQLException, JRException, IOException, InstantiationException, IllegalAccessException{
	   //String ruta="Listado de Adherentes de Socios.pdf";
	   Date fecha=new Date();
       String fechaTitulo=String.valueOf(fecha);
       String master=System.getProperty("user.dir")+"//src//informes//ListadoAdherentesDeSocios.jasper";
        String ruta="C://AMTAUgestor//Listado de Adherentes de Socios.pdf";
           Map numeroSocio=new HashMap();
	
	   numeroSocio.put("numeroTitular",this.numeroCliente);
	   numeroSocio.put("nombreTitular",this.apellido);
	   System.out.println(this.numeroCliente);
	   System.out.println(this.apellido);
	   Coneccion con=new Coneccion();
	   Class.forName(con.getDriver()).newInstance();
	   Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
	   JasperReport reporte=(JasperReport) JRLoader.loadObject(master);
	   JasperPrint jasperPrint=JasperFillManager.fillReport(reporte,numeroSocio,cnn);
	   JRExporter exporter=new JRPdfExporter();
	   exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
	   exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File(ruta));
	   exporter.exportReport();
	   //cnn.close();
	   
	   File f=new File(ruta);
	   if(f.exists()){
		   Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ruta);
		   

	   }

	  
   }

    public void alta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void baja(Integer numero) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificacion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void actualizarListado(ArrayList listado) {
        try {
            Iterator il=listado.listIterator();
            Coneccion con=new Coneccion();
            SimpleDateFormat df=new SimpleDateFormat("0000-00-00");
            Connection cnn=null;
            String sql=null;
            cnn=con.getCp();
            Statement st=null;
            while(il.hasNext()){
                Socios sc=(Socios)il.next();
                /*
                if(sc.getFechaDeAlta()==null){
                    try {
                        sc.setFechaDeAlta(df.parse("2012/01/01"));
                    } catch (ParseException ex) {
                        Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                 * 
                 */
                sql="insert into amtau_socios (numeroSolicitud,apellido,numeroDocumento,domicilioParticular,localidad,codigoPostal,telefono,domicilioCobranza,telefonoCobranza,estadoDeSalud,numeroDePlan,numeroVendedor,numeroCobrador,cantidadAdherentes,tipoCondicion,parentescoTitular,medicinaIntegral,cantiMedicinaIntegral,carenciaMedicinaIntegral,sepelio,cantidadSepelio,carenciaSepelio,emergencias,cantidadEmergencias,carenciaEmergencias,numeroTitular,montoACobrar) values ("+sc.getNumeroSolicitud()+",'"+sc.getApellido()+"','"+sc.getNumeroDocumento()+"','"+sc.getDomicilioParticular()+"','"+sc.getLocalidad()+"','"+sc.getCodigoPostal()+"','"+sc.getTelefono()+"','"+sc.getDomicilioCobranza()+"','"+sc.getTelefonoCobranza()+"','"+sc.getEstadoDeSalud()+"',"+sc.getNumeroDePlan()+","+sc.getNumeroVendedor()+","+sc.getNumeroCobrador()+","+sc.getCantidadAdherentes()+","+sc.getTipoCondicion()+","+sc.getParentescoTitular()+","+sc.getMedicinaIntegral()+","+sc.getCantiMedicinaIntegral()+",'"+sc.getCarenciaMedicinaIntegral()+"',"+sc.getSepelio()+","+sc.getCantidadSepelio()+",'"+sc.getCarenciaSepelio()+"',"+sc.getEmergencias()+","+sc.getCantidadEmergencias()+",'"+sc.getCarenciaEmergencias()+"',"+sc.getNumeroTitular()+","+sc.getMontoACobrar()+")";
                //sql="insert into amtau_socios (numeroSolicitud,apellido,fechaDeAlta,numeroDocumento,fechaDeNacimiento,domicilioParticular,localidad,codigoPostal,telefono,domicilioCobranza,telefonoCobranza,estadoDeSalud,numeroDePlan,numeroVendedor,numeroCobrador,cantidadAdherentes,tipoCondicion,parentescoTitular,fechaCobro,medicinaIntegral,cantiMedicinaIntegral,carenciaMedicinaIntegral,sepelio,cantidadSepelio,carenciaSepelio,emergencias,cantidadEmergencias,carenciaEmergencias,montoACobrar,numeroTitular) values ("+sc.getNumeroSolicitud()+",'"+sc.getApellido()+"','"+sc.getFechaDeAlta()+"','"+sc.getNumeroDocumento()+"','"+sc.getFechaNacimiento()+"','"+sc.getDomicilioParticular()+"','"+sc.getLocalidad()+"','"+sc.getCodigoPostal()+"','"+sc.getTelefono()+"','"+sc.getDomicilioCobranza()+"','"+sc.getTelefonoCobranza()+"','"+sc.getEstadoDeSalud()+"',"+sc.getNumeroDePlan()+","+sc.getNumeroVendedor()+","+sc.getNumeroCobrador()+","+sc.getCantidadAdherentes()+","+sc.getTipoCondicion()+","+sc.getParentescoTitular()+",'"+sc.getFechaCobro()+"',"+sc.getMedicinaIntegral()+","+sc.getCantiMedicinaIntegral()+",'"+sc.getCarenciaMedicinaIntegral()+"',"+sc.getSepelio()+","+sc.getCantidadSepelio()+",'"+sc.getCarenciaSepelio()+"',"+sc.getEmergencias()+","+sc.getCantidadEmergencias()+",'"+sc.getCarenciaEmergencias()+"',"+sc.getMontoACobrar()+","+sc.getNumeroTitular()+")";
                st=cnn.createStatement();
                st.executeUpdate(sql);
                System.err.println(sql);
            }
            st.close();
            con.cerrarConeccion(cnn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    public void cargar() {
        try {
            System.out.println("numero ingresado:"+numeroSolicitud);
            Integer numSol=numeroSolicitud;
            Coneccion con=new Coneccion();
            Class.forName(con.getDriver());
            Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
            Statement s=cnn.createStatement();
            s.executeQuery("select * from amtau_socios where numeroSolicitud="+ numSol);
            ResultSet rs=s.getResultSet();
            while (rs.next())
            {
            this.numeroCliente=rs.getInt("numeroCliente");
            //this.numeroCliente=1;
            this.numeroSolicitud=rs.getInt("numeroSolicitud");
            //this.numeroSolicitud=numSol;
            this.apellido=rs.getString("apellido");
            //this.apellido="mauro";
            //this.apellido=rs.getString("apellido");
            }
            rs.close();
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Socios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarPlanes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

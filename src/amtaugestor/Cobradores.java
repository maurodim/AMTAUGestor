/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amtaugestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauro
 */
public class Cobradores implements Procedimientos{
    private Integer numero;
    private String nombre;
    private Double comision;
    private String direccion;
    private String telefono;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    //private ArrayList listado;
    
    public Double getComision() {
        return comision;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumero() {
        return numero;
    }
    public void cargarCobrador(Integer numero) throws ClassNotFoundException, SQLException
    {
        Coneccion con=new Coneccion();
        Class.forName(con.getDriver());
        Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
        Statement s=cnn.createStatement();
        ResultSet rs=s.executeQuery("select * from amtau_cobradores where numero="+ numero);
        this.nombre=rs.getString("nombre");
        this.comision=rs.getDouble("comision");
        rs.close();
        cnn.close();
    }

    public void alta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void baja(Integer numero) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificacion(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList listar() {
        try {
            ArrayList listado = new ArrayList();
            //Cobradores cob=new Cobradores();
            Coneccion con=new Coneccion();
            String sql="select * from viajante";
          Class.forName(con.getDriver());
          Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
          Statement s=cnn.createStatement();
          s.execute(sql);
          ResultSet rs=s.getResultSet();
          while(rs.next())
          {
              Cobradores cob=new Cobradores();
              cob.setNombre(rs.getString(2));
              cob.setDireccion(rs.getString(3));
              //cob.setComision(rs.getDouble(3));
              System.out.println(cob.getNombre()+" "+cob.getNumero()+" "+cob.getComision());
              listado.add(cob);
              
          }
          rs.close();
          s.close();
          cnn.close();
          return listado;
        } catch (SQLException ex) {
            Logger.getLogger(Cobradores.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cobradores.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    

    }

    public void actualizarListado(ArrayList listado) {
        try {
            Iterator it=listado.listIterator();
            Coneccion cnn=new Coneccion();
            Cobradores cob=new Cobradores();
            Connection con=cnn.getCp();
            String sql=null;
            Statement st=con.createStatement();
            while(it.hasNext()){
                cob=(Cobradores)it.next();
                sql="insert into amtau_cobradores (nombre,direccion) values ('"+cob.getNombre()+"','"+cob.getDireccion()+"')";
                st.executeUpdate(sql);
                
            }
            st.close();
            cnn.cerrarConeccion(con);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cobradores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cobradores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargar() {
        try {
            Coneccion con=new Coneccion();
            Class.forName(con.getDriver());
            Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
            Statement s=cnn.createStatement();
            ResultSet rs=s.executeQuery("select * from amtau_cobradores where numero="+ numero);
            this.nombre=rs.getString("nombre");
            this.comision=rs.getDouble("comision");
            rs.close();
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Cobradores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cobradores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificacion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cargarPlanes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

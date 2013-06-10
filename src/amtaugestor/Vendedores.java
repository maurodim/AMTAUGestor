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

/**
 *
 * @author mauro
 */
public class Vendedores {
    private Integer numero;
    private String nombre;
    private Double comision;

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    
    public Double getComision() {
        return comision;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumero() {
        return numero;
    }
    public void cargarVendedores(Integer numero) throws ClassNotFoundException, SQLException
    {
        Coneccion con=new Coneccion();
        Class.forName(con.getDriver());
        Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
        Statement s=cnn.createStatement();
        ResultSet rs=s.executeQuery("select * from amtau_vendedores where numero="+ numero);
        this.nombre=rs.getString("nombre");
        this.comision=rs.getDouble("comision");
        rs.close();
        cnn.close();
    }
   
}

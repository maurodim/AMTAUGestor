/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import amtaugestor.Cobradores;
import amtaugestor.Coneccion;
import amtaugestor.Socios;
import amtaugestor.Vendedores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Administrador
 */
public class Procesos {
  public ArrayList listarCobradores() throws ClassNotFoundException, SQLException
    {
     
        ArrayList listado = new ArrayList();
        //Cobradores cob=new Cobradores();
        Coneccion con=new Coneccion();
        String sql="select * from amtau_cobradores";
      Class.forName(con.getDriver());
      Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
      Statement s=cnn.createStatement();
      s.execute(sql);
      ResultSet rs=s.getResultSet();
      while(rs.next())
      {
          Cobradores cob=new Cobradores();
          cob.setNombre(rs.getString(2));
          cob.setNumero(rs.getInt(1));
          cob.setComision(rs.getDouble(3));
          System.out.println(cob.getNombre()+" "+cob.getNumero()+" "+cob.getComision());
          listado.add(cob);
          
      }
      rs.close();
      s.close();
      cnn.close();
      return listado;
    
    }   
   public ArrayList listarVendedores() throws ClassNotFoundException, SQLException
    {
      ArrayList listado = new ArrayList();
      //Vendedores vend=new Vendedores();
      String sql="select * from amtau_vendedores order by numero";
        Coneccion con=new Coneccion();
      Class.forName(con.getDriver());
      Connection cnn=DriverManager.getConnection(con.getBaseDeDatos(),con.getUsuario(),con.getPass());
      Statement s=cnn.createStatement();
      s.execute(sql);
      ResultSet rs=s.getResultSet();
      while(rs.next())
      {
          Vendedores vend=new Vendedores();
          vend.setNumero(rs.getInt(1));
          vend.setNombre(rs.getString(2));
          vend.setComision(rs.getDouble(3));
          listado.add(vend);
          
      }
      rs.close();
      s.close();
      cnn.close();
      return listado;
    }
   public void generarNuevaLiquidacion(String cuotaNumero) throws ClassNotFoundException, SQLException{
       Coneccion con=new Coneccion();
       Socios soc=new Socios();
       ArrayList listado=new ArrayList();
       Connection cnn=con.getCp();
       Statement st=cnn.createStatement();
       String sql="select * from amtau_socios where habilitado=0";
       st.execute(sql);
       ResultSet rs=st.getResultSet();
       while(rs.next()){
           soc=new Socios();
           soc.setNumeroCliente(rs.getInt("numeroCliente"));
           String solicitud=String.valueOf(rs.getInt("numeroSolicitud"));
           soc.setNumeroSolicitud(solicitud);
           soc.setNumeroCobrador(rs.getInt("numeroCobrador"));
           soc.setNumeroDePlan(rs.getInt("numeroDePlan"));
           soc.setMontoACobrar(rs.getInt("montoACobrar"));
           listado.add(soc);
           
           
       }
       rs.close();
       Iterator il=listado.listIterator();
       while(il.hasNext()){
           soc=(Socios)il.next();
           sql="insert into amtau_cobranza (numeroCobrador,numeroCliente,numeroDePlan,cuotaNumero,montoACobrar,tipoMovimiento) values("+soc.getNumeroCobrador()+","+soc.getNumeroSolicitud()+","+soc.getNumeroDePlan()+",'"+cuotaNumero+"',"+soc.getMontoACobrar()+",0)";
           st.executeUpdate(sql);
           System.out.println(sql);
           
       }
       st.close();
       con.cerrarConeccion(cnn);
   }
   public void emisionDeListado(){
       
   }
  
}

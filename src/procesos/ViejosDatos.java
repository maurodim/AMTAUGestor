/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import amtaugestor.Cobradores;
import amtaugestor.Coneccion;
import amtaugestor.Procedimientos;
import amtaugestor.Socios;
import amtaugestor.objetos.Planes;
import java.sql.Connection;
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
public class ViejosDatos implements Procedimientos{

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
        try {
            ArrayList listado=new ArrayList();    
            Coneccion con=new Coneccion();
                String sql="select *,(select amtau_planes.numero from amtau_planes where amtau_planes.nombre like clientes.COL17 limit 0,1)as plan,(select amtau_planes.monto from amtau_planes where amtau_planes.nombre like clientes.COL17 limit 0,1)as montoP from clientes order by COL3";
                Connection cnn=null;
                cnn=con.getCp();
                Statement st=cnn.createStatement();
                st.execute(sql);
                ResultSet rs=st.getResultSet();
                while(rs.next()){
                    Socios socios=new Socios();
                    socios.setNumeroSolicitud(rs.getString("COL1"));
                    String tipocondicion=rs.getString("COL2");
                    Integer tip=Integer.parseInt(tipocondicion);
                    socios.setTipoCondicion(tip);
                    socios.setApellido(rs.getString("COL3"));
                    socios.setDomicilioParticular(rs.getString("COL4"));
                    socios.setLocalidad(rs.getString("COL5"));
                    socios.setCodigoPostal(rs.getString("COL6"));
                    socios.setTelefono(rs.getString("COL8")+"-"+rs.getString("COL9"));
                    socios.setNumeroDocumento(rs.getString("COL12"));
                    socios.setNumeroDePlan(rs.getInt("plan"));
                    String monto=rs.getString("montoP");
                    System.out.println(monto);
                    if(monto==null){
                        monto="0";
                    }
                    Integer mont=Integer.parseInt(monto);
                    socios.setMontoACobrar(mont);
                    Integer cobrador=rs.getInt("COL16");
                    socios.setNumeroCobrador(cobrador);
                    socios.setNumeroVendedor(cobrador);
                    System.out.println("ACTUALIZACION :"+socios.getNumeroCobrador()+" "+socios.getApellido()+" "+socios.getNumeroSolicitud());
                    listado.add(socios);
                }
                rs.close();
                con.cerrarConeccion(cnn);
                return listado;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViejosDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ViejosDatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            
    }

    public void actualizarListado(ArrayList listado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cargar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cargarPlanes() {
        try {
            ArrayList listadoPlanes=new ArrayList();
            Planes pl=new Planes();
            Coneccion con=new Coneccion();
            Connection cnn=con.getCp();
            String sql="select * from planes";
            Statement st=cnn.createStatement();
            st.execute(sql);
            ResultSet rs=st.getResultSet();
            while(rs.next()){
                pl=new Planes();
                pl.setDescripcion(rs.getString("COL3"));
                pl.setNombre(rs.getString("COL1"));
                Integer monto=Integer.parseInt(rs.getString("COL 13"));
                pl.setMonto(monto);
                listadoPlanes.add(pl);
                
            }
            rs.close();
            Iterator il=listadoPlanes.listIterator();
            while(il.hasNext()){
                pl=(Planes)il.next();
                sql="insert into amtau_planes (descripcion,monto,nombre) values('"+pl.getDescripcion()+"',"+pl.getMonto()+",'"+pl.getNombre()+"')";
                st.executeUpdate(sql);
            }
            st.close();
            con.cerrarConeccion(cnn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViejosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViejosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

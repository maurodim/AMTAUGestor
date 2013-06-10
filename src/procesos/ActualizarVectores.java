/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import amtaugestor.Coneccion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauro
 */
public class ActualizarVectores extends Thread{
    private static Connection cav;
    public synchronized void run(){
        try {
            Coneccion con=new Coneccion();
            cav=con.getCp();
            String sql="select * from amtau_socios";
            Statement st=cav.createStatement();
            st.execute(sql);
            ResultSet rs=st.getResultSet();
            while(rs.next()){
                
            }
            st.close();
            rs.close();
            con.cerrarConeccion(cav);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ActualizarVectores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ActualizarVectores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
}

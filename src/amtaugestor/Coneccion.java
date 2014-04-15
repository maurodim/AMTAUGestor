/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amtaugestor;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mauro
 */
public class Coneccion {
    private String driver="com.mysql.jdbc.Driver";
    private String baseDeDatos="jdbc:mysql://201.235.253.65:3306/maurodim_amtau";
    private String usuario="maurodim";
    private String pass="mau*2012";
    private Connection cp;

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public String getDriver() {
        return driver;
    }

    public String getPass() {
        return pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public Connection getCp() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection cp=DriverManager.getConnection(baseDeDatos,usuario,pass);
        //MysqlDataSource dataSource=new MysqlDataSource();
		try{
			//Class.forName(driver1).newInstance();
                    /*
                        dataSource.setUser("maurodim");
                    dataSource.setDatabaseName("maurodim_amtau");
                    dataSource.setPassword("mau*2012");
                    dataSource.setServerName("201.235.253.65:3306");
                    */
                    //cp=dataSource.getConnection();
                 }catch(Exception ex){
                    
                String cod1=String.valueOf(ex);
                
			System.out.println("NO SE PUDO CONECTAR A LA BASE "+ex);
		}

        return cp;
    }
    public void cerrarConeccion(Connection hd) throws SQLException{
        hd.close();
    }
    
    
    
}

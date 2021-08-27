package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import utilidades.Propiedades;

public abstract class Conexion {
    
    private String usuario;
    private String clave;
    private String url;
    private String driver;
    protected Connection objConexion;

    public Conexion() {
        
           usuario = "user_ciclo2";
           clave = "123456";
           url = "jdbc:mysql://localhost:3306/ciclo2_reto5db";
           driver = "com.mysql.cj.jdbc.Driver";
           
//        String archivoVariables = "variablesBD";
//        
//        usuario = Propiedades.leer(archivoVariables, "nombre_usuario").replaceAll("\"" ," ");
//        clave = Propiedades.leer(archivoVariables, "clave_usuario").replaceAll("\"" ," ");
//        url = Propiedades.leer(archivoVariables, "url_conexion").replaceAll("\"" ," ");
//        driver = Propiedades.leer(archivoVariables, "driver").replaceAll("\"" ," ");
//        
            activar();
    }
    
    private void activar(){
        try {
            Class.forName(driver);
            objConexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

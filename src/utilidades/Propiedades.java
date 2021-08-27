package utilidades;

import configuracion.Dominios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Propiedades {

    public static String leer(String nombreArchivo, String valor) {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(new File(Dominios.RUTA_PROYECTO + "\\data\\" + nombreArchivo + ".properties")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return properties.get(valor).toString();

    }
}

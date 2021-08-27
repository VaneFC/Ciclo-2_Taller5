package dao;

import configuracion.Conexion;
import interfaces.Operaciones;
import java.util.List;
import modelos.Estudiante;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAOEstudiante extends Conexion implements Operaciones<Estudiante>{

    private String sql;
    private PreparedStatement consulta;

    public DAOEstudiante() {
    }
    
    
    
    @Override
    public boolean agregar(Estudiante objeto) {
        try {
            sql = "INSERT INTO notas (nombreestudiante, nota1, nota2, nota3, notaFinal) VALUES(?,?,?,?,?)";
            consulta = objConexion.prepareStatement(sql);
            consulta.setString(1, objeto.getNombreEstudiante());
            consulta.setString(2, objeto.getNota1().toString());
            consulta.setString(3, objeto.getNota2().toString());
            consulta.setString(4, objeto.getNota3().toString());
            consulta.setString(5, objeto.getNotaFinal().toString());
            int filas = consulta.executeUpdate();
            objConexion.close();
            return filas > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        
     }

    @Override
    public List<Estudiante> consultar() {
        try {
            ResultSet rs;
            List<Estudiante> arregloPerfiles = new ArrayList<>();

            sql = "SELECT nombreestudiante, nota1, nota2, nota3, notaFinal FROM notas ORDER BY idnota ASC";
            consulta = objConexion.prepareStatement(sql);
            rs = consulta.executeQuery();

            while (rs.next()) {
                Estudiante objTmp = new Estudiante();
                objTmp.setIdNota(Integer.parseInt(rs.getObject(1).toString()));
                objTmp.setNombreEstudiante(rs.getObject(2).toString());
                objTmp.setNota1(Integer.parseInt(rs.getObject(3).toString()));
                objTmp.setNota2(Integer.parseInt(rs.getObject(4).toString()));
                objTmp.setNota3(Integer.parseInt(rs.getObject(5).toString()));
                
                arregloPerfiles.add(objTmp);
            }
            objConexion.close();
            return arregloPerfiles;
        } catch (NumberFormatException | SQLException ex) {
            Logger.getLogger(DAOEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }

    @Override
    public boolean actualizar(Estudiante objeto) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Estudiante buscar(Integer llavePK) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}

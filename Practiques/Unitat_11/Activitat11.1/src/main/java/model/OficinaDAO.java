package model;

import model.Connexio;
import model.Oficina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OficinaDAO {
    public List<Oficina> getAll() {
        List<Oficina> oficinas = new ArrayList<>();
        
        String sql = "SELECT * FROM Oficines";
        
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Oficina oficina = new Oficina(
                    rs.getInt("oficinaId"),
                    rs.getString("ciutat"),
                    rs.getInt("superficie"),
                    rs.getDouble("vendes")
                );
                oficinas.add(oficina);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
        
        return oficinas;
    }
    
    public List<Oficina> getByCiutat(String ciutat) {
        List<Oficina> oficines = new ArrayList<>();
        String sql = "SELECT * FROM Oficines WHERE ciutat = ?";
        
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            
            pstmt.setString(1, ciutat);
            //System.out.println(pstmt.toString());
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Oficina oficina = new Oficina(
                    rs.getInt("oficinaId"),
                    rs.getString("ciutat"),
                    rs.getInt("superficie"),
                    rs.getDouble("vendes")
                );
                oficines.add(oficina);
            }            
        } catch(SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
        return oficines;
    }

    public boolean existeixOficina(int oficinaId) {
        String sql = "SELECT COUNT(*) FROM Oficines WHERE oficinaId = ?";
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            
            pstmt.setInt(1, oficinaId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                int count = rs.getInt(1);
                
                return count > 0;
            }
        } catch(SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
        
        return false;
    }
    public void actualitzarCiutat(int oficinaId, String ciudad) {
        String sql = "UPDATE Oficines SET ciutat = ? WHERE oficinaId = ?";
        
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            
            pstmt.setString(1, ciudad);
            pstmt.setInt(2, oficinaId);
            
            int rows = pstmt.executeUpdate();
            if(rows > 0) {
                System.out.println("La ciudad ha sido actualizada correctamente.");
            } else {
                System.out.println("No se encontró la oficina");
            }
        } catch(SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }

    }
    
    public void incrementarVendes(int oficinaId, double incremento) {
        String sqlObtener = "SELECT vendes FROM oficines WHERE oficinaId = ?";
        double ventasActuales = 0.0;
        
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sqlObtener);
            
            pstmt.setInt(1, oficinaId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                ventasActuales = rs.getDouble("vendes");
            }
        } catch(SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }

        String sql = "UPDATE Oficines SET vendes = ? WHERE oficinaId = ?";
        
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            
            pstmt.setDouble(1, ventasActuales + incremento);
            pstmt.setInt(2, oficinaId);
            
            int rows = pstmt.executeUpdate();
            if(rows > 0) {
                System.out.println("Las ventas han sido actualizadas correctamente.");
            } else {
                System.out.println("No se encontró la oficina");
            }
        } catch(SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    }
}

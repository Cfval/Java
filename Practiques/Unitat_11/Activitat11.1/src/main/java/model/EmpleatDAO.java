package model;

import model.Connexio;
import model.Empleat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleatDAO {
    public List<Empleat> getAll() {
        List<Empleat> empleats = new ArrayList<>();
        
        String sql = "SELECT * FROM Empleats";
        
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement prepared = connexio.getPrepared(sql);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {
                String contracte = rs.getString("contracte");
                LocalDate contracteDate = LocalDate.parse(contracte);

                Empleat empleat = new Empleat(
                    rs.getInt("numemp"),
                    rs.getString("nom"),
                    rs.getInt("edat"),
                    rs.getInt("oficina"),
                    rs.getString("ocupacio"),
                        
                    contracteDate
                );
                empleats.add(empleat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return empleats;
    }
    
    public List<Empleat> getByEdatRange(int minEdat, int maxEdat) {
        List<Empleat> empleats = new ArrayList<>();
        
        String sql = "SELECT * FROM Empleats WHERE edat BETWEEN ? AND ?";
        
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            
            pstmt.setInt(1, minEdat);
            pstmt.setInt(2, maxEdat);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                String contracte = rs.getString("contracte");
                LocalDate contracteDate = LocalDate.parse(contracte);
                
                Empleat empleat = new Empleat(
                    rs.getInt("numemp"),
                    rs.getString("nom"),
                    rs.getInt("edat"),
                    rs.getInt("oficina"),
                    rs.getString("ocupacio"),
                    contracteDate
                );
                empleats.add(empleat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return empleats;
    }    

    public void insertarEmpleat(int numemp, String nom, int edat, int oficina, String ocupacio) {
        String sql = "INSERT INTO Empleats (numemp, nom, edat, oficina, ocupacio, contracte) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            
            pstmt.setInt(1, numemp);
            pstmt.setString(2, nom);
            pstmt.setInt(3, edat);
            pstmt.setInt(4, oficina);
            pstmt.setString(5, ocupacio);
            pstmt.setDate(6, java.sql.Date.valueOf(LocalDate.now()));
        
            pstmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    }
    public void afegir(Empleat empleat) {
        String sql = "INSERT INTO Empleats (numemp, nom, edat, oficina, ocupacio, contracte) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            
            pstmt.setInt(1, empleat.getNumemp());
            pstmt.setString(2, empleat.getNom());
            pstmt.setInt(3, empleat.getEdat());
            pstmt.setInt(4, empleat.getOficina());
            pstmt.setString(5, empleat.getOcupacio());
            pstmt.setDate(6, java.sql.Date.valueOf(empleat.getContracte()));
        
            pstmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    }
    
    public boolean existeixEmpleat(int numemp) {
        String sql = "SELECT COUNT(*) FROM Empleats WHERE numemp = ?";
        try {
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            
            pstmt.setInt(1, numemp);
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
    
    public void moure(int de, int hasta) {
        String sql = "UPDATE Empleats SET oficina = ? WHERE oficina = ?";
        try {    
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            
            pstmt.setInt(1, de);
            pstmt.setInt(1, hasta);
            
            int rows = pstmt.executeUpdate();
            if(rows > 0) {
                System.out.println("Empleados trasladados");
            } else {
                System.out.println("No se ha trasladado ningún empleado");
            }
        } catch(SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    }
    
    public void eliminar(int numemp) {
        String sql = "DELETE FROM Empleats WHERE numemp = ?";
        
        try {    
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            
            pstmt.setInt(1, numemp);
            int rows = pstmt.executeUpdate();
            
            if(rows > 0) {
                System.out.println("Empleado eliminado con éxito.");
            } else {
                System.out.println("No se encontró el empleado.");
            }
        } catch(SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }

    }
}

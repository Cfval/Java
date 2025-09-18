package principal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import model.Connexio;
import model.Empleat;
import model.EmpleatDAO;
import model.Oficina;
import model.OficinaDAO;

public class Principal {

    public static void main(String[] args) {
        try {
            Scanner teclat = new Scanner(System.in);
            Connexio connexio = Connexio.getConnexio();

            // 1 - RESOLT
            String sql = "SELECT * FROM Empleats";
            PreparedStatement prepared = connexio.getPrepared(sql);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {
                int numeroEmpleat = rs.getInt("numemp");
                String nom = rs.getString("nom");
                int edat = rs.getInt("edat");
                int oficina = rs.getInt("oficina");
                String ocupacio = rs.getString("ocupacio");
                String contracte = rs.getString("contracte");
                LocalDate contracteDate = LocalDate.parse(contracte);
                //System.out.println(contracteDate);
                System.out.println(numeroEmpleat + " - " + nom + " - " + edat + " - " + oficina + " - " + ocupacio + " - " + contracte);

            }
            
            
            //o también podemos hacer
            EmpleatDAO empleatDAO = new EmpleatDAO();
            List<Empleat> empleats = empleatDAO.getAll();
            for(Empleat empleat : empleats) {
                System.out.println(empleat.getNom() + " - " + empleat.getEdat());
            }
            
            //empleats.stream().forEach(System.out::println);

            //2 - Implementa classes i mètodes que calguen.
            
            OficinaDAO oficinaDAO = new OficinaDAO();
            System.out.println(oficinaDAO.getAll());

            //3 - Implementa classes i mètodes que calguen.
            System.out.println(oficinaDAO.getByCiutat("Petrer"));

            //4
            System.out.print("Introdueix edat mínima: ");
            int minima = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix edat màxima: ");
            int maxima = teclat.nextInt();
            teclat.nextLine();
            // Implementa ací el codi que falta, similar a l'exercici 1
            System.out.println(empleatDAO.getByEdatRange(minima, maxima));
            
            
            //5
            System.out.print("Introdueix codi empleat: ");
            int numeroEmpleat = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix nom: ");
            String nom = teclat.nextLine();
            System.out.print("Introdueix edat: ");
            int edat = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix codi oficina: ");
            int oficina = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix ocupació: ");
            String ocupacio = teclat.nextLine();
            // Implementa ací el codi que falta.
            empleatDAO.insertarEmpleat(numeroEmpleat, nom, edat, oficina, ocupacio);
            
            //6-7-8 Implementa classes i mètodes que calguen.
            
            //new EmpleatDAO().afegir(empleatAInserir);
            
            if(!oficinaDAO.existeixOficina(oficina)) {
                System.out.println("La oficina no existe.");
            } else if(empleatDAO.existeixEmpleat(numeroEmpleat)) {
                System.out.println("El empleado ya exite.");
            } else {
                Empleat empleatAInserir = new Empleat(numeroEmpleat, nom, edat, oficina, ocupacio, LocalDate.now());
                empleatDAO.afegir(empleatAInserir);
                System.out.println("Empleado añadido");
            }
            
            // 9 Implementa classes i mètodes que calguen.
            if(oficinaDAO.existeixOficina(2) && oficinaDAO.existeixOficina(3)) {
                empleatDAO.moure(2, 3);
            } else {
                System.out.println("No existen las oficinas");
            }
            
            //10 Implementa classes i mètodes que calguen.
            empleatDAO.eliminar(4);
            
            //11 
            List<Oficina> oficines = oficinaDAO.getAll();
            if(oficines.isEmpty()) {
                System.out.println("No hay oficinas");
            } else {
                oficines.stream().forEach(System.out::println);
            }
            
            //12
            System.out.print("Introdueix una superficie mínima: ");
            int superficie = teclat.nextInt();
            teclat.nextLine();
            // Implementa ací el codi que falta.
            for(Oficina of : oficines) {
                if(of.getSuperficie() > superficie) {
                    System.out.println(oficina);
                }
            }
            //13
            oficinaDAO.actualitzarCiutat(9, "Sax");
            
            //14
            oficinaDAO.incrementarVendes(9, 100.5);

            //connexio.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
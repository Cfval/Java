/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dto.Departament;
import dto.Empleat;
import dao.DepartamentsDAO;
import dao.EmpleatsDAO;

import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 * @author jmas
 */
public class Main {
    public static void main(String[] args) {
        
        /* 1.- Imprimeix el primer empleat trobat amb més de 50 anys*/ ex("1");
        EmpleatsDAO.getEmpleats().stream()
            .filter(e -> e.getEdat() > 50)
            .findFirst()
            .ifPresent(System.out::println);
        
        
        /* 2. Imprimeix true si tots els empleats son majors d'edat i false en cas contrari*/ ex("2");
        boolean totsMajorsDEdat = EmpleatsDAO.getEmpleats().stream()
            .allMatch(e -> e.getEdat() >= 18);
        System.out.println(totsMajorsDEdat);
        
        
        /* 3. Imprimeix true si hi ha algun empleat major de 65 anys i false en cas contrari*/ ex("3");
        boolean casiJubilat = EmpleatsDAO.getEmpleats().stream()
                .anyMatch(e -> e.getEdat() >= 65);
        System.out.println(casiJubilat);
                
        
        /* 4. Imprimeix el número d'empleats que tenen més de 50 anys*/ ex("4");
        long empleatsMesDe50 = EmpleatsDAO.getEmpleats().stream()
                .filter(e -> e.getEdat() > 50)
                .count();
        System.out.println(empleatsMesDe50);
        
        /* 5. Imprimeix el nom dels empleats del departament d'informàtica, en majúscules.*/ ex("5");
        Departament informatica = DepartamentsDAO.getDepartaments().stream()
            .filter(d -> d.getNom().equals("Informàtica"))
            .findFirst()
            .orElse(null);

        if (informatica != null) {
            String nomsEnMajuscula = EmpleatsDAO.getEmpleats().stream()
                .filter(e -> e.getDepartament().equals(informatica))
                .map(e -> e.getNom().toUpperCase())
                .collect(Collectors.joining(", "));
            
            System.out.println(nomsEnMajuscula);     
        }
                
        /* 6. Imprimeix la quantitat de lletres de l'empleat d'informàtica amb el nom més llarg.*/ ex("6");

        if (informatica != null) {
            Empleat nomMesLlarg = EmpleatsDAO.getEmpleats().stream()
            .max((e1, e2) -> Integer.compare(e1.getNom().length(), e2.getNom().length()))
            .orElse(null);
            
            if (nomMesLlarg != null) {
                System.out.println(nomMesLlarg.getNom().length());
            }
        }
        
        /* 7. Imprimeix el nom dels departaments que comencen per C*/ ex("7");
        String depsPerC = DepartamentsDAO.getDepartaments().stream()
                .filter(d -> d.getNom().toUpperCase().startsWith("C"))
                .map(d -> d.getNom())
                .collect(Collectors.joining(", "));
        
        System.out.println(depsPerC);
        
        /* 8. Imprimeix la suma de totes les edats dels empleats*/ ex("8");
        int sumaEdats = EmpleatsDAO.getEmpleats().stream()
            .mapToInt(e -> e.getEdat())
            .sum();
        System.out.println(sumaEdats);
        
        /* 9 UTILITZA EL MÈTODE GETEMPLEATS DE LA CLASSE DEPARTAMENT (NOMÉS PER A L'EXERCICI 9 I 10)*/ ex("9");
        // Imprimeix la quantitat d'empleats de cada departament
        List <Departament> departaments = DepartamentsDAO.getDepartaments();
        departaments.forEach(dept -> {
            long quantitatEmpleats = dept.getEmpleats().size();
            System.out.print(dept.getNom() + ": " + quantitatEmpleats + " | ");
        });
        
        System.out.println();
        
        /* 10. UTILITZANT EL MÈTODE GETEMPLEATS DE LA CLASSE DEPARTAMENT (NOMÉS PER A L'EXERCICI 9 I 10)*/ ex("10");
        // Imprimeix la llista de noms dels empleats del departament comercial i de comptatilitat (una única llista d'String)
        List <String> nomsEmpleats = departaments.stream()
            .filter(dept -> dept.getNom().equals("Comercial") || dept.getNom().equals("Comptabilitat"))
            .flatMap(dept -> dept.getEmpleats().stream())
            .map(Empleat::getNom)
            .collect(Collectors.toList());

        String separarNomsEmpleats = String.join(", ", nomsEmpleats);
        System.out.println(separarNomsEmpleats);
            
        /* 11. El mateix d'abans però mostra els noms ordenats alfabèticament.*/ ex("11");
        List <String> nomsEmpleatsEnOrdre = departaments.stream()
            .filter(dept -> dept.getNom().equals("Comercial") || dept.getNom().equals("Comptabilitat"))
            .flatMap(dept -> dept.getEmpleats().stream())
            .map(Empleat::getNom)
            .sorted()
            .collect(Collectors.toList());

        String separarNomsEmpleatsEnOrdre = String.join(", ", nomsEmpleatsEnOrdre);
        System.out.println(separarNomsEmpleatsEnOrdre);
        
        /* 12. Mostra la mitjana d'edat dels empleats del departament d'informàtica.*/ ex("12");
        if (informatica != null) {
            OptionalDouble mitjanaEdat = EmpleatsDAO.getEmpleats().stream()
                .filter(e -> e.getDepartament().equals(informatica))
                .mapToInt(e -> e.getEdat())
                .average();
            mitjanaEdat.ifPresent(System.out::println);
        }
        
        /* 13. Mostra un String que serà el resultat de concatenar la primera lletra de cada departament.*/ ex("13");
        String primeraLletraDepartaments = DepartamentsDAO.getDepartaments().stream()
            .map(dept -> String.valueOf(dept.getNom().charAt(0)))
            /*.reduce("", (acumulador, lletra) -> acumulador + lletra); //Servix per a combinar tots els elements en un. ("",) es el valor inical de l'acumulador y després a este se suma el resultat en cada iteració. */
            .collect(Collectors.joining(", "));
        System.out.println(primeraLletraDepartaments);    
        
        /* 14. Mostra el número de telèfon més alt dels departaments.*/ ex("14");
        DepartamentsDAO.getDepartaments().stream()
            .mapToInt(Departament::getTelefon)
            .max()
            .ifPresent(System.out::println);
        
        
        /* 15. Mostra el departament complet amb el número de telèfon més alt.*/ ex("15");
        DepartamentsDAO.getDepartaments().stream()
            .reduce((dept1, dept2) -> dept1.getTelefon() > dept2.getTelefon() ? dept1 : dept2)
            .ifPresent(System.out::println);

        /* 16. Sense fer ús del mètode "getEmpleats". Dels departament que tenen treballadors, mostrar el nom del departament i el nombre de treballadors que hi treballen.*/ ex("16");
         EmpleatsDAO.getEmpleats().stream()
            .collect(Collectors.groupingBy(Empleat::getDepartament, Collectors.counting()))
            .forEach((dept,compte) -> System.out.print(dept.getNom() + ": " + compte + " | "));
        System.out.println();
        
        /* 17A. Guarda en un Map un registre per a cada Departament (que tinga treballadors) que tinga associat com a valor la llista d'empleats d'eixe departament*/ ex("17A");
        Map<Departament, List<Empleat>> empleatsPerDepartament = DepartamentsDAO.getDepartaments().stream()
            .filter(dept -> !dept.getEmpleats().isEmpty())
            .collect(Collectors.toMap(
                dept -> dept,
                Departament::getEmpleats
            ));

        /*empleatsPerDepartament.forEach((dept, empleats) -> {
            System.out.println(dept.getNom() + ": " + empleats);
        });*/ 
        System.out.println();
        
        /* 17B. Igual que l'anterior pero la llista no serà d'empleats sino del nom dels empleats*/ ex("17B");
         Map<Departament, List<String>> nomsEmpleatsPerDept = DepartamentsDAO.getDepartaments().stream()
            .filter(dept -> !dept.getEmpleats().isEmpty())
            .collect(Collectors.toMap(dept -> dept, dept -> dept.getEmpleats().stream()
                .map(Empleat::getNom)
                .collect(Collectors.toList())
            ));
           
        nomsEmpleatsPerDept.forEach((dept, llistaNomsEmpleats) -> {
            System.out.print(dept.getNom() + ": " + llistaNomsEmpleats + " | ");
        });
        System.out.println();
        
        /* 17C. Igual que l'anterior pero amb els empleats ordenats alfabèticament*/ ex("17C");
        Map<Departament, List<String>> nomsEmpleatsPerDeptOrdenats = DepartamentsDAO.getDepartaments().stream()
            .filter(dept -> !dept.getEmpleats().isEmpty())
            .collect(Collectors.toMap(dept -> dept, dept -> dept.getEmpleats().stream()
                .map(Empleat::getNom)
                .sorted()
                .collect(Collectors.toList())
            ));
           
        nomsEmpleatsPerDeptOrdenats.forEach((dept, llistaNomsEmpleats) -> {
            System.out.print(dept.getNom() + ": " + llistaNomsEmpleats + " | ");
        });
        System.out.println();
        
        /* 18A. Obtín un Map que continga per a cada departament una llista d'enters grans (BigInteger) que es corresponguen amb les edats dels empleats d'eixe departament*/ ex("18A");
        Map<Departament, List<BigInteger>> edatsPerDept = DepartamentsDAO.getDepartaments().stream()
            .filter(dept -> !dept.getEmpleats().isEmpty())
            .collect(Collectors.toMap(
                dept -> dept,
                dept -> dept.getEmpleats().stream()
                    .map(Empleat::getEdat)
                    .map(BigInteger::valueOf)
                    .collect(Collectors.toList())
            ));
        
        edatsPerDept.forEach((dept, llistaEdats) -> {
            System.out.print(dept.getNom() + ": " + llistaEdats + " | ");
        });
        System.out.println();
        
        /* 18B. El mateix que abans però en comptes de l'edat, el probable següent número primer*/ ex("18B");
        
        System.out.println();
        
        /* 19. Obtín un Map que continga per a cada departament l'empleat més jove.*/ ex("19");
        Map<Departament, Empleat> empleatMesJovePerDept = DepartamentsDAO.getDepartaments().stream()
            .filter(dept -> !dept.getEmpleats().isEmpty())
            .collect(Collectors.toMap(
                dept -> dept,
                dept -> dept.getEmpleats().stream()
                    .min(Comparator.comparing(Empleat::getEdat))
                    .orElse(null)        
            ));
        
        /*empleatMesJovePerDept.forEach((dept, empleat) -> {
            System.out.println(dept.getNom() + ": " + empleat);
        });*/
        System.out.println();
        
        /* 20. Obtín un String que continga el mateix que abans, amb el format "Departament1:Empleat1, Departament2:Empleat2 ..."*/ ex("20");
        String nomsEmpleatMesJovePerDept = DepartamentsDAO.getDepartaments().stream()
            .filter(dept -> !dept.getEmpleats().isEmpty())
            .map(dept -> {
                Optional<Empleat> empleatMesJove = dept.getEmpleats().stream()
                    .min(Comparator.comparing(Empleat::getEdat));
                return dept.getNom() + ": " + (empleatMesJove.isPresent() ? empleatMesJove.get().getNom() : "");
            })
            .collect(Collectors.joining(", "));

        System.out.println(nomsEmpleatMesJovePerDept);
        
        
        /* 21. Obtín un Map que conté com a clau el DNI dels empleats i com a valor el nom d'eixe empleat*/ ex("21");
        
        Map<String, String> dniNomEmpleats = EmpleatsDAO.getEmpleats().stream()
            .collect(Collectors.toMap(
                Empleat::getDni,
                Empleat::getNom
            ));

        dniNomEmpleats.forEach((dni, nom) -> {
            System.out.println(dni + ": " + nom);
        });
        
        /* 21A. Obtín una llista d'Strings que continga DNI dels empleats i el nom d'eixe empleat amb el format DNI - Nom. Llista ordenada per DNI*/ ex("21A");
        List<String> dniNomEmpleatsOrdenats = EmpleatsDAO.getEmpleats().stream()
            .map(e -> e.getDni() + " - " + e.getNom())
            .sorted()
            .collect(Collectors.toList());
        dniNomEmpleatsOrdenats.forEach(System.out::println);
        
        /* 22A. Donat un array bidimensional d'Integer transformar-lo en un array unidimensional amb els mateixos valors:*/ ex("22A");
        Integer[][] matriuInteger = {{3, 2, 5}, {0, -8, 7}, {9, 9, 6}};
        Integer[] arrayUnidimensional = Arrays.stream(matriuInteger)
            .flatMap(Arrays::stream)
            .toArray(Integer[]::new);

        System.out.println(Arrays.toString(arrayUnidimensional));
        
        /* 22B. Versió amb int[] en comptes d'Integer[]*/ ex("22B");
        int[][] matriuInt = {{3, 2, 5}, {0, -8, 7}, {9, 9, 6}};
        int[] arrayUnidimensionalInt = Arrays.stream(matriuInt)
            .flatMapToInt(Arrays::stream)
            .toArray();

        System.out.println(Arrays.toString(arrayUnidimensionalInt));
        
        /* 23. Guarda una llista amb els noms dels estudis de tots els empleats (de forma única), ordenats alfabèticament.*/ ex("23");
        List<String> estudisOrdenats = EmpleatsDAO.getEmpleats().stream()
            .flatMap(empleat -> empleat.getTitols().stream())
            .distinct()
            .sorted()
            .collect(Collectors.toList());

        estudisOrdenats.forEach(System.out::println);
        
        /* 24. Imprimeix per pantalla aquells empleats que tinguen un CFGS*/ ex("24");
        EmpleatsDAO.getEmpleats().stream()
            .filter(empleat -> empleat.getTitols().contains("CFGS"))
            .forEach(System.out::println);
        
        /* 25. Mostra un empleat qualsevol que tinga una llicenciatura*/ ex("25");
        
        /* Esta vegada utilitzaré un optional 
        EmpleatsDAO.getEmpleats().stream()
            .filter(empleat -> empleat.getTitols().contains("Llicenciatura"))
            .findAny()
            .ifPresent(System.out::println);*/
        Optional<Empleat> empleatAmbLlicenciatura = EmpleatsDAO.getEmpleats().stream()
            .filter(empleat -> empleat.getTitols().contains("Llicenciatura"))
            .findAny();

        empleatAmbLlicenciatura.ifPresent(System.out::println);
        
        
        /* 26. Mostra per a cada nom d'empleat la suma de les lletres dels seus titols*/ ex("26");
        EmpleatsDAO.getEmpleats().forEach(empleat -> {
            int sumaLletresTitols = empleat.getTitols().stream()
                .mapToInt(String::length)
                .sum();
            System.out.println(empleat.getNom() + ": " + sumaLletresTitols);
        });
        
        /* 27. Mostra el total de lletres dels titols (incloent duplicats) dels empleats*/ ex("27");
        int totalLletresTitols = EmpleatsDAO.getEmpleats().stream()
            .flatMap(empleat -> empleat.getTitols().stream())
            .mapToInt(String::length)
            .sum();

        System.out.println("Total de lletres dels titols: " + totalLletresTitols);
        
        /* 28. Mostra l'empleat amb major quantitat de títols*/ ex("28");
        Optional<Empleat> empleatAmbMesTitols = EmpleatsDAO.getEmpleats().stream()
            .max(Comparator.comparingInt(empleat -> empleat.getTitols().size()));

        empleatAmbMesTitols.ifPresent(System.out::println);
        
        /* 29A. Obtín una llista que continga 5 aleatoris entre 0 i 9 en format String*/ ex("29A");
        List<String> cincAleatoris = new Random().ints(5, 0, 10)
            .mapToObj(String::valueOf)
            .collect(Collectors.toList());

        System.out.println(cincAleatoris);
        
        /* 29B. El mateix d'abans, però ara sense valors repetits.*/ ex("29B");
        List<String> aleatorisSenseRepetits = new Random().ints(5, 0, 10)
            .distinct()
            .mapToObj(String::valueOf)
            .collect(Collectors.toList());

        System.out.println(aleatorisSenseRepetits);
        
        /* 30. Crea un stream amb tots els números positius divisibles entre 3. Després filtra aquells que siguen quadrats perfectes. */ ex("30");
        // Després descarta els 5 primers valors obtinguts. Finalment mostra els 10 següents valors obtinguts
        
        
        
        /* 31. A partir dels cognoms dels empleats imprimeix amb una operació intermèdia els cognoms sense transformar i després transformats en majúscules.*/ ex("31");
        // Finalment retorna el nombre d'empleats.
        
        
        
        /* 32. Imprimeix el cognom dels empleats ordenats en ordre alfabètic invers.*/ ex("32");
        EmpleatsDAO.getEmpleats().stream()
            .map(Empleat::getCognoms)
            .sorted((s1, s2) -> s2.compareTo(s1))
            .forEach(System.out::println);
        
        /* 33. Obtín la suma dels títols de tots els empleats*/  ex("33");
        int sumaTitols = EmpleatsDAO.getEmpleats().stream()
            .mapToInt(empleat -> empleat.getTitols().size())
            .sum();

        System.out.println("Suma dels titols: " + sumaTitols);
        
        /* 34. Obtín un String amb la concatenació dels títols d'aquells empleats que tinguen menys de 30 anys, separats per espais (sense duplicats)*/ ex("34");
        String titolsMenors30 = EmpleatsDAO.getEmpleats().stream()
            .filter(empleat -> empleat.getEdat() < 30)
            .flatMap(empleat -> empleat.getTitols().stream())
            .distinct()
            .collect(Collectors.joining(" "));

        System.out.println("Titols de empleats menors de 30: " + titolsMenors30);
        
        /* 35A. Mostra el cognom del primer dels empleats trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra "No trobat"*/ ex("35A");
        // ¿I si proves per a menors de 40?
        
        
        /* 35B. Mostra el primer dels empleats (complet) trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra "No trobat"*/ ex("35B");
        // ¿I si proves per a menors de 40?
        
        // 36. Obtín un LinkedHashSet dels títols que tenen tots els empleats.
       
        // 37. Obtín un Map amb dos claus, la primera tindrá com a valors una llista dels empleats amb el títol de CFGS i l'altra clau tindrá una llista amb els que no el tenen.
        
        // 38. A partir d'una llista d'String retorna la mateixa llista pero sense cadenes buides
        List<String> elementsOriginals = List.of("aigua", "", "llet", "oli", "", "  ", "lletuga");

        // 39. Obtín una cadena separada per comes basada en una llista determinada d'enters. 
        // Cada element ha d'anar precedit de la lletra 'p' si el nombre és parell i precedit de la lletra 'i' si el nombre és imparell. 
        // Per exemple, si la llista d'entrada és (3,44), la eixida hauria de ser 'i3, p44'.
        List<Integer> llistaEnters = List.of(9,23,4,15);
        
        // 40.A partir dels empleats. Obtín un mapa que tinga com a clau el nom del departament i com a valor un altre mapa
        // Este segon mapa tindrà com a clau el cognom de l'empleat y com a valor la llista de títols que té.
        
        // EXTRA A: A partir d'un String retorna les lletres distintes que conté, separades per comes (només lletres, no espais ni números ni altres caracters)
        String frase1 = "Tinc un 8 en PROG";
        
        // EXTRA B: A partir d'un String retorna la quantitat de lletres distintes que conté (només lletres, no espais ni números ni altres caracters)
        
        // EXTRA C: Obtín un mapa que mostre com a clau cada lletra distinta del String, i com a valor la quantitat de vegades que apareix.
                
        // EXTRA D: Mostra la lletra amb major freqüencia d'aparicions, i el nombre d'aparicions d'eixa lletra.
       

    }
    
    public static void ex(String exercici) {
        System.out.print(exercici + ": ");
    }
    
}

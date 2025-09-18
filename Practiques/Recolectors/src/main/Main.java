/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import dao.ProducteDAO;
import dto.Producte;
import java.security.CodeSigner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author jrmd
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Guarda en un ArrayList els productes que costen entre 100 i 300 euros (sense iva)
        ArrayList <Producte> productesEntre100i300 = ProducteDAO.getAll().stream()
                .filter(p -> p.getPreu() >= 100 && p.getPreu() <= 300)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(productesEntre100i300);
        System.out.println();
        // 2. Guarda en un LinkedHashSet els preus dels productes d'alimentació, ordenats de major a menor
        LinkedHashSet <Double> preusProductesAlimentacio = ProducteDAO.getAll().stream()
                .filter(p -> p.getCategoria().equals("Aliments"))
                .map(Producte::getPreu)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(preusProductesAlimentacio);
        System.out.println();
        // 3. Guarda en un List aquells productes que el seu nom comence per "A" sabent que la llista ha de quedar immutable.
        List <Producte> startsWithA = ProducteDAO.getAll().stream()
                .filter(p -> p.getNom().startsWith("A"))
                .collect(Collectors.toUnmodifiableList());
        System.out.println(startsWithA);
        System.out.println();
        // 4. Guarda en un String les categories (sense repetir), ordenades alfabèticament i separades per comes.
        String categories = ProducteDAO.getAll().stream()
                .map(p -> p.getCategoria()) //(Producte::getCategoria)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(categories);
        System.out.println();
        // 5. Guarda el producte amb el preu més alt
        Producte preuMesAlt = ProducteDAO.getAll().stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Producte::getPreu)))
                .orElse(null);
        System.out.println(preuMesAlt);
        System.out.println("");
                
        // 6. Guarda el producte amb el nom més curt
        Producte nomCurt = ProducteDAO.getAll().stream()
                .collect(Collectors.minBy(Comparator.comparingInt(p -> p.getNom().length())))
                .orElse(null);
        System.out.println(nomCurt);
        System.out.println("");
        // 7. Guarda la mitjana de preus dels procesadors
        double mitjanaPreusProcesadors = ProducteDAO.getAll().stream()
                .filter(p -> p.getCategoria().equals("Procesadors"))
                .collect(Collectors.averagingDouble(Producte::getPreu));
         System.out.println(mitjanaPreusProcesadors);
         System.out.println("");
        /* Bon intent máquina
        double sumaPreus = ProducteDAO.getAll().stream()
                .mapToDouble((Producte::getPreu))
                .sum();
        double mitjana = sumaPreus/ ProducteDAO.getAll().stream().count();
        System.out.println(mitjana);*/
        
        // 8. Guarda en un mapa agrupant per categoria la llista de productes de cada categoria
        Map <String, List<Producte>> mapaProductesCategoria = ProducteDAO.getAll().stream()
                .collect(Collectors.groupingBy(Producte::getCategoria));
        mapaProductesCategoria.forEach((categoria, llista) -> System.out.println(categoria + ": " + llista));
        System.out.println("");
        // 9. Guarda en un mapa agrupant per categoria la mitjana de preus de cada categoria
        Map <String, Double> mapaMitjanaPreus = ProducteDAO.getAll().stream()
                .collect(Collectors.groupingBy(Producte::getCategoria, Collectors.averagingDouble(Producte::getPreu)));
        mapaMitjanaPreus.forEach((categoria, preu) -> System.out.println(categoria + ": " + preu));
        System.out.println("");
        // ¿Qué farà el següent codi?
        Map<Double, List<Producte>> tramsDe100 = ProducteDAO.getAll().stream()
                .collect(Collectors.groupingBy(p -> Math.round(p.getPreu() / 100) * 100.0));
        tramsDe100.forEach((preu, llista) -> System.out.println(preu + ": " + llista));

        // 9. Guarda en un mapa agrupant per la primera lletra del nom del producte, la llista de noms per a cada grup
        Map<Character, List<String>> llistaNomsPerPrimeraLLetra =  ProducteDAO.getAll().stream()
                .map(Producte::getNom)
                .collect(Collectors.groupingBy(n -> n.charAt(0)));
        llistaNomsPerPrimeraLLetra.forEach((lletra, noms) -> System.out.println(lletra + ": " + noms));
        System.out.println("");
        // 10. Guarda la mateixa informació d'abans però ara en un LinkedHashMap ordenat per clau
        LinkedHashMap<Character, List<String>> hashMapNomsPerPrimeraLLetra =  ProducteDAO.getAll().stream()
                .map(Producte::getNom)
                .sorted()
                .collect(Collectors.groupingBy(n -> n.charAt(0), LinkedHashMap::new, Collectors.toList()));
        hashMapNomsPerPrimeraLLetra.forEach((lletra, noms) -> System.out.println(lletra + ": " + noms));
        System.out.println("");
        // 11. Guarda un mapa amb dos grups (true i false). El primer agruparà els productes d'Aliments, i el segon agruparà la resta.
         Map<Boolean, List<Producte>> llistaAlimentacioAltres =  ProducteDAO.getAll().stream()
                 .collect(Collectors.partitioningBy(p -> p.getCategoria().equals("Aliments")));
         llistaAlimentacioAltres.forEach((boolea, llista) -> System.out.println(boolea + ": " + llista));
         System.out.println("");
        // 12. Guarda un mapa amb dos grups (true i false). El primer agruparà els noms dels productes que comencen per vocal separats per commes, i el segon la resta.
         Map<Boolean, String> llistaNomsPerVocal =  ProducteDAO.getAll().stream()
                 .map(Producte::getNom)
                 .collect(Collectors.partitioningBy(ProducteDAO::comensaPerVocal, Collectors.joining(", ")));
         llistaNomsPerVocal.forEach((boolea, llista) -> System.out.println(boolea + ": " + llista));
        System.out.println("");
        // 13. Guarda en un mapa agrupant per categoria el noms dels productes separats per comes per a cada categoria
        
        // 14. Guarda en un mapa agrupant per categoria un LinkedHashSet dels preus d'eixa categoria

        // 15. Mostra el mateix mapa d'abans pero ara guarda els preus en un LinkedList ordenat de menor a major.

        // 16. Guarda en un mapa agrupant per categoria la quantitat de productes d'eixa categoria

        // 17. Guarda la mateixa informació d'abans però ara en un TreeMap<String,Integer>
     
        //18. Guarda en un Array d'Strings aquelles categories (sense repetir i ordenades) que tinguen algun producte més car dels 100 euros

    }

}

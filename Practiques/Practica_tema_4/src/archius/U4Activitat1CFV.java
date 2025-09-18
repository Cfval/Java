package archius;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cfval
 */
public class U4Activitat1CFV {
    
    public static void main(String[] args) {
       
        
        String paraulaSecreta = generarParaulaSecreta();
        String paraulaIntroduida = "";
        //System.out.println(paraulaSecreta); - Per a facilitar la prova del joc 
       
        do{
            paraulaIntroduida = demanarResposta();
            
        }while(!resoldreResposta(paraulaSecreta, paraulaIntroduida));
        
    }
    
    //primer nivell
    public static boolean resoldreResposta(String paraulaSecreta, String paraulaIntroduida){
        
        String pista = generarPista(paraulaSecreta, paraulaIntroduida);
       
        return donarResposta(pista);
    }
    
    //Segon nivell
    public static String generarPista(String paraulaSecreta, String paraulaIntroduida){
        
        StringBuilder pista = new StringBuilder();
        
        for(int i=0; i < paraulaIntroduida.length(); i++){
            
            if(paraulaSecreta.charAt(i) == paraulaIntroduida.charAt(i)){
                pista.append('0');
            }else if(paraulaSecreta.contains(String.valueOf(paraulaIntroduida.charAt(i)))){
                pista.append('X');
            }
            else{
                pista.append('-');
            } 
        }   
        
        return pista.toString();
    }
    
    //Segon nivell
    public static boolean donarResposta(String pista){
        
        boolean jocAcabat = false;
        
        if(!pista.equals("00000")){
            System.out.println("La resposta és [" + pista + "]. Continua intentant-ho.");
        }else {
            System.out.println("La resposta és[" + pista + "]. Has encertat!");
            jocAcabat = true;
        }
        
        return jocAcabat;
    }
    
    //Primer nivell
    public static String demanarResposta(){
        
        String resposta = "";
            
        do{
            
           System.out.print("Escriu 5 lletres minúscules: ");
           resposta = llegirResposta();
           
        }while (!comprovarFormat(resposta));
        
        return resposta;
    }
    
    //Segon nivell
    public static boolean comprovarFormat(String resposta){
        
        boolean paraulaCorrecta = true;
        
        if(resposta.length() == 5 ){
            for(int i = 0; i < resposta.length(); i++){
                if(resposta.charAt(i) < 'a' || resposta.charAt(i) > 'z' ){
                    
                    paraulaCorrecta = false;   
                }       
            }
        }else {
            paraulaCorrecta = false;
        }
        
        if(!paraulaCorrecta){
            System.out.println("Heu d'introduir 5 lletres. Continua intentant-ho.");
        }
        
        return paraulaCorrecta;
    }
    
    //Segon nivell
    public static String llegirResposta() {
        Scanner teclat = new Scanner(System.in);
        
        String llegirResposta = teclat.nextLine();
        
        return llegirResposta;
    }
    
    //Primer nivell
    public static String generarParaulaSecreta(){
        
        return muntarParaula();
    }
    
    //Segon nivell
    public static String muntarParaula(){
        
        //Declaració del string 
        String paraulaMuntada = "";
        
        int llargariaParaula = 5;
        
        //Bucle per a concatenar 5 lletres aleatories
       for(int i = 0; i < llargariaParaula; i++){
           paraulaMuntada += generarLletraAleatoria();
       }
       
       return paraulaMuntada;
    }
    
    //Tercer nivell
    public static char generarLletraAleatoria(){
        
        int longitudAlfabet = 'z' - 'a' + 1;
        
        //Random
        Random r = new Random();
        
        //Generar un numero ASCII aleatori
        int n = r.nextInt(longitudAlfabet) + 'a';
        
        //Obtenir lletra corresponent de n
        char lletraAleatoria = (char)n ;
        
        return lletraAleatoria;
    }   
}


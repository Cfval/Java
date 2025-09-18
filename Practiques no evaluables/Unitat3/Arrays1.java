
public class Arrays1 {
	public static void main(String[] args) {

            //no se pot canviar la medida de un array una vegada se declara
        int x = 30;
        int [] numeros = new int[x];
        x = 60;
		System.out.println("x es " + x);
        System.out.println("la medida de l'array numeros es " + numeros.length);
        System.out.println("-------------------------------------------------------------\n");
        
            //PREGUNTA 5 UNITAT 3_1
        double[] deuNumeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double n = 5.5;
        
        deuNumeros[9] = n;

        System.out.println(deuNumeros[0] + deuNumeros[1]);
        
        double sumaElements = 0;

        for(int i = 0; i<deuNumeros.length; i++) {

            sumaElements += deuNumeros[i]; 
            System.out.println("La suma dels elements és: "+ sumaElements);
        }

        System.out.println("--------------------------------------------------------------\n");

            // ENCONTRA EL VALOR MINIM O MÁXIM D UN ARRAY, NOMES CAL CANVIAR EL SIGNE < DEL IF
        double minim = deuNumeros[0];
        for(int i = 0; i < deuNumeros.length; i++) {
            if (deuNumeros[i] < minim){
                minim = deuNumeros[i];
            }
        }
        System.out.println("El valor mínim és: "+ minim);
	}
}


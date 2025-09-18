/**
 * Autor: Carlos Francés Valdés
 * Descripció: Si que compila 
 */
import java.util.Scanner;
public class U1Activitat4{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float a, b, c, d, e, f, x, y;
		
		
		System.out.println("Valor de a: ");
		a = input.nextFloat();
		System.out.println("Valor de b: ");
		b = input.nextFloat();
		System.out.println("Valor de e: ");
		e = input.nextFloat();
		System.out.println("Valor de c: ");
		c = input.nextFloat();
		System.out.println("Valor de d: ");
		d = input.nextFloat();
		System.out.println("Valor de f: ");
		f = input.nextFloat();
		
		System.out.println("SISTEMA D'EQUACIONS LINEALS \n--------------------------------");
		System.out.println(a + "x + " + b + "y = " + e );
		System.out.println(c + "x + " + d + "y = " + f + "\n");
		System.out.println("SOLUCIÓ PER CRAMER \n--------------------------------");

		x = (e*d - b*f)/(a*d - b*c);
		y = (a*f - e*c)/(a*d - b*c);
		
		System.out.printf("x = %.2f \n",x);
		System.out.printf("y = %.2f \n",y);
		System.out.println("COMPROVACIÓ DONADA LA 'x' \n--------------------------------");
		
		y = (e - a*x)/b;
		System.out.printf("y = %.2f \n",y );

		y = (f - c*x)/d;
		System.out.printf("y = %.2f \n",y); 	
		
		input.close();
	}
}
	
	
	
	
	
	
	
		
	

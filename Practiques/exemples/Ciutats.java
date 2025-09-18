import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Ciutats {
    public static void main(String[] args) {
        List<String> ciutats = new ArrayList<>(
                Arrays.asList("Alacant", "Villena", "Petrer", "Novelda", "Elda"));

        // Versió imperativa
        boolean trobat = false;
        for (String ciutat : ciutats) {
            if (ciutat.equals("Petrer")) {
                trobat = true;
                break;
            }
        }
        System.out.println("Trobat Petrer?: " + trobat);

        // Versió funcional
        System.out.println("Trobat Petrer?: " + ciutats.contains("Petrer"));

        // Versió funcional sense cap assignació de variables.

        System.out.println("Trobat Petrer?: " +
                new ArrayList<>(Arrays.asList("Alacant", "Villena", "Petrer", "Novelda", "Elda"))
                        .contains("Petrer"));

    }
}

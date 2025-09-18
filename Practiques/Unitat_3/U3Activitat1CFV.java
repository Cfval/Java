/**
 * Autor: Carlos Francés Valdés
 * Descripció: No funciona exactament com demana
 * Compila y fucniona 
 */
import java.util.Scanner;

public class U3Activitat1CFV {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double[] sistolicas = new double[10];
        double[] diastolicas = new double[10];
        int cantidadMedidas = 0;

        System.out.println("Introdueix les mesures de tensió arterial (sistòlica diastòlica):");

        while (cantidadMedidas < 10) {
            String input = teclado.nextLine();
            if (input.equals("0")) {
                break;
            }

            String[] valores = input.trim().split(" ");
            if (valores.length % 2 != 0) {
                System.out.println("Entrada no vlida. Introdueix una mesura en el format correcte.");
                continue;
            }

            boolean medidasValidas = true;
            for (int i = 0; i < valores.length; i += 2) {
                try {
                    double sistolica = Double.parseDouble(valores[i]);
                    double diastolica = Double.parseDouble(valores[i + 1]);

                    if (sistolica >= 3 && sistolica <= 22 && diastolica >= 3 && diastolica <= 22 && sistolica >= diastolica) {
                        sistolicas[cantidadMedidas] = sistolica;
                        diastolicas[cantidadMedidas] = diastolica;
                        cantidadMedidas++;
                    } else {
                        System.out.println("Entrada no vàlida.Introdueix una mesura en el format correcte.");
                        medidasValidas = false;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no vàlida. Introdueix una mesura en el format correcte.");
                    medidasValidas = false;
                    break;
                }
            }

        }

        if (cantidadMedidas == 0) {
            System.out.println("No hi ha medides que mostrar.");
        } else {
            while (true) {
                System.out.println("1. Sistólica màxima.");
                System.out.println("2. Diastólica mínima.");
                System.out.println("3. Més compensada.");
                System.out.println("4. Tensió mitjana");
                System.out.println("5. Eixir");
                System.out.print("Selecciona la opción desitjada: ");

                int opcion = Integer.parseInt(teclado.nextLine());
                switch (opcion) {
                    case 1:
                        double maxSistolica = 0;
                        for (int i = 0; i < cantidadMedidas; i++) {
                            if (sistolicas[i] > maxSistolica) {
                                maxSistolica = sistolicas[i];
                            }
                        }
                        System.out.println("Tensió sistólica màxima: " + maxSistolica);
                        break;
                    case 2:
                        double minDiastolica = Double.MAX_VALUE;
                        for (int i = 0; i < cantidadMedidas; i++) {
                            if (diastolicas[i] < minDiastolica) {
                                minDiastolica = diastolicas[i];
                            }
                        }
                        System.out.println("Tensió diastólica mínima: " + minDiastolica);
                        break;
                    case 3:
                        double tensionMasCompensada = -1;
                        int indexCompensada = -1;

                        for (int i = 0; i < cantidadMedidas; i++) {
                            double relacion = sistolicas[i] / diastolicas[i];
                            if (indexCompensada == -1 || Math.abs(2 - relacion) < Math.abs(2 - tensionMasCompensada)) {
                                tensionMasCompensada = relacion;
                                indexCompensada = i;
                            }
                        }

                        if (indexCompensada != -1) {
                            System.out.println(sistolicas[indexCompensada] + " " + diastolicas[indexCompensada]);
                        } else {
                            System.out.println("Error");
                        }
                        break;
                    case 4:
                        double sumaSistolica = 0;
                        double sumaDiastolica = 0;

                        for (int i = 0; i < cantidadMedidas; i++) {
                            sumaSistolica += sistolicas[i];
                            sumaDiastolica += diastolicas[i];
                        }

                        double mediaSistolica = sumaSistolica / cantidadMedidas;
                        double mediaDiastolica = sumaDiastolica / cantidadMedidas;

                        System.out.println("Tensió arterial mitja: " + mediaSistolica + " " + mediaDiastolica);
                        break;
                    case 5:
                        System.out.println("Adéu");
                        return;
                    default:
                        System.out.println("Opció no vàlida. Per favor, seleccione una opció vàlida.");
                }
            }
        }
        teclado.close();
    }
}
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rut {

    public static void main(String[] args) {

        System.out.println(crearRut());
    }

    //Metodo que crea una entrada de String

    public static String entradaString() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese su rut: ");

        return teclado.nextLine();
    }

    //Metodo que valida que dicho rut esté bien escrito

    public static boolean validarRut(String rut) {

        return rut.matches(("^[1-9][0-9]\\.{0,1}[0-9]{3}\\.{0,1}[0-9]{3}[-]{0,1}[0-9-kK]$"));
    }

    //Metodo que valida el verificador rut

    public static boolean validarVerificador(String rut) {

        int j = 2;

        int verificador = 0;

        for (int i = rut.length() - 2; i > -1; i--) {

            if (j > 7) {

                j = 2;
            }

            verificador += Integer.parseInt(String.valueOf(rut.charAt(i))) * j;

            j++;

        }


        verificador = (11 - Math.abs(verificador / 11 * 11 - verificador));

        if (rut.charAt(rut.length() - 1) == 'k' && verificador == 10) {

            return true;
        } else if (rut.charAt(rut.length() - 1) == '0' && verificador == 11) {

            return true;
        }

        return verificador == Integer.parseInt(String.valueOf(rut.charAt(rut.length() - 1)));

    }

    //Metodo que crea un rut

    public static String crearRut() {

        String rut = entradaString();

        if (!(validarRut(rut))) {

            invalidarRut();
            crearRut();
        }

        rut = rut.replace(".", "");
        rut = rut.replace("-", "");

        if (!(validarVerificador(rut.toLowerCase()))) {

            invalidarRut();
            crearRut();
        }

        return "rut válido";
    }

    //metodo que muestra rut no valido

    public static void invalidarRut(){

        System.out.println("Rut no válido");
    }
}

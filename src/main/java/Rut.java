//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Rut {
    public Rut() {
    }

    public static void main(String[] args) {
        System.out.println(crearRut());
        rutValido();
    }

    public static String entradaString() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese su rut: ");
        return teclado.nextLine();
    }

    public static boolean validarRut(String rut) {
        return rut.matches("^[1-9]\\d?\\.?\\d{3}\\.?\\d{3}-?[\\dkK]$");
    }

    public static boolean validarVerificador(String rut) {
        int j = 2;
        int verificador = 0;

        for(int i = rut.length() - 2; i > -1; --i) {
            if (j > 7) {
                j = 2;
            }

            verificador += Integer.parseInt(String.valueOf(rut.charAt(i))) * j;
            ++j;
        }

        verificador = 11 - Math.abs(verificador / 11 * 11 - verificador);
        if (rut.charAt(rut.length() - 1) == 'k' && verificador == 10) {
            return true;
        } else if (rut.charAt(rut.length() - 1) == '0' && verificador == 11) {
            return true;
        } else if (rut.charAt(rut.length() - 1) == 'k' && verificador != 10) {
            return false;
        } else {
            return verificador == Integer.parseInt(String.valueOf(rut.charAt(rut.length() - 1)));
        }
    }

    public static String crearRut() {
        String rut = entradaString();
        if (!validarRut(rut)) {
            invalidarRut();
            rut = crearRut();
        }

        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        if (!validarVerificador(rut.toLowerCase())) {
            invalidarRut();
            rut = crearRut();
        }

        return rut;
    }

    public static void invalidarRut() {
        System.out.println("Rut no válido");
    }

    public static void rutValido() {
        System.out.println("Rut válido");
    }
}

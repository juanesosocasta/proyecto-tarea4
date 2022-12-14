package control;

import java.util.Scanner;

/**
 * MainVuelo
 */
class MainVuelos {

    // metodo encargado de iniciar el programa y mostrar la respuesta en base a el
    // vuelo origen y destino
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("bienvenido a vuelos mario");
        System.out.println("ingrese el origen del vuelo");
        String origen = leer.nextLine();
        System.out.println("ingrese el destino del vuelo");
        String destino = leer.nextLine();

        ControlVuelo.controlVuelo(origen, destino);

    }

}
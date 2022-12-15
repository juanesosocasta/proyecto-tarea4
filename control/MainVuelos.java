package control;

import java.util.Scanner;

import entidad.Vuelo;

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
    public static void impresionVuelos(Vuelo vuelo) {
        
          if (vuelo!=null) {
            System.out.println("------------------------------------------------------- ");

        System.out.println("el vuelo posible es: ");
        System.out.println(vuelo.getOrigen());
        System.out.println(vuelo.getDestino());
        System.out.println("con estas escalas: "+vuelo.getEscala());
        System.out.println("con estae precio: "+vuelo.getPrecio());
        System.out.println("con esta duración: "+vuelo.getDuracion());

        System.out.println("------------------------------------------------------- ");
    
          } 
          else{
            System.out.println("el vuelo es invalido o no existe, por favor recorra de nuevo el programa ");
          }
        
        
}

}
package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.simple.JSONObject;
import entidad.Vuelo;

/**
 * ControlVuelo
 */
public class ControlVuelo {
    public static int escalas = 0;
    public static double precio=0;
    public static double duracion=0;
    static List<String> visitadosDestino= new ArrayList<String>();
    static List<String> visitadosOrigen= new ArrayList<String>();
    static List<Double> costos= new ArrayList<Double>();
    static List<Double> tiempos= new ArrayList<Double>();




    /*
     * metodo encargado de orquestar las funciones para así poder tener orden y dar
     * funcionalidades necesarias
     * por otro lado este metodo permite devolver los posibles vuelos.
     */
    public static void controlVuelo(String inicio, String fin) {
        List<JSONObject> vuelos = LectorJson.leerJson();
        List<JSONObject> vuelosFin = new ArrayList<JSONObject>();
        for (JSONObject jsonObject : vuelos) {

            if (validarVuelo(inicio, fin, jsonObject) != null) {
                vuelosFin.add(validarVuelo(inicio, fin, jsonObject));
            }

        } 
        
        JSONObject viaje = new JSONObject();
        viaje = (procesarVuelo(inicio, fin, vuelosFin));
        if (!viaje.toString().equals("{}")) {
           Vuelo vuelo=new Vuelo();
           precio+=((Double)viaje.get("precio"));
           duracion+=((Double)viaje.get("duracion"));
            
            vuelo.setOrigen(visitadosOrigen.get(0));
            vuelo.setDestino((String)viaje.get("destino"));
            vuelo.setPrecio(precio);
            vuelo.setEscala(escalas);
            vuelo.setDuracion(duracion);
            
            MainVuelos.impresionVuelos(vuelo);
            escalas = 0;
            duracion = 0;
            precio=0;
            costos.clear();
            tiempos.clear();


        }
        Vuelo vuelo=new Vuelo();
        vuelo=null;
        MainVuelos.impresionVuelos(vuelo);
        

    }
    /*
     * este metodo se encarga de hacer una recursión la cual sirve para recorrer los
     * vuelos y hallar el vuelo
     * que cumpla los requisitos
     */

    public static JSONObject procesarVuelo(String inicio, String fin, List<JSONObject> vuelosFin) {
        JSONObject vuelos = new JSONObject();

        for (JSONObject jsonObject : vuelosFin) {
            String origen = (String) jsonObject.get("origen");
            String destino = (String) jsonObject.get("destino");
            if (Objects.equals(origen.toUpperCase(), inicio.toUpperCase())
                    && Objects.equals(destino.toUpperCase(), fin.toUpperCase())) {
                vuelos = (jsonObject);
                return vuelos;
            }
            else if (Objects.equals(origen.toUpperCase(), inicio.toUpperCase())
                   ) {
                visitadosOrigen.add(origen);
                visitadosDestino.add(destino);
                costos.add((Double)jsonObject.get("precio"));
                tiempos.add((Double)jsonObject.get("duracion"));

                escalas=visitadosDestino.size();
                for (Double valor : costos) {
                    precio+=valor;
                }
                for (Double time : tiempos) {
                    duracion+=time;
                }
                
               // duracion

                controlVuelo(destino, fin);

            }else{
                if (!visitadosDestino.isEmpty()) {
                   visitadosDestino.remove(visitadosDestino.size()-1); 
                }
                if (precio!=0) {
                    precio-=(Double)jsonObject.get("precio");
                    
                }
                if (duracion!=0) {
                    duracion-=(Double)jsonObject.get("duracion");
                    
                }
                
            }

        }
        return vuelos;

    }
    /*
     * metodo encargado de realizar una validación, en la cual se le ingresan
     * origen, destino
     * y un objeto, con esto se obtienen los objetos que contengan sea el destino o
     * el origen,
     * si no lo contiene retorna null
     */

    public static JSONObject validarVuelo(String inicio, String fin, JSONObject vuelo) {

        String origen = (String) vuelo.get("origen");
        String destino = (String) vuelo.get("destino");

        if (Objects.equals(origen.toUpperCase(), inicio.toUpperCase())) {
            return vuelo;
        }
        if (Objects.equals(destino.toUpperCase(), fin.toUpperCase())) {
            return vuelo;
        }
        
        return null;

    }

}
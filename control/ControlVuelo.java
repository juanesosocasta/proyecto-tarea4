package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//import LectorJson;
import org.json.simple.JSONObject;

/**
 * ControlVuelo
 */
public class ControlVuelo {  
    /*metodo encargado de orquestar  las funciones para así poder tener orden y dar funcionalidades necesarias 
     * por otro lado este metodo permite devolver los posibles vuelos.
    */
    public static void controlVuelo(String inicio,String fin) {
        List<JSONObject>  vuelos=LectorJson.leerJson();
        List<JSONObject> vuelosFin=new ArrayList<JSONObject>();
        for (JSONObject jsonObject : vuelos) {
           
            if(validarVuelo(inicio,fin,jsonObject)!=null){
                vuelosFin.add(validarVuelo(inicio,fin,jsonObject));
            }
          
        } 
        List<JSONObject> viajes=new ArrayList<JSONObject>();

        viajes.add(procesarVuelo(inicio,fin,vuelosFin));
        
             
        // for (JSONObject vuelosF : vuelosFin) {
        //     System.out.println("los valores que van quedando son: ");
        //     System.out.println(vuelosF.get("origen"));
        //     System.out.println(vuelosF.get("destino"));

            
        // }
    } 
    public void procesarVuelo(String inicio,String fin, List<JSONObject> vuelosFin ) {
        
    }
    /*
     * metodo encargado de realizar una validación, en la cual se le ingresan origen, destino
     *  y un objeto, con esto se obtienen los objetos que contengan sea el destino o el origen, 
     * si no lo contiene retorna null
     */
    
    public static JSONObject validarVuelo(String inicio,String fin, JSONObject vuelo) {
        
        String origen= (String) vuelo.get("origen");
        String destino= (String) vuelo.get("destino");

        
        if (Objects.equals(origen.toUpperCase(), inicio.toUpperCase())) {
            return vuelo;
        }
        if(Objects.equals(destino.toUpperCase(),fin.toUpperCase())){
            return vuelo;
        }
       return null ;
        
    }
    public void ProcesarVuelo(String inicio,String fin,JSONObject vuelofin) {

        
    }

    
}
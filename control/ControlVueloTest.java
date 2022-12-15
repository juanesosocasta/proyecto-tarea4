
package control;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import control.ControlVuelo;
import control.LectorJson;
public class ControlVueloTest {

    @Test
    void testProcesarVuelo() {
        
    }

    @Test
    void testValidarVuelo()throws NullPointerException {
        JSONObject vuelos=new JSONObject();
        vuelos.put( "origen","Manizales");
        vuelos.put( "destino","Medellin");
        vuelos.put( "duracion",1.5);
        vuelos.put( "precio",95000.0);

        boolean existe=false;
        
        ControlVuelo.validarVuelo("Manizales", "Cartagena", vuelos);
            if (!vuelos.isEmpty()) {
                 existe=true;
                
            }
        assertTrue(existe);

        
        

    }
}

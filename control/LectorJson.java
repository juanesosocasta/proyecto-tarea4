package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectorJson{
    //metodo encargado de realizar la lectura de un archivo Json devolviendo un objeto con los valores del Json
     public static List<JSONObject>  leerJson() {
        JSONParser parser = new JSONParser();
		FileReader fileReader;
		try {
			File file = new File("Json/vuelos.json");
			fileReader = new FileReader(file);
			// convertir para retornar un objeto de tipo JSONArray
			JSONArray array = (JSONArray) parser.parse(fileReader);
            JSONObject obj=null;
            List<JSONObject> vuelos=new ArrayList<JSONObject>();
			 //recorrer la lista
			 for(int i=0;i<array.size();i++)
			 {
			 	 obj =  (JSONObject)array.get(i);

			 	vuelos.add(obj);
			 }
             return vuelos;

		}

		catch(FileNotFoundException e)
		{
			System.out.println(e.getStackTrace()+ " :File Not Found");
            return null;
		}
		catch(ParseException e)
		{
			System.out.println(e.getStackTrace()+ " :Could not parse");
            return null;
		}
		catch(IOException e)
		{
			System.out.println(e.getStackTrace()+ " :IOException");
            return null;
		}
        
    }
    private static void parseObject(JSONObject obj) {
		String origen = (String)obj.get("origen");
		String destino = (String)obj.get("destino");
		double duracion = (double)obj.get("duracion");
		double precio = (double)obj.get("precio");
		

		System.out.println("origen: "+origen);
		System.out.println("destino: "+destino);
		System.out.println("duracion: "+duracion);
		System.out.println("precio: "+precio);
	
	}
    
    
}
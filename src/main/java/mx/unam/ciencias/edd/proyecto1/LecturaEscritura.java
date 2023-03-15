package mx.unam.ciencias.edd.proyecto1;
import mx.unam.ciencias.edd.Lista;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
//Cruz Pineda Fernando
public class LecturaEscritura{

    public static Lista<String> lee(Lista<String> lineas,Lista<String> nombres) throws IOException{
	for(String s : nombres){
	    BufferedReader lectura = new BufferedReader(new FileReader(s));
	    String linea="";
	    while((linea=lectura.readLine()) != null){
		lineas.agrega(linea);
	    }
	    lectura.close();
	}
	return lineas;
    }

    public static void escribe(String nombre, Lista<String>lineas){
	try{
	    FileWriter escritor = new FileWriter(nombre);
	    for( String s : lineas){
		escritor.write(s + "\n");
	    }
	    escritor.close();
	}
	catch(IOException e){
	    System.out.println(e);
	}
    }
   


}

package mx.unam.ciencias.edd.proyecto1;
import java.util.Comparator;
import mx.unam.ciencias.edd.Lista;
import java.io.IOException;
import java.util.Scanner;
//Cruz Pineda Fernando
public class Proyecto1{

    public static void main(String args[]){
	Scanner lee=new Scanner(System.in);
	boolean reversa=false;
	boolean guardar=false,bandera=false;
	String nombreArchivo="";
	Lista<String> nombreArchivos=new Lista<String>();
	if(args.length < 1){
	    System.out.println("Introduzca un archivo a ordenar");
	    System.exit(1);
	}
	for(int i=0;i<args.length;i++){
	    if(bandera){
		nombreArchivo=args[i];
		bandera=false;
		continue;
	    }
	    if(args[i].equals("-r"))
	       reversa=true;
	    else if(args[i].equals("-o"))
		guardar=bandera=true;
	    else
		nombreArchivos.agrega(args[i]);
	}
	while (lee.hasNextLine()) {
            String nombre = lee.nextLine();
	    nombreArchivos.agrega(nombre);
        }
	LecturaEscritura lector= new LecturaEscritura();
	Lista<String> orden=null;
	try{
	    orden = lector.lee(nombreArchivos);
	}
	catch (IOException e){
	    System.out.println(e);
	    System.exit(1);
	}
	Comparator<String> comparador= new ComparaStrings();
	orden=orden.mergeSort(comparador);
	if(reversa)
	    orden=orden.reversa();
	if(guardar)
	    lector.escribe(nombreArchivo,orden);
	for(String linea: orden)
	    System.out.println(linea);
	
    }

}

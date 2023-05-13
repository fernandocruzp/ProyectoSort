package mx.unam.ciencias.edd.proyecto1;
import java.util.Comparator;
import mx.unam.ciencias.edd.Lista;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedInputStream;
//Cruz Pineda Fernando
public class Proyecto1{

    public static void main(String args[]){
	BufferedInputStream in = new BufferedInputStream(System.in);
	Scanner lee=new Scanner(in);
	boolean reversa=false;
	boolean guardar=false,bandera=false;
	String nombreArchivo="";
	Lista<String> orden=new Lista<String>();
	Lista<String> nombreArchivos=new Lista<String>();
	try{
	    if(in.available() == 0)
		System.out.print("");
	    else
		while(lee.hasNextLine()){
		    String linea=lee.nextLine();
		    orden.agrega(linea);
		}
	}catch(IOException e){
	    System.out.println(e);
	}
	
	if(args.length < 1 && orden.getElementos() == 0){
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

	if(nombreArchivos.getElementos()==0 && orden.getElementos()==0){
	    System.out.println("Introduzca un archivo a ordenar");
	    System.exit(1);
	}

	LecturaEscritura lector= new LecturaEscritura();
	try{
	    orden = lector.lee(orden,nombreArchivos);
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

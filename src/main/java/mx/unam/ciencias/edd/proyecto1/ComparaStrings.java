package mx.unam.ciencias.edd.proyecto1;
import java.util.Comparator;

public class ComparaStrings implements Comparator<String>{
    private final String acento="áéíóúñü";
    private final String normal="aeiounu";
    @Override public int compare(String a, String b){
	return quitaCaracteres(a).compareTo(quitaCaracteres(b));
    }

    private String quitaCaracteres(String a){
	a=a.replace(" ","");
	a=a.toLowerCase();
	a=a.replace("¿","");
	a=a.replace("¡","");
	char[] a_rreglo=a.toCharArray();
	for(int i=0;i<a_rreglo.length; i++){
	    int cambiar= acento.indexOf(a_rreglo[i]);
	    if(cambiar >= 0)
		a_rreglo[i]=normal.charAt(cambiar);
	}
	return new String(a_rreglo);
    }


}

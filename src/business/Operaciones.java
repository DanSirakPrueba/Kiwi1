package business;
import deliver.Deliver;
import java.util.ArrayList;
/*
 * This class parses the given input and output an operation type-based syntax
 * form.
 */

/**
 *
 * @author Kiwi
 */
public class Operaciones {

    public static void xOperacionSintax(ArrayList order) {
    	String phrase = "%^X_ORDEN_SINTAX.\"";
    	for (int i = 0; i < order.size() - 1; i++) {
    		phrase += order.get(i) + ",";
    	}
    	phrase += order.get(order.size() - 1) +"\"";
    	// TODO: Arreglar el número del deliver.
    	Deliver.deliver(1, phrase);
    }

    public static void xFormateoOperacion(String opciones) {
    	// TODO: En la interfaz hay que poner un ejemplo de esto, para recordar las posibles operaciones.
    	String phrase = "%^C_EJECUTA_COMANDO.\"" + opciones + "\"";

    	// TODO: Arreglar el número del deliver.
    	Deliver.deliver(1, phrase);
    }

    public static void cSintaxisComando(String sintaxis) {
    	String phrase = "%^C_SINTAXIS_COMANDO.\"" + sintaxis + "\"";
    	// TODO: Arreglar el número del deliver.
    	Deliver.deliver(1, phrase);
    }

    
}

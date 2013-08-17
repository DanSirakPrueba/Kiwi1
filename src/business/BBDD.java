/*
 * This class transcribes some given tokens into Syntax Database format.
 */
package business;
import deliver.Deliver;
import java.util.ArrayList;

/**
 *
 * @author Kiwi
 */
public class BBDD {
    
    /**
     * Method that creates a select-type phrase based on the given input.
     * 
     * @param conexion: true if there is conexion field, false in other cases.
     * @param usuarioBD: User of the DB.
     * @param passwdBD: Passwd of the DB.
     * @param conexionBD: Conexion field of the DB.
     * @param resultadoSelect: Results from the select conection.
     * @param tablaSelect: Table in which the select will be used.
     * @param condicionSelect: Conndition under the selec
     */
    public static void selectBD(boolean conexion, String usuarioBD, String passwdBD, String conexionBD, 
    			ArrayList resultadoSelect, ArrayList tablaSelect, String condicionSelect) {
    	// TODO: en la interfaz debe preguntarse qué partes quiere poner.
    	String phraseA = "";
    	if(conexion) {
    		phraseA += "%^S_CONEXION_SELECT.\"" + usuarioBD + "," + passwdBD;
    		if (conexionBD.compareTo("") != 0) phraseA += "," + conexionBD;
    		phraseA += "\"";
    	}
    	String phraseB = "%^S_RESULTADO_SELECT.\"";
    	for (int i = 0; i < resultadoSelect.size() - 1; i++) {
    		phraseB += resultadoSelect.get(i) + " , ";
    	}
    	phraseB += resultadoSelect.get(resultadoSelect.size() - 1) + "\"";
    	String phraseC = "%^S_TABLA_SELECT.\"";
    	for (int i = 0; i < tablaSelect.size() - 1; i++) {
    		phraseC += tablaSelect.get(i) + " , ";
    	}
    	phraseC += tablaSelect.get(tablaSelect.size() - 1) + "\"";
    	String phraseD = "%^S_CONDICION_SELECT.\"" + condicionSelect + "\"";
    	String phrase = phraseA + "\n" + phraseB + "\n" + phraseC + "\n" + phraseD + "\n";
    	Deliver.deliver(Deliver.SELECTBD, phrase);
    }

    public static void deleteBD(boolean conexion, String usuarioBD, String passwdBD, String conexionBD,
                String tablaDelete, String condicionDelete) {
        // TODO: en la interfaz debe preguntarse que partes quiere poner.
        String phraseA = "";
        if (conexion) {
            phraseA += "%^D_CONEXION_DELETE.\"" + usuarioBD + "," + passwdBD;
            if (conexionBD.compareTo("") != 0) phraseA += "," + conexionBD;
            phraseA += "\"";
        }
        String phraseB = "%^D_TABLA_DELETE.\"" + tablaDelete + "\"";
        String phraseC = "%^D_CONDICION_DELETE.\"" + condicionDelete + "\"";
        String phrase = phraseA + "\n" + phraseB + "\n" + phraseC + "\n";
        Deliver.deliver(Deliver.DELETEBD, phrase);
    }

    public static void updateBD(boolean conexion, String usuarioBD, String passwdBD, String conexionBD,
    			ArrayList tablaUpdate, ArrayList camposUpdate, String condicionUpdate) {
    	// TODO: en la interfaz debe preguntarse qué partes quiere poner.
    	String phraseA = "";
    	if(conexion) {
    		phraseA += "%^U_CONEXION_UPDATE.\"" + usuarioBD + "," + passwdBD;
    		if (conexionBD.compareTo("") != 0) phraseA += "," + conexionBD;
    		phraseA += "\"";
    	}
    	String phraseB = "%^U_TABLA_UPDATE.\"";
    	for (int i = 0; i < tablaUpdate.size() - 1; i++) {
    		phraseB += tablaUpdate.get(i) + " , ";
    	}
    	phraseB += tablaUpdate.get(tablaUpdate.size() - 1) + "\"";
    	String phraseC = "%^U_CAMPOS_UPDATE.\"";
    	for (int i = 0; i < camposUpdate.size() - 1; i++) {
    		phraseC += camposUpdate.get(i) + " , ";
    	}
    	phraseC += camposUpdate.get(camposUpdate.size() - 1) + "\"";
    	String phraseD = "%^U_CONDICION_UPDATE.\"" + condicionUpdate + "\"";
    	String phrase = phraseA + "\n" + phraseB + "\n" + phraseC + "\n" + phraseD + "\n";
    	Deliver.deliver(Deliver.UPDATEBD, phrase);
    }
    
    public static void queryBD(boolean conexion, String usuarioBD, String passwdBD, String conexionBD,
    			String sentenciaQuery) {
    	String phraseA = "";
    	if(conexion) {
    		phraseA += "%^X_CONEXION_QUERY.\"" + usuarioBD + "," + passwdBD;
    		if (conexionBD.compareTo("") != 0) phraseA += "," + conexionBD;
    		phraseA += "\"";
    	}
    	String phraseB = "%^X_SENTENCIA_QUERY.\"" + sentenciaQuery + "\"";
    	String phrase = phraseA + "\n" + phraseB + "\n";
    	Deliver.deliver(Deliver.QUERYBD, phrase);
    }

    public static void insertBD(boolean conexion, String usuarioBD, String passwdBD, String conexionBD,
    			ArrayList camposInsert, String tablaInsert, ArrayList columnasInsert) {
    	String phraseA = "";
    	if(conexion) {
    		phraseA += "%^I_CONEXION_UPDATE.\"" + usuarioBD + "," + passwdBD;
    		if (conexionBD.compareTo("") != 0) phraseA += "," + conexionBD;
    		phraseA += "\"";
    	}
        String phraseB = "%^I_CAMPOS_INSERT.\"";
    	for (int i = 0; i < camposInsert.size() - 1; i++) {
    		phraseB += camposInsert.get(i) + " , ";
    	}
    	phraseB += camposInsert.get(camposInsert.size() - 1) + "\"";
        String phraseC = "%^I_TABLA_INSERT.\"" + tablaInsert + "\"";
        String phraseD = "%^I_COLUMNAS_INSERT.\"";
    	for (int i = 0; i < columnasInsert.size() - 1; i++) {
    		phraseD += columnasInsert.get(i) + " , ";
    	}
    	phraseD += columnasInsert.get(columnasInsert.size() - 1) + "\"";
        String phrase = phraseA + "\n" + phraseB + "\n" + phraseC + "\n" + phraseD + "\n";
      	Deliver.deliver(Deliver.INSERTBD, phrase);

    }
}

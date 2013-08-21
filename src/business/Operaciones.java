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

    //before ArrayList
    public static void orderFormat(String orders) {
    	String phrase = "%^X_ORDEN_SINTAX.\"" + orders;
        
        /*if (orders != null) {
            for (int i = 0; i < orders.size() - 1; i++) {
                    phrase += orders.get(i) + ", ";
            }
            phrase += orders.get(orders.size() - 1);
        }*/
        
        phrase += "\"";
        Deliver.deliver(Deliver.orderFormat, phrase);
    }

    public static void commandFormatExe(String opciones) {
    	// TODO: En la interfaz hay que poner un ejemplo de esto, para recordar las posibles operaciones.
    	String phrase = "%^C_EJECUTA_COMANDO.\"" + opciones + "\"";
        
        Deliver.deliver(Deliver.commandFormatExe, phrase);
    }

    public static void commandFormatSintax(String sintaxis) {
        // TODO: En la interfaz hay que poner un ejemplo de esto, para recordar las posibles operaciones.
    	String phrase = "%^C_SINTAXIS_COMANDO.\"" + sintaxis + "\"";
    	
    	Deliver.deliver(Deliver.commandFormatSintax, phrase);
    }

    //before ArrayList
    public void failureManagerFormat(String variables) {
        // Ej: variables = S:NUM_EQU|X:REMOTA|Campo5|E:SOC
        String phrase = "%^CAMPOS_GF.\"" + variables;
        
        /*if (variables != null) {
            for (int i = 0; i < variables.size() - 1; i++) {
            	phrase += variables.get(i) + ",";
            }
            phrase += variables.get(variables.size() - 1);
        }*/
        
        phrase += "\"";
    	Deliver.deliver(Deliver.failureManagerFormat, phrase);
    }
    
    //before ArrayList
    public static void concatOperationSintax(String Variables) {
        // Ej: Variables0 = Input1 = [X:|S:|C:|E:][N:|H:]NAME_op1
        // Ej: Variables1 = Input2 = [X:|S:|C:|E:][N:|H:]NAME_op2
        // Ej: Variables2 = Output = [X:|S:|C:|E:][N:|H:]NAME_res
        
        String phrase = "%^X_OPERACION_SINTAX.\"" + Variables;
        
        /*if (Variables != null) {
            phrase += Variables.get(0) + " + " + Variables.get(1) +
                    " = " + Variables.get(2);
        }*/
        phrase += "\"";
        Deliver.deliver(Deliver.concatOperationSintax, phrase);
    }
    
    //before ArrayList
    public static void compAsigOperationSintax(String Fields) {
        //Field0 = VariableComp1 = [X:|S:|C:|E:][N:|H:]NAME_op1
        //Field1 = operation = ‘==’, ‘!=’, ‘>=’, ‘<=’, ‘>’ , ‘<’ , ‘$’ y ‘!!’
        //Field2 = VariableComp2 = [X:|S:|C:|E:][N:|H:]NAME_op2
        //Field3 = VariableHit = [X:|S:|C:|E:][N:|H:]NAME_Hit
        //Field4 = VariableMiss = [X:|S:|C:|E:][N:|H:]NAME_Miss
        //Field5 = VariableAsig =[X:|S:|C:|E:][N:|H:]NAME_Asig
        
        String body = "" + Fields;
        /*if (Fields != null) {
            body = Fields.get(0) + " " + Fields.get(1) + " " + Fields.get(2);        
            for (int i = 0; i < 2; i++) {
                body += " # " + Fields.get(3+i) + " = " + Fields.get(5);
            }
        }*/
        
        String phrase = "%^X_OPERACION_SINTAX.\"" + body + "\"";
        Deliver.deliver(Deliver.compAsigOperationSintax, phrase);
    }
    
    //before ArrayList
    public static void basicProcessingFormat(String Fields) {
        //  %^_TRATAR_.” | %^I_TRATAR_INSERT.”
        //Field(s%3=0) = VariableComp1 = [X:|S:|C:|E:][N:|H:]NAME_op1
        //Field(s%3=1) = operation = ',' ',,'
        //Field(s%3=2) = VariableComp2 = [X:|S:|C:|E:][N:|H:]NAME_op2
        
        String phrase = "%^_TRATAR_.\"" + Fields;
        
        /* if (Fields != null) {
            for (int i = 0; i < Fields.size() - 3; i += 3) {
                phrase += Fields.get(i) + " " + Fields.get(i+1) + " " + Fields.get(i+2) + " # ";
            }
            phrase += Fields.get(Fields.size() - 3) + " " + Fields.get(Fields.size() - 2) + " " + Fields.get(Fields.size() - 1);
        }*/
        
        phrase += "\"";
        Deliver.deliver(Deliver.basicProcessingFormat, phrase);
    }
    
    //before ArrayList
    public static void newProcessingFormat(String Fields) {
        //Field(s%4=0) = VariableComp1 = [X:|S:|C:|E:][N:|H:]NAME_op1
        //Field(s%4=1) = operation = '==' '!=' '<' '>' '>=' '<='
        //Field(s%4=2) = VariableComp2 = [X:|S:|C:|E:][N:|H:]NAME_op2
        //Field(s%4=3) = VariableAsig = [A|B|C|...]
        //Field(s-1) = VariableForm = Ej: !(A|B)^C
        
        String phrase = "%^_TRATAR_.\"" + Fields;
        
        /*if (Fields != null) {
            for (int i = 0; i < Fields.size() - 5; i += 4) {
                phrase += Fields.get(i) + " " + Fields.get(i+1) + " " + Fields.get(i+2) + " = " + Fields.get(i+3) + " ; ";
            }
            phrase += Fields.get(Fields.size() - 5) + " " + Fields.get(Fields.size() - 4) + " "
                + Fields.get(Fields.size() - 3) + " = " + Fields.get(Fields.size() - 2) + " # " + Fields.get(Fields.size() - 1);
        }*/
        
        phrase += "\"";
        Deliver.deliver(Deliver.newProcessingFormat, phrase);
    }
    
    //before 2 ArrayList (ArrayList ReplaceVars, ArrayList NewVars)
    public static void associationFormat(String vars) {
        // ReplaceVars = variables que se van a sustituir
        // NewVars = Variables nuevas que cogen el contenido de las ReplaceVars
        
        String phrase = "%^X_ASOCIAR_SINTAX.\"" + vars;
        /*if (ReplaceVars != null && NewVars != null) {
            for(int i = 0; i < ReplaceVars.size() - 1; i++) {
                phrase += ReplaceVars.get(i) + ", ";
            }
            phrase += ReplaceVars.get(ReplaceVars.size() - 1) + " # ";

            for(int i = 0; i < NewVars.size() - 1; i++) {
                phrase += NewVars.get(i) + ", ";
            }
            phrase += NewVars.get(NewVars.size() - 1);
        }*/
        phrase += "\"";
        Deliver.deliver(Deliver.associationFormat, phrase);
    }
    
    public static void specialEventFormat(String template) {
        String phrase = "_SPECIAL_.\"" + template +"??\"";
        Deliver.deliver(Deliver.specialEventFormat, phrase);
    }
}

/*
 * Controller of the application. It pipes the commands from above (the interface)
 * into the business.
 */
package controller;
import business.Input;
import business.Operaciones;

/**
 *
 * @author Kiwi
 */
public class Controller {
    
    public static final int SELECTBD = 11;
    public static final int DELETEBD = 12;
    public static final int UPDATEBD = 13;
    public static final int QUERYBD = 14;
    public static final int INSERTBD = 15;
    
    public static final int readInput = 21;
    
    public static final int orderFormat = 31;
    public static final int commandFormatExe = 32;
    public static final int commandFormatSintax = 33;
    public static final int failureManagerFormat = 34;
    public static final int concatOperationSintax = 35;
    public static final int compAsigOperationSintax = 36;
    public static final int basicProcessingFormat = 37;
    public static final int newProcessingFormat = 38;
    public static final int associationFormat = 39;
    public static final int specialEventFormat = 310;
    
    public static void controller(int where, String what) {
        //TODO Temporal
        switch(where){
            case orderFormat: 
                Operaciones.orderFormat(what); 
            break;
            case commandFormatExe: 
                Operaciones.commandFormatExe(what); 
            break;
            case commandFormatSintax: 
                Operaciones.commandFormatSintax(what); 
            break;
            case failureManagerFormat: 
                Operaciones.failureManagerFormat(what); 
            break;
            case concatOperationSintax: 
                Operaciones.concatOperationSintax(what); 
            break;
            case compAsigOperationSintax: 
                Operaciones.compAsigOperationSintax(what); 
            break;
            case basicProcessingFormat: 
                Operaciones.basicProcessingFormat(what); 
            break;
            case newProcessingFormat: 
                Operaciones.newProcessingFormat(what); 
            break;
            case associationFormat: 
                Operaciones.associationFormat(what); 
            break;
            case specialEventFormat: 
                Operaciones.specialEventFormat(what); 
            break;
            case readInput:
                Input.readInput(what);
            // TODO los multitud de cases
            default: break;
        }
    }
}

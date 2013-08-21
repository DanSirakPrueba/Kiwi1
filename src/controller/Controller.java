/*
 * Controller of the application. It pipes the commands from above (the interface)
 * into the business.
 */
package controller;
//import deliver.Deliver;
import business.Operaciones;

/**
 *
 * @author Kiwi
 */
public class Controller {
    
    public static void controller(int where, String what) {
        Operaciones o = new Operaciones();
        //TODO Temporal, mirar los numeros del case, para que los tome del deliver
        switch(where){
            case 31: o.orderFormat(what); break;
            case 32: o.commandFormatExe(what); break;
            case 33: o.commandFormatSintax(what); break;
            case 34: o.failureManagerFormat(what); break;
            case 35: o.concatOperationSintax(what); break;
            case 36: o.compAsigOperationSintax(what); break;
            case 37: o.basicProcessingFormat(what); break;
            case 38: o.newProcessingFormat(what); break;
            case 39: o.associationFormat(what); break;
            case 310: o.specialEventFormat(what); break;
            // TODO los multitud de cases
            default: break;
        }
    }
}

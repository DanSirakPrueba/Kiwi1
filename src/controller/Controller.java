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
            // TODO los multitud de cases
            default: break;
        }
    }
}

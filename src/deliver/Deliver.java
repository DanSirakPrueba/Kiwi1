/*
 * Link between business and the interface. Classes at business delegate to this
 * one so as to send messages to the interface.
 */
package deliver;

import interfaz.NewJFrame2;

/**
 * @author Kiwi
 */
public class Deliver {
    
    /* TODO: esto solo es un método deliver temporal, para poder hacer la lógica
     * del negocio.
     */
    public static Object GUI;
    
    public static void setDestination(Object target) {
        GUI = target;
    }
    
    public static void deliver(int where, String what) {
        if(GUI instanceof NewJFrame2) {
            ((NewJFrame2) GUI).setSyntaxText(what);
        } else {
            System.err.println("Instancia desconocida");
        }
    }
      
    
}

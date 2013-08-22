/*
 * Link between business and the interface. Classes at business delegate to this
 * one so as to send messages to the interface.
 */
package deliver;

import GUI.MainWindow;

/**
 * @author Kiwi
 */
public class Deliver {
    
    /* TODO: esto solo es un método deliver temporal, para poder hacer la lógica
     * del negocio.
     */
    public static Object GUI;
    public static final int EVENT_AREA = 1;
    public static final int SYNTAX_AREA = 2;
    
    public static void setDestination(Object target) {
        GUI = target;
    }
    
    public static void deliver(int where, String what) {
        if(GUI instanceof MainWindow) {
            switch (where) {
                case EVENT_AREA: ((MainWindow) GUI).setEventText(what); break;
                case SYNTAX_AREA: ((MainWindow) GUI).setSyntaxText(what); break;
                default: System.err.println("¡¡¡Opción desconocida!!!");
            }
        } else {
            System.err.println("Instancia desconocida");
        }
    }
      
    
}

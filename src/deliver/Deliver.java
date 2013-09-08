/*
 * Link between business and the interface. Classes at business delegate to this
 * one so as to send messages to the interface.
 */
package deliver;

import GUI.MainWindow;
import GUI.NewOperations;
import static deliver.Deliver.ERROR;
import static deliver.Deliver.EVENT_AREA;
import static deliver.Deliver.GUI_Destination;
import static deliver.Deliver.GUI_Origin;
import static deliver.Deliver.SYNTAX_AREA;

/**
 * @author Kiwi
 */
public class Deliver {
    
    /* TODO: esto solo es un método deliver temporal, para poder hacer la lógica
     * del negocio.
     */
    public static Object GUI_Origin;
    public static Object GUI_Destination;
    public static final int EVENT_AREA = 1;
    public static final int SYNTAX_AREA = 2;
    public static final int ERROR = 3;
    
    public static void setOrigin(Object target) {
        GUI_Origin = target;
    }
    
    public static void setDestination(Object target) {
        GUI_Destination = target;
    }
    
    public static void deliver(int where, String what) {
        switch (where) {
            case EVENT_AREA: ((MainWindow) GUI_Destination).setEventText(what); break;
            case SYNTAX_AREA: ((MainWindow) GUI_Destination).setSyntaxText(what); break;
            case ERROR: 
                if(GUI_Origin instanceof NewOperations) {
                    ((NewOperations) GUI_Origin).showError(what);
                } else {
                    System.err.println("Origen Desconocido");
                }
                break;
            default: System.err.println("Destino desconocido"); break;
        }
    }
      
    
}

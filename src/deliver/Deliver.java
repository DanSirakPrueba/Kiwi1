/*
 * Link between business and the interface. Classes at business delegate to this
 * one so as to send messages to the interface.
 */
package deliver;

/**
 * @author Kiwi
 */
public class Deliver {
    
    /* TODO: esto solo es un método deliver temporal, para poder hacer la lógica
     * del negocio.
     */
    public static final int SELECTBD = 11;
    public static final int DELETEBD = 12;
    public static final int UPDATEBD = 13;
    public static final int QUERYBD = 14;
    public static final int INSERTBD = 15;
    
    public static void deliver(int where, String what) {
        System.out.println(what);
    }

    
}

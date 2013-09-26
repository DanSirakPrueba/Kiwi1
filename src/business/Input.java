/*
 * This class manages the given input of the application. The given inputs are 
 * alarms, emergencies, etc.
 */
package business;
import deliver.Deliver;
import java.io.*;
/**
 *
 * @author Kiwi
 */
public class Input {
    
    public static final int Event = 0;
    public static final int Sintax = 1;
    
    /**
     * This method read a file from the path and outputs it through the Deliver.
     * @param path: Absolute path of the input file.
     */
    public static void readInput(int where, Object[] stringPath) {
      String path = (String)stringPath[0];
      File file = null;
      FileReader fr = null;
      BufferedReader br = null;
      String text = "";
      try {
         file = new File (path);
         fr = new FileReader (file);
         br = new BufferedReader(fr);
 
         String line;
         while((line=br.readLine())!=null)
            text += line + "\n";
      }
      catch(Exception e){
         //e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            } 
            if(where == Event) {Deliver.deliver(Deliver.EVENT_AREA, text);}
            else {Deliver.deliver(Deliver.SYNTAX_AREA, text);}
         }catch (Exception e2){ 
            //e2.printStackTrace();
         }
      }
   }

}

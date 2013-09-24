/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Adrián
 */
public class FailureManager {
    
    
    public ArrayList takeNewVariables(ArrayList list, String text){
    
        String[] varArry;
        varArry = text.split("%");
        
        for(int i = 0; i < varArry.length;i++){
            int cont = 0;
            if(isLetter(varArry[i].charAt(cont))){
                return null;
            }
            
            
        }
        
    
        return list;
    }
    
    public boolean isLetter(char letter){
        return true;
    }
    
}

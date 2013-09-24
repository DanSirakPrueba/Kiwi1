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
    
    /**
     * 
     * @param list
     * @param text
     * @return 
     * 
     * Check all Syntax text and get new variables.
     */
    public ArrayList takeNewVariables(ArrayList list, String text){
    
        String[] varArry;
        varArry = text.split("%"); // % <- variable symbol.
        
        for(int i = 0; i < varArry.length;i++){ // All possible variables.
            
            boolean end = false;
            while(!end){ // Recognise name of variable
                int cont = 0;
                if(isLetter(varArry[i].charAt(cont))){ // First character must be letter, end at a dot.
                    end = true;
                    int pointLocation = cont;
                    
                    while(varArry[i].charAt(pointLocation) == '.') // Find last character.
                        pointLocation++;
                    
                    String newVar = varArry[i].substring(cont, pointLocation); // Get the name.
                    
                    if(!list.contains(newVar)) // Add if it's a new one.
                        list.add(newVar);
                        
                }
                cont++;
            }
            
        }
        
    
        return list;
    }
    
    public boolean isLetter(char letter){ // Chech if it is a letter.
        return true;
    }
    
}

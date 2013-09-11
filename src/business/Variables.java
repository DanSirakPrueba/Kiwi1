/*
 * This class receives an input and outputs variables in syntax form. 
 */
package business;

import deliver.Deliver;

/**
 *
 * @author Kiwi
 */
public class Variables {

    /**
     * This method creates a new variable in syntax.
     * @param orders: Divided to:
     *      @param name: The given name of the variable. 
     *      @param value: The given value of the variable.
     */
    public static void createNewVariable(Object[] what) {
        // String name, String value
        // TODO: corregir el número.
        String name = (String) what[0];
        String value = (String) what[1];
        String phrase;
        phrase = "%^" + name + ".\"" + value + "\"";
        Deliver.deliver(Deliver.SYNTAX_AREA, phrase);
    }

	/**
	 * This method creates a new variable from text of the input file.
	 * @param column_start: The column in which the content starts on the original file.
	 * @param column_end: The column in which the content ends on the original file.
	 * @param name: Name of the variable.
	 * @param type: Type of the variable, it can be w(word), s(string), d(number) or "..." which stands for any given text chain.
	 * @param absolute: This boolean is set as true if the positioning is absolute and false if it is relative.
	 */
    public static void createVariableFromText(Object[] what) {
        String phrase;
        //int column_start, int column_end, String name, String type, boolean absolute
        // TODO: La variable type --> w, s, d... (posible modificacion)
        
	int column_start = (int) what[0];
        int column_end = (int) what[1];
        String name = (String) what[2];
        String type = (String) what[3];
        Boolean absolute = (boolean) what[4];
       	if (column_start == 0 && column_end == 255) {
		if (absolute) {
			phrase = "%-" + name + "." + type;
		} else {
			phrase = "%+" + name + "." + type;
		}
	}
	else if (column_start == 0 && column_end != 255) {
		if (absolute) {
			phrase = "%-" + column_end + name + "." + type;
		} else {
			phrase = "%+" + column_end + name + "." + type;
		}
	}
	else {
		if (absolute) {
			phrase = "%" + column_start + "-" + column_end + name + "." + type;
		} else {
			phrase = "%" + column_start + "+" + column_end + name + "." + type;
		}
	}
	Deliver.deliver(Deliver.SYNTAX_AREA, phrase);
    }
}

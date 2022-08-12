package Helpers;

/**
 *
 * @author ander
 */
public class ClearSpecialCharactersText {
    
    public static String clear(String txt){
        txt = txt.replace("(","");
        txt = txt.replace(")","");
        txt = txt.replace("-","");
        txt = txt.replace("/","");
        txt = txt.replace(".","");
        txt = txt.replace(" ","");
               
        return txt;
    }
}

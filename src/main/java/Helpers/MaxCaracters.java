package Helpers;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ander
 */
public class MaxCaracters extends PlainDocument{
    private int maxCaracters = 0;

    public MaxCaracters() {
    }
    
    public MaxCaracters(int maxCaracters) {
        this.maxCaracters = maxCaracters;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) return;
        
        if(this.maxCaracters > 0){
            String oldStr = getText(0, getLength());
            
            if((oldStr.length() + str.length()) > this.maxCaracters){
                super.insertString(offs, "", a);
                return;
            }
        }
        
        super.insertString(offs, str, a);
    }
    
    
    
    
}

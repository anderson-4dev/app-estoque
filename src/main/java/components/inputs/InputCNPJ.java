package components.inputs;

import javax.swing.text.MaskFormatter;

/**
 *
 * @author ander
 */
public class InputCNPJ  extends Input {
    
    public InputCNPJ() {
        super();
        
        try {
            
            MaskFormatter formater = new MaskFormatter();
            formater.setMask("##.###.###/####-##");
            formater.install(inputText);
            inputText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        
        
    }
}

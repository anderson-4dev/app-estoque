package components.inputs;

import javax.swing.text.MaskFormatter;

/**
 *
 * @author ander
 */
public class InputTelefone extends Input {

    public InputTelefone() {
        super();
        
        try {
            
            MaskFormatter formater = new MaskFormatter();
            formater.setMask("(##) #####-####");
            formater.install(inputText);
            inputText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
            
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}

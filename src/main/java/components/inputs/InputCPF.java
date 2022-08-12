package components.inputs;

import javax.swing.text.MaskFormatter;

/**
 *
 * @author ander
 */
public class InputCPF extends Input {
    
    public InputCPF() {
        super();
        setMask("###.###.###-##");
    }

    public void setMask(String string) {
        try {
            
            MaskFormatter formater = new MaskFormatter();
            formater.setMask(string);
            formater.install(inputText);
            inputText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
    }
    
}

package components.inputs;

/**
 *
 * @author ander
 */
public class InputCep extends Input {

    public InputCep() {
        super();
        
        try {
            
            inputText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
            inputText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
            maxLenght = 15;
            inputText.setText("11111-1111");
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    
}

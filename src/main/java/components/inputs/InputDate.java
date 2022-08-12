package components.inputs;

import javax.swing.text.MaskFormatter;

/**
 *
 * @author ander
 */
public class InputDate extends Input {
    private static final String TXT_PADRAO = "/  /";
    
    public InputDate() {
        super();
        
        try {
            MaskFormatter formater = new MaskFormatter();
            formater.setMask("##/##/####");
            formater.install(inputText);
            
            //inputText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
            inputText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            inputText.setText(TXT_PADRAO);
            
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public String getInputText(){
       String text =  inputText.getText();
       
       if(text.replace(" ","").equals("//")){
           System.out.println("não tem nada");
           return "";
       }
       
       return inputText.getText();
    }
    //jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
    
}

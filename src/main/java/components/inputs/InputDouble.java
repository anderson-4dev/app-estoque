package components.inputs;

import java.awt.event.KeyEvent;

/**
 *
 * @author ander
 */
public class InputDouble extends Input {

    public InputDouble() {
        super();
        inputText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        //jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        inputText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputText.setText("0,00");
        
        inputText.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt){
                JTextFieldKeyTyped(evt);
            }

            private void JTextFieldKeyTyped(KeyEvent evt) {
                String caracteres="01234567890.,";// lista de caracters que devem ser aceitos
    
                if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o evento NÃO estiver na lista
                   evt.consume();//aciona esse propriedade para eliminar a ação do evento
                }
            }
        });
    }

    public void setInputText(double inputText) {
        super.setInputText(Helpers.FormatNumber.formatDouble(inputText));
    }
    
    public double getValue(){
        return Double.parseDouble(Helpers.FormatNumber.clearFormatedNumber(inputText.getText()));
    }

    
}

package components.inputs;

import java.awt.event.KeyEvent;

/**
 *
 * @author ander
 */
public class InputInt extends Input{

    public InputInt() {
        super();
        inputText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputText.setText("0");
        
        inputText.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt){
                JTextFieldKeyTyped(evt);
            }

            private void JTextFieldKeyTyped(KeyEvent evt) {
                String caracteres="0123456789";// lista de caracters que devem ser aceitos
    
                if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o evento não estiver na lista
                   evt.consume();//aciona esse propriedade para eliminar a ação do evento
                }
            }
        });
    }
    
    public void setInputText(int inputText) {
        super.setInputText(Integer.toString(inputText)); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public int getValue(){
        String value = (inputText.getText().equals("")) ? "0" : inputText.getText();
        return Integer.parseInt(value);
    }

  
   
    
}

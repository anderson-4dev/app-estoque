/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components.inputs;

import Helpers.MaxCaracters;
import java.awt.Color;

/**
 *
 * @author ander
 */
public class TextArea extends javax.swing.JPanel {
    
    private boolean enabled = false;
    //define a quantidade de caracteres na input
    private int maxLenght = 0;
    
    private final Color DEFAULT_BACKGROUND = new java.awt.Color(255, 255, 255);
    private final Color READONLY_BACKGROUND = new java.awt.Color(204,204,204);

    /**
     * Creates new form TextArea
     */
    public TextArea() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputText = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(238, 48));

        inputLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        inputLabel.setForeground(new java.awt.Color(42, 77, 104));
        inputLabel.setText("inputLabel");

        inputText.setColumns(20);
        inputText.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        inputText.setForeground(new java.awt.Color(42, 77, 104));
        inputText.setRows(5);
        jScrollPane2.setViewportView(inputText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(inputLabel)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel inputLabel;
    private javax.swing.JTextArea inputText;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
     //valor padrão da input text
    protected String inputDefaultText = "";
    
    /*PERSONAL CODE*/
    public String getInputLabel() {
        return inputLabel.getText();
    }

    public void setInputLabel(String inputLabel) {
        this.inputLabel.setText(inputLabel);
    }

    public String getInputText() {
        return inputText.getText();
    }

    public void setInputText(String inputText) {
        this.inputText.setText(inputText);
    }
    
    public String getInputDefaultText() {
        return inputDefaultText;
    }

    public void setInputDefaultText(String inputDefaultText) {
        this.inputDefaultText = inputDefaultText;
    }

    public int getMaxLenght() {
        return maxLenght;
    }

    public void setMaxLenght(int maxLenght) {
        this.maxLenght = maxLenght;
        this.inputText.setDocument(new MaxCaracters(maxLenght));
    }
    

    /**
    * Torna a input editavel ou não
     * @param readOnly
    */
    public void readOnly(boolean readOnly){
        this.inputText.setEditable(!readOnly);
        
        if(!readOnly){
            this.inputText.setBackground(DEFAULT_BACKGROUND);
        }else{
            this.inputText.setBackground(READONLY_BACKGROUND);
        }
    }
    
    /**
     * Prepara o input para receber novos dados
     * @param enabled
     */
    public void enableDataInput(boolean enabled){
        this.readOnly(!enabled);
        this.setInputText(this.inputDefaultText);
    }
}

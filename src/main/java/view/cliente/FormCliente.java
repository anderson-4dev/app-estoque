package view.cliente;

import control.ClienteControl;
import control.LogradouroControl;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import model.Cliente;
import model.Logradouro;
import view.logradouro.FormLogradouro;

/**
 *
 * @author ander
 */
public class FormCliente extends javax.swing.JDialog {
    
  
    //sinaliza se teve sucesso ao salvar;
    public boolean success;
    
    /**
     * Creates new form FormCliente
     */
    public FormCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        
        inputSelectNatureza.loadOptions((List<Object>) (Object) ClienteControl.NATUREZA_LIST);
        inputSelectSexo.loadOptions((List<Object>) (Object) ClienteControl.SEXO_LIST);
        
        isLogradouro.loadOptions((List<Object>) (Object) new LogradouroControl().getAll(), (Object) "Selecione...");
        
        isLogradouro.getButton().addActionListener((ActionEvent e) -> {
                FormLogradouro dialog = new FormLogradouro(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        
                        @Override
                        public void windowClosed(WindowEvent e) {
                            if(dialog.success){
                                isLogradouro.loadOptions((List<Object>) (Object) new LogradouroControl().getAll(), (Object) "Selecione...");
                            }
                        }
                    });
                    dialog.setVisible(true);
                });
               
        
        this.iCodigo.enableDataInput(false);
        
        this.iCep.readOnly(true);
        
        
        this.inputSelectNatureza.getjComboBox().addActionListener((java.awt.event.ActionEvent evt) -> {
            loadFormNatureza(inputSelectNatureza.getSelectedIndex());
        });
        
        loadFormNatureza(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iCodigo = new components.inputs.InputInt();
        iNome = new components.inputs.Input();
        inputSelectNatureza = new components.selecter.InputSelect();
        iDocumento = new components.inputs.Input();
        iCpf = new components.inputs.Input();
        inputSelectSexo = new components.selecter.InputSelect();
        iNascimento = new components.inputs.InputDate();
        iTelefone = new components.inputs.InputCelular();
        iCep = new components.inputs.InputCep();
        isLogradouro = new components.selecter.InputSelectButton();
        iNumero = new components.inputs.Input();
        iPontoReferencia = new components.inputs.Input();
        iObservacoes = new components.inputs.TextArea();
        ibInativo = new javax.swing.JCheckBox();
        ibLiberaCredito = new javax.swing.JCheckBox();
        iLimiteCredito = new components.inputs.InputDouble();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulário de Cliente");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        iCodigo.setInputLabel("Código");
        iCodigo.setInputText("");

        iNome.setInputLabel("Nome");
        iNome.setInputText("");

        inputSelectNatureza.setInputLabel("Natureza");

        iDocumento.setInputLabel("Documento (RG)");
        iDocumento.setInputText("");

        iCpf.setInputLabel("CPF");
        iCpf.setInputText("");

        inputSelectSexo.setInputLabel("Sexo");

        iNascimento.setInputLabel("Nascimento");

        iTelefone.setInputLabel("Telefone");
        iTelefone.setInputText("");

        iCep.setInputLabel("CEP");
        iCep.setInputText("");

        isLogradouro.setInputLabel("Logradouro");

        iNumero.setInputLabel("Número");
        iNumero.setInputText("");

        iPontoReferencia.setInputLabel("Ponto de Referência");
        iPontoReferencia.setInputText("");

        iObservacoes.setInputLabel("Observações");

        ibInativo.setBackground(new java.awt.Color(255, 255, 255));
        ibInativo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ibInativo.setForeground(new java.awt.Color(42, 77, 104));
        ibInativo.setText("Cliente Inativo");
        ibInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ibInativoActionPerformed(evt);
            }
        });

        ibLiberaCredito.setBackground(new java.awt.Color(255, 255, 255));
        ibLiberaCredito.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ibLiberaCredito.setForeground(new java.awt.Color(42, 77, 104));
        ibLiberaCredito.setText("Liberar Crédito");
        ibLiberaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ibLiberaCreditoActionPerformed(evt);
            }
        });

        iLimiteCredito.setInputLabel("Limite de Crédito");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(iCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(iTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iCep, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(isLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputSelectNatureza, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputSelectSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ibInativo))
                            .addComponent(iNome, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iPontoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ibLiberaCredito)
                                    .addComponent(iLimiteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSelectNatureza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSelectSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ibInativo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(iPontoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ibLiberaCredito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iLimiteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iObservacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        btnSalvar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnDeletar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeletar.setText("DELETAR");
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletar.setEnabled(false);
        btnDeletar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ibInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ibInativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ibInativoActionPerformed

    private void ibLiberaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ibLiberaCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ibLiberaCreditoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        int id = iCodigo.getValue();
        int naturezaIndex = this.inputSelectNatureza.getSelectedIndex();
        int sexoIndex = this.inputSelectSexo.getSelectedIndex();
        boolean inativo = ibInativo.isSelected();
        String nome = iNome.getInputText();
        String cpf = iCpf.getInputText();
        String documento = iDocumento.getInputText();
        String telefone = iTelefone.getInputText();
        String nascimento = iNascimento.getInputText();
        // cep = iCep.getInputText();
        String numero = iNumero.getInputText();
        String pontoReferencia = iPontoReferencia.getInputText();
        String observacoes = iObservacoes.getInputText();
        boolean liberarCredito = ibLiberaCredito.isSelected();
        double limiteCredito = iLimiteCredito.getValue();
        
        Logradouro logradouro = (isLogradouro.getSelectedIndex() == 0) ? null : (Logradouro) isLogradouro.getSelectedItem();
        
        if(new ClienteControl().save(id, nome, naturezaIndex, sexoIndex, inativo, cpf, documento, telefone, nascimento, logradouro, numero, pontoReferencia, observacoes, liberarCredito, limiteCredito)){
            this.success = true;

            components.Message.show(null,"Cliente registrado com sucesso.");

            //quando for produto novo que foi salvo, ele fecha a janela do formulario.
            if(id == 0){
                this.dispose();
            }

        }else{
            this.success = false;
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int id = iCodigo.getValue();
        
        ClienteControl c = new ClienteControl();
        
        if(c.delete(id)){
            components.Message.show(null, "Cliente excluido da base de dados!");
            this.success = true;
            this.dispose();
        }else{
            components.Message.show(null, "Cliente com movimentação, não pode excluir!");
        }
        
        c.closeConection();
    }//GEN-LAST:event_btnDeletarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormCliente dialog = new FormCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private components.inputs.InputCep iCep;
    private components.inputs.InputInt iCodigo;
    private components.inputs.Input iCpf;
    private components.inputs.Input iDocumento;
    private components.inputs.InputDouble iLimiteCredito;
    private components.inputs.InputDate iNascimento;
    private components.inputs.Input iNome;
    private components.inputs.Input iNumero;
    private components.inputs.TextArea iObservacoes;
    private components.inputs.Input iPontoReferencia;
    private components.inputs.InputCelular iTelefone;
    private javax.swing.JCheckBox ibInativo;
    private javax.swing.JCheckBox ibLiberaCredito;
    private components.selecter.InputSelect inputSelectNatureza;
    private components.selecter.InputSelect inputSelectSexo;
    private components.selecter.InputSelectButton isLogradouro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
  
    public void loadForm(Cliente c){
        
        
        this.iCodigo.setInputText(c.getId());
        this.ibInativo.setSelected(c.isAtivo());
        this.iNome.setInputText(c.getNome());
        this.iCpf.setInputText(c.getCpfCpnj());
        this.iDocumento.setInputText(c.getDocumento());
        this.iTelefone.setInputText(c.getTelefone());
        this.iNascimento.setInputText(c.getNascimento());
        this.iCep.setInputText(c.getCep());
        this.iNumero.setInputText(c.getNumero());
        this.iPontoReferencia.setInputText(c.getPontoReferencia());
        this.iObservacoes.setInputText(c.getObservacoes());
        this.ibLiberaCredito.setSelected(c.isLiberarCredito());
        this.iLimiteCredito.setInputText(c.getLimiteCredito());
        this.inputSelectNatureza.setSelectedIndex(ClienteControl.getIndexSiglaNatureza(c.getNatureza()));
        this.inputSelectSexo.setSelectedIndex(ClienteControl.getIndexSiglaSexo(c.getSexo()));
        
        this.isLogradouro.setSelectedItem((Object) c.getLogradouro());
        
        
        loadFormNatureza(inputSelectNatureza.getSelectedIndex());
        
        
        this.btnDeletar.setEnabled(true);
    }
    
    //seta o formulario confome natureza
    private void loadFormNatureza(int index){
        
        if(index == 1){//pessoa juridica
            //this.iCpf.setMask("##.###.###/####-##");
            
            this.iNome.setInputLabel("Razão Social *");
            this.iCpf.setInputLabel("CNPJ");
            this.iDocumento.setInputLabel("Inscrição Estadual");
            
            
        }else{//seta como fisica
            //this.iCpf.setMask("###.###.###-##");
            
            this.iNome.setInputLabel("Nome *");
            this.iCpf.setInputLabel("CPF");
            this.iDocumento.setInputLabel("Documento (RG)");
        }
        
    }
    
}

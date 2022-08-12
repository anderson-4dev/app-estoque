/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.produto;

import control.CategoriaControl;
import control.FornecedorControl;
import control.ProdutoControl;
import control.UnidadeControl;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import model.Categoria;
import model.Fornecedor;
import model.Produto;
import model.Unidade;
import view.categoria.FormCategoria;
import view.fornecedor.FormFornecedor;
import view.unidade.FormUnidade;

/**
 *
 * @author ander
 */
public class FormProduto extends javax.swing.JDialog {
    
    private List<Unidade> unidades; 
    private List<Categoria> categorias; 
    private List<Fornecedor> fornecedores;
    
    private final ProdutoControl produtoControl;
    
    //sinaliza se teve sucesso ao salvar;
    public boolean success;

    /**
     * Creates new form FormProduto
     */
    public FormProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        
        this.produtoControl = new ProdutoControl();
        
        this.success = false;
        
        this.unidades = new ArrayList();
        this.fornecedores = new ArrayList();
        this.categorias = new ArrayList();
        
        
        //Carrega dados do inputSelect fornecedor
        this.loadFornecedores();
        //Carrega dados do inputSelect categoria
        this.loadCategorias();
        //Carrega dados do inputSelect unidade
        this.loadUnidades();
        
        //rotina para o dialog fechar com a tecla ESC
        this.getRootPane()
                .registerKeyboardAction(
                        e -> { this.dispose(); },
                        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), 
                        JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        this.iCodigo.enableDataInput(false);
        
        this.iCodigoBarras.setMaxLenght(13);
        
        iProduto.requestFocus();
        
        /*Start de eventos dos buttons de add*/
        isUnidade.getButton().addActionListener((ActionEvent e) -> {
            
            FormUnidade dialog = new FormUnidade(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        if(dialog.success){
                            loadUnidades();
                        }
                    }
                });
                dialog.setVisible(true);
            });
        
        /*Start de eventos dos buttons de add*/
        isCategoria.getButton().addActionListener((ActionEvent e) -> {
            
            FormCategoria dialog = new FormCategoria(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        if(dialog.success){
                            loadCategorias();
                        }
                    }
                });
                dialog.setVisible(true);
            });
        
        /*Start de eventos dos buttons de add*/
        isFornecedor.getButton().addActionListener((ActionEvent e) -> {
            FormFornecedor dialog = new FormFornecedor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        if(dialog.success){
                            loadFornecedores();
                        }
                    }
                });
                dialog.setVisible(true);
            });
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
        iProduto = new components.inputs.Input();
        isFornecedor = new components.selecter.InputSelectButton();
        isCategoria = new components.selecter.InputSelectButton();
        isUnidade = new components.selecter.InputSelectButton();
        iCusto = new components.inputs.InputDouble();
        ibInativo = new javax.swing.JCheckBox();
        iPreco = new components.inputs.InputDouble();
        iEstoque = new components.inputs.InputDouble();
        iEstoqueMinimo = new components.inputs.InputDouble();
        iCodigoBarras = new components.inputs.InputInt();
        iObservacoes = new components.inputs.TextArea();
        txtDateUpdate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Produto");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 355));

        iCodigo.setEnabled(false);
        iCodigo.setFocusable(false);
        iCodigo.setInputLabel("Código");
        iCodigo.setInputText("000");

        iProduto.setInputLabel("Produto *");
        iProduto.setInputText("");

        isFornecedor.setInputLabel("Fornecedor *");

        isCategoria.setInputLabel("Categoria *");

        isUnidade.setInputLabel("Unidade de Venda *");

        iCusto.setInputLabel("Preço de Custo");

        ibInativo.setBackground(new java.awt.Color(255, 255, 255));
        ibInativo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ibInativo.setForeground(new java.awt.Color(42, 77, 104));
        ibInativo.setText("Produto inativo ?");
        ibInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ibInativoActionPerformed(evt);
            }
        });

        iPreco.setInputLabel("Preço de Venda *");
        iPreco.setPreferredSize(new java.awt.Dimension(235, 48));

        iEstoque.setInputLabel("Estoque");

        iEstoqueMinimo.setInputLabel("Estoque Mínimo");
        iEstoqueMinimo.setPreferredSize(new java.awt.Dimension(235, 48));

        iCodigoBarras.setInputLabel("Código de Barras");
        iCodigoBarras.setInputText("");

        iObservacoes.setInputLabel("Observações");

        txtDateUpdate.setForeground(new java.awt.Color(0, 0, 0));
        txtDateUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDateUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(iCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(isUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(isCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(iCodigoBarras, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(iCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(iPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(iEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(iEstoqueMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ibInativo)
                        .addGap(18, 18, 18)
                        .addComponent(iObservacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(isUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ibInativo)
                    .addComponent(iObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDateUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void ibInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ibInativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ibInativoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        int id = iCodigo.getValue();
        String nome = iProduto.getInputText();
        String codBarras = iCodigoBarras.getInputText();
        Fornecedor fornecedor = (Fornecedor) isFornecedor.getSelectedItem(); 
        Categoria categoria =(Categoria) isCategoria.getSelectedItem(); 
        Unidade unidade = (Unidade) isUnidade.getSelectedItem(); 
        double valorCusto = iCusto.getValue(); 
        double valorVenda = iPreco.getValue(); 
        double estoqueInicial = iEstoque.getValue();
        double estoqueMinimo = iEstoqueMinimo.getValue();
        boolean inativo = ibInativo.isSelected(); 
        String observacoes = iObservacoes.getInputText();
        
        if(this.produtoControl.save(id, nome, codBarras, fornecedor, categoria, unidade, valorCusto, valorVenda, estoqueInicial, estoqueMinimo, inativo, observacoes)){
            this.success = true;
            
            components.Message.show(null,"Produto registrado com sucesso.");
            
            //quando for produto novo que foi salvo, ele fecha a janela do formulario.
            if(id==0){
                this.dispose();
            }
            
        }else{
            this.success = false;
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int id = iCodigo.getValue();
        
        if(this.produtoControl.delete(id)){
            components.Message.show(null, "Produto excluido da base de dados!");
            this.success = true;
            this.dispose();
        }else{
            components.Message.show(null, "Produto com movimentação, não pode excluir!");
        }
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
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormProduto dialog = new FormProduto(new javax.swing.JFrame(), true);
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
    private components.inputs.InputInt iCodigo;
    private components.inputs.InputInt iCodigoBarras;
    private components.inputs.InputDouble iCusto;
    private components.inputs.InputDouble iEstoque;
    private components.inputs.InputDouble iEstoqueMinimo;
    private components.inputs.TextArea iObservacoes;
    private components.inputs.InputDouble iPreco;
    private components.inputs.Input iProduto;
    private javax.swing.JCheckBox ibInativo;
    private components.selecter.InputSelectButton isCategoria;
    private components.selecter.InputSelectButton isFornecedor;
    private components.selecter.InputSelectButton isUnidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtDateUpdate;
    // End of variables declaration//GEN-END:variables
    
    //carrega o formulario com dados em caso de edição
    public void loadForm(Produto p){
        iCodigo.setInputText(p.getId());
        iProduto.setInputText(p.getNome());
        iCodigoBarras.setInputText(p.getCodBarras());
        iCusto.setInputText(p.getValorCusto());
        iPreco.setInputText(p.getValorVenda());
        iEstoque.setInputText(p.getEstoqueInicial());
        iEstoqueMinimo.setInputText(p.getEstoqueMinimo());
        ibInativo.setSelected(p.isInativo());
        iObservacoes.setInputText(p.getObservacoes());
        
        isFornecedor.setSelectedItem((Object) p.getFornecedor());
        isCategoria.setSelectedItem((Object) p.getCategoria());
        isUnidade.setSelectedItem((Object) p.getUnidade());
        
        this.txtDateUpdate.setText("Atualização em "+Helpers.DataHora.fomartStringDateTime(p.getRegistro()));
        
        this.setTitle("Edição de Produto");
        
        //habilitar o botão de deletar
        this.btnDeletar.setEnabled(true);
    }
    /******************/
    //carrega todas as fornecedores no form
    private void loadFornecedores() {
        this.fornecedores.clear();
        this.fornecedores = new FornecedorControl().getDBAll();
        this.isFornecedor.loadOptions((List<Object>) (Object) this.fornecedores);
    }
    
    //carrega todas as categorias no form
    private void loadCategorias() {
        this.categorias.clear();
        this.categorias = new CategoriaControl().getDBAll();
        this.isCategoria.loadOptions((List<Object>) (Object) this.categorias);
    }
    
    //carrega todas as unidades no form
    private void loadUnidades() {
        this.unidades.clear();
        this.unidades = new UnidadeControl().getDBAll();
        this.isUnidade.loadOptions((List<Object>) (Object) this.unidades);
    }
}

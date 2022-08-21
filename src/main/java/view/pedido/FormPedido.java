package view.pedido;

import components.inputs.Input;
import control.PedidoControl;
import control.VendedorControl;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ActionMap;
import javax.swing.FocusManager;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import model.PedidoItem;
import model.Produto;

/**
 *
 * @author ander
 */
public class FormPedido extends javax.swing.JDialog {
    //produto selecionado
    private Produto selectedProduct = null;
    private List<PedidoItem> items;
    
    KeyboardFocusManager focusManager;
    
    /**
     * Creates new form FormPedido
     */
    public FormPedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.items = new ArrayList();
        
        inputCodigo.readOnly(true);
        inputData.readOnly(true);
        
        clearInputs();
        
        /**muda estilo da header da tabela**/
        new components.TableHeader(jTable.getTableHeader());
        
        //start a pesquisa
        inputFindProduct.getInput().addActionListener((java.awt.event.ActionEvent evt) -> {
            
            findProduct(inputFindProduct.getInputText());
        });
        
        /*
            quando o ganha o foco
        */
        inputFindProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                insertItemInList();
            }
        });
        
        addEventCalcTotalItem(inputQuantidade);
        addEventCalcTotalItem(inputValor);
        addEventCalcTotalItem(inputDesconto);
        
        inputData.setInputText(Helpers.DataHora.CURRENT_DATE_STRING_BR);
        
        
        //inputSelectVendedor.loadOptions((List<Object>) (Object) new VendedorControl().getAll());
        //inputSelectTipoPedido.loadOptions(enums.PedidoTipo.values());
        
        //rotina para o dialog fechar com a tecla ESC
        this.getRootPane()
                .registerKeyboardAction(
                        e -> { this.setVisible(false); },
                        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), 
                        JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        //habilitar os atalhos
        this.focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        String windowName = this.getName();
        this.focusManager
                .addKeyEventDispatcher(new KeyEventDispatcher(){
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent evt){
                        String windowNameEvent = FocusManager.getCurrentManager().getFocusedWindow().getName();
                        if(evt.getID() == KeyEvent.KEY_RELEASED && windowNameEvent.equals(windowName)){
                            atalhos(evt);
                        }
                        return false;
                    }
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
        inputCodigo = new components.inputs.InputInt();
        inputSelectTipoPedido = new components.selecter.InputSelect();
        input1 = new components.inputs.Input();
        inputInt2 = new components.inputs.InputInt();
        btnPesquisarCliente = new javax.swing.JButton();
        inputData = new components.inputs.InputDate();
        inputSelectVendedor = new components.selecter.InputSelect();
        jPanel2 = new javax.swing.JPanel();
        inputFindProduct = new components.inputs.Input();
        inputQuantidade = new components.inputs.InputDouble();
        inputTotal = new components.inputs.InputDouble();
        inputValor = new components.inputs.InputDouble();
        inputDesconto = new components.inputs.InputDouble();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtTotalItens = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtTotalDescontos = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtTotalPedido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido");
        setFocusCycleRoot(false);
        setName("FormPedido"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setFocusTraversalPolicyProvider(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 100));

        inputCodigo.setInputLabel("Pedido");
        inputCodigo.setInputText("NOVO");

        inputSelectTipoPedido.setInputLabel("Tipo de Saída");

        input1.setInputLabel("Nome");

        inputInt2.setInputLabel("Cliente");

        btnPesquisarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnPesquisarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnPesquisarCliente.setContentAreaFilled(false);

        inputData.setInputLabel("Data");

        inputSelectVendedor.setInputLabel("Vendedor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputInt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnPesquisarCliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inputSelectVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputSelectTipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSelectTipoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSelectVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputInt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        inputFindProduct.setInputLabel("Produto");
        inputFindProduct.setInputText("");
        inputFindProduct.setNextFocusableComponent(inputQuantidade);

        inputQuantidade.setInputLabel("Quantidade");
        inputQuantidade.setInputText("1,00");
        inputQuantidade.setNextFocusableComponent(inputValor);

        inputTotal.setInputLabel("Total Item");
        inputTotal.setNextFocusableComponent(inputFindProduct);

        inputValor.setInputLabel("Valor");
        inputValor.setNextFocusableComponent(inputDesconto);

        inputDesconto.setInputLabel("Desconto");
        inputDesconto.setNextFocusableComponent(inputTotal);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputFindProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputFindProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable.setBackground(new java.awt.Color(255, 255, 255));
        jTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Descrição", "UN.", "Quant.", "Preço", "Desc.", "Total Item"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(20);
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(300);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(5);
            jTable.getColumnModel().getColumn(4).setResizable(false);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(5).setResizable(false);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(6).setResizable(false);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(7).setResizable(false);
            jTable.getColumnModel().getColumn(7).setPreferredWidth(50);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Quantidade Itens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 12), new java.awt.Color(42, 77, 104))); // NOI18N

        txtTotalItens.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtTotalItens.setForeground(new java.awt.Color(42, 77, 104));
        txtTotalItens.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalItens.setText("0,00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTotalItens, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTotalItens, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Descontos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 12), new java.awt.Color(42, 77, 104))); // NOI18N

        txtTotalDescontos.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtTotalDescontos.setForeground(new java.awt.Color(42, 77, 104));
        txtTotalDescontos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalDescontos.setText("0,00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTotalDescontos, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTotalDescontos, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 12), new java.awt.Color(42, 77, 104))); // NOI18N

        txtTotalPedido.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txtTotalPedido.setForeground(new java.awt.Color(42, 77, 104));
        txtTotalPedido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalPedido.setText("0,00");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTotalPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTotalPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FormPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPedido dialog = new FormPedido(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnPesquisarCliente;
    private components.inputs.Input input1;
    private components.inputs.InputInt inputCodigo;
    private components.inputs.InputDate inputData;
    private components.inputs.InputDouble inputDesconto;
    private components.inputs.Input inputFindProduct;
    private components.inputs.InputInt inputInt2;
    private components.inputs.InputDouble inputQuantidade;
    private components.selecter.InputSelect inputSelectTipoPedido;
    private components.selecter.InputSelect inputSelectVendedor;
    private components.inputs.InputDouble inputTotal;
    private components.inputs.InputDouble inputValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel txtTotalDescontos;
    private javax.swing.JLabel txtTotalItens;
    private javax.swing.JLabel txtTotalItens2;
    private javax.swing.JLabel txtTotalPedido;
    // End of variables declaration//GEN-END:variables
    
    private void findProduct(String txt){
        FindProduct dialog = new FindProduct(new javax.swing.JFrame(), true);
        dialog.getProducts(txt);
        dialog.setInputText(txt);
        dialog.setVisible(true);
        
        //KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(focusManager);
        
        this.selectedProduct = dialog.getProduto();
        
        Produto p = this.selectedProduct;
        
        if(p != null && p.getId() > 0){
            //seta a produto no form
            inputFindProduct.setInputText(p.getNome());
            inputValor.setInputText(p.getValorVenda());
            inputQuantidade.setInputText(1);
            inputTotal.setInputText(p.getValorVenda());
            
            //muda o foco para o proximo elemento
            this.transferFocus();

            
        }else{
            System.out.println("Nenhum produto selecionado!");
        }
        
        this.setFocusable(true);
    }
    
    //adciona evento para setar o total item
    private void addEventCalcTotalItem(Input i){
        i.getInput().addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputTotal.setInputText(PedidoControl.calcTotalItem(inputQuantidade.getValue(), inputValor.getValue(),inputDesconto.getValue()));
            }
        });
    }
    
    /**
     * Verifica a validade dos campos e adiciona o novo item a lista
     * função principal
     */
    private void insertItemInList() {
        Produto p = this.selectedProduct;
        //verifica se não é nulo
        if(p != null && p.getId() > 0){
            if(inputQuantidade.getValue() <= 0){
                
                components.Message.show(null,"Quantidade deve ser maior que 0,00.");
                inputQuantidade.setInputText(1);
                inputQuantidade.requestFocus();
                
            }else if(inputValor.getValue() <= 0){
                
                components.Message.show(null,"Valor do produto deve ser maior que 0,00.");
                inputValor.setInputText(p.getValorVenda());
                inputValor.requestFocus();
                
            }else if(
                    !PedidoControl.validarDescontoItem(
                            (inputQuantidade.getValue() * inputValor.getValue()), 
                            inputDesconto.getValue()
                    )){
                
                components.Message.show(null,"Desconto não permitido.");
                inputDesconto.setInputText(0);
                inputDesconto.requestFocus();
                
            }else{
                items.add(new PedidoItem(p, inputQuantidade.getValue(), inputDesconto.getValue(), inputValor.getValue()));
                //carrega os produtos para visualização
                loadJtable();
                //limpa os campos de quantidade, valor, desconto e total item.
                clearInputs();
                //printa o total do pedido;
                printTotalPedido();
            }
        }
    }
    
    private void loadJtable(){
        
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();

        modelo.setRowCount(0);

        int index = 1;
        
        for(PedidoItem item : items){
            modelo.addRow(new Object[]{
                index++,
                item.getProduto().getId(),
                item.getProduto().getNome(),
                item.getProduto().getUnidade(),
                Helpers.FormatNumber.formatDouble(item.getQuantidade()),
                Helpers.FormatNumber.formatDouble(item.getValor()),
                Helpers.FormatNumber.formatDouble(item.getDesconto()),
                Helpers.FormatNumber.formatDouble(PedidoControl.calcTotalItem(item))
            });
        }
    }
    
    private void clearInputs(){
        inputQuantidade.setInputText(1);
        inputValor.setInputText(0);
        inputDesconto.setInputText(0);
        inputTotal.setInputText(0);
        
    }
    
    private void newPedido(){
        txtTotalPedido.setText("0,00");
        txtTotalItens.setText("0,00");
    }

    private void printTotalPedido() {
        if(items.size() > 0){
            txtTotalPedido.setText(Helpers.FormatNumber.formatDouble(PedidoControl.totalPedido(items)));
            txtTotalItens.setText(Helpers.FormatNumber.formatDouble((double) items.size()));
            txtTotalDescontos.setText(Helpers.FormatNumber.formatDouble(PedidoControl.sumDescontoItems(items)));
        }
    }
    
    private void atalhos(KeyEvent evt){
        if(Helpers.TeclasAtalho.TECLA_F1(evt)){
            components.Message.show(null,"Tecla f1");
        }
        if(Helpers.TeclasAtalho.TECLA_F2(evt)){
            components.Message.show(null,"Tecla f2");
        }
        
    }
    
}

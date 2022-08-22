package control;

import model.Cliente;
import model.Usuario;

/**
 *
 * @author ander
 */
public class Main {
    public static Usuario SESSION_USUARIO = new Usuario(1);
    public static String SESSION_DATE_TIME_INIT = Helpers.DataHora.CURRENT_DATE_TIME_STRING;
    public static int EMPRESA_ID = 1;
    public static double DESCONTO_MAXIMO_GERENTE = (10/100);//10%
    public static Cliente CLIENTE_PADRAO = new Cliente(1);
    
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
                if (!"Windows".equals(info.getName())) {
                } else {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new view.Main().setVisible(true);
        });
    }
    
}

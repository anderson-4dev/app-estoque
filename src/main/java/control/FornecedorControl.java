package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Fornecedor;
import model.Usuario;
import persistence.FornecedorDao;

/**
 *
 * @author ander
 */
public class FornecedorControl{
    private final FornecedorDao dAo;
    
    public FornecedorControl() {
        this.dAo = new FornecedorDao();
    }
    
    /**
     * Busca todas as fornecedores no banco de dados
     * @return fornecedores
     **/
    public List<Fornecedor> getDBAll(){
        return this.dAo.getAll();
    }
    
    public boolean save(
            int id,
            String nome, 
            String telefone, 
            String contato, 
            String observacoes){
        
        if(validateValues(nome)){
            
            telefone = Helpers.ClearSpecialCharactersText.clear(telefone);
            
            Fornecedor fornecedor = new Fornecedor(id, nome, telefone, contato, observacoes);

            fornecedor.setRegistro(Helpers.DataHora.CURRENT_DATE_TIME_STRING);
            fornecedor.setUsuario(new Usuario(1));//pegar da session

            return this.dAo.save(fornecedor);
        
        }
        
        return false;
    }
    
    public boolean delete(int id) {
            return this.dAo.delete(id);
    }
    
    private boolean validateValues(String nome){
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe um nome para o fornecedor.");
            return false;
        }
        
        return true;
    }
}

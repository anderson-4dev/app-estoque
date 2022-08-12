package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Unidade;
import persistence.UnidadeDao;

/**
 *
 * @author ander
 */
public class UnidadeControl{
    private final UnidadeDao dAo;

    public UnidadeControl() {
        this.dAo = new UnidadeDao();
    }
    
    public boolean save(int id, String nome){
        
        if(validateValues(nome)){
        
            Unidade unidade = new Unidade(id, nome);

            return this.dAo.save(unidade);
        
        }
        
        return false;
    }
    
    /**
     * Busca todas as unidades no banco de dados
     * @return unidades
     **/
    public List<Unidade> getDBAll(){
        return this.dAo.getAll();
    }
    
    
    private boolean validateValues(String nome){
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe um nome para a unidade.");
            return false;
        }
        
        return true;
    }
    
    public boolean delete(int id) {
            return this.dAo.delete(id);
    }

}

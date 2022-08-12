package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import persistence.CategoriaDao;

/**
 *
 * @author ander
 */
public class CategoriaControl {
    
    private final CategoriaDao dAo;
    
    public CategoriaControl() {
        this.dAo = new CategoriaDao();
    }
    
    /**
     * Busca todas as categorias no banco de dados
     * @return unidades
     **/
    public List<Categoria> getDBAll(){
        return this.dAo.getAll();
    }
    
    public boolean save(int id, String nome){
        
        if(validateValues(nome)){
        
            Categoria unidade = new Categoria(id, nome);

            return this.dAo.save(unidade);
        
        }
        
        return false;
    }
    
    public Categoria get(int id){
        return this.dAo.get(id);
    }

    private boolean validateValues(String nome){
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe um nome para a categoria.");
            return false;
        }
        
        return true;
    }
    
    public boolean delete(int id) {
            return this.dAo.delete(id);
    }

    public void closeConection() {
        this.dAo.close();
    }
    
  
    
    
    
}

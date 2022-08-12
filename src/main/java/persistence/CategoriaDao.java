package persistence;

import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;

/**
 *
 * @author ander
 */
public class CategoriaDao extends GenericDAO<Categoria>{
    
    public CategoriaDao() {
        super(Categoria.class);
    }
    
    public List<Categoria> pesquisar(String nome){
        try{
            return this.em.createQuery("from Categoria C WHERE C.nome LIKE :nome")
                .setParameter("nome", "%"+nome+"%")
                .getResultList();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao buscar!\n"+e);
        }
        
        return null;
    }
    
}

package control;

import java.util.List;
import model.Cidade;
import model.Estado;
import persistence.BairroDao;
import persistence.CidadeDao;
import persistence.EstadoDao;
import persistence.LogradouroDao;

/**
 *
 * @author ander
 */
public class EnderecoControl {
    
    
    public static List<Estado> getEstados(){
        return new EstadoDao().getAll();
    }
    
    public List<Cidade> getCidades(){
        return new CidadeDao().getAll();
    }
    
    
    public static void main(String[] args) {
        LogradouroDao dao = new LogradouroDao();
        
        dao.getAll().forEach(e->{
            System.out.println(e.toString());
        });
    }
}

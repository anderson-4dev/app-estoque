package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Bairro;
import model.Logradouro;
import persistence.LogradouroDao;

/**
 *
 * @author ander
 */
public class LogradouroControl {
    private final LogradouroDao dAo;
    
    public LogradouroControl() {
        this.dAo = new LogradouroDao();
    }
    
    /**
     * Busca todos no banco de dados
     * @return fornecedores
     **/
    public List<Logradouro> getAll(){
        return this.dAo.getAll();
    }

    public boolean save(int id, String cep, String logradouro, Bairro bairro) {
        
        if(this.validateData(logradouro)){
            LogradouroDao dao = new LogradouroDao();
            Logradouro l = new Logradouro();
            l.setId(id);
            l.setCep(Helpers.ClearSpecialCharactersText.clear(cep));
            l.setLogradouro(logradouro);
            l.setBairro(bairro);
            
            return dao.save(l);
        }
        
        return false;
    }
    
    private boolean validateData(String logradouro){
        if("".equals(logradouro)){
            JOptionPane.showMessageDialog(null,"Informe um nome para o lugar(Rua, Av, Beco, Travessa, Rodovia, Ramal)!");
            return false;
        }
        return true;
    }
    
    public void closeConection() {
        this.dAo.close();
    }

    public boolean delete(int id) {
        return this.dAo.delete(id);
    }
}

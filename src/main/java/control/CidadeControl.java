package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Cidade;
import model.Estado;
import persistence.CidadeDao;

/**
 *
 * @author ander
 */
public class CidadeControl {
    private final CidadeDao dAo;
    
    public CidadeControl() {
        this.dAo = new CidadeDao();
    }
    
    public List<Cidade> getAll(){
        return new CidadeDao().getAll();
    }
    
    public boolean save(int id, String nome, Estado estado){
        
         if(this.validateValues(nome)){
            Cidade obj = new Cidade();
            
            obj.setId(id);
            obj.setNome(nome);
            obj.setEstado(estado);

            return this.dAo.save(obj);
        
         }
        
        return false;
    }
    
    private boolean validateValues(String nome){
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe o nome da cidade.");
            return false;
        }
        
        return true;
    }
    
    //private Estado getEstado(String uf){}

    public void closeConection() {
        this.dAo.close();
    }

    public boolean delete(int id) {
        return this.dAo.delete(id);
    }
}

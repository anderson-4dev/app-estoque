package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Bairro;
import model.Cidade;
import persistence.BairroDao;

/**
 *
 * @author ander
 */
public class BairroControl {
   
    private final BairroDao dAo;
    
    public BairroControl() {
        this.dAo = new BairroDao();
    }
    
    public List<Bairro> getAll(){
        return new BairroDao().getAll();
    }
    
    public boolean save(int id, String nome, Cidade cidade){
        
         if(this.validateValues(nome)){
            Bairro obj = new Bairro();
            
            obj.setId(id);
            obj.setNome(nome);
            obj.setCidade(cidade);

            return this.dAo.save(obj);
        
         }
        
        return false;
    }
    
    private boolean validateValues(String nome){
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe o nome do Bairro.");
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
    
    
    public static void main(String[] args) {
        new BairroControl().getAll().forEach(e -> {
            System.out.println(e.toString());
        });
    }
}//AND CLASS

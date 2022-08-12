package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;
import persistence.UsuarioDao;

/**
 *
 * @author ander
 */
public class UsuarioControl {
    
    private final UsuarioDao dAo;
    
    public UsuarioControl() {
        this.dAo = new UsuarioDao();
    }
    
    /**
     * Busca todas as categorias no banco de dados
     * @return unidades
     **/
    public List<Usuario> getAll(){
        return this.dAo.getAll();
    }
    
    public boolean save(int id, String nome, String senha, boolean master){
        //add um validador para senha
        if(validateValues(nome)){
            
            Usuario obj;
            
            if(id == 0){
                obj = new Usuario();
                obj.setAtivo(true);
            
            }else{
                obj = this.get(id);
            }
            
            //obj.setId(id);
            obj.setNome(nome);
            obj.setSenha(senha);
            obj.setMaster(master);
            
            return this.dAo.save(obj);
        
        }
        
        return false;
    }
    
    public boolean save (Usuario u){
        return this.dAo.save(u);
    }
    
    public boolean toggleAtive(int id){
        Usuario u = this.get(id);
        boolean status = u.isAtivo();
        
        u.setAtivo(!status);
        
        if(this.save(u)){
            if(status){
                components.Message.show(null, "Usuário "+u.getNome()+" não pode mais acessar!");
            }else{
                components.Message.show(null, "Usuário "+u.getNome()+" autorizado a acessar!");
            }
            return true;
        }
        
        return false;
    }
    
    public Usuario get(int id){
        return this.dAo.get(id);
    }

    private boolean validateValues(String nome){
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe um nome para o Usuario.");
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

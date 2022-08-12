package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Gerente;
import model.Vendedor;
import persistence.VendedorDao;

/**
 *
 * @author ander
 */
public class VendedorControl {
    
    private final VendedorDao dAo;
    
    public VendedorControl() {
        this.dAo = new VendedorDao();
    }
    
    /**
     * Busca todas as categorias no banco de dados
     * @return unidades
     **/
    public List<Vendedor> getAll(){
        return this.dAo.getAll();
    }
    
    public boolean save(int id, String nome, String senha, Gerente gerente){
        //add um validador para senha
        if(validateValues(nome, senha)){
            
            Vendedor obj;
            
            if(id == 0){
                obj = new Vendedor();
                obj.setAtivo(true);
            
            }else{
                obj = this.get(id);
            }
            
            //obj.setId(id);
            obj.setNome(nome);
            obj.setSenha(senha);
            obj.setGerente(gerente);
            obj.setDataCadastro(Helpers.DataHora.CURRENT_DATE_TIME_STRING);
            obj.setUsuario(Main.SESSION_USUARIO);
            
            return this.dAo.save(obj);
        
        }
        
        return false;
    }
    
    public boolean save (Vendedor u){
        return this.dAo.save(u);
    }
    
    public boolean toggleAtive(int id){
        Vendedor u = this.get(id);
        boolean status = u.isAtivo();
        
        u.setAtivo(!status);
        
        if(this.save(u)){
            if(status){
                components.Message.show(null, "Vendedor "+u.getNome()+" bloqueado!");
            }else{
                components.Message.show(null, "Vendedor "+u.getNome()+" desbloqueado!");
            }
            return true;
        }
        
        return false;
    }
    
    public Vendedor get(int id){
        return this.dAo.get(id);
    }

    private boolean validateValues(String nome, String senha){
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe um nome para o Vendedor.");
            return false;
        }else if(senha.equals("") || senha.length() < 3){
            components.Message.show(null,"A senha deve conter no mínimo 3 caracteres.");
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
    
    public static void main(String[] args) {
        new VendedorControl().getAll().forEach(e->{
            System.out.println(e);
        });
    }
}

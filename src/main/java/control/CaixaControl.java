package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Gerente;
import model.Caixa;
import model.Vendedor;
import persistence.OperadorCaixaDao;

/**
 *
 * @author ander
 */
public class CaixaControl {
     private final OperadorCaixaDao dAo;
    
    public CaixaControl() {
        this.dAo = new OperadorCaixaDao();
    }
    
    /**
     * Busca todas as categorias no banco de dados
     * @return unidades
     **/
    public List<Caixa> getAll(){
        return this.dAo.getAll();
    }
    
    public boolean save(int id, String nome, String senha, Gerente gerente, Vendedor vendedor){
        //add um validador para senha
        if(validateValues(nome)){
            
            Caixa obj;
            
            if(id == 0){
                obj = new Caixa();
                obj.setAtivo(true);
            
            }else{
                obj = this.get(id);
            }
            
            //obj.setId(id);
            obj.setNome(nome);
            obj.setSenha(senha);
            obj.setGerente(gerente);
            obj.setVendedor(vendedor);
            obj.setDataCadastro(Helpers.DataHora.CURRENT_DATE_TIME_STRING);
            obj.setUsuario(Main.SESSION_USUARIO);
            
            return this.dAo.save(obj);
        
        }
        
        return false;
    }
    
    public boolean save (Caixa u){
        return this.dAo.save(u);
    }
    
    public boolean toggleAtive(int id){
        Caixa u = this.get(id);
        boolean status = u.isAtivo();
        
        u.setAtivo(!status);
        
        if(this.save(u)){
            if(status){
                components.Message.show(null, "Caixa "+u.getNome()+" bloqueado!");
            }else{
                components.Message.show(null, "Caixa "+u.getNome()+" desbloqueado!");
            }
            return true;
        }
        
        return false;
    }
    
    public Caixa get(int id){
        return this.dAo.get(id);
    }

    private boolean validateValues(String nome){
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe um nome para o Caixa.");
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
        new CaixaControl().getAll().forEach(e->{
            System.out.println(e);
        });
    }
}

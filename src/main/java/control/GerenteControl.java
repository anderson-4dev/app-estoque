package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Gerente;
import model.Usuario;
import persistence.GerenteDao;

/**
 *
 * @author ander
 */
public class GerenteControl {
    
    private final GerenteDao dAo;
    
    public GerenteControl() {
        this.dAo = new GerenteDao();
    }
    
    /**
     * Busca todas as categorias no banco de dados
     * @return unidades
     **/
    public List<Gerente> getAll(){
        return this.dAo.getAll();
    }
    
    public boolean save(
            int id, 
            String nome, 
            String senha, 
            double descontoMaximo, 
            double limiteMaximo, 
            Usuario usuarioVinculado, 
            boolean excederDesconto, 
            boolean excederLimite, 
            boolean liberarTodasVendas, 
            boolean cancelarVenda){

        if(validateValues(nome, senha, descontoMaximo, limiteMaximo)){
            
            Gerente obj;
            
            if(id == 0){
                obj = new Gerente();
                obj.setAtivo(true);
            
            }else{
                obj = this.get(id);
            }
            
            obj.setNome(nome);
            obj.setSenha(senha);
            obj.setDescontoMaximo(descontoMaximo);
            obj.setLimiteMaximo(limiteMaximo);
            obj.setUsuarioVinculado(usuarioVinculado);
            obj.setExcederDesconto(excederDesconto);
            obj.setExcederLimite(excederLimite);
            obj.setLiberarTodasVendas(liberarTodasVendas);
            obj.setCancelarVenda(cancelarVenda);
            obj.setUsuario(new Usuario(1));//pegar da sessão
            obj.setDataRegistro(Helpers.DataHora.CURRENT_DATE_TIME_STRING);
            
            return this.dAo.save(obj);
        
        }
        
        return false;
    }
    
    public boolean save (Gerente u){
        return this.dAo.save(u);
    }
    
    public boolean toggleAtive(int id){
        Gerente u = this.get(id);
        boolean status = u.isAtivo();
        
        u.setAtivo(!status);
        
        if(this.save(u)){
            if(status){
                components.Message.show(null, "Gerente "+u.getNome()+" bloqueado no sistema!");
            }else{
                components.Message.show(null, "Gerente "+u.getNome()+" desbloqueado no sistema!");
            }
            return true;
        }
        
        return false;
    }
    
    public Gerente get(int id){
        return this.dAo.get(id);
    }

    private boolean validateValues(String nome, String senha, double descontoMaximo, double limiteMaximo){
        if(nome.equals("")){
            components.Message.show(null,"Informe um nome para o Gerente.");
            return false;
        }
        else if(senha.equals("") || senha.length() < 3){
            components.Message.show(null,"A senha deve conter no mínimo 3 caracteres.");
            return false;
        }
        else if((descontoMaximo < 0 ) || (descontoMaximo > 100)){
            components.Message.show(null,"Desconto não pode ser negativo ou maior que 100%!");
            return false;
        }
        else if(limiteMaximo < 0){
            components.Message.show(null,"Limite Máximo não pode ser negativo!");
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


package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Empresa;
import model.Logradouro;
import persistence.EmpresaDao;

/**
 *
 * @author ander
 */
public class EmpresaControl {
    
    private final EmpresaDao dAo;
    
    public EmpresaControl() {
        this.dAo = new EmpresaDao();
    }    
    
    public List<Empresa> getAll(){
        return this.dAo.getAll("nome", "asc");
    }
    
    public Empresa getId(int id){
        return this.dAo.get(id);
    }
    
    public boolean save(
            int id, 
            String nome, 
            String telefone, 
            String celular, 
            Logradouro logradouro, 
            String cnpj, 
            String ie, 
            String diretorio) {
        
        if(this.validateValues(nome, diretorio)){
            
            

            Empresa obj = new Empresa();
            
            obj.setId(id);
            obj.setRegistro(Helpers.DataHora.CURRENT_DATE_TIME_STRING);//ativar tratamento logo
            obj.setUsuario(control.Main.SESSION_USUARIO);
            
            obj.setNome(nome);
            obj.setTelefone(Helpers.ClearSpecialCharactersText.clear(telefone));
            obj.setCelular(Helpers.ClearSpecialCharactersText.clear(celular));
            obj.setLogradouro(logradouro);
            obj.setCnpj(Helpers.ClearSpecialCharactersText.clear(cnpj));
            obj.setIe(ie);
            obj.setDiretorio(diretorio);
            
            return this.dAo.save(obj);
        }
        
        return false;
    }

    
    private boolean validateValues( String nome, String diretorio){
         if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe o nome da empresa!");
            return false;
        } else if(diretorio.equals("")){
            JOptionPane.showMessageDialog(null,"Informe o diretorio dos arquivos do sistema!");
            return false;
        }
        
        return true;
   }
}

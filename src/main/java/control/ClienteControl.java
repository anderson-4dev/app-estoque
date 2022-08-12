package control;

import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Logradouro;
import model.Usuario;
import persistence.ClienteDao;

/**
 *
 * @author ander
 */
public class ClienteControl {
    
    public static final List<String> SEXO_LIST = Arrays.asList("Selecione...", "Masculino", "Feminino");
    public static final List<String> NATUREZA_LIST = Arrays.asList("Física", "Jurídica");
    
    
    private static final String[] SEXO_SIGLA = {null, "M", "F"};
    private static final String[] NATUREZA_SIGLA = { "F", "J"};
    
    private final ClienteDao dAo;
    
    public ClienteControl() {
        this.dAo = new ClienteDao();
    }
    
     /**
     * Busca todas as fornecedores no banco de dados
     * @return fornecedores
     **/
    
    public List<Cliente> getDBAll(){
        return this.dAo.getAll("nome", "asc");
    }
    
    public List<Cliente> get(String txt){
        return this.dAo.get("nome", txt);
    }
    
    public Cliente getId(int id){
        return this.dAo.get(id);
    }
    
    public boolean save(
            int id, 
            String nome, 
            int naturezaIndex, 
            int sexoIndex, 
            boolean inativo,
            String cpf, 
            String documento, 
            String telefone, 
            String nascimento, 
            Logradouro logradouro, 
            String numero, 
            String pontoReferencia, 
            String observacoes, 
            boolean liberarCredito, 
            double limiteCredito) {
        
        if(this.validateValues(nome)){
            
            
            String natureza = NATUREZA_SIGLA[naturezaIndex];
            String sexo = (sexoIndex == 0) ? null : SEXO_SIGLA[sexoIndex];

            Cliente cliente;
            
            if(id == 0){
                cliente = new Cliente();
                cliente.setDataCadastro(Helpers.DataHora.CURRENT_DATE_TIME_STRING);//ativar tratamento logo
            }else{
                cliente = new ClienteControl().getId(id);
            }
            
            
            
            //cliente.setId(id);
            cliente.setNome(nome);
            cliente.setNatureza(natureza);
            
            cliente.setDocumento(documento);
            cliente.setCpfCpnj(Helpers.ClearSpecialCharactersText.clear(cpf));
            cliente.setSexo(sexo);
            
            if(!nascimento.equals("")){
                cliente.setNascimento(Helpers.DataHora.parseDateToStringDataBase(Helpers.DataHora.parseStringToDate(nascimento)));
            }
            cliente.setTelefone(Helpers.ClearSpecialCharactersText.clear(telefone));
            cliente.setCep(Helpers.ClearSpecialCharactersText.clear(""));
            cliente.setLogradouro(logradouro);
            
            cliente.setNumero(numero);
            cliente.setPontoReferencia(pontoReferencia);
            cliente.setLimiteCredito(limiteCredito);
            
            cliente.setLiberarCredito(liberarCredito);
            cliente.setAtivo(inativo);
            
            cliente.setObservacoes(observacoes);
            cliente.setDataAlteracao(Helpers.DataHora.CURRENT_DATE_TIME_STRING);
            cliente.setUsuario(new Usuario(1));
            
            return this.dAo.save(cliente);
        }
        
        return false;
    }

    public boolean delete(int id) {
            return this.dAo.delete(id);
    }
    
    private boolean validateValues( String nome){
         if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe o nome do cliente!");
            return false;
        }
        
        return true;
   }
    
    public void closeConection() {
        this.dAo.close();
    }
    
    //retorna a palavra da natureza completa
    public static String naturezaWord(String n){
        return ("F".equals(n)) ? NATUREZA_LIST.get(0) : NATUREZA_LIST.get(1);
    }
    
    //retorna a palavra da sexo completa
    public static String sexoWord(String n){
        if(n == null) return null;
        return ("M".equals(n)) ? SEXO_LIST.get(1) : SEXO_LIST.get(2);
    }
    
    //retorna posição 
    public static int getIndexSiglaNatureza(String s){
        for(int i=0; i < NATUREZA_SIGLA.length; i++){
            if(s.toUpperCase().equals(NATUREZA_SIGLA[i]))
                return i;
        }
        
        return 0;
    }
    
    public static int getIndexSiglaSexo(String s){
        if(s == null) return 0;
        
        for(int i=0; i < SEXO_SIGLA.length; i++){
            if(s.toUpperCase().equals(SEXO_SIGLA[i]))
                return i;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        new ClienteControl().get("").forEach(c ->{ System.out.println(c.getNome()); });
    }
    
}//AND CLASS

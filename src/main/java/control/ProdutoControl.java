package control;

import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Fornecedor;
import model.Produto;
import model.Unidade;
import model.Usuario;
import persistence.ProdutoDao;

/**
 *
 * @author ander
 */
public class ProdutoControl {
    
    private final ProdutoDao dAo;

    public ProdutoControl() {
        this.dAo = new ProdutoDao();
    }
    
     /**
     * Busca todas as fornecedores no banco de dados
     * @return fornecedores
     **/
    public List<Produto> getDBAll(){
        return new ProdutoDao().getAll();
    }
    
    public boolean save(
            int id,
            String nome, 
            String codBarras, 
            Fornecedor fornecedor, 
            Categoria categoria, 
            Unidade unidade, 
            double valorCusto, 
            double valorVenda, 
            double estoqueInicial, 
            double estoqueMinimo, 
            boolean inativo, 
            String observacoes){
        
        if(validateValues(nome, fornecedor, categoria, unidade, valorVenda)){
        
            Produto produto = new Produto(id, nome, codBarras, fornecedor, categoria, unidade, valorCusto, valorVenda, estoqueInicial, estoqueMinimo, inativo, observacoes);

            produto.setRegistro(Helpers.DataHora.CURRENT_DATE_TIME_STRING);
            produto.setUsuario(Main.SESSION_USUARIO);//pegar da session

            return this.dAo.save(produto);
        
        }
        
        return false;
    }

    public boolean delete(int id) {
            return this.dAo.delete(id);
    }
    
    private boolean validateValues(String nome, Fornecedor fornecedor, Categoria categoria, Unidade unidade, double valorVenda){
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null,"Informe uma descrição para o produto.");
            return false;
        }else if(fornecedor.getId() == 0){
            JOptionPane.showMessageDialog(null,"Informe um fornecedor para o produto.");
            return false;
        }else if(categoria.getId() == 0){
            JOptionPane.showMessageDialog(null,"Informe uma categoria para o produto.");
            return false;
        }else if(unidade.getId() == 0){
            JOptionPane.showMessageDialog(null,"Informe uma unidade para o produto.");
            return false;
        }else if(Double.toString(valorVenda).equals("")){
            JOptionPane.showMessageDialog(null,"Informe um valor de venda para o produto.");
            return false;
        }
        
        return true;
    }
}

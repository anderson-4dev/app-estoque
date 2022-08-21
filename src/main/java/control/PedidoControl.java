package control;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Modalidade;
import model.Pedido;
import model.PedidoItem;
import model.PedidoPagamento;
import model.Produto;
import model.Usuario;
import model.Vendedor;
import persistence.PedidoDao;

/**
 *
 * @author ander
 */
public class PedidoControl {

    private final PedidoDao dAo;
    
    public PedidoControl() {
        this.dAo = new PedidoDao();
    }
    
    public List<Pedido> getAll(){
        return dAo.getAll();
    }
    
    public boolean delete(int id) {
            return this.dAo.delete(id);
    }
    
    public boolean novo(
            Cliente cliente, 
            Vendedor vendedor, 
            double descontos,
            String observacoes,
            List<PedidoItem> items, 
            List<PedidoPagamento> pgts){
        
        Usuario usuario = control.Main.SESSION_USUARIO;
        String status = "A";
        String registro = Helpers.DataHora.CURRENT_DATE_TIME_STRING;
        
        Pedido p = new Pedido(cliente, usuario, vendedor, status, registro, this.totalPedido(items), descontos, observacoes);
        
        for(PedidoItem item: items){
            item.setPedido(p);
        }
        
        for(PedidoPagamento item: pgts){
            item.setPedido(p);
        }
        
        p.setItems(items);
        p.setPagamentos(pgts);
        
        return dAo.save(p);
    }
    
    public static double totalPedido(List<PedidoItem> items){
        double total = 0.0;
        
        for(PedidoItem item: items){
            total += (item.getQuantidade() * item.getValor()) - item.getDesconto();
        }
        
        return total;
    }
    
    public static double calcTotalItem(PedidoItem item){
        return calcTotalItem(item.getQuantidade(), item.getValor(), item.getDesconto());
    }
    
    public static double calcTotalItem(double quantidade, double valor, double desconto){
        return (quantidade * valor) - desconto;
    }
    
    /**
     * Valida o desconto
     * caso não seja permitido, abre tela para autorização do gerente
     * @param totalItem
     * @param desconto
     * @return true se o desconto for permitido
     */
    public static boolean validarDescontoItem(double totalItem, double desconto) {
        
        //return ((totalItem * control.Main.DESCONTO_MAXIMO_GERENTE) <= desconto);
        return true;
    }
    
    public static double sumDescontoItems(List<PedidoItem> items){
        double total = 0;
        
        if(items.size() > 0){
            for(PedidoItem item: items){
                total += item.getDesconto();
            }
        }
        
        return total;
    }
    
    
    public static void main(String[] args) {
        if(!validarDescontoItem(10, 2)){
            System.out.println("Desconto não permitido");
        }else{
            System.out.println("Desconto ok");
        }
    }
    
//    public static void main(String[] args) {
//        PedidoControl control = new PedidoControl();
//        
//        Cliente cliente = new Cliente(1);
//        Vendedor vendedor = new Vendedor(1);
//        double descontos = 0;
//        
//        List<PedidoItem> items = new ArrayList();
//        
//        items.add(new PedidoItem(new Produto(1),10,5, 2.5));
//        items.add(new PedidoItem(new Produto(29),5,0.5, 6.5));
//        
//        List<PedidoPagamento> pgts = new ArrayList();
//        
//        pgts.add(new PedidoPagamento(new Modalidade(1), 52.0));
//        
//        control.novo(cliente, vendedor, descontos, "Inserindo registro pelo app java", items, pgts);
//        
//    }
    
}

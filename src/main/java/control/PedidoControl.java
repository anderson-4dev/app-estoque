package control;

import enums.PedidoStatus;
import enums.PedidoTipo;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Modalidade;
import model.Pedido;
import model.PedidoItem;
import model.PedidoPagamento;
import model.Usuario;
import model.Vendedor;
import persistence.PedidoDao;

/**
 *
 * @author ander
 */
public class PedidoControl {

    //private final PedidoDao dAo;
    //private List<PedidoItem> items;
    private Pedido pedido;
    
    
    public PedidoControl() {
        
        //this.items = new ArrayList();
        this.pedido = new Pedido();
    }
    
    private PedidoDao getDao(){
        return new PedidoDao();
    }

    public List<PedidoItem> getItems() {
        return this.pedido.getItems();
    }

    public void addItem(PedidoItem item) {
        item.setPedido(this.pedido);
        this.pedido.getItems().add(item);
    }
    
    public void addPagamento(PedidoPagamento pagamento) {
        pagamento.setPedido(this.pedido);
        this.pedido.getPagamentos().add(pagamento);
    }
    
    public void setData(String data){
        this.pedido.setData(data);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void setCliente(Cliente c) {
        this.pedido.setCliente(c);
    }
    
    public void setVendedor(Vendedor vendedor) {
        this.pedido.setVendedor(vendedor);
    }
    
    /*Operands*/
    
    public List<Pedido> getAll(){
        return getDao().getAll();
    }
    
    public boolean delete(int id) {
            return this.getDao().delete(id);
    }
    
//    public boolean novo(
//            Cliente cliente, 
//            Vendedor vendedor, 
//            double descontos,
//            String observacoes,
//            List<PedidoItem> items, 
//            List<PedidoPagamento> pgts){
//        
//        Usuario usuario = control.Main.SESSION_USUARIO;
//        String status = "A";
//        String registro = Helpers.DataHora.CURRENT_DATE_TIME_STRING;
//        
//        Pedido p = new Pedido(cliente, usuario, vendedor, status, registro, this.totalPedido(items), descontos, observacoes);
//        
//        for(PedidoItem item: items){
//            item.setPedido(p);
//        }
//        
//        for(PedidoPagamento item: pgts){
//            item.setPedido(p);
//        }
//        
//        p.setItems(items);
//        p.setPagamentos(pgts);
//        
//        return dAo.save(p);
//    }
    
    public boolean salvar(PedidoTipo tipo, String data_pedido, double desconto){
        
        if(this.pedido.getItems().size() > 0){

            String status = tipo.getSigla() == 'O' ? "O" : "A";
            this.pedido.setStatus(status);
            this.pedido.setData(Helpers.DataHora.parseDateStringBrToDateDataBase(data_pedido));
            this.pedido.setRegistro(Helpers.DataHora.CURRENT_DATE_TIME_STRING);
            this.pedido.setDescontos(desconto);
            this.pedido.setUsuario(control.Main.SESSION_USUARIO);
            this.pedido.setTotal(totalPedido(pedido.getItems()));
            System.out.println("total pedido" + pedido.getTotal());
            this.pedido.setPagamentos(getPagamentos());
            
            this.pedido.setObservacoes("Inserindo a parti do formulario");

            return getDao().save(this.pedido);
        
        }else{
            System.out.println("pedido sem itens para finalizar");
        }
        
        return false;
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

    private List<PedidoPagamento> getPagamentos() {
        List<PedidoPagamento> pgts = new ArrayList();
        
        pgts.add(new PedidoPagamento(this.pedido, new Modalidade(1), this.pedido.getTotal()));
        
        return pgts;
    }

    
    
}

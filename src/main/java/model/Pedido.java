package model;

/**
 *
 * @author ander
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @JoinColumn(name="CLIENTE")
    private Cliente cliente;
    
    @JoinColumn(name="USUARIO")
    private Usuario usuario;
    
    @JoinColumn(name="VENDEDOR")
    private Vendedor vendedor;
    
    @Column
    private String status;
    
    @Column
    private String registro;//timestamp
    
    @Column
    private String faturamento;//timestamp
    
    
    @Column
    private String cancelamento;//timestamp
     
    @Column
    private double total;
     
    @Column
    private double descontos;
    
    @Column
    private String observacoes;
    //recuperar todos os itens do pedido, não é uma coluna no banco de dados
    @OneToMany(mappedBy = "pedido")
    private List<PedidoItem> items;
    
    @OneToMany(mappedBy = "pedido")
    private List<PedidoPagamento> pagamentos;
    
    /*************************************************************************/

    public Pedido() {
        this.items = new ArrayList();
    }

    public Pedido(int id) {
        this.id = id;
        this.items = new ArrayList();
    }

    public Pedido(Cliente cliente, Usuario usuario, Vendedor vendedor, String status, String registro, String faturamento, String cancelamento, double total, double descontos, String observacoes, List<PedidoItem> items, List<PedidoPagamento> pagamentos) {
        this.cliente = cliente;
        this.usuario = usuario;
        this.vendedor = vendedor;
        this.status = status;
        this.registro = registro;
        this.faturamento = faturamento;
        this.cancelamento = cancelamento;
        this.total = total;
        this.descontos = descontos;
        this.observacoes = observacoes;
        this.items = items;
        this.pagamentos = pagamentos;
    }

    public Pedido(int id, Cliente cliente, Usuario usuario, Vendedor vendedor, String status, String registro, String faturamento, String cancelamento, double total, double descontos, String observacoes, List<PedidoItem> items, List<PedidoPagamento> pagamentos) {
        this.id = id;
        this.cliente = cliente;
        this.usuario = usuario;
        this.vendedor = vendedor;
        this.status = status;
        this.registro = registro;
        this.faturamento = faturamento;
        this.cancelamento = cancelamento;
        this.total = total;
        this.descontos = descontos;
        this.observacoes = observacoes;
        this.items = items;
        this.pagamentos = pagamentos;
    }
    
    /**
     * Para registro de pedido novo
     * 
     * @param cliente
     * @param usuario
     * @param vendedor
     * @param status
     * @param observacoes
     * @param total
     * @param descontos
     * @param registro
     * @param items
     * @param pgts
     */
    public Pedido(Cliente cliente, Usuario usuario, Vendedor vendedor, String status, String registro, double total, double descontos, String observacoes, List<PedidoItem> items, List<PedidoPagamento> pgts) {
        this.cliente = cliente;
        this.usuario = usuario;
        this.vendedor = vendedor;
        this.status = status;
        this.registro = registro;
        this.total = total;
        this.descontos = descontos;
        this.observacoes = observacoes;
        this.items = items;
        this.pagamentos = pgts;
    }

    public Pedido(Cliente cliente, Usuario usuario, Vendedor vendedor, String status, String registro, double totalPedido, double descontos, String observacoes) {
        this.cliente = cliente;
        this.usuario = usuario;
        this.vendedor = vendedor;
        this.status = status;
        this.registro = registro;
        this.total = total;
        this.descontos = descontos;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(String faturamento) {
        this.faturamento = faturamento;
    }

    public String getCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(String cancelamento) {
        this.cancelamento = cancelamento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }

    public List<PedidoItem> getItems() {
        return items;
    }

    public void setItems(List<PedidoItem> items) {
        this.items = items;
    }

    public List<PedidoPagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<PedidoPagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
    
    
}

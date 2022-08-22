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
    private String status;//A - 
    
    @Column
    private String data;//A - 
    
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
        //
    }

    public Pedido(int id) {
        this.id = id;
        this.items = new ArrayList();
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
    
}

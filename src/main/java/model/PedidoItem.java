package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ander
 */
@Entity
@Table(name = "PEDIDO_ITENS")
public class PedidoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @ManyToOne
    @JoinColumn(name="PEDIDO")
    private Pedido pedido;
    
    @JoinColumn(name="PRODUTO")
    private Produto produto;
    
    @Column
    private double quantidade;
    
    @Column
    private double desconto;
    
    @Column
    private double valor;//valor unitario do produto
    
    public PedidoItem() {
    }

    public PedidoItem(Produto produto, double quantidade, double desconto, double valor) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.valor = valor;
    }
    

    public PedidoItem(Pedido pedido, Produto produto, double quantidade, double desconto, double valor) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PedidoItem{ produto=" + produto.getNome() + ", quantidade=" + quantidade + ", desconto=" + desconto + ", valor=" + valor + '}';
    }
    
    
}

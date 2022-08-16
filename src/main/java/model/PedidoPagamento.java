package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import model.Pedido;
import model.Modalidade;

/**
 *
 * @author ander
 */
@Entity
@Table(name = "PEDIDO_PAGAMENTO")
public class PedidoPagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @ManyToOne
    @JoinColumn(name="PEDIDO")
    private Pedido pedido;
    
    
    @JoinColumn(name="MODALIDADE")
    private Modalidade modalidade;
    
    @Column
    private double valor;

    public PedidoPagamento() {
    }

    public PedidoPagamento(Modalidade modalidade, double valor) {
        this.modalidade = modalidade;
        this.valor = valor;
    }
    
    public PedidoPagamento(int id, Pedido pedido, Modalidade modalidade, double valor) {
        this.id = id;
        this.pedido = pedido;
        this.modalidade = modalidade;
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

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PedidoPagamento{" + "modalidade=" + modalidade.getTipo() + ", valor=" + valor + '}';
    }
    
    
    
    
    
}

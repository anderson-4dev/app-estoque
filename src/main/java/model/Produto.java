package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 *
 * @author ander
 */
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column
    private String nome;
    
    @Column(name="codbarras")
    private String codBarras;
    
    //@OneToOne
    //@Fetch(FetchMode.JOIN)
    @JoinColumn(name="fornecedor")
    private Fornecedor fornecedor;
    
    //@OneToOne
    //@Fetch(FetchMode.JOIN)
    @JoinColumn(name="categoria")
    private Categoria categoria;
    
    //@OneToOne
    //@Fetch(FetchMode.JOIN)
    @JoinColumn(name="unidade")
    private Unidade unidade;
    
    @Column(name="valorcusto")
    private double valorCusto;
    
    @Column(name="valorvenda")
    private double valorVenda;
    
    @Column(name="estoque_inicial")
    private double estoqueInicial;
    
    @Column(name="estoque_minimo")
    private double estoqueMinimo;
    
    @Column
    private boolean inativo;
    
    @Column
    private String observacoes;
    
    @Column
    private String registro;
    
    //@OneToOne
    //@Fetch(FetchMode.JOIN)
    @JoinColumn(name="usuario")
    private Usuario usuario;

    public Produto() {
    }

    public Produto(int id) {
        this.id = id;
    }

    public Produto(
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
            String observacoes) {
        this.id = id;
        this.nome = nome;
        this.codBarras = codBarras;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.unidade = unidade;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.estoqueInicial = estoqueInicial;
        this.estoqueMinimo = estoqueMinimo;
        this.inativo = inativo;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getEstoqueInicial() {
        return estoqueInicial;
    }

    public void setEstoqueInicial(double estoqueInicial) {
        this.estoqueInicial = estoqueInicial;
    }

    public double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}

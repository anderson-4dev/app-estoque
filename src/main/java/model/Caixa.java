package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author ander
 */
@Entity
@Table(name = "CAIXA")
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column
    private String nome;
    
    @Column
    private String senha;
    
    @Column
    private boolean ativo;
    
    @JoinColumn(name="GERENTE")
    private Gerente gerente;
    
    @JoinColumn(name="VENDEDOR")
    private Vendedor vendedor;
    
    @Column(name="DATA_CADASTRO")
    private String dataCadastro;
    
    @JoinColumn(name="USUARIO")
    private Usuario usuario;

    public Caixa() {
    }

    public Caixa(int id) {
        this.id = id;
    }

    public Caixa(int id, String nome, String senha, boolean ativo, Gerente gerente, Vendedor vendedor, String dataCadastro, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
        this.gerente = gerente;
        this.vendedor = vendedor;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
}

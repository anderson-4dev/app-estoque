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
public class Gerente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String nome; //not null
    @Column
    private String senha; //not null
    
    @Column(name = "DESCONTO_MAXIMO")
    private double descontoMaximo;
    
    @Column(name = "LIMITE_MAXIMO")
    private double limiteMaximo;
    
    @JoinColumn(name="USUARIO_VINCULADO")
    private Usuario usuarioVinculado;
    
    @Column(name = "EXCEDER_DESCONTO_MAXIMO")
    private boolean excederDesconto;
    
    @Column(name = "EXCEDER_LIMITE_MAXIMO")
    private boolean excederLimite;
    
    @Column(name = "LIBERAR_TODAS_AS_VENDAS")
    private boolean liberarTodasVendas;
    
    @Column(name = "CANCELAR_VENDA")
    private boolean cancelarVenda;
    
    @Column(name = "DATA_REGISTRO")
    private String dataRegistro;
    
    @JoinColumn(name="USUARIO")
    private Usuario usuario;
    
    @Column
    private boolean ativo;

    public Gerente() {
    }

    public Gerente(int id) {
        this.id = id;
    }

    public Gerente(String nome, String senha, double descontoMaximo, double limiteMaximo, Usuario usuarioVinculado, boolean excederDesconto, boolean excederLimite, boolean liberarTodasVendas, boolean cancelarVenda, String dataRegistro, Usuario usuario, boolean ativo) {
        this.nome = nome;
        this.senha = senha;
        this.descontoMaximo = descontoMaximo;
        this.limiteMaximo = limiteMaximo;
        this.usuarioVinculado = usuarioVinculado;
        this.excederDesconto = excederDesconto;
        this.excederLimite = excederLimite;
        this.liberarTodasVendas = liberarTodasVendas;
        this.cancelarVenda = cancelarVenda;
        this.dataRegistro = dataRegistro;
        this.usuario = usuario;
        this.ativo = ativo;
    }

    public Gerente(int id, String nome, String senha, double descontoMaximo, double limiteMaximo, Usuario usuarioVinculado, boolean excederDesconto, boolean excederLimite, boolean liberarTodasVendas, boolean cancelarVenda, String dataRegistro, Usuario usuario, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.descontoMaximo = descontoMaximo;
        this.limiteMaximo = limiteMaximo;
        this.usuarioVinculado = usuarioVinculado;
        this.excederDesconto = excederDesconto;
        this.excederLimite = excederLimite;
        this.liberarTodasVendas = liberarTodasVendas;
        this.cancelarVenda = cancelarVenda;
        this.dataRegistro = dataRegistro;
        this.usuario = usuario;
        this.ativo = ativo;
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

    public double getDescontoMaximo() {
        return descontoMaximo;
    }

    public void setDescontoMaximo(double descontoMaximo) {
        this.descontoMaximo = descontoMaximo;
    }

    public double getLimiteMaximo() {
        return limiteMaximo;
    }

    public void setLimiteMaximo(double limiteMaximo) {
        this.limiteMaximo = limiteMaximo;
    }

    public Usuario getUsuarioVinculado() {
        return usuarioVinculado;
    }

    public void setUsuarioVinculado(Usuario usuarioVinculado) {
        this.usuarioVinculado = usuarioVinculado;
    }

    public boolean isExcederDesconto() {
        return excederDesconto;
    }

    public void setExcederDesconto(boolean excederDesconto) {
        this.excederDesconto = excederDesconto;
    }

    public boolean isExcederLimite() {
        return excederLimite;
    }

    public void setExcederLimite(boolean excederLimite) {
        this.excederLimite = excederLimite;
    }

    public boolean isLiberarTodasVendas() {
        return liberarTodasVendas;
    }

    public void setLiberarTodasVendas(boolean liberarTodasVendas) {
        this.liberarTodasVendas = liberarTodasVendas;
    }

    public boolean isCancelarVenda() {
        return cancelarVenda;
    }

    public void setCancelarVenda(boolean cancelarVenda) {
        this.cancelarVenda = cancelarVenda;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    //se ativo, não tá bloqueado
    public boolean isBloqueado(){
        return !this.ativo;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    
    
}

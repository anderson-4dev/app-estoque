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
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column
    private String nome;//VARCHAR(255) NOT NULL,
    
    @Column
    private String natureza;// CHAR(1), not null F-fisica ou J-Juridica
    
    @Column
    private String documento;//VARCHAR(10), RG OU IE
   
    @Column(name="CPF_CNPJ")
    private String cpfCpnj; //VARCHAR(14)
    
    @Column
    private String sexo; //CHAR(1)
    
    @Column
    private String nascimento; // DATE,
    
    @Column
    private String telefone;//VARCHAR(15),
   
    @Column
    private String cep;//VARCHAR(8),
    
    @Column
    private String numero;//VARCHAR(25),
    
    @Column(name="PONTO_REFERENCIA")
    private String pontoReferencia;//VARCHAR(255),
    
    @Column(name="DATA_CADASTRO")
    private String dataCadastro;//TIMESTAMP NOT NULL,
    
    @Column(name="DATA_ALTERACAO")
    private String dataAlteracao;//TIMESTAMP NOT NULL,
    
    @Column(name="LIMITE_CREDITO")
    private double limiteCredito;
    
    @Column(name="LIBERAR_CREDITO")
    private boolean liberarCredito; // BOOLEAN NOT NULL
    
    @Column(name="OBSERVACOES")
    private String observacoes;
    
    @Column
    private boolean inativo; // BOOLEAN NOT NULL
   
    @JoinColumn(name="USUARIO")
    private Usuario usuario; // INTEGER NOT NULL,
    
    @JoinColumn(name="LOGRADOURO")
    private Logradouro logradouro; // INTEGER NOT NULL,

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
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

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCpfCpnj() {
        return cpfCpnj;
    }

    public void setCpfCpnj(String cpfCpnj) {
        this.cpfCpnj = cpfCpnj;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public boolean isLiberarCredito() {
        return liberarCredito;
    }

    public void setLiberarCredito(boolean liberarCredito) {
        this.liberarCredito = liberarCredito;
    }

    public boolean isAtivo() {
        return inativo;
    }

    public void setAtivo(boolean inativo) {
        this.inativo = inativo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }
    
    
}//AND CLASS

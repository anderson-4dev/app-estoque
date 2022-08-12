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
public class Logradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column
    private String logradouro;
    
    @Column
    private String cep;
    
    @JoinColumn(name="bairro")
    private Bairro bairro;

    public Logradouro() {
    }

    public Logradouro(int id) {
        this.id = id;
    }

    public Logradouro(int id, String logradouro, String cep, Bairro bairro) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.bairro = bairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return logradouro+ ", " +bairro.toString();
    }
    
}

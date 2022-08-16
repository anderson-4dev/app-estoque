package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ander
 */
@Entity
public class Modalidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column
    private String tipo;
    
    @Column
    private String grupo;
    
    @Column
    private int prazo;

    public Modalidade() {
    }

    public Modalidade(int id) {
        this.id = id;
    }

    public Modalidade(int id, String tipo, String grupo, int prazo) {
        this.id = id;
        this.tipo = tipo;
        this.grupo = grupo;
        this.prazo = prazo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
    
        

    
}

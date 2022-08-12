
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
public class Usuario {
    
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
    @Column
    private boolean master;
    
    
    public Usuario() {
    }
    
    public Usuario(int id) {
        this.id = id;
    }
    
    public Usuario(String nome, String senha, boolean ativo, boolean master) {
        this.nome = nome;
        this.senha = senha;
        this.ativo = ativo;
        this.master = master;

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

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}

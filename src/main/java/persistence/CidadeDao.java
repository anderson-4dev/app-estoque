package persistence;

import model.Cidade;

/**
 *
 * @author ander
 */
public class CidadeDao extends GenericDAO<Cidade>{
    
    public CidadeDao() {
        super(Cidade.class);
    } 
}

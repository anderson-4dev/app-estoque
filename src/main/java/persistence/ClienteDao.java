package persistence;

import model.Cliente;

/**
 *
 * @author ander
 */
public class ClienteDao extends GenericDAO<Cliente>{
    
    public ClienteDao() {
        super(Cliente.class);
    }

}

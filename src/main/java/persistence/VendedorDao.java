package persistence;

import model.Vendedor;

/**
 *
 * @author ander
 */
public class VendedorDao extends GenericDAO<Vendedor> {
    
    public VendedorDao() {
        super(Vendedor.class);
    }
    
}

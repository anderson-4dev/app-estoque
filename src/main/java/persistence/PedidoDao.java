package persistence;

import model.Pedido;

/**
 *
 * @author ander
 */
public class PedidoDao extends GenericDAO<Pedido>{

    public PedidoDao() {
        super(Pedido.class);
    }
    
}

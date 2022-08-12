
package persistence;

import model.Produto;

/**
 *
 * @author ander
 */
public class ProdutoDao extends GenericDAO<Produto> {
    
    public ProdutoDao() {
        super(Produto.class);
    }
}

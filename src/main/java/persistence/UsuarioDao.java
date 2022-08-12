package persistence;

import model.Usuario;

/**
 *
 * @author ander
 */
public class UsuarioDao extends GenericDAO<Usuario> {
    
    public UsuarioDao() {
        super(Usuario.class);
    }
}

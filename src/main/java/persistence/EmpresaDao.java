package persistence;

import model.Empresa;

/**
 *
 * @author ander
 */
public class EmpresaDao extends GenericDAO<Empresa>{
    
    public EmpresaDao() {
        super(Empresa.class);
    }
    
}

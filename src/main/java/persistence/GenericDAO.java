package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 * @param <T>
 */
public abstract class GenericDAO <T>{
    
    protected EntityManager em;
    protected Class<T> classe;

    public GenericDAO(Class<T> classe) {
        this.classe = classe;
        
        if(this.em == null){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConectionDataBase");
            this.em = emf.createEntityManager();
        }
    }
    
    //Insert ou Salvar um item
    public boolean save(T obj){
        try{
            this.em.getTransaction().begin();
            this.em.merge(obj);
            this.em.flush();
            this.em.getTransaction().commit();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao salvar!\n"+e);
            this.em.getTransaction().rollback();
        }finally{
            this.close();
        }
        
        return false;
    }
    
    public boolean delete(int id){
        try{
            this.em.getTransaction().begin();
            this.em.remove(this.get(id));
            this.em.flush();
            this.em.getTransaction().commit();
            return true;
        }catch(Exception e){
            this.em.getTransaction().rollback();
        }finally{
            this.close();
        }
        return false;
    }
    
    public T get(int id){
        return this.em.find(classe, id);
    }
    
    public List<T> get(String column, String value){
        return this.getQuery("FROM " + this.classe.getSimpleName() + " O WHERE LOWER(O."+ column + ") LIKE LOWER('" + value + "%') ORDER BY" + " LOWER(O."+column+") ASC");
    }
    
    public List<T> getAll(){
        
        return this.em.createQuery("FROM " + this.classe.getSimpleName() + " O" ).getResultList();
    }
    
    /**
     *
     * @param column_order = nome da coluna para ordernar
     * @param order = asc ou descending
     * @return 
     */
    public List<T> getAll(String column_order, String order){
        
        return this.em.createQuery("FROM " + this.classe.getSimpleName() + " O ORDER BY" + " LOWER(O." + column_order +") "+ order ).getResultList();
    }
    
    /**
     *
     * @param column
     * @param value
     * @param limit
     * @return 
     */
    public List<T> getAll(String column, String value, int limit){
        //return this.em.createQuery("SELECT FIRST " + limit + " * FROM " + this.classe.getSimpleName() + " O WHERE LOWER(O."+ column + ") LIKE LOWER('" + value + "%') ORDER BY" + " LOWER(O."+column+") " + order ).getResultList();
        return this.getQuery("FROM " + this.classe.getSimpleName() + " O WHERE LOWER(O."+ column + ") LIKE LOWER('" + value + "%') ORDER BY" + " LOWER(O."+column+") ASC");
    }
    
    public List<T> getQuery(String query){
        return this.em.createQuery(query).getResultList();
    }
    
    public void close(){
        this.em.close();
    }
    
    
}

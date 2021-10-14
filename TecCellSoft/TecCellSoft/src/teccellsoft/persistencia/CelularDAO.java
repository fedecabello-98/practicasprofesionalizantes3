
package teccellsoft.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import teccellsoft.entidades.Celular;

public class CelularDAO {
     private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TecCellSoftPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarCelular(Celular celular) throws Exception {
        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
    }

    public void modificarCelular(Celular celular) throws Exception {
        em.getTransaction().begin();
        em.merge(celular);
        em.getTransaction().commit();
    }

    public void eliminarCelularPorCodigo(Integer codigo) throws Exception {
        Celular celular = buscarCelularPorCodigo(codigo);
        em.getTransaction().begin();
        em.remove(celular);
        em.getTransaction().commit();
    }
    
     public List<Celular> listarCelulares() throws Exception {
        List<Celular> celular = em.createQuery("SELECT c FROM celular c")
                .getResultList();
        return celular;
    }
    
    public Celular buscarCelularPorCodigo(Integer codigo) throws Exception {
        Celular celular = em.find(Celular.class, codigo); // Esto que envio es la llave primaria
        return celular;
    }
    //CONSULTA CON PARAMETROS

    public List<Celular> ListarCelularPorMarca(String marca) throws Exception {
        List<Celular> celulares = em.createQuery("SELECT c "
                + " FROM Celular c"
                + " WHERE c.marca LIKE :marca").
                setParameter("marca", marca).getResultList();
        return celulares;
    }
    
     public List<Celular> ListarCelularPorModelo(String modelo) throws Exception {
        List<Celular> celulares = em.createQuery("SELECT c "
                + " FROM Celular c"
                + " WHERE c.modelo LIKE :modelo").
                setParameter("modelo", modelo).getResultList();
        return celulares;
    }

   
}

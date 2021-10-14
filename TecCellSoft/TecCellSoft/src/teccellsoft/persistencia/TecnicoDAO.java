
package teccellsoft.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import teccellsoft.entidades.Tecnico;


public class TecnicoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TecCellSoftPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarTecnico(Tecnico tecnico) throws Exception {
        em.getTransaction().begin();
        em.persist(tecnico);
        em.getTransaction().commit();
    }

    public void modificarTecnico(Tecnico tecnico) throws Exception {
        em.getTransaction().begin();
        em.merge(tecnico);
        em.getTransaction().commit();
    }

    public void eliminarTecnicoPorId(int id) throws Exception {
        Tecnico tecnico = buscarTecnicoPorId(id);
        em.getTransaction().begin();
        em.remove(tecnico);
        em.getTransaction().commit();
    }

    public void eliminarTecnicoCorreo(String nombre) throws Exception {
        Tecnico tecnico = buscarTecnicoPorNombre(nombre);
        em.getTransaction().begin();
        em.remove(tecnico);
        em.getTransaction().commit();
    }

    public Tecnico buscarTecnicoPorId(int id) throws Exception {
        Tecnico tecnico = em.find(Tecnico.class, id); // Esto que envio es la llave primaria
        return tecnico;
    }
    //CONSULTA CON PARAMETROS

    public Tecnico buscarTecnicoPorNombre(String nombreIngresado) throws Exception {
        Tecnico tecnico = (Tecnico) em.createQuery("SELECT c "
                + " FROM Tecnico c"
                + " WHERE c.nombre LIKE :nombreIngresado").
                setParameter("correoElectronico", nombreIngresado).
                getSingleResult();
        return tecnico;
    }

    public Tecnico buscarTecnicoPorApellido(String apellidoIngresado) throws Exception {
        Tecnico tecnico = (Tecnico) em.createQuery("SELECT c "
                + " FROM Tecnico c"
                + " WHERE c.apellido LIKE :apellidoIngresado").
                setParameter("apellidoIngresado", apellidoIngresado).
                getSingleResult();
        return tecnico;
    }
    //CONSULTA SIN PARAMETROS

    public List<Tecnico> listarTecnicos() throws Exception {
        List<Tecnico> tecnicos = em.createQuery("SELECT c FROM Tecnico c")
                .getResultList();
        return tecnicos;
    }
}

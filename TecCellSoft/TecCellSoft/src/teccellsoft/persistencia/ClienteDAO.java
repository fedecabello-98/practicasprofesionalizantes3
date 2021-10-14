package teccellsoft.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import teccellsoft.entidades.Cliente;

public class ClienteDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TecCellSoftPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarCliente(Cliente cliente) throws Exception {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public void modificarCliente(Cliente cliente) throws Exception {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public void eliminarClientePorDNI(int dni) throws Exception {
        Cliente cliente = buscarClientePorDNI(dni);
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }

    public void eliminarClienteCorreo(String nombre) throws Exception {
        Cliente cliente = buscarClientePorNombre(nombre);
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }

    public Cliente buscarClientePorDNI(int dni) throws Exception {
        Cliente cliente = em.find(Cliente.class, dni); // Esto que envio es la llave primaria
        return cliente;
    }
    //CONSULTA CON PARAMETROS

    public Cliente buscarClientePorNombre(String nombreIngresado) throws Exception {
        Cliente cliente = (Cliente) em.createQuery("SELECT c "
                + " FROM Cliente c"
                + " WHERE c.nombre LIKE :nombreIngresado").
                setParameter("correoElectronico", nombreIngresado).
                getSingleResult();
        return cliente;
    }

    public Cliente buscarClientePorEmail(String correoElectronico) throws Exception {
        Cliente cliente = (Cliente) em.createQuery("SELECT c "
                + " FROM Cliente c"
                + " WHERE c.email LIKE :correoElectronico").
                setParameter("correoElectronico", correoElectronico).
                getSingleResult();
        return cliente;
    }
    //CONSULTA SIN PARAMETROS

    public List<Cliente> listarClientes() throws Exception {
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c")
                .getResultList();
        return clientes;
    }
}

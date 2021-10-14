package teccellsoft.servicios;

import java.util.Collection;
import teccellsoft.entidades.Celular;
import teccellsoft.entidades.Cliente;
import teccellsoft.enumeraciones.Rol;
import teccellsoft.persistencia.ClienteDAO;

public class ClienteService {

    private ClienteDAO clienteDAO;
    private CelularService celularServ;
    private EstadoService estadoServ;
    private TecnicoService tecnicoServ;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
        this.celularServ = new CelularService();
        this.estadoServ = new EstadoService();
        this.tecnicoServ = new TecnicoService();
    }

    public void crearCliente(int dni, String nombre, String apellido, String domicilio, String email) {
        try {
            if (dni < 1000000 | dni > 100000000) {
                throw new Exception("Debe indicar un DNI de tamaño válido");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre válido");
            }
            if (apellido == null || apellido.trim().isEmpty()) {
                throw new Exception("Debe indicar un apellido válido");
            }
            if (domicilio == null || domicilio.trim().isEmpty()) {
                throw new Exception("Debe indicar un domicilio válido");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("El correo electrónico es incorrecto");
            }
            if (!email.contains("@")) {
                throw new Exception("El correo indicado no es válido");
            }

            Cliente cliente = new Cliente();

            cliente.setDni(dni);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDomicilio(domicilio);
            cliente.setEmail(email);
            cliente.setRol(Rol.CLIENTE);

            clienteDAO.guardarCliente(cliente);

        } catch (Exception e) {
            System.out.println("No se creo el cliente " + e.getMessage());
        }
    }

    public void modificarClientePorDNI(int dni, String nombre, String apellido, String domicilio, String email) {
        try {
            if (dni < 1000000 | dni > 100000000) {
                throw new Exception("Debe indicar un DNI de tamaño válido");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }
            if (apellido == null || apellido.trim().isEmpty()) {
                throw new Exception("El correo electrónico es incorrecto");
            }
            if (domicilio == null || domicilio.trim().isEmpty()) {
                throw new Exception("Debe indicar un domicilio válido");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new Exception("El correo electrónico es incorrecto");
            }
            if (!email.contains("@")) {
                throw new Exception("El correo indicado no es válido");
            }

            Cliente cliente = buscarClientePorDNI(dni);

            cliente.setDni(dni);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDomicilio(domicilio);
            cliente.setEmail(email);

            clienteDAO.modificarCliente(cliente);

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

    }

    public void eliminarCliente(int dni) throws Exception {
        try {
            if (dni < 1000000 | dni > 100000000) {
                throw new Exception("Debe indicar un DNI de tamaño válido");
            }

            clienteDAO.eliminarClientePorDNI(dni);
            System.out.println("CLIENTE ELIMINADO CON ÉXITO");
        } catch (Exception e) {
            throw e;
        }
    }

    public Cliente buscarClientePorDNI(int dni) throws Exception {
        try {
            if (dni < 1000000 | dni > 100000000) {
                throw new Exception("Debe indicar un DNI de cliente váldio");
            }
            Cliente cliente = clienteDAO.buscarClientePorDNI(dni);
            return cliente;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Cliente> listarClientes() throws Exception {

        try {
            Collection<Cliente> clientes = clienteDAO.listarClientes();
            return clientes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void ImprimirClientes() {
        try {
            Collection<Cliente> clientes = listarClientes();
            if (clientes.isEmpty()){
                throw new Exception("No existen clientes para mostrar");
            }
            for (Cliente c : clientes) {
                System.out.println("*****************************************");
                System.out.println("DNI: " +c.getDni()
                + "\n Nombre:" + c.getNombre()
                + "\n Apellido:" + c.getApellido()
                + "\n Domicilio:" + c.getDomicilio()
                + "\n Correo Electrónico: " + c.getEmail()
               );
            }
        } catch (Exception e) {
        }
    }
}

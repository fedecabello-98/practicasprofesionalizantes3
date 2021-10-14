package teccellsoft.servicios;

import java.util.Collection;
import java.util.Date;
import teccellsoft.entidades.Celular;
import teccellsoft.persistencia.CelularDAO;

public class CelularService {

    private CelularDAO celularDAO;
    private ClienteService servCliente;
    private TecnicoService servTecnico;

    public void crearCelular(String marca, String modelo, String observacion, Date fechaIngreso, Double monto) {
        try {

            if (marca == null || marca.trim().isEmpty()) {
                throw new Exception("Debe indicar una marca válida");
            }
            if (modelo == null || modelo.trim().isEmpty()) {
                throw new Exception("Debe indicar un modelo válido");
            }
            if (fechaIngreso == null) {
                throw new Exception("Debe indicar una fecha de ingreso del dispositivo ");
            }
            if (monto == null || monto < 0) {
                throw new Exception("El monto ingresado es inválido");
            }

            Celular celular = new Celular();

            celular.setMarca(marca);
            celular.setModelo(modelo);
            celular.setObservacion(observacion);
            celular.setFechaIngreso(fechaIngreso);
            celular.setMonto(monto);

            celularDAO.guardarCelular(celular);

        } catch (Exception e) {
            System.out.println("No se creo el celular " + e.getMessage());
        }
    }

    public void modificarCelularPorDNI(Integer codigo, String marcaNueva, String modeloNuevo, String observacionNueva, Date fechaIngresoNueva, Double montoNuevo) {
        try {
            if (celularDAO.buscarCelularPorCodigo(codigo) == null) {

            }
            if (marcaNueva == null || marcaNueva.trim().isEmpty()) {
                throw new Exception("Debe indicar una marca válida");
            }
            if (modeloNuevo == null || modeloNuevo.trim().isEmpty()) {
                throw new Exception("Debe indicar un modelo válido");
            }
            if (montoNuevo == null || montoNuevo < 0) {
                throw new Exception("El monto ingresado es inválido");
            }

            Celular celular = buscarCelularPorCodigo(codigo);

            if (fechaIngresoNueva != null) {
                celular.setFechaIngreso(fechaIngresoNueva);
            }
            celular.setMarca(marcaNueva);
            celular.setModelo(modeloNuevo);
            celular.setObservacion(observacionNueva);
            celular.setMonto(montoNuevo);
            
            celularDAO.modificarCelular(celular);

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

    }

    public void eliminarCelular(Integer codigo) throws Exception {
        try {

            celularDAO.eliminarCelularPorCodigo(codigo);
            System.out.println("CLIENTE ELIMINADO CON ÉXITO");
        } catch (Exception e) {
            throw e;
        }
    }

    public Celular buscarCelularPorCodigo(Integer codigo) throws Exception {
        try {
            if (dni < 1000000 | dni > 100000000) {
                throw new Exception("Debe indicar un DNI de cliente váldio");
            }
            Celular celular = celularDAO.buscarCelularPorCodigo(codigo);
            return celular;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Celular> listarCelulares() throws Exception {

        try {
            Collection<Celular> celulares = celularDAO.listarCelulares();
            return celulares;
        } catch (Exception e) {
            throw e;
        }
    }

    public void ImprimirCelulares() {
        try {
            Collection<Celular> celulares = listarCelulares();
            if (celulares.isEmpty()) {
                throw new Exception("No existen celulars para mostrar");
            }
            for (Celular c : celulares) {
                System.out.println("*****************************************");
                System.out.println("DNI: " + c.getDni()
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

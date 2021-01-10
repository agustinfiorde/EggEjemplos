package com.redsocial.dominio.mascota;

import com.redsocial.dominio.mascota.Mascota;
import com.redsocial.persistencia.MascotaDAO;
import java.util.Collection;

public class MascotaService {

    private MascotaDAO dao = new MascotaDAO();

    public void crearMascota(String apodo, String raza, int idUsuario) throws Exception {

        try {

            //Validamos
            if (apodo == null || apodo.trim().isEmpty()) {
                throw new Exception("Debe indicar el apodo");
            }

            if (raza == null || raza.trim().isEmpty()) {
                throw new Exception("Debe indicar la raza");
            }

            if (idUsuario < 0) {
                throw new Exception("Debe indicar el Usuario");
            }

            //Creamos el mascota
            Mascota mascota = new Mascota();
            mascota.setApodo(apodo);
            mascota.setRaza(raza);
            mascota.setIdUsuario(idUsuario);

            dao.guardarMascota(mascota);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }

    public void modificarClaveMascota(int id, String apodo, String raza, int idUsuario) throws Exception {

        try {

            //Validamos
            if (id > 0) {
                throw new Exception("Debe indicar el id");
            }

            if (apodo == null || apodo.trim().isEmpty()) {
                throw new Exception("Debe indicar el apodo");
            }

            if (raza == null || raza.trim().isEmpty()) {
                throw new Exception("Debe indicar la raza");
            }

            if (idUsuario < 0) {
                throw new Exception("Debe indicar el Usuario");
            }

            //Buscamos
            Mascota mascota = buscarMascotaPorId(id);

            dao.modificarMascota(mascota);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }

    public void eliminarMascota(int id) throws Exception {

        try {

            //Validamos 
            if (id < 0) {
                throw new Exception("Debe indicar el Id");
            }
            dao.eliminarMascota(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }

    public Mascota buscarMascotaPorId(int id) throws Exception {

        try {

            //Validamos
            if (id < 0) {
                throw new Exception("Debe indicar el id");
            }
            Mascota mascota = dao.buscarMascotaPorId(id);
            //Verificamos
            if (mascota == null) {
                throw new Exception("No se econtró mascota para el correo electrónico indicado");
            }

            return mascota;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }

    public Collection<Mascota> listarMascota() throws Exception {

        try {

            Collection<Mascota> mascotas = dao.listarMascota();

            return mascotas;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }

    public void imprimirMascotas() throws Exception {

        try {

            //Listamos los mascotas
            Collection<Mascota> mascotas = listarMascota();

            //Imprimimos los mascotas
            if (mascotas.isEmpty()) {
                throw new Exception("No existen mascotas para imprimir");
            } else {
                for (Mascota u : mascotas) {

                    System.out.println(u.toString());

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        }
    }

}

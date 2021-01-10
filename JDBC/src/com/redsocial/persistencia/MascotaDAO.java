package com.redsocial.persistencia;

import com.redsocial.dominio.mascota.Mascota;
import java.util.ArrayList;
import java.util.Collection;

public class MascotaDAO extends DAO {

    public void guardarMascota(Mascota mascota) throws Exception {
        try {
            if (mascota == null) {
                throw new Exception("Debe indicar el mascota");
            }
            //Armo el sql
            String sql = "INSERT INTO Mascota (apodo, raza, idUsuario) "
                    + "VALUES ( '" + mascota.getApodo() + "' , '" + mascota.getRaza() + "' ," + mascota.getIdUsuario() + " );";

            System.out.println(sql);
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarMascota(Mascota mascota) throws Exception {
        try {
            if (mascota == null) {
                throw new Exception("Debe indicar el mascota que desea modificar");
            }
            //Armo el sql
            String sql = "UPDATE Mascota SET "
                    + " apodo = '" + mascota.getApodo() + "' , raza = '" + mascota.getRaza() + "' , idUsuario = " + mascota.getIdUsuario()
                    + " WHERE id = '" + mascota.getId() + "'";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarMascota(int id) throws Exception {
        try {
            //Armo el sql
            String sql = "DELETE FROM Mascota WHERE id = " + id + "";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Mascota buscarMascotaPorId(int id) throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT * FROM Mascota WHERE id = " + id + "";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorremos el resultado de la consulta
            Mascota mascota = null;
            while (resultado.next()) {
                mascota = new Mascota();
                mascota.setId(resultado.getInt(1));
                mascota.setApodo(resultado.getString(2));
                mascota.setRaza(resultado.getString(3));
                mascota.setIdUsuario(resultado.getInt(4));
            }
            return mascota;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Mascota> listarMascota() throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT * FROM Mascota ";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Mascota mascota = null;
            Collection<Mascota> mascotas = new ArrayList();
            while (resultado.next()) {
                mascota = new Mascota();
                mascota.setId(resultado.getInt(1));
                mascota.setApodo(resultado.getString(2));
                mascota.setRaza(resultado.getString(3));
                mascota.setIdUsuario(resultado.getInt(4));
                mascotas.add(mascota);
            }
            return mascotas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }
}

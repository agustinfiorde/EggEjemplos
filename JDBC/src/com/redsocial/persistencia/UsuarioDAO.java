package com.redsocial.persistencia;

import com.redsocial.dominio.usuario.Usuario;
import java.util.ArrayList;
import java.util.Collection;

public class UsuarioDAO extends DAO {

    public void guardarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar el usuario");
            }
            //Armo el sql
            String sql = "INSERT INTO Usuario (correoElectronico, clave)"
                    + "VALUES ( '" + usuario.getCorreoElectronico() + "' , '" + usuario.getClave() + "' );";

            //Ejecuto el sql
            
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }
            //Armo el sql
            String sql = "UPDATE Usuario SET "
                    + "clave = '" + usuario.getClave() + "' WHERE correoElectronico = '" + usuario.getCorreoElectronico() + "'";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarUsuario(String correEletronico) throws Exception {
        try {
            //Armo el sql
            String sql = "DELETE FROM Usuario WHERE correoElectronico = '" + correEletronico + "'";
            //Ejecuto el sql
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico) throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT * FROM Usuario "
                    + " WHERE correoElectronico = '" + correoElectronico + "'";

            //Consulto la base de datos
            consultarBase(sql);
            //Recorremos el resultado de la consulta
            Usuario usuario = null;
            while (resultado.next()) {
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setCorreoElectronico(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
            }
            return usuario;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Usuario> listarUsuario() throws Exception {
        try {
            //Armo el sql
            String sql = "SELECT correoElectronico, clave FROM Usuario ";
            //Consulto la base de datos
            consultarBase(sql);
            //Recorro el resultados de la consulta
            Usuario usuario = null;
            Collection<Usuario> usuarios = new ArrayList();
            while (resultado.next()) {
                usuario = new Usuario();
                usuario.setCorreoElectronico(resultado.getString(1));
                usuario.setClave(resultado.getString(2));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error de sistema");
        } finally {
            desconectarBase();
        }
    }
}

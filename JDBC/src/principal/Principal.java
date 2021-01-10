package principal;

import com.redsocial.dominio.mascota.MascotaService;
import com.redsocial.dominio.usuario.Usuario;
import com.redsocial.dominio.usuario.UsuarioService;

public class Principal {

    public static void main(String[] args) {
   
       UsuarioService usuarioService = new UsuarioService();
       MascotaService mascotaService = new MascotaService();
        
       try{ 
           
//        //Creamos  usuarios
//        usuarioService.crearUsuario("leo_spadaro@hotmail.com", "eggprogramacion");
//        usuarioService.crearUsuario("sebastian.cardello@hotmail.com", "seba2019");
//        usuarioService.imprimirUsuarios();
//                
//        //Modificamos un usuario
//        usuarioService.modificarClaveUsuario("sebastian.cardello@hotmail.com", "seba2019", "seba2020");
//        usuarioService.imprimirUsuarios();
//        
//        //Eliminamos un usuario
//        usuarioService.eliminarUsuario("sebastian.cardello@hotmail.com");
//        usuarioService.imprimirUsuarios();
        
        
        //Buscamos el Usuario por correo
        Usuario usuario = usuarioService.buscarUsuarioPorCorreoElectronico("leo_spadaro@hotmail.com");
        
        mascotaService.crearMascota("Chiquito", "Beagle", usuario.getId());
        
        //Mostramos Usuarios y mascotas
        usuarioService.imprimirUsuarios();
        mascotaService.imprimirMascotas();
        
      }catch(Exception e){
        System.out.println(e.getMessage());
      } 
    }
}

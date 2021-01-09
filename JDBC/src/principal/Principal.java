package principal;

import com.redsocial.dominio.usuario.UsuarioService;

/**
 *
 * @author L.Spadaro
 */
public class Principal {

    public static void main(String[] args) {
   
       UsuarioService usuarioService = new UsuarioService();
        
       try{ 
        
        /************************************/
        /************** USUARIO *************/   
        /************************************/
           
        //Creamos  usuarios
        usuarioService.crearUsuario("leo_spadaro@hotmail.com", "eggprogramacion");
        usuarioService.crearUsuario("sebastian.cardello@hotmail.com", "seba2019");
        usuarioService.imprimirUsuarios();
                
        //Modificamos un usuario
        usuarioService.modificarClaveUsuario("sebastian.cardello@hotmail.com", "seba2019", "seba2020");
        usuarioService.imprimirUsuarios();
        
        //Eliminamos un usuario
        usuarioService.eliminarUsuario("sebastian.cardello@hotmail.com");
        usuarioService.imprimirUsuarios();
        
      }catch(Exception e){
        System.out.println(e.getMessage());
      } 
    }
}

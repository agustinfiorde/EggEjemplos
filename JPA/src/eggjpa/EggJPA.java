package eggjpa;

import eggjpa.servicios.MascotaServicio;
import eggjpa.servicios.PersonaServicio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EggJPA {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();

        Menu menu = Menu.getInstance();
        
        menu.ejecucion();

    }

}

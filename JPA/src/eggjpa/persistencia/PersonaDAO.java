package eggjpa.persistencia;

import eggjpa.entidades.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonaDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarPersona(Persona persona) throws Exception {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    public void eliminar(String dni) {
        Persona persona = buscarPorDNI(dni);
        em.getTransaction().begin();
        em.remove(persona);
        em.getTransaction().commit();
    }

    public List<Persona> listarTodos() {
        List<Persona> personas = em.createQuery("SELECT p FROM Persona p")
                .getResultList();
        return personas;
    }

    public Persona buscarPorDNI(String dni) {
        Persona persona = (Persona) em.createQuery("SELECT p FROM Persona p WHERE p.dni LIKE :dni")
                .setParameter("dni", dni).getSingleResult();
        return persona;
    }

    public Persona buscarPorDNIMascota(String dni) {
        Persona persona = (Persona) em.createQuery("SELECT p FROM Persona p, IN(p.mascotas) m WHERE m.dni LIKE :dni")
                .setParameter("dni", dni).getSingleResult();
        return persona;
    }

    public List<Persona> buscarPorPaisyProvincia(String pais, String provincia) {
        List<Persona> personas = em.createQuery("SELECT p FROM Persona p WHERE p.direccion.pais LIKE :pais AND p.direccion.provincia LIKE :provincia ")
                .setParameter("pais", pais).setParameter("provincia", provincia).getResultList();
        return personas;
    }
}

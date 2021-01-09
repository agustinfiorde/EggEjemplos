package eggjpa.persistencia;

import eggjpa.entidades.Mascota;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MascotaDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarMascota(Mascota mascota) throws Exception {
        em.getTransaction().begin();
        em.persist(mascota);
        em.getTransaction().commit();
    }

    public void eliminar(String dni) throws Exception {
        Mascota mascota = buscarPorDNI(dni);
        em.getTransaction().begin();
        em.remove(mascota);
        em.getTransaction().commit();
    }

    public List<Mascota> listarTodos() throws Exception {
        List<Mascota> mascotas = em.createQuery("SELECT m FROM Mascota m ")
                .getResultList();
        return mascotas;
    }

    public Mascota buscarPorDNI(String dni) throws Exception {
        Mascota mascota = (Mascota) em.createQuery("SELECT m FROM Mascota m WHERE p.dni LIKE :dni")
                .setParameter("dni", dni).getSingleResult();
        return mascota;
    }
}

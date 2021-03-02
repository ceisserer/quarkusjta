package at.ac.htlleonding;

import at.ac.htlleonding.entities.Person;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestEndpoint {
    @Inject
    EntityManager em;

    @GET
    @Transactional
    public List<Person> getPersons() throws Exception {
        List<Person> allPersons = em.createQuery("Select p from Person p").getResultList();
        return allPersons;
    }

    @POST
    @Transactional
    public void savePerson(Person p) throws Exception {
        em.persist(p);
    }
}
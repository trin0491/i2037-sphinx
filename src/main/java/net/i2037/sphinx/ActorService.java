package net.i2037.sphinx;

import net.i2037.sphinx.model.ActorEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by richard on 08/05/2016.
 */
@Path("/actors")
public class ActorService {

    private static final java.lang.String PERSISTENCE_UNIT_NAME = "net.i2037.sphinx";
    private final EntityManagerFactory entityManagerFactory;

    public ActorService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActorEntity> getActors() {
        EntityManager entityMgr = null;
        try {
            entityMgr = entityManagerFactory.createEntityManager();
            return entityMgr.createQuery("FROM ActorEntity", ActorEntity.class).getResultList();
        } finally {
            if (entityMgr != null)
                entityMgr.close();
        }
    }
}

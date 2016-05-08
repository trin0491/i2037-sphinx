package net.i2037.sphinx;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by richard on 08/05/2016.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class UserService {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }
}

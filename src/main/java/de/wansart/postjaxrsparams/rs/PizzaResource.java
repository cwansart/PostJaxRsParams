package de.wansart.postjaxrsparams.rs;

import de.wansart.postjaxrsparams.control.PizzaController;
import de.wansart.postjaxrsparams.entity.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("pizza")
@Produces({MediaType.APPLICATION_JSON})
public class PizzaResource {

    @Inject
    private PizzaController pizzaController;

    @GET
    public Response get() {
        List<Pizza> all = pizzaController.getAll();
        GenericEntity<List<Pizza>> list = new GenericEntity<List<Pizza>>(all) {
        };
        return Response.ok(list).build();
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Response create(@FormParam("name") String name,
            @FormParam("price") double price,
            @FormParam("amount") int amount) {
        return Response.ok(pizzaController.create(name, price, amount)).build();
    }
}

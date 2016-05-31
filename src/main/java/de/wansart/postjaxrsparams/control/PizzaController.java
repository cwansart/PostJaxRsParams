package de.wansart.postjaxrsparams.control;

import de.wansart.postjaxrsparams.entity.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Stateless
public class PizzaController {
    
    @PersistenceContext(unitName = "PostJaxPu")
    private EntityManager entityManager;
    
    public List<Pizza> getAll() {
        return entityManager.createQuery("SELECT p FROM Pizza p").getResultList();
    }

    public Object create(String name, double price, int amount) {
        Pizza pizza = new Pizza();
        pizza.setName(name);
        pizza.setPrice(price);
        pizza.setAmount(amount);
        entityManager.persist(pizza);
        return pizza;
    }
}

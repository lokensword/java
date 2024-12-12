import java.util.ArrayList;
import java.util.List;

public class PizzaRepository {
    private List<Pizza> pizzas;

    public PizzaRepository() {
        this.pizzas = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public void updatePizza(int index, Pizza newPizza) {
        if (index >= 0 && index < pizzas.size()) {
            pizzas.set(index, newPizza);
        } else {
            System.out.println("Incorrect index");
        }
    }

    public List<Pizza> getAllPizzas() {
        return this.pizzas;
    }

    public int countPizzasAboveWeight(double weight) {
        int count = 0;
        for (Pizza pizza : pizzas) {
            if (pizza.getWeight() > weight) {
                count++;
            }
        }
        return count;
    }

    public List<Pizza> getPizzasAboveDiameter(double diameter) {
        List<Pizza> result = new ArrayList<>();
        for (Pizza pizza : pizzas) {
            if (pizza.getDiameter() > diameter) {
                result.add(pizza);
            }
        }
        return result;
    }
}

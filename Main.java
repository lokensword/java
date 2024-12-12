import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PizzaRepository repository = new PizzaRepository();

        repository.addPizza(new Pepperoni("Пепперони", 14.99, 500.0, 25.0));
        repository.addPizza(new Pepperoni("Двойная пепперони", 19.99, 700.0, 27.0));
        repository.addPizza(new Pepperoni("Суперпепперони", 29.99, 900.0, 32.0));
        repository.addPizza(new Cheese("Сырная", 12.99, 480.0, 25.0));
        repository.addPizza(new Cheese("Четыре сыра", 18.99, 490.0, 26.0));
        repository.addPizza(new Cheese("Сырный король", 34.99, 890.0, 35.0));
        repository.addPizza(new Meat("Мясная", 17.99, 800.0, 29.0));
        repository.addPizza(new Meat("Мясной пир", 24.99, 890.0, 32.0));
        repository.addPizza(new Meat("Барбекю", 39.99, 1100.0, 37.0));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите вес: ");
        double inputWeight = scanner.nextDouble();
        System.out.print("Введите диаметр: ");
        double inputDiameter = scanner.nextDouble();

        int countPizzas = repository.countPizzasAboveWeight(inputWeight);
        System.out.println("Количество пицц с весом больше заданного: " + countPizzas);

        List<Pizza> pizzasAboveDiameter = repository.getPizzasAboveDiameter(inputDiameter);
        System.out.println("Пиццы с диаметром больше заданного:");

        for (Pizza pizza : pizzasAboveDiameter) {
            System.out.println(pizza);
        }

        scanner.close();
    }
}
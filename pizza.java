abstract class Pizza {
    private String name;
    private double price;
    private double weight;
    private double diameter;
    private double calories;

    Pizza(String name ,double price, double weight, double diameter) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.diameter = diameter;
    }
    public double getWeight() { return weight; }

    public double getDiameter() { return diameter; }

    @Override
    public String toString() {
        return "Пицца " +
                name +
                "(цена: " + price +
                ", вес: " + weight +
                ", диаметр: " + diameter +
                ')';
    }
}

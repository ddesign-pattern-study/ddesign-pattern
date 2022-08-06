package ingredient;

public class Mushroom implements Veggies {
    String name;

    public Mushroom() {
        this.name = "Mushroom";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Mushroom{" +
                "name='" + name + '\'' +
                '}';
    }
}

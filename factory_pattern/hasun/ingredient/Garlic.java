package ingredient;

public class Garlic implements Veggies {
    String name;

    public Garlic() {
        this.name = "Garlic";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Garlic{" +
                "name='" + name + '\'' +
                '}';
    }
}

package ingredient;

public class Onion implements Veggies {
    String name;

    public Onion() {
        this.name = "Onion";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Onion{" +
                "name='" + name + '\'' +
                '}';
    }
}

package ingredient;

public class RedPepper implements Veggies {
    String name;

    public RedPepper() {
        this.name = "Red Pepper";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RedPepper{" +
                "name='" + name + '\'' +
                '}';
    }
}

package ingredient;

public class ReggianoCheese implements Cheese {
    String name;

    public ReggianoCheese() {
        this.name = "Reggiano Cheese";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ReggianoCheese{" +
                "name='" + name + '\'' +
                '}';
    }
}

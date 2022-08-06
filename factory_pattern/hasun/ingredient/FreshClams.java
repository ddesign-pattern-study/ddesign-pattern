package ingredient;

public class FreshClams implements Clams {
    String name = "Fresh Clams";

    public FreshClams() {
        this.name = "Fresh Clams";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FreshClams{" +
                "name='" + name + '\'' +
                '}';
    }
}

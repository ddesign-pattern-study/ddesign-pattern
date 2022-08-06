package ingredient;

public class ThinCrustDough implements Dough {
    String name;

    public ThinCrustDough() {
        this.name = "Thin Crust Dough";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "ThinCrustDough{" +
                "name='" + name + '\'' +
                '}';
    }
}

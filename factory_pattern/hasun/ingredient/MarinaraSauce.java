package ingredient;

public class MarinaraSauce implements Sauce {
    String name;

    public MarinaraSauce() {
        this.name = "Marinara Sauce";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MarinaraSauce{" +
                "name='" + name + '\'' +
                '}';
    }
}

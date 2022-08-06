package ingredient;

public class SlicedPepperoni implements Pepperoni {
    String name;

    public SlicedPepperoni() {
        this.name = "Sliced Pepperoni";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SlicedPepperoni{" +
                "name='" + name + '\'' +
                '}';
    }
}

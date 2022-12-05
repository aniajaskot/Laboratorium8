package exercise1.items;

public class Item {
    // identyfikator
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // przyda się przy poszukiwaniu optymalnego pudełka
    public double volume() {
        return 0;
    }

    public String getInfo() {
        return name;
    }
}

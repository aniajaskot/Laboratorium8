package exercise1.items;

public class BallItem extends Item {
    // wymiary
    private double r;

    public BallItem(String name, double r) {
        super(name);
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double volume() {
        return 4.0 / 3.0 * Math.PI * Math.pow(r, 3);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", R: " + r;
    }
}

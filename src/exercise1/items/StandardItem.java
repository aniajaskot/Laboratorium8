package exercise1.items;

public class StandardItem extends Item {
    // wymiary
    private double a;
    private double b;
    private double c;

    public StandardItem(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double volume() {
        return a * b * c;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " " + a + "x" + b + "x" +c;
    }
}

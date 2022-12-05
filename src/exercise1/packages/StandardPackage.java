package exercise1.packages;

import exercise1.items.BallItem;
import exercise1.items.Item;
import exercise1.items.StandardItem;

public class StandardPackage extends ItemPackage {
    // wymiary
    private double a;
    private double b;
    private double c;

    public StandardPackage(double a, double b, double c) {
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

    /**
     * sprawdzamy jakiego typu jest obiekt produktu
     * a następnie porównujemy wymiary i sprawdzamy,
     * czy produkt zmieści się w pudełku
     */
    public boolean checkFit(Item item){
        //w celu uniknięcia instanceof można rozważyć dodanie pola type
        //w Item i zastąpienie ifów, przy pomocy switcha, ostateczny efekt będzie taki sam
        if(item instanceof StandardItem) {
            StandardItem standardItem = (StandardItem) item;
            double itemA = standardItem.getA();
            double itemB = standardItem.getB();
            double itemC = standardItem.getC();
            return a >= itemA && b >= itemB && c >= itemC ||
                    a >= itemA && c >= itemB && b >= itemC ||
                    b >= itemA && a >= itemB && c >= itemC ||
                    b >= itemA && c >= itemB && b >= itemC ||
                    c >= itemA && a >= itemB && b >= itemC ||
                    c >= itemA && b >= itemB && a >= itemC;
        } else if(item instanceof BallItem) {
            BallItem ballItem = (BallItem) item;
            double r = ballItem.getR();
            double r2 = 2 * r;
            return r2 <= a && r2 <= b && r2 <= c;
        } else {
            return false;
        }
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
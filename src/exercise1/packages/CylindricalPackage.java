package exercise1.packages;

import exercise1.items.BallItem;
import exercise1.items.Item;
import exercise1.items.StandardItem;

public class CylindricalPackage extends ItemPackage {
    // wymiary
    private double r;
    private double height;

    public CylindricalPackage(double r, double height) {
        this.r = r;
        this.height = height;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * sprawdzamy jakiego typu jest obiekt produktu
     * a następnie porównujemy wymiary i sprawdzamy,
     * czy produkt zmieści się w pudełku
     */
    public boolean checkFit(Item item) {
        //w celu uniknięcia instanceof można rozważyć dodanie pola type
        //w Item i zastąpienie ifów, przy pomocy switcha, ostateczny efekt będzie taki sam
        if (item instanceof StandardItem) {
            StandardItem standardItem = (StandardItem) item;
            double itemA = standardItem.getA();
            double itemB = standardItem.getB();
            double itemC = standardItem.getC();
            double abHalfDiagonal = Math.sqrt((Math.pow(itemA, 2) + Math.pow(itemB, 2))) / 2;
            double acHalfDiagonal = Math.sqrt((Math.pow(itemA, 2) + Math.pow(itemC, 2))) / 2;
            double bcHalfDiagonal = Math.sqrt((Math.pow(itemB, 2) + Math.pow(itemC, 2))) / 2;
            return abHalfDiagonal <= r && itemC <= height ||
                    acHalfDiagonal <= r && itemB <= height ||
                    bcHalfDiagonal <= r && itemA <= height;
        } else if (item instanceof BallItem) {
            BallItem ballItem = (BallItem) item;
            double itemR = ballItem.getR();
            return itemR <= r && itemR * 2 <= height;
        } else {
            return false;
        }
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(r, 2) * height;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " R: " + r + ", H: " + height;
    }
}
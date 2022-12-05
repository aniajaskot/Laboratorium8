package exercise1.utils;

import exercise1.items.Item;
import exercise1.packages.CylindricalPackage;
import exercise1.packages.ItemPackage;
import exercise1.packages.StandardPackage;

public class PackageSet {
    private ItemPackage[] packages = new ItemPackage[5];

    // tworzymy tablicę pudełek
    public PackageSet() {
        packages[0] = new StandardPackage(20, 20, 20);
        packages[1] = new StandardPackage(10, 10, 10);
        packages[2] = new StandardPackage(30, 30, 30);
        packages[3] = new CylindricalPackage(10, 20);
        packages[4] = new CylindricalPackage(20, 50);
    }

    // najpierw sprawdzamy, czy obiekt zmieści się w pudełku
    // następnie porównując objętości produktu i pudełka
    // szukamy tego pudełka, które będzie optymalne
    public ItemPackage findOptimalPackage(Item item) {
        ItemPackage otimumPackage = null;
        double optimumVolumeDiff = Double.MAX_VALUE;
        double itemVolume = item.volume();
        for (ItemPackage pack : packages) {
            if (pack.checkFit(item)) {
                double packageVolume = pack.volume();
                double volumeDiff = packageVolume - itemVolume;
                if (volumeDiff < optimumVolumeDiff) {
                    otimumPackage = pack;
                    optimumVolumeDiff = volumeDiff;
                }
            }
        }
        return otimumPackage;
    }
}
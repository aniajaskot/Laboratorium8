package exercise1.app;

import exercise1.items.BallItem;
import exercise1.items.Item;
import exercise1.items.StandardItem;
import exercise1.packages.ItemPackage;
import exercise1.utils.PackageSet;

class Shop {
    public static void main(String[] args) {
        PackageSet packageSet = new PackageSet();
        Item testItem1 = new StandardItem("cukierki", 15, 15, 18);
        Item testItem2 = new BallItem("kula do kąpieli", 10);
        Item testItem3 = new StandardItem("Żel pod prysznic", 15, 15, 40);

        findBox(packageSet, testItem1);
        findBox(packageSet, testItem2);
        findBox(packageSet, testItem3);
    }

    private static void findBox(PackageSet packageSet, Item testItem2) {
        ItemPackage optimalPackage = packageSet.findOptimalPackage(testItem2);
        if(optimalPackage != null) {
            System.out.println("Produkt " + testItem2.getInfo());
            System.out.println("Pudełko: " + optimalPackage.getInfo());
        } else {
            System.out.println("Brak odpowiedniego pudełka");
        }
    }
}
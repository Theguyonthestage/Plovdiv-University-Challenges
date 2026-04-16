import java.util.ArrayList;
import java.util.Comparator;

public class Catalogue {
    private ArrayList<Product> catalogue;

    public Catalogue() {
        this.catalogue = new ArrayList<>();
    }

    public ArrayList<Product> getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(ArrayList<Product> catalogue) {
        this.catalogue = catalogue;
    }

    public void addToCatalogue(Product newProduct) {
        if (catalogue.size() < 2000) {
            catalogue.add(newProduct);
        } else
            System.out.println("Списъкът с продукти има 2000 продукта. Продуктът " + newProduct.getName() + " не е добавен.");
    }

    public void printFormattedInfo() {
        for (Product product : this.catalogue) {
            System.out.println(product.getSequentialNumber() + ", " + product.getName() + ", " +
                    product.getPricePerUnit() + " лв., " +
                    product.getAvailability() + " броя, " +
                    product.getType() + " тип, " +
                    product.getUniqueCode());
        }

    }

    public void sortByName() {
        catalogue.sort(Comparator.comparing(Product::getName));
    }

    public Catalogue filterByType(int type) {
        Catalogue filtered = new Catalogue();
        for (Product product : this.catalogue) {
            if (product.getType() == type) {
                filtered.addToCatalogue(product);
            }
        }
        return filtered;
    }

    public void sortByTotalValue() {
        catalogue.sort(Comparator.comparing(p -> p.getPricePerUnit() * p.getAvailability()));
    }

    public void printAveragePriceForUnits() {
        if (catalogue.size() <= 0) {
            System.out.println("Няма въведени артикули от този тип.");
        } else {
            float total = 0;
            float totalValue = 0;

            for (Product product : catalogue) {
                total += product.getPricePerUnit();
                totalValue += product.getAvailability() * product.getPricePerUnit();
            }
            float averagePerUnit = (total / catalogue.size());
            System.out.printf("Средна единична цена: %.2f лв.\n", averagePerUnit);
            System.out.printf("Обща стойност: %.2f лв.\n", totalValue);
        }
    }
}
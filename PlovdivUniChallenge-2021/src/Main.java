public class Main {
    public static void main(String[] args) {
        Catalogue catalogue = new Catalogue();

        // Add test products - different types, prices, availability
        try {
            catalogue.addToCatalogue(new Product("1", "Колело", 180.23f, 5, 3));
            // add more products here - make sure to include some type 4
        } catch (IllegalArgumentException e) {
            System.out.println("Грешка: " + e.getMessage());
        }

        // #2 - full list sorted by name

        // #3 - filter by type, sort by total value

        // #4 - average price and total value for type 4
    }
}

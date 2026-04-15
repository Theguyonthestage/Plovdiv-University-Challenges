public class Product {
    private String sequentialNumber;
    private String name;
    private float pricePerUnit;
    private int availability;
    private int type;// these should be in constuctor as params
    private String uniqueCode;

    public Product(String sequentialNumber, String name, float pricePerUnit, int availability, int type) {
        this.sequentialNumber = sequentialNumber;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.availability = availability;
        this.type = type;
        this.uniqueCode = sequentialNumber + name.substring(0,2) + type;

    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public String getSequentialNumber() {
        return sequentialNumber;
    }

    public String getName() {
        return name;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public int getAvailability() {
        return availability;
    }

    public int getType() {
        return type;
    }
}
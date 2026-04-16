public class Product {
    private String sequentialNumber;
    private String name;
    private float pricePerUnit;
    private int availability;
    private int type;// these should be in constuctor as params
    private String uniqueCode;

    public Product(String sequentialNumber, String name, float pricePerUnit, int availability, int type) {

        if (name.length() < 2 || name.length() > 20) {
            throw new IllegalArgumentException("Името на артикула трябва да е между 2 и 20 символа.");
        }
        if (pricePerUnit < 0.10f) {
            throw new IllegalArgumentException("Минималната единична цена е 0.10 лв.");
        }
        if (availability < 0) {
            throw new IllegalArgumentException("Наличността трябва да е положително число.");
        }
        if (type < 1 || type > 5) {
            throw new IllegalArgumentException("Типът трябва да е между 1 и 5.");
        }

        this.sequentialNumber = sequentialNumber;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.availability = availability;
        this.type = type;
        this.uniqueCode = sequentialNumber + name.substring(0, 2) + type;
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
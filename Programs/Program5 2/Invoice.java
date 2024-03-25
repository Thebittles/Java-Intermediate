public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        if (partNumber == null || partNumber.isEmpty()) {
            throw new IllegalArgumentException("Must have a part number");
        }

        if (partDescription == null || partDescription.isEmpty()) {
            throw new IllegalArgumentException("Must have a part description");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (pricePerItem <= 0.0) {
            throw new IllegalArgumentException("Price per item must be greater than zero");
        }

        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    // Setters
    public void setPartNumber(String partNumber) {
        if (partNumber == null || partNumber.isEmpty()) {
            throw new IllegalArgumentException("Must have a part number");
        }
        this.partNumber = partNumber;
    }

    public void setPartDescription(String partDescription) {
        if (partDescription == null || partDescription.isEmpty()) {
            throw new IllegalArgumentException("Must have a part description");
        }
        this.partDescription = partDescription;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this.quantity = quantity;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem <= 0.0) {
            throw new IllegalArgumentException("Price per item must be greater than zero");
        }
        this.pricePerItem = pricePerItem;
    }

    // Getters
    public String getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public double getValue() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return String.format("Part Number: %s, Description: %s, Quantity: %d, Price: %.2f",
                             getPartNumber(), getPartDescription(), getQuantity(), getPricePerItem());
    }


}
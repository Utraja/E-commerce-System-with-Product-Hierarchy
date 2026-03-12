package products;

public class ElectronicsProduct extends Product {

    private String brand;
    private int warrantyMonths;

    public ElectronicsProduct(String id,String name,double price,
                              String description,int stockQuantity,
                              String brand,int warrantyMonths) {

        super(id,name,price,description,stockQuantity);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10;
    }

    @Override
    public void displayInfo() {

        super.displayInfo();

        System.out.println("Type: Electronics");
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warrantyMonths + " months");
        System.out.println("----------------------------------------");
    }
}
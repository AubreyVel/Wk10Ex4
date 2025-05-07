import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;


public class Product {
    private String ProductID;
    private String ProductName;
    private double Price;
    
    //constructor
    public Product(String productID, String productName, double price) {
        this.ProductID = productID;
        this.ProductName = productName;
        this.Price = price;
    }

    public String GetProductID() {
        return ProductID;
    }

    public String GetProductName() {
        return ProductName;
    }

    public double GetPrice() {
        return Price;
    }
}

class ShoppingCart {
    private ArrayList<Product> items = new ArrayList<>();

    public void AddProduct(ArrayList<Product> products) {
        //decalre
        String id;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the id of the product you want to add: ");
        id = scanner.nextLine();

        for (Product p : products) {
            if(p.GetProductID().equals(id)) {
                items.add(p);
                System.out.println(p.GetProductName() + " has been added to the cart.");
                return;

            }
        }

        System.out.println("Product not found.");
    }



    public void RemoveProduct() {
        //declare
        Scanner scanner = new Scanner(System.in);
        String id;
        
        System.out.print("Enter The ID of the product you want to remove: ");
        id = scanner.nextLine();

        for(int i = 0; i< items.size(); i++){
            if (items.get(i).GetProductID().equals(id)){
                System.out.println(items.get(i).GetProductName()+ " Has Been Removed from the Cart.");
                items.remove(i);
                return;
            }
        }
        
        System.out.println("Product not found.");
    }


    public double CalculateTotalPrice() {
        //declare
        double total = 0;
        for(Product item : items) {
            total += item.GetPrice();

        }
        return total;
    }

    public void DisplayCart() {
        System.out.println("----------Your Cart----------");
        for (Product item : items) {
            System.out.println(item.GetProductID()+" --- "+ item.GetProductName()+" --- $" + item.GetPrice());
        }
        System.out.println("Cart Total ------ $"+CalculateTotalPrice());
    }

}


public class Main {
    public static void main(String[] args) {
        //create products
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("001","Bread",4.99));
        products.add(new Product("002","Milk",8.99));
        products.add(new Product("003","Cereal",10.99));
        products.add(new Product("004","Pasta",2.99));
        products.add(new Product("005","Water Bottle",.10));
        //declare and amke scanner and cart
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        int choice;

        while (loop) {
            //main menu
            System.out.println("----------Shopping Menu----------");
            System.out.println("1. Product List");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. View Cart");
            System.out.println("5. Calculate Total Price");
            System.out.println("6. Exit");
            System.out.print("Select an operation: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                System.out.println("---------- Products ----------");
                    for(Product product : products){
                        System.out.println(product.GetProductID()+" --- "+product.GetProductName()+" --- $"+product.GetPrice());
                    }
                    break;
                case 2:
                    cart.AddProduct(products);
                    break;
                case 3:
                    cart.RemoveProduct();
                    break;
                case 4:
                    cart.DisplayCart();
                    break;
                case 5:
                    System.out.println("Cart Total ----- $"+ cart.CalculateTotalPrice());
                    break;
                case 6:
                    //exi program
                    System.out.println("Goodbye.");
                    loop = false;
                    break;
                default:
                    System.out.println("Not a choice");
                    break;

            }
        
        
        }


    }
}
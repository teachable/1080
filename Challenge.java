
import java.util.*;

public class Challenge {
   public static void main(String[] arguments) {
        Storefront2 store = new Storefront2();
        store.addItem("C01", "MUG", "9.99", "150", "FALSE");
        store.addItem("C02", "LG MUG", "12.99", "82", "TRUE");
        store.addItem("C03", "MOUSEPAD", "10.49", "800", "FALSE");
        store.addItem("D01", "T SHIRT", "16.99", "90", "TRUE");
        store.sort();
        
        for (int i = 0; i < store.getSize(); i++) {
            Item2 show = (Item2)store.getItem(i);
            System.out.println("\nItem ID: " + show.getId() +
                "\nName: " + show.getName() +
                "\nRetail Price: $" + show.getRetail() +
                "\nPrice: $" + show.getPrice() +
                "\nQuantity: " + show.getQuantity());
        }
    }
}
 

class Storefront2 {
    private LinkedList catalog = new LinkedList();

    public void addItem(String id, String name, String price,
        String quant, String discount) {

        Item2 it = new Item2(id, name, price, quant, discount);
        catalog.add(it);
    }

    public Item2 getItem(int i) {
        return (Item2)catalog.get(i);
    }

    public int getSize() {
        return catalog.size();
    }

    public void sort() {
        Collections.sort(catalog);
    }
}

 class Item2 implements Comparable {
    private String id;
    private String name;
    private double retail;
    private int quantity;
    private double price;
    private boolean noDiscount;

    Item2(String idIn, String nameIn, String retailIn, String quanIn, String discountIn) {
        id = idIn;
        name = nameIn;
        retail = Double.parseDouble(retailIn);
        quantity = Integer.parseInt(quanIn);
        noDiscount = discountIn.equals("TRUE");
        
        if (quantity > 400) {
            price = retail * .5D;
        } else if (quantity > 200) {
            price = retail * .6D;
        } else {
            price = retail * .7D;
        }
        price = Math.floor( price * 100 + .5 ) / 100;
        if (noDiscount) {
            price = retail;
        }
    }

    public int compareTo(Object obj) {
        Item2 temp = (Item2)obj;
        if (this.price < temp.price) {
            return 1;
        } else if (this.price > temp.price) {
            return -1;
        }
        return 0; 
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRetail() {
        return retail;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

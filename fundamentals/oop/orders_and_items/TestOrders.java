import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Items items1 = new Items();
        items1.name = "mocha";
        items1.price = 2.5;

        Items items2 = new Items();
        items2.name= "latte";
        items2.price = 3.0;

        Items items3 = new Items();
        items3.name = "drip coffee";
        items3.price = 1.5;

        Items items4 = new Items();
        items4.name= "capuccino";
        items4.price = 4.5;
    
        // Order variables -- order1, order2 etc.
    

        Orders order1 = new Orders();
        order1.name= "Cindihuri";
        order1.total = 0.00;
        order1.ready = false;

        Orders order2 = new Orders();
        order2.name= "Jimmy";
        order2.total = 0.00;
        order2.ready = false;

        Orders order3 = new Orders();
        order3.name= "Noah";
        order3.total = 0.00;
        order3.ready = false;

        Orders order4 = new Orders();
        order4.name= "Sam";
        order4.total = 0.00;
        order4.ready = false;

        order2.items.add(items1);
        order2.total+= items1.price;

        order3.items.add(items4);
        order3.total+= items4.price;

        order4.items.add(items2);
        order4.total+= items2.price;

        order1.ready = true;

        order4.items.add(items2);
        order4.total+= items2.price;

        order4.items.add(items2);
        order4.total+= items2.price;

        order2.ready = true;
        // Application Simulations
        // Use this example code to test various orders' updates
        
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }

}
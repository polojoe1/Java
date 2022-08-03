import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        Orders order1 = new Orders();
        System.out.println(order1.getName());
        order1.addItems(new Items("Candy", 1.4));
        order1.addItems(new Items("dog food", 9.99));

        Orders order2 = new Orders();
        System.out.println(order2.getName());
        order2.addItems(new Items("popscicle", 3.5));
        order2.addItems(new Items("ice cream", 2.4));

        Orders order3 = new Orders("Joe");
        System.out.println(order3.getName());
        order3.addItems(new Items("pop", 5.0));
        order3.addItems(new Items("showerhead", 22.4));
    
        Orders order4 = new Orders("Jess");
        System.out.println(order4.getName());
        order4.addItems(new Items("soap", 1.9));
        order4.addItems(new Items("rags", 5.5));
    
        Orders order5 = new Orders("John");
        System.out.println(order5.getName());
        order5.addItems(new Items("Candy", 1.4));
        order5.addItems(new Items("Sugar", 2.4));
        order5.setReady(true);
        System.out.println(order5.getStatus(order5.getReady()));


        order4.display();
    }

}
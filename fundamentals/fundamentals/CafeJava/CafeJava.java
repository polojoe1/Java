public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 4.5;
        double latte = 6.1;
        double cappuccino = 3.8;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "John";
        String customer3 = "Chris";
        String customer4 = "Layla";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.println(isReadyOrder1? customer1+readyMessage : customer1+pendingMessage);
        System.out.println(isReadyOrder2? customer2+readyMessage + displayTotalMessage+cappuccino:customer2+pendingMessage);
        System.out.println(customer3+displayTotalMessage+(latte*2));
        System.out.println(isReadyOrder3? customer3+readyMessage:customer3+pendingMessage);
        isReadyOrder3 =true;
        System.out.println(customer4+displayTotalMessage+(latte-dripCoffee));
        mochaPrice=3.6;
        System.out.println(isReadyOrder4?customer4+readyMessage+displayTotalMessage+mochaPrice:customer4+displayTotalMessage);


    }
}
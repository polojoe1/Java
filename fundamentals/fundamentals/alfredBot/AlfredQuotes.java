import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        
        return "Hello "+name;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "It is "+date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        return "I dont care";
    }
}

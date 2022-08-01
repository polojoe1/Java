import java.util.ArrayList;

public class CafeUtil {
    public Integer getStreakGoal(int numWeeks){
        int sum = 0;
        for(int i =1;i<=numWeeks;i++){
            sum+=i;
        }
        return sum;
    }
    public Double getOrderTotal(double[] lineItems){
        double sum = 0.0;
        for(double item:lineItems){
        sum += item;
        }
        return sum;
    }
    public void displayMenu(ArrayList<String> menu){
        for(int i=0;i<menu.size();i++){
            System.out.println(i+ " "+menu.get(i));
        }
        }
    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        customers.add(userName);
        System.out.println("hello "+ userName);
        System.out.println("there are "+(customers.size()-1)+ " people in front of you");
    }
    }


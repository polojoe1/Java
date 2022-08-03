public class BankAccount {
    private Double checking=0.0;
    private Double savings=0.0;
    static private int member = 0;
    // static private double allCash;
    public BankAccount(){
        member++;
    }

    public static int getMember(){
        return member;
    }
    public Double getChecking(){
        return this.checking;
    }
    public void depositChecking(Double deposit){
        
        checking =this.getChecking();
        checking+=deposit;

        System.out.println("New balance is: "+ checking);
    }
    public void withdrawChecking(Double amount){
        if(amount<checking){
            checking-= amount;
            System.out.println("New balance is: "+checking);
        }
        else{
            System.out.println("Not enough money sir/ma'am");
        }
    }
    public Double getSavings(){
        return savings;
    }
    public void depositSavings(Double deposit){
        savings+= deposit;
        System.out.println("New balance is: "+savings);
    }
    public void withdrawSavings(Double amount){
        if(amount<savings){
            savings-= amount;
            System.out.println("New balance is: "+savings);
        }
        else{
            System.out.println("Not enough money sir/ma'am");
        }
    }
    public void status(){
        System.out.println("Checking: " +this.getChecking());
        System.out.println("Savings: " +this.getSavings());
        System.out.println("Total: "+(this.getChecking()+this.getSavings()));


    }
}

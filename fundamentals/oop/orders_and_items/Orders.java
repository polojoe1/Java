import java.util.ArrayList;

public class Orders {
    private String name;
    private double total;
    private boolean ready= false;
    private ArrayList<Items> items = new ArrayList<Items>();
    public Orders(String name){
        this.name = name;
    }
    public Orders(){
        this.name = "Another";
    }

//Getters & Setters

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }
    public double getTotal(){
        return total;
    }
    public void setTotal(double total){
        this.total=total;
    }
    public boolean getReady(){
        return ready;
    }
    public void setReady(boolean ready){
        this.ready=ready;
    }
    public ArrayList<Items> getItems(){
        return items;
    }
    public void addItems(Items items){
        getItems().add(items);
        this.total += items.getPrice();
    }

    public String getStatus(boolean ready){
        if(ready){
            return "Your order is ready";
        }
        else{
            return "Not ready yet";
        }
    }
    public void display(){
        System.out.println("Customer name: "+ this.getName());
        for(Items i : this.getItems()){
            System.out.println(i.getName() +": "+ i.getPrice());
        }
        System.out.println("Total: "+this.getTotal());
        
    }
}
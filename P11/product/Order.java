package product;

import java.util.ArrayList;

import person.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Order {
    public Order(Customer cust) {
        this.customer=cust;
        this.servings = new ArrayList<>();
    }
    
    public Order(BufferedReader br) throws IOException {
        this.servings = new ArrayList<>();
        int numServings = Integer.parseInt(br.readLine());
        while(numServings-- > 0) servings.add(new Serving(br));
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + servings.size() + '\n');
        for(Serving s : servings) s.save(bw);
    }

    public int price(){
        int price=0;
        Serving temp;
            int get;
            for(int x=0;x<servings.size();x++){
                temp=servings.get(x);
                get=temp.price();
                price=price+get;
            }
        return price;
    }

    public void addServing(Serving serving) {
        servings.add(serving);
    }

    public Customer getCustomer(){
        return this.customer;
        
    }
    public Object[] servings(){
        return this.servings.toArray();
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String separator = "";
        result.append(customer+separator);
        if(servings.size() > 0) {
            for(Serving s : servings) {
                result.append(separator + s.toString());
                separator = "<br/>";
            }
        }
        result.append("<br/>"+"Price: "+""+price());
        return result.toString();
    }
    private ArrayList<Serving> servings;
    private Customer customer;
}
package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order {
    private ArrayList<Serving> servings;

    public Order(){
        this.servings=new ArrayList<>();
    }
    
    public Order(BufferedReader br)throws IOException{
        this.servings=new ArrayList<>();
        int numServing = Integer.parseInt(br.readLine());
        while(numServing-- > 0) servings.add(new Serving(br));
    }

    public void save(BufferedWriter bw) throws IOException {
        
        bw.write("" + servings.size() + '\n');
        for(Serving mi : servings) mi.save(bw);
    }

    public void addServing(Serving serving){
        servings.add(serving);
    }
    @Override
    public String toString(){
        String ret="";
        for(Serving mi:servings){
            ret += mi+"\n";
        }
        return ret;
    }
    
}

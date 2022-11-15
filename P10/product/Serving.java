package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Serving{
    private Container container;
    private ArrayList<Scoop> scoop;
    private ArrayList<MixIn>topping;
    

    public Serving(Container container)throws IOException {
        this.container=container;
        this.scoop=new ArrayList<>();
        this.topping= new ArrayList<>();
        
    }
    
    public Serving(BufferedReader br) throws IOException {
        this.container = new Container(br);
        this.scoop = new ArrayList<>();
        this.topping= new ArrayList<>();

        int numOfScope = Integer.parseInt(br.readLine());
        int i;
        
        for(i=0;i<numOfScope;i++){
            scoop.add(new Scoop(br));
        }

        int numOfToppings=Integer.parseInt(br.readLine());

        for(i=0;i<numOfToppings;i++){
            topping.add(new MixIn(br));
        }
    }
    
    public void save(BufferedWriter bw) throws IOException {
        container.save(bw);
        bw.write("" + scoop.size() + '\n');
        for(Scoop sp : scoop) sp.save(bw);

        bw.write("" + topping.size() + '\n');
        for(MixIn tp : topping) tp.save(bw);
    }

    public void addScoop(Scoop nscoop){
        this.scoop.add(nscoop);
    }

    public void addTopping(MixIn ntopping){
        this.topping.add(ntopping);
    }

    @Override
    public String toString(){
        String para = "" + container;

        int scoopSize = scoop.size();
        if(scoop.isEmpty())
        {
            para += " does not have any scoops";
        }
        else if(scoopSize==1)
        {
            para += " with a scoop of ";
        }
        else if(scoopSize>1)
        {
            para += " with scoops of ";
            
        }

        for(Scoop s : scoop)
        {
            para += ", " + s;
        }
        
        if(!topping.isEmpty())
        {
            para += "and topped with ";
            for(MixIn t : topping)
            {
                para += " " + t;
            }
        }
        return para;
    }

}

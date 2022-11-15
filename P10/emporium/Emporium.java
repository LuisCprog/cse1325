package emporium;


import product.Container;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Order;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Emporium {
    public Emporium() { }
    //save and read containers and order
    public Emporium(BufferedReader br) throws IOException { 
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) mixInFlavors.add(new MixInFlavor(br));

        size = Integer.parseInt(br.readLine());
        while(size-- > 0) iceCreamFlavors.add(new IceCreamFlavor(br));
        //change to constructor
        size = Integer.parseInt(br.readLine());
        while(size-- > 0) containers.add(new Container(br));

        size = Integer.parseInt(br.readLine());
        while(size-- > 0) orders.add(new Order (br));
    }    
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + mixInFlavors.size() + '\n');
        for(MixInFlavor mif : mixInFlavors) mif.save(bw);

        bw.write("" + iceCreamFlavors.size() + '\n');
        for(IceCreamFlavor icf : iceCreamFlavors) icf.save(bw);
        //change to save method
        bw.write("" + containers.size() + '\n');
        for(Container Con : containers) Con.save(bw);

        bw.write("" + orders.size() + '\n');
        for(Order Ord : orders) Ord.save(bw);

    }
    //Setters
    public void addMixInFlavor(MixInFlavor flavor) {
        mixInFlavors.add(flavor);
    }
    public void addIceCreamFlavor(IceCreamFlavor flavor) {
        iceCreamFlavors.add(flavor);
    }
    public void addContiner(Container container){
        containers.add(container);
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    //Getters
    public Object[] iceCreamFlavors() {
        return this.iceCreamFlavors.toArray();
    }
    public Object[] mixInFlavors() {
        return this.mixInFlavors.toArray();
    }
    public Object[] containers(){
        return this.containers.toArray();
    }
    public Object[] orders(){
        return this.orders.toArray();
    }

    private ArrayList<MixInFlavor> mixInFlavors = new ArrayList<>();
    private ArrayList<IceCreamFlavor> iceCreamFlavors = new ArrayList<>();
    private ArrayList<Container> containers=new ArrayList<>();
    private ArrayList<Order> orders=new ArrayList<>();
}

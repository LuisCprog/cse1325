package emporium;

import product.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Emporium {
    public Emporium(){

    }
    public Emporium(BufferedReader br)throws IOException{
        int Run= Integer.parseInt(br.readLine());
        for(int i=0;i<Run;i++){
            MixInFlavor MixC=new MixInFlavor(br);
            addMixInFlavor(MixC);
        }
        int Run2= Integer.parseInt(br.readLine());
        for(int i=0;i<Run2;i++){
            IceCreamFlavor ICEfC=new IceCreamFlavor(br);
            addIceCreamFlavor(ICEfC);
        }
        int Run3=Integer.parseInt(br.readLine());
        for(int i=0;i<Run3;i++){
           Scoop ScoopC=new Scoop(br);
           addScoop(ScoopC);
        }
    }

    public void addMixInFlavor(MixInFlavor flavor) {
        mixInFlavors.add(flavor);
    }
    public void addIceCreamFlavor(IceCreamFlavor flavor) {
        iceCreamFlavors.add(flavor);
    }
    public void addScoop(Scoop scoop) {
        scoops.add(scoop);
    }
    public Object[] iceCreamFlavors() {
        return this.iceCreamFlavors.toArray();
    }
    public Object[] mixInFlavors() {
        return this.mixInFlavors.toArray();
    }
    public Object[] scoops() {
        return this.scoops.toArray();
    }

    public void save(BufferedWriter out)throws IOException{
        out.write(""+mixInFlavors.size()+'\n');
        for(int i=0;i<mixInFlavors.size();i++){
            mixInFlavors.get(i).save(out);
           }
        out.write(""+iceCreamFlavors.size()+'\n');
        for(int i=0;i<iceCreamFlavors.size();i++){
        iceCreamFlavors.get(i).save(out);
       }
       out.write(""+scoops.size()+'\n');
       for(int i=0;i<scoops.size();i++){
        scoops.get(i).save(out);
       }
    }

    private ArrayList<MixInFlavor> mixInFlavors = new ArrayList<>();
    private ArrayList<IceCreamFlavor> iceCreamFlavors = new ArrayList<>();
    private ArrayList<Scoop> scoops = new ArrayList<>();
}

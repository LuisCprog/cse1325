package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Scoop {
    public Scoop(IceCreamFlavor flavor) {
        this.flavor = flavor;
        this.mixins = new ArrayList<>();
    }
    public Scoop(BufferedReader in)throws IOException{
        this.mixins = new ArrayList<>();
        IceCreamFlavor NewFlavC=new IceCreamFlavor(in);
        this.flavor=NewFlavC;
        int Run=Integer.parseInt(in.readLine());
        for(int i=0;i<Run;i++){
            MixIn MixInC=new MixIn(in);
            addMixIn(MixInC);
        }
    }
    public void addMixIn(MixIn mixin) {
        mixins.add(mixin);
    }
    public void save(BufferedWriter out)throws IOException{
        flavor.save(out);
        out.write(""+mixins.size()+'\n');
        for(int i=0;i<mixins.size();i++){
            mixins.get(i).save(out);
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(flavor.toString());
        if(mixins.size() > 0) {
            String separator = " with ";
            for(MixIn m : mixins) {
                result.append(separator + m.toString());
                separator = ", ";
            }
        }
        return result.toString();
    }
    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixins;
}

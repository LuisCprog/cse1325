package product;
import java.util.ArrayList;
public class Scoop {
    private IceCreamFlavor flavor;
    private ArrayList <MixIn> mixins;
    

    public Scoop(IceCreamFlavor flavor){
        this.flavor=flavor;
        this.mixins=new ArrayList<>();
    }

    public void addMixIn(MixIn mixin){
        mixins.add(mixin);
    }

    //cited source code
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
    //Rice, G(2022) Scopp.java source code(version 1.0) [source code]https://github.com/prof-rice/cse1325-prof/blob/main/P05/Scoop.java
    
}

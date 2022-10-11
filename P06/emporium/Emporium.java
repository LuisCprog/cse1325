package emporium;
import product.*;
import java.util.ArrayList;
import java.util.*;

public class Emporium {
    private ArrayList<IceCreamFlavor> iceCreamFlavors=new ArrayList<>();
    private ArrayList<MixInFlavor> MixInFlavors=new ArrayList<>();
    private ArrayList<Scoop> scoops=new ArrayList<>();

    public void addMixInFlavor(MixInFlavor mFlavor){
        MixInFlavors.add(mFlavor);

    }

    public void addiceCreamFlavors(IceCreamFlavor flavor){
        iceCreamFlavors.add(flavor);
    }

    public void addScoop(Scoop scoop){
        scoops.add(scoop);
    }

    public Object mixInFlavors(){
        return MixInFlavors.toArray();
    }

    public Object iceCreamFlavors(){
        return (iceCreamFlavors.toArray());
    }

    public Object scoops(){
        return scoops.toArray();

    }
    
}

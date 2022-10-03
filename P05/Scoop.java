import java.util.ArrayList;
public class Scoop {
    private IceCreamFlavor flavor;
    private ArrayList <MixIn> mixins=new ArrayList<>();
    int i=0;

    public Scoop(IceCreamFlavor flavor){
        this.flavor=flavor;
    }

    void addMixIn(MixIn mixin){
        mixins.add(mixin);
    }
    @Override
    public String toString(){
        if(mixins.isEmpty()){
            return flavor+""+"(no mixins added)";
        }
        return flavor+""+" whith "+mixins+"";
    }
    
}

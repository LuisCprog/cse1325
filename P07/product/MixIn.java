package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MixIn {
    public MixIn(BufferedReader in)throws IOException{
    MixInFlavor MixFlavC=new MixInFlavor(in);
    this.flavor=MixFlavC; 
    String check=(in.readLine());
    if(MixInAmount.Extra.toString().equals(check)){
        this.amount=MixInAmount.Extra;
    }
    if(MixInAmount.Light.toString().equals(check)){
        this.amount=MixInAmount.Light;
    }
    if(MixInAmount.Normal.toString().equals(check)){
        this.amount=MixInAmount.Normal;
    }
    if(MixInAmount.Drenched.toString().equals(check)){
        this.amount=MixInAmount.Drenched;
    }
    
    }
    public MixIn(MixInFlavor flavor, MixInAmount amount) {
        this.flavor = flavor;
        this.amount = amount;
    }
    @Override
    public String toString() {
//        return flavor.toString() + ((amount != MixInAmount.Normal)
        return flavor.toString() + (!amount.equals(MixInAmount.Normal)
                                 ? " (" + amount + ")"
                                 : "");
    }
    public void save(BufferedWriter out)throws IOException{
        flavor.save(out);
        out.write(amount.toString());
    }
    private MixInFlavor flavor;
    private MixInAmount amount;
}
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class TestScoop {
    public static void main(String args[]){
        ArrayList<IceCreamFlavor> flavors=new ArrayList<>();
        ArrayList<MixInFlavor> mixins=new ArrayList<>();
        ArrayList<Scoop> scoops=new ArrayList<>();
        Scanner obj=new Scanner(System.in);
        Scanner info=new Scanner(System.in);
        Scanner info1=new Scanner(System.in);
        int i=0;


        while(i==0){
            System.out.printf("\n===============\nMICE TESTER v0.1\n===============\n");
            System.out.println("Creat (m)ixin, (i)ce cream flavor, (s)coop, or (q)uit?");
            String in=obj.next();
            if(in.equals("q"))
                i++;

            if(in.equals("m")){
                System.out.printf("\ncreating new MixIn Flavor\n");
                System.out.print("Name?");
                String nameM =info1.nextLine();
                System.out.print("Description?");
                String description =info1.nextLine();
                System.out.print("price?");
                int price =info1.nextInt();
                System.out.print("Cost?");
                int cost= info1.nextInt();

                MixInFlavor newF=new MixInFlavor(nameM, description, cost, price);
                mixins.add(newF);
            }

            if(in.equals("i")){
                System.out.printf("\ncreating new Icecream Flavor\n");
                System.out.print("Name?");
                String name =info.nextLine();
                System.out.print("Description?");
                String description =info.nextLine();
                System.out.print("price?");
                int price =info.nextInt();
                System.out.print("Cost?");
                int cost= info.nextInt();

                IceCreamFlavor ice=new IceCreamFlavor(name, description, cost, price);
                flavors.add(ice);
                
            }
            if(in.equals("s")){
                
                Scanner pick=new Scanner(System.in);

                System.out.printf("\nCreating a scoop of ice cream!\n:");
                for(int z=0;z<flavors.size();z++){
                    System.out.printf("\n %d) %s",z,flavors.get(z)); 
                }
                System.out.print("\nFlavor?");
                int fpick=pick.nextInt();
                Scoop nScoop=new Scoop(flavors.get(fpick));
                
                for(int z=0;z<mixins.size();z++){
                    System.out.println(z+") "+mixins.get(z)+"");
                }
                System.out.println("\nMixin?");
                int Mpick=pick.nextInt();

                System.out.printf("\n0) Light\n1) Normal\n2) Extra\n3) Drenched");
                System.out.println("\nAmount?");
                int Apick=pick.nextInt();

                if(Apick==0){
                    MixInAmount Ltype=MixInAmount.Light;
                    MixIn LMake=new MixIn(mixins.get(Mpick), Ltype);
                    nScoop.addMixIn(LMake);
                }
                if(Apick==1){
                    MixInAmount Ntype=MixInAmount.Normal;
                    MixIn NMake=new MixIn(mixins.get(Mpick), Ntype);
                    nScoop.addMixIn(NMake);
                }
                if(Apick==2){
                    MixInAmount Etype=MixInAmount.Extra;
                    MixIn EMake=new MixIn(mixins.get(Mpick), Etype);
                    nScoop.addMixIn(EMake);
                }
                if(Apick==3){
                    MixInAmount Dtype=MixInAmount.Drenched;
                    MixIn DMake =new MixIn(mixins.get(Mpick), Dtype);
                    nScoop.addMixIn(DMake);
                }
                    int loop=0;
                    while (loop==0){
                        for(int z=0;z<mixins.size();z++){
                            System.out.printf("\n %d) %s",z,mixins.get(z));    
                        }
                        System.out.println("\nAnother mix in?");
                        Mpick=pick.nextInt();
                         if(Mpick<0 || Mpick>3){
                            scoops.add(nScoop);
                            break;
                        }

                        System.out.printf("0) Light\n1) Normal\n2) Extra\n3) Drenched");
                        System.out.println("\nAmount?");
                        Apick=pick.nextInt();
                        if(Apick==0){
                            MixInAmount Ltype=MixInAmount.Light;
                            MixIn LMake=new MixIn(mixins.get(Mpick), Ltype);
                            nScoop.addMixIn(LMake);
                           
                        }
                        else if(Apick==1){
                            MixInAmount Ntype=MixInAmount.Normal;
                            MixIn NMake=new MixIn(mixins.get(Mpick), Ntype);
                            nScoop.addMixIn(NMake);
                            
                        }
                        else if(Apick==2){
                            MixInAmount Etype=MixInAmount.Extra;
                            MixIn EMake=new MixIn(mixins.get(Mpick), Etype);
                            nScoop.addMixIn(EMake);
                            
                        }
                        else if(Apick==3){
                            MixInAmount Dtype=MixInAmount.Drenched;
                            MixIn DMake =new MixIn(mixins.get(Mpick), Dtype);
                            nScoop.addMixIn(DMake);
                            
                        }
                    }
                    System.out.println("adding"+nScoop.toString());
                }
            } 
            System.out.println("List of Ice Cream scoops:\n"+scoops);
        }
    }


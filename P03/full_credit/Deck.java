
import java.util.Stack;
import java.util.*;

public class Deck {
    private Stack deck=new Stack<>();
    
    public Deck(){
        for(int S=0;S<3;S++){
            for (int R=0;R<10;R++){
                Card Cards=new Card(R,S);
                deck.push(Cards.toString());
                }
            }
            shuffle(deck);
            
    }
    
    public void shuffle(Stack deck){
        Collections.shuffle(deck);
    }
    // still have to do the exception and then can turin in :) 
    public String deal(){
        String top;

        if(isempty()==true){
            try{
                deck.pop();
            }
            catch(Exception e){
                System.out.println("No more in the cards in deck");
                System.exit(-1);
            }
        }
        top=deck.peek()+"";
        deck.pop();
        return top;
    }

    public boolean isempty(){
        boolean ret=true;
        if(deck.empty()){
            return ret;
        }
        ret=!ret;
        return ret ;
    }
}

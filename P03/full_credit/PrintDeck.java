public class PrintDeck {
        public static void main(String [] args){
            Deck one= new Deck();
            for(int x=0;x<=29;x++){
            System.out.printf(" %s ",one.deal());
            }
        }
}

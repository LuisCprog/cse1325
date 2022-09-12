

public class Card {
        private String rank;
        private String suit;

        public Card(int Rnum, int Slet ){
            this.getRank(Rnum);
            this.getSuit(Slet);
        }
        public void getRank(int Rnum){
            Rank rank1= new Rank(Rnum);
            this.rank=rank1.toString();
        }
        public void getSuit(int Slet){

            if(Slet==0){
                Suit Utype=Suit.U;
                this.suit=Utype+"";
            }
            if(Slet==1){
                Suit Ttype=Suit.T;
                this.suit=Ttype+"";
            }
            if(Slet==2){
                Suit Atype=Suit.A;
                this.suit=Atype+"";
            }
            
        }
        public String toString(){
            return rank+suit;
        }
}



public class Rank {
    private int rank;

    public static final int MIN=0;
    public static final int MAX=9;

    public Rank(int pass){
        this.setRank(pass);
    }

    public void setRank(int pass ){
        if(pass>=MIN && pass<=MAX)
            this.rank=pass;
    }
    
    public String toString(){
        return rank+"";
    }
    
}

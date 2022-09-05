public class Clock {
    private int Hours;
    private int Minutes;
    private int Seconds;

    

    public void setHours(int Hr){
        Hours =Hr;
    }

    public void setMinutes(int Min){
        Minutes=Min;
    }

    public void setSeconds(int Sec){
        Seconds=Sec;
    }
    public void rationalize(){
        if(Seconds<0){
            while(Seconds<0 ){
                Seconds+=60;
                Minutes--;
            }
        }
        if(Seconds>59){
            while(Seconds>59){
                Seconds-=60;
                Minutes++;
            }
        }
        if(Minutes<0){
            while(Minutes<0 ){
                Minutes+=60;
                Hours--;
            }
        }
        if(Minutes>59){
            while(Minutes>59){
                Minutes-=60;
                Hours++;
            }
        }
        if(Hours>23){
            while(Hours>23){
                Hours-=24;
            }
        }


    }
        

    public String toString(){
        rationalize();
        String time=twoDight(Hours, Minutes, Seconds);
        return time;
    }

    private String twoDight(int Hour, int Minute,int Second){
        String hr =Hours+"";
        String min = Minutes+"";
        String sec =Seconds+"";

        if(hr.length()==1){
            hr='0'+hr;
        }
        if(min.length()==1){
            min='0'+min;
        }
        if(sec.length()==1){
            sec='0'+sec;
        }
        
        return hr+":"+min+":"+sec ;

    }

}


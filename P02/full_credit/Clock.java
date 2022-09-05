public class Clock{
    private Integer Hours;
    private Integer Minutes;
    private Integer Seconds;

    

    public void setHours(Integer Hr){
        Hours =Hr;
    }

    public void setMinutes(Integer Min){
        Minutes=Min;
    }

    public void setSeconds(Integer Sec){
        Seconds=Sec;
    }

    public String toString(){
        String time=twoDight(Hours, Minutes, Seconds);
        return time;
    }

    private String twoDight(Integer Hour, Integer Minute,Integer Second){
        String hr =Hours.toString();
        String min = Minutes.toString();
        String sec =Seconds.toString();

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
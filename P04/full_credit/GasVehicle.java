public class GasVehicle extends Vehicle{
    static double dollarsPergallonOfgas;
    static double miles;

    private double milesPerGallon;

    private double gallonsinTank;

    public GasVehicle(int year,String make,String model,BodyStyle bodystyle, double milesPerGallon,double gallonsinTank){
        super (year,make,model,bodystyle);
        this.milesPerGallon=milesPerGallon;
        this.gallonsinTank=gallonsinTank;
    }


    public  double range(){
        return gallonsinTank*milesPerGallon;
    }

    public  double fuelConsumed(double miles){
        try{
        return miles/milesPerGallon;
        }
        catch(Exception e){
            System.out.println("No quema cuh :(");
        }
        return 0;
    }
    public double dollarsToTravel(double miles){
        return fuelConsumed(miles)*dollarsPergallonOfgas;
    }

    public String toRet(){
        String info= toString();
        return "$ "+dollarsToTravel(miles)+"  (rang "+range()+") "+info;
    }

}
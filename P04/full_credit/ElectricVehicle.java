public class ElectricVehicle extends Vehicle {
    static double centsPerKwhOfElectricity;
    static double miles;

    private double whPerMile;

    private double kwhinBattery;

    public ElectricVehicle(int year,String make,String model,BodyStyle bodystyle, double whPerMile,double kwhinBattery){
        super (year,make,model,bodystyle);
        this.whPerMile=whPerMile;
        this.kwhinBattery=kwhinBattery;
    }


    public  double range(){
        return (kwhinBattery/(whPerMile/1000));
    }
    public  double fuelConsumed(double miles){
        try{
            return miles*(whPerMile/1000);
        }
        catch(Exception e){
            System.out.println("No quema cuh :(");

        }
        return 0;
    }
    public double dollarsToTravel(double miles){
        return fuelConsumed(miles)*(centsPerKwhOfElectricity/100);
    }

    public String toRet(){
        String info= toString();
        return "$ "+dollarsToTravel(miles)+"  (rang "+range()+") "+info;
    }

    
}

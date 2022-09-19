public abstract class Vehicle {
    private int year;
    private String make;
    private String model;
    private BodyStyle bodyStyle;

    public Vehicle (int year, String make, String model, BodyStyle bodystyle){
        this.year=year;
        this.make=make;
        this.model=model;
        this.bodyStyle=bodystyle;
    }

    public abstract double range();
    public abstract double fuelConsumed(double miles);
    public abstract double dollarsToTravel(double miles);
    @Override
    public String toString(){
        return (year+" "+make+" "+model+" "+bodyStyle);
    }
}

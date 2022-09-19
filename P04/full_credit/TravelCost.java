import java.util.Scanner;
import java.util.ArrayList;

public class TravelCost {
    public static void main(String[] args){
        Scanner line=new Scanner(System.in);
        System.out.println("What is the price per gallon of gas(dollars)?");
        double Pgas= line.nextDouble();

        System.out.println("What is the price per kwh of electrictiy(cents)?");
        double Pkwh= line.nextDouble();

        System.out.println("How many miles is your trip ?");
        double miles=line.nextDouble();
        ElectricVehicle.centsPerKwhOfElectricity=Pkwh;
        ElectricVehicle.miles=miles;
        GasVehicle.dollarsPergallonOfgas=Pgas;
        GasVehicle.miles=miles;

        ArrayList Cars = new ArrayList<>();

        GasVehicle GCar;
        ElectricVehicle ECar;
        ECar=new ElectricVehicle(2022, "Telsa",    "Model S Plaid",   BodyStyle.Sedan,     297, 100  );
        Cars.add(ECar.toRet());
        ECar=new ElectricVehicle(2022, "Telsa",    "Model 3 LR",      BodyStyle.Sedan,     242,  82  );
        Cars.add(ECar.toRet());
        ECar=new ElectricVehicle(2022, "GM",       "Bolt",            BodyStyle.Hatchback, 286,  66  );
        Cars.add(ECar.toRet());
        ECar=new ElectricVehicle(2022, "Nissan",   "LEAF",            BodyStyle.Hatchback, 269,  60  );
        Cars.add(ECar.toRet());
        ECar=new ElectricVehicle(2022, "Ford",     "Mustang Mach-E",  BodyStyle.SUV,       347,  88  );
        Cars.add(ECar.toRet());
        ECar=new ElectricVehicle(2022, "Ford",     "F-150 Lightning", BodyStyle.Truck,     511, 131  );
        Cars.add(ECar.toRet());
        GCar=new GasVehicle(2022, "Ford",     "F-150",           BodyStyle.Truck,      25,  23 );
        Cars.add(GCar.toRet());
        GCar=new GasVehicle(2022, "Toyota",   "Prius Hybrid",    BodyStyle.Hatchback,  55,  11.4);
        Cars.add(GCar.toRet());
        GCar=new GasVehicle(2022, "Toyota",   "RAV4",            BodyStyle.Crossover,  31,  14.5);
        Cars.add(GCar.toRet());
        GCar=new GasVehicle(2022, "Nissan",   "Rogue",           BodyStyle.Hatchback,  33,  14.5);
        Cars.add(GCar.toRet());
        GCar=new GasVehicle(2022, "Chrysler", "Pacifica",        BodyStyle.Minivan,    24,  19);
        Cars.add(GCar.toRet());

        for (int i=0;i<Cars.size();i++)
        {
            System.out.println(Cars.get(i));
        }
        
        

    }

    
}

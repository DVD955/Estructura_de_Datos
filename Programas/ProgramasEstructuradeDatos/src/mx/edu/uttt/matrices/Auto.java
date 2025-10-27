package mx.edu.uttt.matrices;

public class Auto {

    private  String model;
    private int milesDriven;
    private double galloOfGas;

    public  Auto (){
        this.model = "Unknow";


    }

    public Auto(String model, int milesDriven, double galloOfGas) {
        this.model = model;
        this.setMilesDriven(milesDriven);;
        this.setGalloOfGas(galloOfGas);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMilesDriven() {
        return milesDriven;
    }

    public void setMilesDriven(int milesDriven) {
        if(milesDriven >=0)
        this.milesDriven = milesDriven;
        else{

            System.out.println("Miles driven be nefative");
            System.out.println("Valua to changed");


        }
    }

    public double getGalloOfGas() {
        return galloOfGas;
    }

    public void setGalloOfGas(double galloOfGas) {
        if(galloOfGas >=0.0)
        this.galloOfGas = galloOfGas;
        else{
            System.out.println("Gallos of Gas cannot be negative");
            System.out.println("Gallos of Gas not chaged");
        }
    }

    public double calculateMilePerGallo(){
        if(this.galloOfGas != 0.0){
           return  milesDriven/ galloOfGas;
        }else{
           return 0.0;
        }
    }

    @Override
    public String toString() {
        return "Auto{" +
                "model='" + model + '\'' +
                ", milesDriven=" + milesDriven +
                ", galloOfGas=" + galloOfGas +
                '}';
    }
}



package model;

public class ModelTest {
    public static void main(String[] args) {
        Model model = new ModelManager();

        /*
        // Methods to test
        public void updateTemperature(Double temperature);

        public Heater getHeater();

        public Thermometer getThermometer();

        public void increase();

        public void decrease();
         */
        System.out.println(model.getThermometer("t0").getTemperatureList());
        System.out.println(model.getThermometerList().toString());
        model.updateTemperature(46.0, "t0");
        System.out.println(model.getThermometerList().toString());
        System.out.println(model.getThermometer("t0").getTemperatureList());




    }
}

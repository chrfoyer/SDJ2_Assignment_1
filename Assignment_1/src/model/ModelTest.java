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

        model.updateTemperature(69.0); // Problem: which thermometer am I updating?
        // Suggested solution: Include thermometer in parameter or string/int


    }
}

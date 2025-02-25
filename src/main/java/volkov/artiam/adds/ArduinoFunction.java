package volkov.artiam.adds;

public class ArduinoFunction {

    static double minValue = 0.0;
    static double maxValue = 31.5;
    static double step = 0.5;

    public static void main(String[] args) {

        /**/
        double currentValue = minValue;
        for(int i = 0; i <= (maxValue/step);i++){
            System.out.print(i + " step = ");
            System.out.println(currentValue);
            currentValue += step;

        }
        /**/

        getSPIcommandByAttValue(9.5);
        getSPIcommandByAttValue(0.0);

        getSPIcommandByAttValue(31.2);
        getSPIcommandByAttValue(31.5);
        getSPIcommandByAttValue(31.2);

    }

    public static void getSPIcommandByAttValue(double attValue){
        System.out.println( (int) (attValue/step) );

    }

}

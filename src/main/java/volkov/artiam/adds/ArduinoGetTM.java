package volkov.artiam.adds;

import volkov.artiam.datas.DATAS;

public class ArduinoGetTM {

    static String data = "yyyyTM_ATT;63;xxx";

    // static String data = "yyyyTM_ATT;cc;xxx";
    static String tmPrefix = DATAS.TM_ATT.toString();
    static String substring = "";


    public static void main(String[] args) {

        substring = data.substring(data.indexOf(tmPrefix) + tmPrefix.length());
        substring = substring.substring(0, substring.indexOf(";"));
        System.out.println(substring);

        double value = 0.0;
        try {
            value = Double.parseDouble(substring) * 0.5;
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        System.out.println(value);



    }


}

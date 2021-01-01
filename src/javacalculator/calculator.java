package javacalculator;

import static java.lang.Math.log10;
import static java.lang.Math.pow;
import static java.lang.Double.NaN;

public class calculator {



    public enum Bioperatormodes {
        normal,add,minus,multiply,divide,xpowerofy
    }

    public enum Monooperators{
        square,squareroot,onedividedby,cos,sin,tan,log,rate,abs
    }

    private Double num1,num2;
    private Bioperatormodes mode;

    {
        mode = Bioperatormodes.normal;
    }

    private Double calculateBi(){
        if (mode == Bioperatormodes.normal){
            return num2;
        }
        if (mode == Bioperatormodes.add){
            if (num2 != 0){
                return num1 + num2;
            }
            return num1;
        }
        if (mode == Bioperatormodes.minus){
            return num1 - num2;
        }

        if (mode == Bioperatormodes.multiply){
            return num1 * num2;
        }

        if (mode == Bioperatormodes.divide){
            return num1 / num2;
        }

        if (mode == Bioperatormodes.xpowerofy){
            return pow(num1,num2);
        }

        throw new Error("error");
    }
    
    public Double calculateBi(Bioperatormodes newmode, Double num){
        if(mode == Bioperatormodes.normal){
            num2 = 0.0;
            num1 = num;
            mode = newmode;
            return NaN;
        }else{
            num2 = num;
            num1 = calculateBi();
            mode = newmode;
            return num1;
        }
    }

    public Double calculateEqual(Double num){
        return calculateBi(Bioperatormodes.normal,num);
    }

    public Double reset(){
        num1 = 0.0;
        num2 = 0.0;
        mode = Bioperatormodes.normal;

        return NaN;
    }

    public Double calculateMono(Monooperators newMode, Double num) {
        if (newMode == Monooperators.square) {
            return num * num;

        }
        if (newMode == Monooperators.onedividedby) {
            return 1 / num;
        }

        if (newMode == Monooperators.squareroot) {
            return Math.sqrt(num);
        }

        if (newMode == Monooperators.cos) {
            return Math.cos(Math.toRadians(num));
        }

        if (newMode == Monooperators.sin) {
            return Math.sin(Math.toRadians(num));
        }

        if (newMode == Monooperators.tan) {
            if (num == 0 || num % 180 == 0) {
                return 0.0;
            }
            if (num % 90 == 0 && num % 180 != 0) {
                return NaN;
            }

            return Math.tan(Math.toRadians(num));
        }

        if (newMode == Monooperators.log){
            return log10(num);
        }

        if (newMode == Monooperators.rate) {
            return num / 100;
        }
        if (newMode == Monooperators.abs){
            return Math.abs(num);
        }

        throw new Error();
    }

}

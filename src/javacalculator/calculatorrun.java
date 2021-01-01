package javacalculator;

public class calculatorrun {

    public static void main (String args[]){
        try{
            UI uical = new UI();
            uical.init();
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

import java.lang.*;
public class StrictMathRandom {
    public static void main(String[]args){
        double random_num = StrictMath.random();
        System.out.println("Generated random number:"+random_num);
        random_num = StrictMath.random();
        System.out.println("Generated random number:"+random_num);
    }
}

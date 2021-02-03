// Author: John Palmer

public class test_n {
    public static void main(String[] args){
        fibonacci myFib = new fibonacci();

        for (int a = 0; a <= 10; a++){
            System.out.format("%d: ", a*50);
            System.out.println(myFib.fibonacci_linear(a*50));
        }
    }
}
// Author: John Palmer

public class test_expo {
    public static void main(String[] args){
        fibonacci myFib = new fibonacci();
        
        for (int a = 0; a <= 10; a++){
            System.out.format("%d: ", a*5);
            System.out.println(myFib.fibonacci_expo(a*5));
        }
    }

}

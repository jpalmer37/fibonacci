// Author: John Palmer
// Student ID: 250804907

// Question 7b)
public class test_b {
    public static void main(String[] args){
        fibonacci myFib = new fibonacci();

        for (int a = 0; a <= 10; a++){
            System.out.format("%d: ", a*5);
            System.out.println(myFib.fibonacci_linear(a*5));
        }
    }
}
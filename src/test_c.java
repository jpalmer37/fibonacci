// Author: John Palmer
// Student ID: 250804907

// Question 7c)
public class test_c {
    public static void main(String[] args){
        fibonacci myFib = new fibonacci();

        for (int a = 0; a <= 10; a++){
            System.out.format("%d: ", a*5);
            System.out.println(myFib.fibonacci_logn(a*5));
        }
        
    }
}
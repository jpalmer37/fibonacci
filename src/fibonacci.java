// Author: John Palmer


public class fibonacci{

    // A function to compute matrix multiplication on two BigInt matrices
    public BigInt[][] matrixMult(BigInt[][] mat1, BigInt[][] mat2){
        
        // Initialize the new matrix 
        BigInt[][] newMat = new BigInt[mat1.length][mat2[0].length];

        // For every row in matrix 1
        for (int i = 0; i < mat1.length; i++){

            // For every column in matrix 2 
            for (int j = 0; j < mat2[0].length; j++){
                BigInt toAdd = new BigInt("0");

                // Compute the sum of the matrix products 
                for (int k = 0; k < mat1[0].length; k++){
                    toAdd = toAdd.add(mat1[i][k].mult(mat2[k][j]));
                }
                // Load the final value into the matrix 
                newMat[i][j] = toAdd;
            }
        }
        return newMat;
    }

    // Algorithm to compute nth Fibonacci number in O(2^n)
    public long fibonacci_expo(long n){
        // If n is 1 or 0, simply return n 
        if (n <= 1){
            return n;
        }
        
        // Make two recursive calls to compute the nth Fibonacci number
        return fibonacci_expo(n-1) + fibonacci_expo(n-2);
    }

    // Algorithm to compute nth Fibonacci number in O(n)
    public BigInt[] fib_linear_nomatrix(int n){
        BigInt zero = new BigInt("0");
        BigInt one = new BigInt("1");

        //  G(0) case
        if (n == 0 ){
            BigInt[] res = {zero,zero};
            return res;
        }
        // G(1) case
        if (n == 1){
            BigInt[] res = {one,zero};
            return res;
        }  

        
        // Create the G(n) matrix used to add two previous Fibonacci numbers
        BigInt[] values = fib_linear_nomatrix(n-1);
        BigInt[] result = {values[0].add(values[1]), values[0]};
        return result;
    }

    // Algorithm to compute nth Fibonacci number in O(n)
    public BigInt[][] fib_linear(int n){
        BigInt zero = new BigInt("0");
        BigInt one = new BigInt("1");

        //  G(0) case
        if (n == 0 ){
            BigInt[][] res = {{zero},{zero}};
            return res;
        }
        // G(1) case
        if (n == 1){
            BigInt[][] res = {{one},{zero}};
            return res;
        }  

        // Create the G(n) matrix used to add two previous Fibonacci numbers
        BigInt[][] mat = {{one,one},{one,zero}};

        // Compute the new G(n) column vector using the G(n-1) column vector
        BigInt[][] result = matrixMult(mat, fib_linear(n-1));
        return result;
    }

    // Wrapper function for "fib_linear" to return the single BigInt output value 
    public BigInt fibonacci_linear(int n){
        BigInt[][] result = fib_linear(n);
        
        return result[0][0];
    }

    // Algorithm to compute nth Fibonacci number in O(logn)
    public BigInt[][] fib_logn(BigInt[][] matrix, int n){
        BigInt zero = new BigInt("0");
        BigInt one = new BigInt("1");
        
        if (n == 0){
            BigInt[][] res = {{one,zero},{zero,one}};   // Identity matrix 
            return res;
        }else if (n % 2 == 0){      // Even number 
            BigInt[][] res = fib_logn(matrix, n/2);
            return matrixMult(res, res);
        }else{                      // Odd number
            return matrixMult(matrix, fib_logn(matrix, n-1));
        }
    }

    // Wrapper function for "fib_logn" to return the single BigInt output value 
    public BigInt fibonacci_logn(int n){
        BigInt zero = new BigInt("0");
        BigInt one = new BigInt("1"); 
        if (n == 0){
            return zero;
        }

        BigInt[][] start = {{one,one},{one,zero}};
        BigInt[][] result = fib_logn(start, n-1);
          
        return result[0][0];
    }
}
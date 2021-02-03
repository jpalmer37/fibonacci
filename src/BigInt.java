// Author: John Palmer

public class BigInt {

    private String number; 

    public BigInt(String n){
        number = n;
    }
    public BigInt(int n){
        number = Integer.toString(n);
    }

    public int length(){
        return number.length();
    }

    // For printing the number
    public String toString(){
        return number;
    }

    public BigInt add(BigInt otherNumber){
        String num1 = number;
        String num2 = otherNumber.toString();

        int len = num1.length();
        int diff; 
        
        // Pad the shorter number with zeros
        if (num2.length() < num1.length()){
            diff = num1.length() - num2.length();
            
            for(int i = 0; i < diff; i++){
                num2 = "0" + num2;
            }

        }else if(num2.length() > num1.length()){
            diff = num2.length() - num1.length();
            len = num2.length();

            for(int i = 0; i < diff; i++){
                num1 = "0" + num1;
            }
        }
        
        String newNum = "";
        int pass = 0;
        int val1;
        int val2; 
        int res; 

        // ELEMENTARY ADDITION 
        for (int i = len-1; i >= 0; i-- ){

            val1 = Character.getNumericValue(num1.charAt(i));
            val2 = Character.getNumericValue(num2.charAt(i));
            
            // Compute result
            res = val1 + val2 + pass;

            // Append new digit to number
            newNum = (char)((res % 10) + '0') + newNum;  
            
            // Compute whether there is a "1" to pass
            pass = 0;
            pass = res  / 10;
            
            // Catch a "1" in the last position
            if (i == 0 && pass != 0){
                newNum = (char)(pass + '0') + newNum;
            }
        }

        // REMOVES EXTRA ZEROS AT THE FRONT OF THE NUMBER
        while (newNum.length() > 0 && newNum.charAt(0) == '0'){
            newNum = newNum.replaceFirst("^0", "");  // DELETING THE FIRST ZERO
        }

        BigInt result = new BigInt(newNum);
        return result;
    }

    public BigInt mult(BigInt otherNumber){
        String num1 = number;
        String num2 = otherNumber.toString();

        int len = length();
        int diff = 0; 
        
        // Pad the shorter number with zeros
        if (num2.length() < num1.length()){
            diff = num1.length() - num2.length();
            
            for(int i = 0; i < diff; i++){
                num2 = "0" + num2;
            }

        }else if(num2.length() > num1.length()){
            diff = num2.length() - num1.length();
            len = num2.length();

            for(int i = 0; i < diff; i++){
                num1 = "0" + num1;
            }
        }
        
        String newNum = "";
        long pass = 0;
        int val1;
        int val2; 
        BigInt[] results = new BigInt[len];    // Array to hold the multiplication results
        long res; 
        int inv_i;

        // ELEMENTARY MULTIPLICATION 
        for (int i = len-1; i >= 0; i-- ){

            val1 = Character.getNumericValue(num1.charAt(i));
            
            pass = 0;    // Records the number to be passed to the next column
            newNum = "";

            for(int j = len-1; j >= 0; j--){
                val2 = Character.getNumericValue(num2.charAt(j));
                
                res = val1 * val2 + pass;     

                newNum = (char)((res % 10) + '0') + newNum;    

                pass = res  / 10;

                if (j == 0 && pass != 0){
                    newNum = (char)(pass + '0') + newNum;
                }
            }
            
            // Add necessary zeros to the end of the number
            inv_i = len-1-i;
            for (int k = 0; k < inv_i; k++){
                newNum =  newNum + "0";
            }

            // Load this number into the array
            results[inv_i] = new BigInt(newNum);
        }

        // Calculate the summation of all numbers in the array
        BigInt sum = new BigInt(0);
        if (results.length > 0){
            sum = results[0];
            for (int x = 1; x < len; x++){
                sum = sum.add(results[x]);
            }
        }
        
        return sum;
    }
}

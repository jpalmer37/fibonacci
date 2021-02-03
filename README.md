# Fibonacci Algorithms

This small project involves the design of Fibonacci calculation algorithms for the purpose of comparing and studying different time complexities. 
For brief context, Fibonacci numbers are defined by added the previous two numbers in the sequence to get the next one (i.e. F(n-1) + F(n-2) = F(n). 
As a result, Fibonacci numbers actually grow at a roughly exponential rate, meaning that extremely large and lengthy numbers can be reached even by the 50th or 100th value in the sequence.  
Take for example, the fact that the 50th number is 11 digits long (13 billion) and the 100th number is 21 digits long (350 million trillion). 

Here, to clearly display differences in time complexity, I want to be able to compute very large Fibonacci numbers (n > 100).
A slight problem with this task is that primitive data types in Java and other languages cannot support numbers of this size. 
To address this, I created a custom Java class called 'BigInt' that can hold extremely large integer values (i.e. hundreds of digits long) by storing them as string objects.
I also implement standard addition and multiplication functions within this class so that necessary calculations can be performed in the Fibonacci algorithms.  

- fibonacci_expo: 
    - This is the most intuitive, but most inefficient method of calculating Fibonacci numbers, utilizing two recursive calls to F(n-1) and F(n-2). 
- fibonacci_linear
    - This algorithm uses recursive matrix multiplication to compute the F(n) term and save the F(n) and F(n-1) values in a vector. N matrix multiplication steps are needed, making this O(n).
- fibonacci_logn
    - This utilizes Pinto's algorithm to compute the nth Fibonacci number in O(logn) time. Briefly, this involves dividing even matrix powers by two and squaring the result to reduce the number of recursive calls to approximate log(n).  
- fibonacci_linear_nomatrix
    - This algorithm simplifies the linear algorithm to return an array of size 2, so that matrix multiplication is not needed. While this is certainly the more intuitive approach, I opted to leave matrix multiplication in the standard linear algorithm for the sake of comparison, (i.e. in order to keep the fundamental addition operations constant between the `fibonacci_linear` and `fibonacci_logn` algorithms). My matrix multiplication algorithm is rather inefficient, so this algorithm can often beat `fibonacci_logn` despite having O(n) complexity. 
    
![Text?](https://github.com/jpalmer37/fibonacci/blob/main/testing-table.png?raw=true)

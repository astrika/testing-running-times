//************************************************************
// Astrid Manuel
// 3354122
// COP3337
// Section U04
// Final Assignment
// December 1, 2016
// 
// I hereby certify that this collective work is my own 
// and none of it is the work of any other person or entity
//
//
//
//************************************************************ 

/**
*                 Fast Recursive Fib
*	The purpose of this class is to provide a fast recursive  
*   method for computing the Fibonacci number sequence. This class is 
*	tested in FibTester class along with StopWatch, RecursiveFib and 
*	LoopFib	classes, which are also tested. The tester class will display
*	the implementation of the getFastRecursiveFib method in an output file as 
*	a roughly square table labeled "Fast Recursive Fib Table".
*
*	Solves COP3337 Final Assignment
*
*	To compile and test:
*	javac LoopFib.java
*	javac FastRecursiveFib.java
*	javac RecursiveFib.java
*	javac StopWatch.java
*	javac FibTester.java
*	java FibTester input.txt output.txt
*
*/

public class FastRecursiveFib{

	//instance variables for FastRecursiveFib class
	
	private int MAX_NUMBER = 50;
	private long memory[] = new long[MAX_NUMBER];
	
/*
* FastRecursiveFib constructor
*/
	public FastRecursiveFib(){
		
	}

/*
* getFastRecursiveFib() method provides a fast recursive way of obtaining the Fibonacci 
* sequence The algorithm was derived from the YouTube video "Dynamic Programming with 
* memorization [Top-Down Approach]". This YouTube video is found in the following link: 
* https://www.youtube.com/watch?v=dZ0OS4YUs2A
* @param nthFib the n'th position in the Fibonacci sequence 
* @return fibNumber the value for the n'th position in Fibonacci sequence
*/	
	
	public long getFastRecursiveFib(int nthFib) {
		long fibNumber = 0;
		if(memory[nthFib] == 0){
			if(nthFib <= 2){
				memory[nthFib] = 1;
			}else{
				memory[nthFib]=(getFastRecursiveFib(nthFib-1) + getFastRecursiveFib(nthFib-2));
			}
		}
		fibNumber = memory[nthFib];
		return fibNumber;
	}
	
}

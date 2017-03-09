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
*                 Recursive Fib
*	The purpose of this class is to provide a recursive  
*   method for computing the Fibonacci number sequence. This class is 
*	tested in FibTester class along with StopWatch, FastRecursiveFib and 
*	LoopFib	classes, which are also tested. The tester class will display
*	the implementation of the getRecursiveFib method in an output file as 
*	a roughly square table labeled "Recursive Fib Table".
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

public class RecursiveFib{
	
/*
* RecursiveFib constructor
*/
	public RecursiveFib(){
		
	}
	
/*
* getRecursiveFib() method provides a recursive way of obtaining the Fibonacci sequence
* The algorithm was derived from the textbook "Big Java" by Cay Horstmann (pages 588-599).
* @param nthFib the n'th position in the Fibonacci sequence 
* @return fibNumber the value for the n'th position in Fibonacci sequence
*/
	public long getRecursiveFib(int nthFib){
		long fibNumber = 0;
		if (nthFib <= 2){
			fibNumber = 1;
			return fibNumber;
		} else{
			fibNumber = getRecursiveFib(nthFib-1) + getRecursiveFib(nthFib-2);
			return fibNumber;
		}
	}
	
}

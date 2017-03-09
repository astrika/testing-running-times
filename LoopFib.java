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
*                 Loop Fib
*	The purpose of this class is to provide an iterative 
*   method for computing the Fibonacci number sequence. This class is 
*	tested in FibTester class along with StopWatch, FastRecursiveFib and 
*	RecursiveFib classes, which are also tested. The tester class will 
*	display the implementation of the getLoopFib method in an output file 
*	as a roughly square table labeled "Loop Fib Table".
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

public class LoopFib{
	
/*
* LoopFib constructor
*/
	public LoopFib(){
		
	}

/*
* getLoopFib() method provides an iterative way of obtaining the Fibonacci sequence
* The algorithm was derived from the textbook "Big Java" by Cay Horstmann (pages 601-602).
* @param nthFib the n'th position in the Fibonacci sequence
* @return fibNumber the value for the n'th position in Fibonacci sequence
*/
	public long getLoopFib(int nthFib){
		long fibNumber = 0;
		if(nthFib <= 2){
			fibNumber = 1;
			return fibNumber;
		} else {
			long olderValue = 1;
			long oldValue = 1;
			long newValue = 1;
			for (int i = 3; i <= nthFib; i ++){
				newValue = oldValue + olderValue;
				olderValue = oldValue;
				oldValue = newValue;
			}
			fibNumber = newValue;
			return fibNumber;
		}
		
	}
}

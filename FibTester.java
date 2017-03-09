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
*                  Fib Tester
*	The purpose of this class is to test the StopWatch, RecursiveFib, 
*	FastRecursiveFib and LoopFib classes. This class has two arguments: an 
*	input file and an output file. The input file should obtain an integer within
*	a given range that will be set as the number of Fibonacci numbers that will be
*	provided by class.This tester class will display roughly square tables of the Fibonacci 
*	number sequence along with a nanosecond approximation of the elapsed time it takes to 
*	compute the sequence. This is done for a Loop Fib Table, Fast Recursive Table, and 
*	Recursive Table.
*
*	Solves COP3337 Final Assignment
*
*	To compile and run:
*	javac LoopFib.java
*	javac FastRecursiveFib.java
*	javac RecursiveFib.java
*	javac StopWatch.java
*	javac FibTester.java
*	java FibTester input.txt output.txt
*
*/

import java.io.File; //used in order to create File objects
import java.io.FileNotFoundException; //used for throwing exeptions
import java.io.PrintWriter; //used to write on output file
import java.util.Scanner; //used to scan the input file
import java.lang.Math; //used for the creation of roughly squared tables

public class FibTester{

	private	static int UPPER_LIMIT = 49;
	private static int LOWER_LIMIT = 1;
	private static PrintWriter writer;
	
	public static void main(String[] args) throws FileNotFoundException{
		int numberOfFibs = 0;
		String input = args[0];
		File inputFile = new File(input);
		Scanner fileReader = new Scanner(inputFile);
		//Exceptions
		if(fileReader.hasNext()){
			try {
				numberOfFibs = Integer.parseInt(fileReader.nextLine());
				if (numberOfFibs > UPPER_LIMIT){
					System.out.println("Integer must be a number " + LOWER_LIMIT + "-" + UPPER_LIMIT + ".");
					System.exit(1);
				} 
				if (numberOfFibs < LOWER_LIMIT){
					System.out.println("Integer must be a number " + LOWER_LIMIT + "-" + UPPER_LIMIT + ".");
					System.exit(1);
				}
			} catch(NumberFormatException e){
				System.out.println("The file must contain an integer.");
				System.exit(1);
			}
		}else{
			System.out.println("The input file is empty. Please input an integer " + LOWER_LIMIT + "-" + UPPER_LIMIT + ".");
			System.exit(1);
		}
		runTest(numberOfFibs);
	}
	
/*
* runTest method runs the test of all different methods of obtaining fibonacci numbers:
* loop, recursive, and fast recursive. It will write this test on an output file by 
* using the PrintWriter object. 
* @param numberOfFibs the desired number of fibonacci numbers given by input file 
* @throws FileNotFoundException this is an exception that is thrown if file is not found
*/	
	public static void runTest(int numberOfFibs) throws FileNotFoundException{
		writer = new PrintWriter("output.txt");
		LoopFib loopFib = new LoopFib();
		FastRecursiveFib fastRecursiveFib = new FastRecursiveFib();
		RecursiveFib recursiveFib = new RecursiveFib();
		StopWatch timer1 = new StopWatch();
		StopWatch timer2 = new StopWatch();
		StopWatch timer3 = new StopWatch();
		getLoopTable(loopFib, numberOfFibs, timer1);
		getFastRecursiveTable(fastRecursiveFib, numberOfFibs, timer2);
		getRecursiveTable(recursiveFib, numberOfFibs, timer3);
		writer.close();
	}


/*
* getLoopTable provides a table for the loop fibonacci method. In order to create a 
* roughly squared table, the square root of number of fibs is obtained and rounded to 
* nearest whole number.
* @param loopFib the loop fib object for the LoopFib class that contains getLoopFib method
* @param numberOfFibs the desired number of fibonacci numbers given by input file 
* @param timer1 the stop watch used for the loop fib method
*/	
	public static void getLoopTable(LoopFib loopFib, int numberOfFibs, StopWatch timer1){
		writer.println("Loop Fib Table:\n");
		long numberPerRow = (Math.round(Math.sqrt(numberOfFibs)));
		int numberPerRowI = (int)numberPerRow;
		timer1.start();
		for(int nthFib = 1; nthFib <= numberOfFibs; nthFib++){
			long f = loopFib.getLoopFib(nthFib);
			//12 spaces is used for proper aesthetics 
			writer.printf("%12s",f);
			if(nthFib % numberPerRowI == 0){
				writer.println();
			}
		}
		timer1.stop();
		String time = "\nElapsed time: " + timer1.getElapsedTime() + " nanoseconds\n";
		writer.println(time);
	}	

/*
* getFastRecursiveTable provides a table for the fast recursive fibonacci method. In order 
* to create a roughly squared table, the square root of number of fibs is obtained and
* rounded to nearest whole number.
* @param fastRecursiveFib the fast recursive fib object for the FastRecursiveFib class
* that contains getFastRecursiveFib method
* @param numberOfFibs the desired number of fibonacci numbers given by input file 
* @param timer2 the stop watch used for the fast recursive fib method
*/

	public static void getFastRecursiveTable(FastRecursiveFib fastRecursiveFib, int numberOfFibs, StopWatch timer2){
		writer.println("Fast Recursive Fib Table:\n");
		long numberPerRow = (Math.round(Math.sqrt(numberOfFibs)));
		int numberPerRowI = (int)numberPerRow;
		timer2.start();
		for(int nthFib = 1; nthFib <= numberOfFibs; nthFib++){
			long f = fastRecursiveFib.getFastRecursiveFib(nthFib);
			writer.printf("%12s",f);
			if(nthFib % numberPerRowI == 0){
				writer.println();
			}
		}
		timer2.stop();
		String time = "\nElapsed time: " + timer2.getElapsedTime() + " nanoseconds\n";
		writer.println(time);
	}	

/*
* getRecursiveTable provides a table for the recursive fibonacci method. In order 
* to create a roughly squared table, the square root of number of fibs is obtained and 
* rounded to nearest whole number.
* @param recursiveFib the recursive fib object for the RecursiveFib class that contains 
* getRecursiveFib method
* @param numberOfFibs the desired number of fibonacci numbers given by input file 
* @param timer3 the stop watch used for the recursive fib method
*/

		public static void getRecursiveTable(RecursiveFib recursiveFib, int numberOfFibs, StopWatch timer3){
		writer.println("Recursive Fib Table:\n");
		long numberPerRow = (Math.round(Math.sqrt(numberOfFibs)));
		int numberPerRowI = (int)numberPerRow;
		timer3.start();
		for(int nthFib = 1; nthFib <= numberOfFibs; nthFib++){
			long f = recursiveFib.getRecursiveFib(nthFib);
			writer.printf("%12s", f);
			if(nthFib % numberPerRowI == 0){
				writer.println();			 
			}						
		}
		timer3.stop();
		String time = "\nElapsed time: " + timer3.getElapsedTime() + " nanoseconds\n";
		writer.println(time);
	}

	
}

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
*                 Stop Watch
*	The purpose of this class is to provide a timing mechanism for the 
*	computation of a Fibonacci sequence (derived in 3 ways). This class is 
*	tested in FibTester class along with FastRecursiveFib, RecursiveFib and 
*	LoopFib	classes, which are also tested. The tester class will display
*	an "Elapsed time" in nanoseconds after each Fibonacci sequence computation.
* 	The algorithm for this class was derived from the textbook "Big Java" by 
*	Cay Horstmann (pages 634-635).
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

public class StopWatch{
	
	//instance variables for StopWatch class
	
	private long elapsedTime;
	private long startTime;
	private boolean isRunning;
	
/*
* StopWatch constructor
* reset() method will allow the timer to reset
*/
	public StopWatch(){
		reset();
	}
	
/*
* start method will begin the timer
* isRunning is set to true if the timer is started
* the method will return nothing if the timer is already running
*/

	public void start(){
		if(isRunning){
			return;
		}
		isRunning = true;
		//time is measured in nanoseconds
		startTime = System.nanoTime(); 
	}
/*
* stop method will stop the timer
* isRunning is set to false if the timer is stopped
* the method will return nothing if the timer is not running
*/
	public void stop(){
		if(!isRunning){
			return;
		}
		isRunning = false;
		//time is measured in nanoseconds
		long endTime = System.nanoTime();
		elapsedTime = elapsedTime + endTime - startTime;
	}
	
/*
* getElapsed method will calculate the time between the start and end of timer
* @return timeCalculated provides the amount of time elapsed
*/
	
	public long getElapsedTime(){
		long timeCalculated = 0;
		if(isRunning){
			//time is measured in nanoseconds
			long endTime = System.nanoTime();
			timeCalculated = elapsedTime + endTime - startTime;
			return timeCalculated;
		} else{
			timeCalculated = elapsedTime;
			return timeCalculated;
		}
	}

/*
* reset method will reset the timer
*/
	public void reset(){
		elapsedTime = 0;
		isRunning = false;
	}
	
}

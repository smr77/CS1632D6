
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class javaArrayTestCases
{
	
	Random randomGen;

	@Before
	public void setUp() throws Exception 
	{
		//Random Generator for the creation of arrays and array values
		 randomGen = new Random();
	}

	
	//Test method checks three properties of the random arrays generated
	//1. After Java Sort of an unsorted array, the sorted array is the same size as the original 
	//2. After Java Sort of an unsorted array, running another sort on the sorted array should not change the output   
	//3. After two Java Sorts of an unsorted array, the two resulting arrays should contain the same output
	@Test
	public void ArrayPropertyTest() 
	{
		int[] unsortedArray;			//Holds the random unsorted array
		int[] sortedArray;				//Holds the sorted array
		int[] dupSortedArray;			//Holds the duplicated sorted array for test 3
		int[] secondSortedArray; 		//Holds the array that is sorted twice
		int randomArraySize;			//holds the array size
		
		//Generated 100 random arrays and test 3 different properties on each
		for(int x = 0; x < 100; x++)
		{
			//Gets the random size of the array and creates it
			//kept the size of the array and the numbers generated in the array at 100
			randomArraySize = randomGen.nextInt(100);
			unsortedArray = new int[randomArraySize];
		
			//Fill the array
			for(int a = 0; a < unsortedArray.length; a++)
			{
				unsortedArray[a] = randomGen.nextInt(100);
			}
		
			sortedArray = new int[randomArraySize];
			System.arraycopy(unsortedArray, 0, sortedArray, 0, randomArraySize);
		
			//sort the 'sortedArray'
			Arrays.sort(sortedArray);
		
			//Test 1: the sorted array is the same size as the original 
			assertTrue("Array " + x + ": Sorted Array and Unsorted array differ in size", unsortedArray.length == sortedArray.length);
		
		
			//Test 2: Sorting the already sorted array should not change the original sorted array
			secondSortedArray = new int[randomArraySize];
			System.arraycopy(sortedArray, 0, secondSortedArray, 0, randomArraySize);
		
			//Perform a second sort on an already sorted array
			Arrays.sort(secondSortedArray);
						
			assertArrayEquals("Array " + x + ": Running sort on sorted array changed the output", sortedArray, secondSortedArray);
		
			//Test 3: two sorted arrays based off of an unsorted array contains the same output
			dupSortedArray = new int[randomArraySize];
			System.arraycopy(unsortedArray, 0, dupSortedArray, 0, randomArraySize);
			Arrays.sort(dupSortedArray);
			
			assertArrayEquals("Array " + x + ": Sorted Arrays do not match", sortedArray, dupSortedArray);
			
		}
		
	}
	
	//Not implemented
	@After
	public void tearDown() throws Exception 
	{	
	}
}


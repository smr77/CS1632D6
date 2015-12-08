
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


//This test class test Collections.sort() on integer ArrayLists
public class javaArrayListTestCases 
{

	Random randomGen;
	
	@Before
	public void setUp() throws Exception 
	{
		//Random Generator for the creation of new Array Lists
		 randomGen = new Random();
	}

	
	//Test method checks three properties of the random integer array Lists generated
	//1. After collection sort of an unsorted integer array list, the sorted array list is the same size as the original 
	//2. After collection sort of an unsorted integer array list , running another sort on the sorted array list should not change the output   
	//3. After two collection sorts of an unsorted array list, the two resulting arrays lists should contain the same output
	@Test
	public void ArrayListPropertyTest()
	{
		
		ArrayList<Integer> unsortedArrayList;			//Holds the random unsorted arrayList
		ArrayList<Integer> sortedArrayList;				//Holds the sorted arrayList
		ArrayList<Integer> dupSortedArrayList;			//Holds the duplicated sorted arrayList for test 3
		ArrayList<Integer> secondSortedArrayList; 		//Holds the arrayList that is sorted twice
		int randomArrayListSize;			//holds the array size
		
		//Generate 100 random array lists and test 3 different properties on each
		for(int x = 0; x < 100; x++)
		{
			//Gets the random size of the arraylist and creates it
			//kept the size of the arraylist and the numbers generated in the array at 100
			randomArrayListSize = randomGen.nextInt(100);
			unsortedArrayList = new ArrayList<Integer>(randomArrayListSize);
				
			//Fill the array
			for(int a = 0; a < randomArrayListSize; a++)
			{
				unsortedArrayList.add(randomGen.nextInt(100));
			}
				
			sortedArrayList = new ArrayList<Integer>(randomArrayListSize);
			
			sortedArrayList.addAll(unsortedArrayList);
			
			//sort the 'sortedArrayList'
			Collections.sort(sortedArrayList);
				
			//Test 1: the sorted array list is the same size as the original 
			assertTrue("ArrayList " + x + ": Sorted ArrayList and Unsorted arrayList differ in size", unsortedArrayList.size() == sortedArrayList.size());
			
			//Test 2: Sorting the already sorted array list should not change the original sorted array list 
			secondSortedArrayList = new ArrayList<Integer>(randomArrayListSize);
			secondSortedArrayList.addAll(sortedArrayList);
			
			//Perform a second sort on an already sorted array list
			Collections.sort(secondSortedArrayList);
									
			assertArrayEquals("ArrayList" + x + ": Running sort on sorted ArrayList changed the output", sortedArrayList.toArray(), secondSortedArrayList.toArray());
			
			//Test 3: two sorted array lists based off of an unsorted arrayList contain the same output
			dupSortedArrayList = new ArrayList<Integer>(randomArrayListSize);
			
			dupSortedArrayList.addAll(unsortedArrayList);
			
			Collections.sort(dupSortedArrayList);
			
			assertArrayEquals("Array " + x + ": Sorted Arrays do not match", sortedArrayList.toArray(), dupSortedArrayList.toArray());
		}
	}
	
	

}

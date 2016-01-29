package com.samirrk.trial;

public class SortingMain 
{
	public static int[] unsortedArr = {7, 9, 0, 1, 5, 2, 8, 3, 6, 4};
	public static int depth = 0;
	
	private static int[] numbers;
	private static int[] helper;
	  
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		showArray();
		// shellSort();
		//quickSort(unsortedArr, 0, 9);
		
		numbers = unsortedArr;
		helper = new int[10];
		mergesort(0, 9);
	}
	
	
	private static void mergesort(int low, int high) 
	{
	    System.out.println();
		depth++;
		showDepth();
		System.out.print(low + "--" + high);
	    // check if low is smaller then high, if not then the array is sorted
	    if (low < high) 
	    {
	    	System.out.print("------");
	      // Get the index of the element which is in the middle
	      int middle = low + (high - low) / 2;
	      // Sort the left side of the array
	      mergesort(low, middle);
	      // Sort the right side of the array
	      mergesort(middle + 1, high);
	      // Combine them both
	      merge(low, middle, high);
	      
	    }
	    depth--;
	  }

	  private static void merge(int low, int middle, int high) 
	  {
		System.out.print("<"+low + " " + middle + " " + high+">");
	    // Copy both parts into the helper array
	    for (int i = low; i <= high; i++) 
	    {
	      helper[i] = numbers[i];
	      System.out.print(numbers[i] + " ");
	    }
	    System.out.println();

	    int i = low;
	    int j = middle + 1;
	    int k = low;
	    // Copy the smallest values from either the left or the right side back
	    // to the original array
	    while (i <= middle && j <= high) 
	    {
	      if (helper[i] <= helper[j]) 
	      {
	        numbers[k] = helper[i];
	        i++;
	      } 
	      else 
	      {
	        numbers[k] = helper[j];
	        j++;
	      }
	      k++;
	    }
	    // Copy the rest of the left side of the array into the target array
	    while (i <= middle) 
	    {
	      numbers[k] = helper[i];
	      k++;
	      i++;
	    }

		showArray();
	  }
/*
	public static void mergeSort(int[] arr, int first, int last)
	{
		int[] tempArr;
		int mid = (first + last / 2);
		if( first < last)
		{
			mergeSort(arr,first,mid);
			mergeSort(arr,mid+1,last);
		}
		int a=0;
		int f=first;
		int b=mid+1;
		tempArr = new int[last-first+1];
		while(f<=mid && b<=last)
		{
			if(arr[f] < arr[b])
			{
				tempArr[a]=arr[f];
				f=f+1;
			}
			else
			{
				tempArr[a]=arr[b];
				b=b+1;
			}
			a=a+1;
		}
		if(f <= mid)
		{
			tempArr[a:]=arr[f:mid+1];
		}
		if(b<=last)
		{
			tempArr[a:]=arr[b:last+1]
		}
		a=0;
		while(first <= last)
		{
			arr[first]=tempArr[a];
			first=first+1;
			a=a+1;
		}
	}
*/
	
	public static void shellSort()
	{
		int d = 10;
		int temp;
		boolean flag = true;
		
		while (d > 0)
		{
			d = d/2;
			flag = true;
			while (flag)
			{
				flag = false;
				int j = 10 - d;
				for (int i=0; i < j ;i++)
				{
					if (unsortedArr[i] > unsortedArr[i+d])
					{
						temp = unsortedArr[i+d];
						unsortedArr[i+d] = unsortedArr[i];
						unsortedArr[i] = temp;
						flag = true;
					}
				}
				showArray();
			}
			System.out.println();
			showArray();
		}
	}
	
	
	public static void quickSort(int[] arr, int left, int right)
	{
		int i=left;
		int j=right;
		int temp;
		
		depth++;
		int pivot=arr[(left+right)/2];
		System.out.print("<"+pivot+"> ");
		System.out.print("---" + left + " " + right + "---");

		
		while(i <= j)
		{
			while(arr[i] < pivot)
			{
				i=i+1;
			}
			while(arr[j] > pivot)
			{
				j = j - 1;
			}
			if(i <= j)
			{
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i = i + 1;
				j = j - 1;
			}
		}
		System.out.print("----");
		for (int idx=left; idx < right; idx++)
			System.out.print(arr[idx] + "-");
		showArray();

		if(left < j)
		{
			quickSort(arr, left, j);
		}
		if(i < right)
		{
			quickSort(arr, i, right);
		}
		depth--;
		System.out.println(".");
	}
	
	public static void showArray()
	{
		showDepth();
		for (int i=0; i < 10; i++)
			System.out.print(unsortedArr[i] + " ");
		System.out.println();
	}
	
	public static void showDepth()
	{
		for (int i=0; i < depth ;i++)
			System.out.print("   ");
	}
}

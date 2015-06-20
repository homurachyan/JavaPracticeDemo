package com.seele.Algorithm;

public class BubbleSort 
{
	//冒泡排序及其变种:在n的范围内，每次两两比较并Swap
	//冒泡排序1
	public void BubbleSort1(int input[], int n)
	{
	    int i, j;
	    for (i = 0; i < n; i++)  //共比较n-1趟，也可以写作规模缩小 for (int i = input.length-1; i > 0; --i) j < i
	    {
	    	for (j = 1; j < n-i; j++)  //实际操作游标
	    	{
	    		if (input[j-1] > input[j])
	    		{			
	    		    //Swap(input[j-1], input[j]);
	    			int temp;
	    			temp = input[j-1];
	    			input[j-1] = input[j];
	    			input[j] = temp;
	    		}
	    	}              
	    }	              
	}

	public static void main(String[] args)
	{
		int[] input = {9,12,17,30,50,20,60,65,4,49};
		
		BubbleSort BS = new BubbleSort();
		BS.BubbleSort1(input, input.length);
		
		System.out.println("冒泡排序结果：");
		for(int i=0; i<input.length; i++)
		{
			System.out.print(input[i]+" ");
		}
		
	}
}

package com.seele.Algorithm;

public class QuickSort 
{
	public void QuickSort1(int[] input, int low, int high)
	{
		if(low < high)
		{
			int mid = partition1(input, low, high);
			QuickSort1(input, low, mid-1);
			QuickSort1(input, mid+1, high);
		}
	}
	//分治
	public int partition1(int[] input, int low, int high)
	{
		//设该partition的X在第一个位置取，即x = input[0] = input[i]		
		int i = low;
		int j = high;
		int x = input[low];
		
		while(i < j)
		{
			//从右往左寻找小于X的数值填坑input[i] 低端坑
			while(i < j && input[j] >= x)
			{
				j--;
			}
			input[i] = input[j]; //将找到的input[j]填入input[i], input[j]本身形成新坑

			//从左往右寻找大于X的数值填坑input[j] 高端坑
			while(i < j && input[i] <= x)
			{
				i++;
			}
			input[j] = input[i]; //将找到的input[j]填入input[i], input[j]本身形成新坑
		}		
		//退出时 i==j,将X填到这个坑中
		input[i] = x;
		
		return i; //返回中坐标
		
	}
	
	public static void main(String[] args)
	{
		int[] input = {9,12,17,30,50,20,60,65,4,49};
		QuickSort QS = new QuickSort();
		QS.QuickSort1(input, 0, input.length-1);
		
		System.out.println("快速排序结果：");
		for(int i=0; i<input.length; i++)
		{
			System.out.print(input[i]+" ");
		}	
	}
}

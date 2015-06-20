package com.seele.Algorithm;

public class HeapSort 
{
	/*
	//父=((i+1)/2)-1 左=2*i+1 右=2*i+2
	public void heapSort(int[] input)
	{
		int i;
		for(i=input.length/2; i>0; i--)
		{
			heapAdjust(input,i,input.length);
		}
	}
	
	public void heapAdjust(int[] input, int s, int m)
	{
		
	}
	*/
	
	public void MakeMinHeap(int input[])
	{
		for(int i = input.length/2-1; i >= 0; i--) //找到最后一个非叶子节点开始调整(当然也可以直接从最后一个数开始)
		{   //int i = n
			 MinHeapAdjust(input, i, input.length);  
		}	
	}
	
    //从i节点开始调整,n为节点总数,即是input.length 从0开始计算 i节点的子节点为 2*i+1, 2*i+2  
	//相当于从根结点将一个数据的“下沉”过程
	public void MinHeapAdjust(int input[], int i, int n)  
	{  
		int j, father;
		
		while(2*i+1<n)
		{
			father = input[i];
			j = 2*i+1; //左子节点
			if(j+1 < n && input[j+1] < input[j]) //在左右孩子中找最小的
			{          //input[rightchild] < input[leftchild]
				j++;
			}
			if(input[j] >= father)  //子节点>父节点
			{
				break; 
			}
			else  //子节点<父节点
			{
				input[i] = input[j];     //把较小的子结点往上移动,替换它的父结点  
				input[j] = father;  //直到稳定了
				i = j;  //设定下移后新的父节点的游标
				//j = 2*i+1;  
			}
		}
		//input[i] = father;  //直到稳定了
	}
	
	public void MinHeapAdjust2(int input[], int i, int n)
	{
		int child, father;
        while(2*i+1<n) //设定下移后新的父节点的游标
        {
        	father = input[i];
        	child = 2*i+1; 
			if(child+1 < n && input[child+1] < input[child]) //在左右孩子中找最小的  
			{          
				child++;
			}
			if(input[child] >= father)  //子节点>父节点
			{
				break; 
			}
			else
			{
				input[i] = input[child];     //把较小的子结点往上移动,替换它的父结点  
				input[child] = father;  //直到稳定了
				i=child;  //设定下移后新的父节点的游标
			}			
        }

	}
	
	public void MinheapsortTodescendarray(int input[])
	{
		for(int i = input.length-1; i>=1; i--)
		{
			//将选出的最小的元素（也就是当前根节点同尾元素交换），所以是O(1)空间开销
			//Swap(input[i], input[0]);
			int temp;
			temp = input[i];
			input[i] = input[0];
			input[0] = temp;
			//然后，重新调整堆
			MinHeapAdjust2(input, 0, i-1);
		}
	}
	
	/*
    //Java对于基本数据类型不能传引用，是值传递
    public void Swap(int m,int n)
    {
    	int temp;
    	temp = m;
    	m = n;
    	n = temp;
    }
	*/
	public static void main(String[] args)
	{
		int[] input = {9,12,17,30,50,20,60,65,4,49};
		
		HeapSort HS = new HeapSort();
		HS.MakeMinHeap(input); //建立堆化数组
		HS.MinheapsortTodescendarray(input);
		
		System.out.println("最小堆排序结果：");
		for(int i=0; i<input.length; i++)
		{
			System.out.print(input[i]+" ");
		}
	}

}

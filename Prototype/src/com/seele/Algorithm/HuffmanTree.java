package com.seele.Algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HuffmanTree<E> {
	
	private TreeNode root;
	
	private static class TreeNode{  //节点结构内部类
		Object data;
		double weight;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		
		TreeNode(){
		}		
		
		TreeNode(Object element,double weight){
			this.data = element;
			this.weight = weight;
		}
	}
	
	public HuffmanTree(){
		
	}
	
	public HuffmanTree(List<TreeNode> list){
		while(list.size()>1){
			this.Sort(list); //先排序
			//先取weight最小的两个节点
			TreeNode left = list.get(list.size()-1);
			TreeNode right = list.get(list.size()-2);
			TreeNode newParent = new TreeNode(null,left.weight+right.weight);
			newParent.left = left;
			newParent.right = right;
            //除名
			list.remove(list.size()-1);
			list.remove(list.size()-1);
			list.add(newParent);
		}
		root = list.get(0);
	}
	
	public static void Sort(List<TreeNode> list){
		Collections.sort(list, new Comparator<TreeNode>(){

			public int compare(TreeNode o1, TreeNode o2) {
				if(o1.weight>o2.weight){
					return -1;
				}else if(o1.weight<o2.weight){
					return 1;
				}else{
					return 0;
				}				
			}});
	}
	
	//广度优先——层次遍历
	public List<TreeNode> breathIterator(){
		List<TreeNode> list = new ArrayList<TreeNode>(); //存放序列
		Queue<TreeNode> queue = new LinkedList<TreeNode>();//存放层次关系
		if(root!=null){
			queue.offer(root);
		}
		
		while(!queue.isEmpty()){
			list.add(queue.peek());
			TreeNode temp = queue.poll();//出队列
			if(temp.left!=null){
				queue.offer(temp.left);
			}
			if(temp.right!=null){
				queue.offer(temp.right);
			}
		}
		return list;		
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(new TreeNode("A", 7));
		list.add(new TreeNode("B", 5));
		list.add(new TreeNode("C", 2));
		list.add(new TreeNode("D", 4));
        HuffmanTree ht = new HuffmanTree(list);
        list = ht.breathIterator();
        for(TreeNode tn :list){
        	System.out.println(tn.weight);
        }
	}

}

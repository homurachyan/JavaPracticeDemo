package com.seele.Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.jmx.remote.internal.ArrayQueue;

public class LinkedBinaryTree<E>{

	private class TreeNode{  //节点结构内部类
		Object data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		
		TreeNode(){
		}		
		
		TreeNode(Object element){
			this.data = element;
		}
	}
	
	//根节点ref
	private TreeNode root;
	//无参构造
	public LinkedBinaryTree(){
		root = new TreeNode();
	}
	//有参构造
	public LinkedBinaryTree(E element){
		root = new TreeNode(element);
	}
	//判断是否为空树
	public boolean isEmpty(){		
		return this.root.data == null;		
	}	
	//添加节点
	public void add(E element,TreeNode parent,boolean isLeft){
		if(parent==null){
			throw new RuntimeException("父节点为空，无法添加子节点");
		}
		if(isLeft){
			//判断左子树是否满了
			if(parent.left!=null){
				throw new RuntimeException("左子树满，无法添加子节点");
			}else{
				TreeNode newNode = new TreeNode(element);
				newNode.parent = parent;
				parent.left = newNode;
			}
		}else{
			//判断右子树是否满了		
			if(parent.right!=null){
				throw new RuntimeException("右子树满，无法添加子节点");
			}else{
				TreeNode newNode = new TreeNode(element);
				newNode.parent = parent;
				parent.right = newNode;
			}
		}
	}
	//先根遍历
	public List<TreeNode> preIterator(){
		return preIterator(root);		
	}
	
	public List<TreeNode> preIterator(TreeNode node){
		List<TreeNode> list = new ArrayList<TreeNode>(); //存放序列
		list.add(node);
		if(node.left!=null){
			list.addAll(preIterator(node.left));
		}
		if(node.right!=null){
			list.addAll(preIterator(node.right));
		}
		return list;		
	}	
	//中根遍历
	public List<TreeNode> inIterator(){
		return preIterator(root);		
	}
	
	public List<TreeNode> inIterator(TreeNode node){
		List<TreeNode> list = new ArrayList<TreeNode>(); //存放序列
		if(node.left!=null){
			list.addAll(preIterator(node.left));
		}
		list.add(node);
		if(node.right!=null){
			list.addAll(preIterator(node.right));
		}
		return list;		
	}	
	//后根遍历
	public List<TreeNode> postIterator(){
		return preIterator(root);		
	}
	
	public List<TreeNode> postIterator(TreeNode node){
		List<TreeNode> list = new ArrayList<TreeNode>(); //存放序列
		if(node.left!=null){
			list.addAll(preIterator(node.left));
		}
		if(node.right!=null){
			list.addAll(preIterator(node.right));
		}
		list.add(node);
		return list;		
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

	}

}

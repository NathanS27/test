package testFiles;

import java.util.*;


public class testers {

	public class BTNode<T> {
		private T data;
		private BTNode<T> leftChild;
		private BTNode<T> rightChild;
		private BTNode<T> parent;
		public BTNode getLeftChild() {return leftChild;}
		public BTNode getRightChild() {return rightChild;}
		public BTNode getParent() {return parent;}
		}
	public class BinaryTree<T> {
		private BTNode<T> root;
		public BTNode getRoot() {return root;}
		}

	private static void question1A() {
		PriorityQueueWithDeletions<Integer> pq=new PriorityQueueWithDeletions();
		pq.add(10);
		Ticket t2=pq.add(3);
		pq.add(1);
		
		pq.removeByTicket(t2);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.removeHighestPriority());
		}
	}
	//test
	private static void question1B() {
		StackWithMax<Integer> stack=new StackWithMax<>();
		
		stack.push(3);
		System.out.println("Max: "+stack.getMax());
		stack.push(12);
		stack.push(14);
		System.out.println("Max: "+stack.getMax());
		stack.pop();
		System.out.println("Max: "+stack.getMax());
	}
	
	private static void question2A() {
		//BinaryTree<Integer> bst=new BinaryTree<>();
		//isAVLTree(bst);
		//test
	}
	
	public boolean isAVLTree(BinaryTree bst) {
		return isBalanced(bst.getRoot());
	}
	
	private boolean isBalanced(BTNode n) {
		int lh, rh;
		
		if(n==null) {
			return true;
		}
		
		lh=height(n.getLeftChild());
		rh=height(n.getRightChild());
		
		if(Math.abs(lh-rh)<=1&&isBalanced(n.getRightChild())&&isBalanced(n.getLeftChild())) {
			return true;
		}
		return false;
	}
	
	private int height(BTNode n) {
		if(n==null) {
			return 0;
		}
		return 1+Math.max(height(n.getLeftChild()), height(n.getRightChild()));
	}	
	
	private static void question3A() {
		int[][] board = {
				{1,1,1,1,1},
				{1,0,0,0,1},
				{1,0,1,1,1},
				{1,1,1,0,0},
				{1,1,1,1,1},
				{0,0,1,0,1}
				};
		int[][] board1 = {
				{1,0,1},
				{1,0,0},
				{1,0,1},
				{1,1,1}
				};
		int[][] board2 = {
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1}
				};
		int[][] board3 = {
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,1,1},
				{1,1,1,1,0},
				{1,0,0,0,0},
				{1,1,1,1,1}
				};
		printPath(board3);

	}
	public static class point {
		private point parent;
		private int[][] board;
		private int x;
		private int y;
		public point(int xc, int yc,point p,int[][] b) {x=xc;y=yc;parent=p;board=b;}
		public int getX() {return x;}
		public int getY() {return y;}
		public int[] getintArr(){int[] temp= {x,y}; return temp;}
		public int getYlength() {return board[0].length-1;}
		public int getXlength() {return board.length-1;}
		public int[][] getBoard(){return board;}
		public point getParent() {return parent;}
		public String getPoint() {return String.format("%d,%d", x,y);}
		public String toString() {return String.format("%d,%d", x,y);}
		}
	public static ArrayList<String> visited=new ArrayList<>();
	public static ArrayList<point> points=new ArrayList<>();
	public static void printPath(int[][] grid) {
		if(grid[0][0]==1) {
			point start = new point(0,0,null,grid);
			points.add(start);
			point end=solveBoard();
			System.out.println(printSol(end));
		}
		
	}
	private static String printSol(point p) {
		if(p!=null) {
			return printSol(p.parent)+"\n"+String.format("%d,%d", p.getY(),p.getX()).trim();
		}
		return " ";
	}
	public static point solveBoard() {
		int i=0;
		point p=points.get(i);
		while(p!=null) {
			ArrayList<point> possibleMoves=new ArrayList<>();
			possibleMoves.addAll(generateMoves(p,'R'));
			possibleMoves.addAll(generateMoves(p,'U'));
			possibleMoves.addAll(generateMoves(p,'D'));
			possibleMoves.addAll(generateMoves(p,'L'));
			for(point np:possibleMoves) {
				if(np.getX()==np.getXlength()&& np.getY()==np.getYlength()) {
					return np;
				}
				points.add(np);
			}
				if(points.size()-1>i) {
					i++;
					p=points.get(i);
				}
				else {
					p=null;
				}
			}

		return null;
		
	}
	private static ArrayList<point> generateMoves(point g,char dir) {
		ArrayList<point> moves=new ArrayList<>();
		int x=g.getX();
		int y=g.getY();
		int[][] board=g.getBoard();
		point p=null;
		switch(dir) {
		case 'U':
			y++;
			break;
		case 'D':
			y--;
			break;
		case 'L':
			x--;
			break;
		case 'R':
			x++;
			break;
		}
		if((x>=0&&y>=0)&&(x<=g.getXlength()&&y<=g.getYlength())) {
			p=new point(x,y,g,board);
			if(board[x][y]==1&&!visited.contains(p.getPoint())) {
				visited.add(p.getPoint());
				moves.add(p);

			}
		}
		return moves;
	}
  	
	
    private static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	private static void question4C() {
		int[] A = {3,1,8,2,6,11,4,12,5,7,10,9};
		int[] B=  {12,11,10,9,8,7,6,5,4,3,2,1};
		printArray(B);
		Q4C(B,12,3);
		printArray(B);
	}

	private static void Q4C(int[] a,int n, int k) {
		for(int i=0;i<k;i++) {
			for(int j=n-1;j>=i;j--) {
				if(a[i]>a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		//question1A();
		//question1B();
		//question2A();
		//question3A();
		question4C();

	}

}

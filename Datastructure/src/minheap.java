
import java.util.*;

public class minheap {

	links_bintree parent;
	links_bintree update;
	public minheap()
	{
		parent=null;
		update=null;
	}
	
	public void insert (int number)
	{
		links_bintree l=new links_bintree();
		l.setNumber(number);
		Queue1_address q=new Queue1_address();
		if(parent==null)
		{
			parent=l;
			//System.out.println(parent.getNumber());
		}
		else
		{	
			q.push(parent);
			links_bintree temp=null;
			while(q.isEmpty()!=true)
			{
				temp=q.element();
				q.pop();
				
				if(temp.getLeft()==null)
				{
					temp.setLeft(l);
					break;
				}
				else	
					q.push(temp.getLeft());
				if(temp.getRight()==null)
				{
					temp.setRight(l);
					break;
					
				}
				else
					q.push(temp.getRight());
				
			}
			
			minheap(temp);
			
			
		}
	}
	
	public void minheap(links_bintree temp)
	{
		links_bintree temp99=parent;
		while(temp!=parent && temp!=null)
		{
			
			if(temp.getLeft()!=null && temp.getLeft().getNumber()<temp.getNumber())
			{
				int temp1=temp.getLeft().getNumber();
				temp.getLeft().setNumber(temp.getNumber());
				temp.setNumber(temp1);
				search(temp,temp99);
				temp=update;
				System.out.println(temp);
			}
			else if(temp.getRight()!=null && temp.getRight().getNumber()<temp.getNumber())
			{
				int temp1=temp.getRight().getNumber();
				temp.getRight().setNumber(temp.getNumber());
				temp.setNumber(temp1);
				search(temp,temp99);
				temp=update;
				System.out.println("Executed");
			}
			else
				break;
		}
		if(temp==parent)
		{
		if(temp.getLeft()!=null && temp.getLeft().getNumber()<temp.getNumber())
		{
			int temp1=temp.getLeft().getNumber();
			temp.getLeft().setNumber(temp.getNumber());
			temp.setNumber(temp1);
		}
		else if(temp.getRight()!=null && temp.getRight().getNumber()<temp.getNumber())
		{
			int temp1=temp.getRight().getNumber();
			temp.getRight().setNumber(temp.getNumber());
			temp.setNumber(temp1);
		}
		}
	}
	public void search(links_bintree tem,links_bintree temp)
	{
	
		if(temp!=null)
		{
			if(temp.getLeft()!=null && temp.getLeft()==tem)
			{
				update=temp;
			}
			
			else if(temp.getRight()!=null && temp.getRight()==tem)
			{
				update=temp;
			}
		
			search(tem,temp.getLeft());
			search(tem,temp.getRight());
		}
			
	}
	
	public int test(int tem1,int temp)
	{
		
		
		return 1;
	}
	
	public void inorder(links_bintree node)
	{
			
			if(node==null)
			{
				return;
			}
		
			else
			{
		        
		     // first recur on left subtree
		     inorder(node.getLeft());	 
		 
		     // now deal with the node
		     System.out.println(node.getNumber());
		 
		     // then recur on right subtree
		     inorder(node.getRight());
		 
		 }
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		minheap m=new minheap();
		while(b==true)
		{
			System.out.println("Constructing a min heap");
			System.out.println("------------------------");
			System.out.println("1. Insert a node ");
			System.out.println("2. inorder traversal");
			System.out.println("3. Exit");
			System.out.println("Enter your choice : ");
			int n=sc.nextInt();
		
			
			
			switch(n)
			{
		
				case 1:
					System.out.println("Enter the value -: ");
					int node=sc.nextInt();
					m.insert(node);
					break;
				case 2:
					m.inorder(m.parent);
					break;
				case 3: 
					System.out.println("Program Teriminated");
				b=false;
				break;
				default:
					System.out.println("Enter a valid choice ");
			}
		}
	}

}

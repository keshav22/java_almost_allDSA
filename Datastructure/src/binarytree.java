import java.util.*;

public class binarytree {

	links_bintree parent;
	int maxLevel=-1;
	int res=-1;
	links_bintree update;
	int direction;
	public binarytree()
	{
		
		parent=null;
		
	}
	
	public void menu()
	{
		
		System.out.println("1. Enter elements : ");
		System.out.println("2. Pre-order traversal :");
		System.out.println("3. In-Order traversal :");
		System.out.println("4. Post-order traversal :");
		System.out.println("5. Level-order traversal :");
		System.out.println("6. Del. a node : ");
		System.out.println("7. Exit : ");
		System.out.println("Enter your choice : ");
	}
	
	public void preorder(links_bintree node)
	{
			
			if(node==null)
			{
				return;
			}
		
			else
			{
		        
			     // now deal with the node
			     System.out.println(node.getNumber());
			
				
			     // first recur on left subtree
			     postorder(node.getLeft());	 
		 
		 
		     
			     // then recur on right subtree
			     postorder(node.getRight());
		 
		 }
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
		     postorder(node.getLeft());	 
		 
		     // now deal with the node
		     System.out.println(node.getNumber());
		 
		     
		     // then recur on right subtree
		     postorder(node.getRight());
		 
		 }
	}
	
	public void postorder(links_bintree node)
	{
			
			if(node==null)
			{
				return;
			}
		
			else
			{
		        
				// first recur on left subtree
				postorder(node.getLeft());	 
				// then recur on right subtree
				postorder(node.getRight());
		 
				// now deal with the node
				System.out.println(node.getNumber());
		 }
	}
	
	public void display()
	{
		Queue1_address q=new Queue1_address();
		
		//System.out.println(parent.getLeft().getNumber());
		
		if(parent==null)
		{
			System.out.println("No noded");
		}
		
		else
		{
			q.push(parent);
			
			while(!q.isEmpty())
			{
				
				links_bintree temp=q.element();
				System.out.println(temp.getNumber());
				q.pop();
			
				if(temp.getLeft()!=null)
				{
					q.push(temp.getLeft());
				}	
					
				if(temp.getRight()!=null)
				{
					q.push(temp.getRight());
				}
			}
		}
		
	}
	
	public void deepest(links_bintree node,int level)
	{
		
		if(node!=null)
		{
		
		deepest(node.getLeft(), ++level);
		 
        if (level > maxLevel)
        {
            res = node.getNumber();
            maxLevel = level;
        }
        deepest(node.getRight(), ++level);
		}
	}
	
	public void delnode(int num)
	{
		
		
		deepest(parent,0);
		
	
		searchnode(parent,res);
		links_bintree replace_node=update;
		int dir1=direction;
		
		searchnode(parent,num);
		links_bintree del_node=update;
		int dir2=direction;
		
		if(del_node.getLeft().getNumber()==num)
		{
			if(dir1==0)
			{
				del_node.getLeft().setNumber(replace_node.getLeft().getNumber());
				replace_node.setLeft(null);
			}
			else
			{
				del_node.getLeft().setNumber(replace_node.getRight().getNumber());
				replace_node.setRight(null);
			}	
			
		}
		else if(del_node.getRight().getNumber()==num)
		{
			if(dir1==0)
			{
				del_node.getRight().setNumber(replace_node.getLeft().getNumber());
				replace_node.setLeft(null);
			}
			else
			{
				del_node.getRight().setNumber(replace_node.getRight().getNumber());
				replace_node.setRight(null);
			}	
			}
			
	}
	
	public void searchnode(links_bintree node,int num)
	{
		
		
			if(node!=null)
			{
				
				if((node.getLeft()!=null && node.getLeft().getNumber()==num ))
				{
					update=node;
					direction=0;
				}
				else if(( node.getRight()!=null && node.getRight().getNumber()==num))
					
				{
					update=node;
					direction=1;
				}
				searchnode(node.getLeft(),num);
				searchnode(node.getRight(),num);
			}
			
			
			
			
	}
	
	public void insertnode(int num)
	{
		links_bintree l=new links_bintree();
		l.setNumber(num);
		Queue1_address q=new Queue1_address();
		
		
		if(parent==null)
		{
			parent=l;
		}
		else
		{
		q.push(parent);
		while(q.isEmpty()!=true)
		{
			links_bintree temp=q.element();
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
			
		}}
		
		
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		binarytree t=new binarytree();
		
		boolean b=true;
		while(b!=false)
		{
			t.menu();
			int choice=sc.nextInt();
		
			switch(choice)
			{
				case 1:
					
					System.out.println("Enter the number : ");
					int num=sc.nextInt();
					t.insertnode(num);
					
					break;
				case 2:
					t.preorder(t.parent);
					break;
				case 3:
					t.inorder(t.parent);
					break;
				case 4:
					t.postorder(t.parent);
					break;
				case 5:
					t.display();
					break;
					
				case 6:
					
						System.out.println("Enter the number you wanna delete : ");
						int num1=sc.nextInt();
						//t.searchnode(t.parent,num1);
						t.delnode(num1);
						//System.out.println(t.update.getNumber());
					break;
				case 7: b=false;
				System.out.println("Terminated");
			break;
				default:
					System.out.println("Enter a valid input or press 5 to exit ");
					break;
			}
		
		}
		
		
	}

}

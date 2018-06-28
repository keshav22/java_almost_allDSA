import java.util.*;

public class binary_search_tree 
{
	links_bintree parent;
	
	
	public void menu()
	{
		System.out.println("1. Insert node in BST ");
		System.out.println("2. Del. node from BST ");
		System.out.println("3. Search an element in BST ");
		System.out.println("4. Pre-order traversal");
		System.out.println("5. Post-order traversal");
		System.out.println("6. Level-order traversal");
		System.out.println("7. Exit ");
		System.out.println("Enter your choice : ");
		
	}
	
	public void search(int num)
	{
		if(parent==null)
		{
			System.out.println("Create a tree first!!");
		}
		else
		{
			links_bintree temp=parent;
			
			while(temp!=null)
			{
				if(temp.getNumber()==num)
				{
					System.out.println("Found");
					break;
				}
				else if(temp.getNumber()<num)
				{
					temp=temp.getLeft();
				}
				else
				{
					temp=temp.getRight();			
				}
			}
			if(temp==null)
				System.out.println("Not found");
		}
	}
	
	public void insert(int num)
	{
		links_bintree l=new links_bintree();
		l.setNumber(num);
		
		if(parent==null)
		{
			parent=l;
		}
		else
		{
			links_bintree temp=parent;
			
			while(temp!=null)
			{
				if(temp.getNumber()<=num)
				{
					if(temp.getLeft()!=null)
					temp=temp.getLeft();
					else
					{
						temp.setLeft(l);
						break;
					}
				}
				else
				{
					if(temp.getRight()!=null)
						temp=temp.getRight();
						else
						{
							temp.setRight(l);			
							break;
						}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) 
	{
		
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		binary_search_tree binary=new binary_search_tree();
		
		while(b==true)
		{
			binary.menu();
			int n=sc.nextInt();
		
			switch(n)
			{
				
				case 1: 
						System.out.println("Enter the value to be inserted : ");
						int num=sc.nextInt();
						binary.insert(num);
					break;
		
				case 2:
					break;
		
				case 3:
						System.out.println("Search a key in BST inout the key : ");
						int key=sc.nextInt();
						binary.search(key);
					break;
		
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					b=false;
					break;
			
				default: 
					System.out.println("Enter the correct choice");
				break;
			}
		}
	
		sc.close();
	}

}

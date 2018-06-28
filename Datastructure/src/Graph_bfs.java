import java.util.Scanner;

class link2
{
	private int number;
	private link2 next;
	
	public link2()
	{
		number=0;
		next=null;
	}
	public link2 getNext()
	{
		return next;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNext(link2 nxt)
	{
		this.next=nxt;
	}
	public void setNumber(int num)
	{
		this.number=num;
	}	
}


public class Graph_bfs {

	link2 front[];
	link2 rear[];
	int nodes[];
	public Graph_bfs(int n)
	{
		front=new link2[n];
		rear=new link2[n];
		int i=0;
		for(i=0;i<n;i++)
		{
			front[i]=null;
			rear[i]=null;
		}
		nodes=new int[n];
	}
	
	public void push(int u,int v)
	{		
			link2 newnode1=new link2();
			newnode1.setNumber(v);
			
			int i=0;
			
			while(front[i]!=null && front[i].getNumber()!=u)
			{
				i=i+1;
			}
			if(front[i]==null)
			{
				link2 newnode=new link2();
				newnode.setNumber(u);
				front[i]=newnode;
				front[i].setNext(newnode1);
				rear[i]=newnode1;
				nodes[i]=u;
			}
			
			else
			{
				rear[i].setNext(newnode1);
				rear[i]=newnode1;
			}
			
			
		
	}
	
	public void display(int n)
	{
			int i=0;
			
			for(i=0;i<n;i++)
			{
				link2 temp=front[i];
				
				if(temp!=null)
				{
				while(temp.getNext()!=null)
				{
					temp=temp.getNext();
					System.out.println("Edge : "+front[i].getNumber()+"---->"+temp.getNumber());	
				}
				}
				else
				{
					break;
				}
				System.out.println("____________________________");
			}
			
	}
	
	public void editnodes(int num)
	{
		int i=0;
		int length = nodes.length;
		for(i=0;i<length;i++)
		{
			
			if(nodes[i]==num)
			{	
				nodes[i]=-1;
				break;
			}
		}
		
	}
	
	public int checknodes(int num)
	{
		int i=0;
		int length = nodes.length;
		for(i=0;i<length;i++)
		{
			if(nodes[i]==num)
			{	
				return 0;
			}
		}
		return -1;
		
	}
	public void bfs(int n)
	{
		
		if(front[0]==null)
		{
			System.out.println("Graph not created first input some edges ");
		}
		else
		{
			Queue1 q=new Queue1();
			int length = nodes.length;
			
			int b[] = new int[length];
			b=nodes;
			
			int i=0;
			
			if(q.start==null)
			{
				int s=front[0].getNumber();
				
				q.push(s);
				editnodes(s);
				q.pop();
				
				link2 temp=front[0].getNext();
				
				while(temp!=null)
				{		
					int m=checknodes(temp.getNumber());
					
					if(m==0)
					{
						editnodes(temp.getNumber());
						q.push(temp.getNumber());
					}
						temp=temp.getNext();
				}
			}
			
			while(q.start!=null)
			{
					int s= q.element();
					q.pop();
					link2 temp=null;
					int ki=1;
					for(ki=1;ki<n;ki++)
					{
						if(s==front[ki].getNumber())
						{	
							temp=front[ki];
							break;
						}
					}
					while(temp!=null)
					{
						int m=checknodes(temp.getNumber());
						if(m==0)
						{
							editnodes(temp.getNumber());
							q.push(temp.getNumber());
						}
						temp=temp.getNext();
					}
					
				
				
				
			}
		}
		
		
	}
	public void dfs(int n)
	{
		if(front[0]==null)
		{
			System.out.println("Graph not created first input some edges ");
		}
		else
		{
			stack q=new stack();
			int length = nodes.length;
			
			int b[] = new int[length];
			b=nodes;
			
			int s=front[0].getNumber();
				
				q.push(s);
				editnodes(s);
				System.out.println(s);
				link2 temp=front[0].getNext();
						
				
				editnodes(temp.getNumber());
				q.push(temp.getNumber());
				System.out.println(temp.getNumber());
				s=temp.getNumber();
				while(q.start!=null)
				{	 
					 int ki=1;
					 for(ki=1;ki<n;ki++)
						{
							if(s==front[ki].getNumber())
							{	
								temp=front[ki].getNext();
								break;
							}
						}
						while(true)
						{
							if(temp!=null)
							{
								
								int m=checknodes(temp.getNumber());
								if(m==0)
								{
									System.out.println(temp.getNumber());
									editnodes(temp.getNumber());
									q.push(temp.getNumber());
									break;
								}
								else
								{
									temp=temp.getNext();
								}
								if(temp!=null)
								s=temp.getNumber();
							}
							else
							{
								q.pop();
								if(q.start==null)
									break;
								s=q.element();
							}
						}
						
				}
			
		}
	}
	
	public void menu()
	{
		System.out.println("1. Enter an Edge");
		System.out.println("2. Display Tree");
		System.out.println("3. DFS");
		System.out.println("4. BFS");
		System.out.println("5. Exit");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		
		System.out.print("Enter the no. of nodes of the Graph => ");
		int n=sc.nextInt();
		
		Graph_bfs s1=new Graph_bfs(n);
		
		while(true)
		{
			s1.menu();
			
			System.out.println("Enter your Choice");
		
			int choice=sc.nextInt();
		
			if(choice==1)
			{
				/*System.out.println("Enter the Edge Details : ");
				
				System.out.println("Like edge(u,v) \n");
				
				System.out.print("u : ");
				int u=sc.nextInt();
				System.out.print("v : ");
				int v=sc.nextInt();
				
				System.out.println(" ________________________");
				System.out.println("| Inserting Edge "+u+"---->"+v+" |");
				System.out.println("| Inserting Edge "+v+"---->"+u+" |");
				System.out.println("|________________________|\n");
				s1.push(u,v);
				s1.push(v,u);
				*/
				s1.push(1,2);
				s1.push(2,1);
				s1.push(1,3);
				s1.push(3,1);
				s1.push(5,3);
				s1.push(3,5);
				s1.push(2,4);
				s1.push(4,2);
				s1.push(2,5);
				s1.push(5,2);
				s1.push(4,5);
				s1.push(5,4);
				s1.push(5,6);
				s1.push(6,5);
				s1.push(4,6);
				s1.push(6,4);
			}
			else if(choice==2)
			{
				s1.display(n);
			}
			else if(choice==3)
			{
				s1.dfs(n);
			}
			else if(choice==4)
			{
				s1.bfs(n);
			}
			else if(choice==5)
			{
				System.out.println("Program Terminated");
				break;	
			}
			else
			{
				continue;
			}
		}
		
	}

}


import java.util.Scanner;

class link1
{
	private int number;
	private link1 next;
	
	public link1()
	{
		number=0;
		next=null;
	}
	public link1 getNext()
	{
		return next;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNext(link1 nxt)
	{
		this.next=nxt;
	}
	public void setNumber(int num)
	{
		this.number=num;
	}	
}


public class Queue1 {

	link1 start;
	link1 top;
	public Queue1()
	{
		start=null;
	}
	
	public void push(int number1)
	{
		link1 newnode=new link1();
		newnode.setNumber(number1);
		
		if(start==null)
		{
			start=newnode;
			top=newnode;
		}
		else
		{
			
			link1 temp=start;
			
			while(temp.getNext()!=null)
			{
				temp=temp.getNext();
			}
			top=newnode;
			temp.setNext(newnode);	
		}
	}
	
	public int element()
	{
		return start.getNumber();	
	}
	
	public void pop()
	{
		link1 temp=start;
		if(start==null)
		{
			System.out.println("No nodes");
		}
		else
		{
			if(top!=start)
			{
				System.out.println(start.getNumber());
				start=start.getNext();
			}
			else
			{
				System.out.println(top.getNumber());
				start=null;
				top=null;
			}
		}
		
	}
	
	public void menu()
	{
		System.out.println("1. Push a Data from Queue \n");
		System.out.println("2. Pop a Data from Queue \n");
		System.out.println("3. Exit");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		
		Queue1 s1=new Queue1();
		while(true)
		{
		s1.menu();
			
		System.out.println("Enter your Choice");
		
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			System.out.println("Enter the number : ");
			int num=sc.nextInt();
			s1.push(num);
		}
		else if(choice==2)
		{
			s1.pop();
		}
		else
		{
		break;	
		}
		}
		
	}

	
}

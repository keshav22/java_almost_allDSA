
import java.util.Scanner;
import java.util.Scanner;

class link4
{
	private links_bintree number;
	private link4 next;
	
	public link4()
	{
		number=null;
		next=null;
	}
	public link4 getNext()
	{
		return next;
	}
	public links_bintree getNumber()
	{
		return number;
	}
	public void setNext(link4 nxt)
	{
		this.next=nxt;
	}
	public void setNumber(links_bintree num)
	{
		this.number=num;
	}	
}


public class Queue1_address {

	link4 start;
	link4 top;
	public Queue1_address()
	{
		start=null;
	}
	
	public void push(links_bintree number1)
	{
		link4 newnode=new link4();
		newnode.setNumber(number1);
		
		if(start==null)
		{
			start=newnode;
			top=newnode;
		}
		else
		{
			
			link4 temp=start;
			
			while(temp.getNext()!=null)
			{
				temp=temp.getNext();
			}
			top=newnode;
			temp.setNext(newnode);	
		}
	}
	
	
	
	public links_bintree element()
	{
		return start.getNumber();	
	}
	
	public void pop()
	{
		link4 temp=start;
		if(start==null)
		{
			System.out.println("No nodes");
		}
		else
		{
			if(top!=start)
			{
				start=start.getNext();
			}
			else
			{
				//System.out.println(top.getNumber());
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

	

	public boolean isEmpty() {
		if(start==null)
		{
			return true;
		}
		return false;
		// TODO Auto-generated method stub
		
	}

	
}

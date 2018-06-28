import java.util.*;

class link
{
	private int number;
	private link next;
	
	public link()
	{
		number=0;
		next=null;
	}
	public link getNext()
	{
		return next;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNext(link nxt)
	{
		this.next=nxt;
	}
	public void setNumber(int num)
	{
		this.number=num;
	}	
}


public class stack {

	link start;
	link top;
	public stack()
	{
		start=null;
	}
	
	public void push(int number1)
	{
		link newnode=new link();
		newnode.setNumber(number1);
		
		if(start==null)
		{
			start=newnode;
			top=newnode;
		}
		else
		{
			
			link temp=start;
			
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
		return top.getNumber();	
	}
	public void pop()
	{
		link temp=start;
		if(start==null)
		{
			System.out.println("No nodes");
		}
		else
		{
			if(top!=temp)
			{
				while(temp.getNext()!=top)
				{
					temp=temp.getNext();
				}
		
				//System.out.println(top.getNumber());
				temp.setNext(null);
				top=temp;
			}
			else
			{
				//System.out.println(top.getNumber());
				start=null;
				
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
		
		stack s1=new stack();
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

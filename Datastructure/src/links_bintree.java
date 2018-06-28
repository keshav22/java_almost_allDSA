
public class links_bintree {
	
		private int number;
		private links_bintree left;
		private links_bintree right;
		
		public links_bintree()
		{
			number=-1;
			right=null;
			left=null;
		}
		public links_bintree getLeft()
		{
			return left;
		}
		
		public links_bintree getRight()
		{
			return right;
		}
		
		public void setRight(links_bintree rgt)
		{
			this.right=rgt;
		}
		
		public int getNumber()
		{
			return number;
		}
		public void setLeft(links_bintree lft)
		{
			this.left=lft;
		}
		public void setNumber(int num)
		{
			this.number=num;
		}	

	}


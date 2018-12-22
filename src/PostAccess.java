import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class PostAccess {
	public ArrayList<Post> P =new ArrayList<Post>();
    public Vector  Contains=new Vector();

  public  void GetPost() {
	  System.out.println("Enter the name of the post: ");
	  String pp;
	  Scanner Sc=new Scanner(System.in);
	  pp=Sc.nextLine();
	  for(int i=0; i<P.size();i++)
	  {
		  Post p=P.get(i);
		  if(p.GetTitle()==pp)
		  {
			  p.Print();
		  }
	  }
	  
  }

  public  void SavePost(Post b)
  {	  
	  this.P.add(b);
  }

  public void DeletePost() {
}

  public void UpdatePost() {
}

  public Boolean VerifyInfo() {
	return null;
}

}
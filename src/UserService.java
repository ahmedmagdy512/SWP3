import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class UserService {
	public PostAccess PP=new PostAccess();
	
	public Boolean EditProfile(User u) {
		  
		   System.out.print("Enter the new info: \n");
		   Scanner sc=new Scanner(System.in);
		   String un;
		   String p;
		   String e;
		   Integer a;
		   String addr; 
		   un=sc.next();
		   p=sc.next();
		   e=sc.next();
		   a=sc.nextInt();
		   addr=sc.nextLine();
		   u.SetUserName(un);
		   u.SetAddress(addr);
		   u.SetAge(a);
		   u.SetEmail(e);
		   u.SetPassword(p);
		   return true;
	   
	  }

  public boolean SignIn(UserAccess UA,User Curr)
  {
	  String un,pwd;
	  System.out.print("Enter the username and password : \n");
	  Scanner sc=new Scanner(System.in);
	  un=sc.next();
	  pwd=sc.next();
	  for(int i=0; i<UA.U.size();i++)
	  {
		  User x=UA.U.get(i);
		  x.Print();
		  if(x.GetUserName()==un && x.GetPassword()==pwd)
		  {
			 Curr=new User(x);
			 return true;
		  }
	  }
	  System.out.println("Invalid username or password");
	  return false;
  }

  public void SignUp(UserAccess UA) throws IOException
  {
	  UA.SaveUser();
  }
	public boolean SearchItem(String name, PostAccess PA) 
	{
		boolean f=false;
		ArrayList<Post> posts=new ArrayList<Post>();
		for(int i=0;i<PA.P.size();i++)
		{
			Post post=PA.P.get(i);
			if(post.GetTitle()==name)
			{
				post.Print();
				System.out.println(post.Create.Email);
				f=true;
			}
		}
		return f;
	}

}
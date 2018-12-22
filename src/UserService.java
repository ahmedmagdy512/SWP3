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
		   System.out.print("UserName : ");
		   un=sc.nextLine();
		   System.out.print("Password : ");
		   p=sc.nextLine();
		   System.out.print("Email : ");
		   e=sc.nextLine();
		   System.out.print("Address : ");
		   addr=sc.nextLine();
		   System.out.print("Age : ");
		   a=sc.nextInt();
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
	  un=sc.nextLine();
	  pwd=sc.next();
	  for(int i=0; i<UA.U.size();i++)
	  {
		  User x=UA.U.get(i);
		  if(x.GetUserName().equals(un) &&  x.GetPassword().equals(pwd))
		  {
			  Curr.SetUserName(x.GetUserName());
			  Curr.SetAddress(x.GetAddress());
			  Curr.SetAge(x.GetAge());
			  Curr.SetEmail(x.GetEmail());
			  Curr.SetPassword(x.GetPassword());
			  Curr.setU(x.getU());
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
		for(int i=0;i<PA.P.size();i++)
		{
			if(PA.P.get(i).GetTitle().contains(name))
			{
				System.out.println("Name : "+PA.P.get(i).GetItem().getName());
				System.out.println("Category : "+PA.P.get(i).GetItem().getCategory());
				System.out.println("HolderName : "+PA.P.get(i).GetItem().getHolderName());
				System.out.println("Title : "+PA.P.get(i).GetTitle());
				System.out.println("Description : "+PA.P.get(i).GetDesc());
				System.out.println("Date : "+PA.P.get(i).GetDate());
				System.out.println(PA.P.get(i).Create.Email);
				f=true;
			}
		}
		return f;
	}

}
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class UserAccess {
    public Vector  Contains=new Vector();
    ArrayList<User> U=new ArrayList<User>();
  public void GetUser()
  {
	  System.out.println("Enter the e-mail that you want to view its user : ");
	  String Email;
	  Scanner Sc=new Scanner(System.in);
	  Email=Sc.nextLine();
	  for(int i=0; i<U.size();i++)
	  {
		  User u=U.get(i);
		  if(u.getEmail()==Email)
		  {
			  u.Print();
			  break;
		  }
	  }
  }

  public void SaveUser() throws IOException
  {
	  
	  User u=new User();
	  System.out.print("Enter the user's info: \n");
	   Scanner sc=new Scanner(System.in);
	   String un;
	   String p;
	   String e;
	   Integer a;
	   String addr; 
	   un=sc.next();
	   p=sc.next();
	   e=sc.next();
	   addr=sc.next();
	   a=sc.nextInt();
	   u.SetUserName(un);
	   u.SetAddress(addr);
	   u.SetAge(a);
	   u.SetEmail(e);
	   u.SetPassword(p);
	   System.out.println("User "+u.GetUserName()+" is Added");
	   U.add(u);
	   BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt",true));
	   writer.append(un+"$"+p+"$"+e+"$"+a+"$"+addr);
	   writer.append('\n');
	     
	    writer.close();
	
  }

  public void DeleteUser()
  {
	  System.out.println("Enter the e-mail that you want to delete its user : ");
	  String Email;
	  Scanner Sc=new Scanner(System.in);
	  Email=Sc.nextLine();
	  for(int i=0; i<U.size();i++)
	  {
		  User u=U.get(i);
		  if(u.GetEmail()==Email)
		  {
			  U.remove(U.get(i));
			  break;
		  }
	  }
  }
  public void Update()
  {
	  System.out.println("Enter the e-mail that you want to edit its user : ");
	  String Email;
	  Scanner Sc=new Scanner(System.in);
	  Email=Sc.nextLine();
	  for(int i=0; i<U.size();i++)
	  {
		  User u=U.get(i);
		  if(u.GetEmail()==Email)
		  {
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
			   U.set(i,u);
			  break;
		  }
	  }
  }
  public Boolean VerifyInfo()
  {
	  return null;
  }

}
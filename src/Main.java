import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	  public static UserAccess UA;

	  public static PostAccess PA;

	  public static ItemAccess IA;
	  public static void InitializeUsers() throws IOException
	  {
		  UA = new UserAccess();
		  BufferedReader in = new BufferedReader(new FileReader("Users.txt"));
		  
		  String line;
		  while((line = in.readLine()) != null)
		  {
			  User u=new User();
		      String []attrs=line.split(Pattern.quote("$"));
		      u.SetUserName(attrs[0]);
		      u.SetPassword(attrs[1]);
		      u.SetEmail(attrs[2]);
		      u.SetAge(Integer.parseInt(attrs[3]));
		      u.SetAddress(attrs[4]);
		      u.setU(UA);
		      UA.U.add(u);
		  }
		  in.close();
	  }
	  @SuppressWarnings("deprecation")
	 public static void InitializePosts() throws IOException, ParseException
	  {
		  PA=new PostAccess();
		  BufferedReader in = new BufferedReader(new FileReader("Posts.txt"));
		  User u=new User();
		  String line;
		  while((line = in.readLine()) != null)
		  {
		      String []attrs=line.split(Pattern.quote("$"));
		      Post p=new Post();
		      Item It = new Item();
		      User Create=new User();
		      It.setName(attrs[0]);// item's info
		      It.setCategory(attrs[1]);
		      It.setHolderName(attrs[2]);
		      It.setItAcc(IA);// end of item's info
		      p.SetTitle(attrs[3]);
		      p.SetDesc(attrs[4]);
		      String temp=attrs[5];
		      String[] Date=temp.split("-");
		      Date D = new Date(Integer.parseInt(Date[2]), Integer.parseInt(Date[1]), Integer.parseInt(Date[0]));
		      p.SetDate(D);
		      Create.setU(UA); // creator info
		      Create.SetEmail(attrs[6]);
		      p.setCreate(Create);
		      It.setCan_have(Create);
		      It.setContains(p);
		      p.SetItem(It);
		      PA.P.add(p);
		  }
		  in.close();
	  }
	/*  public static void InitializeItems(ItemAccess I) throws IOException
	  {
		  IA=new ItemAccess();
		  BufferedReader in = new BufferedReader(new FileReader("Items.txt"));
		  String line;
		  while((line = in.readLine()) != null)
		  {
		      String []attrs=line.split("$");
		      Item It=new Item();
		      It.setName(attrs[0]);
		      It.setItAcc(I);
		      It.setHolderName(attrs[1]);
		      It.setCategory(attrs[2]);
		      
		  }
		  in.close();
	  }*/
	public static   User Current=new User();
	public static void main(String[] args) throws IOException, ParseException
	{
		InitializeUsers();
		InitializePosts();
		//InitializeItems(IA);
		UserService x=new UserService();
		PostService y=new PostService();
		int op=0;
		System.out.println("Welcome to Masroo2a \n");
		while(true)
		{
			System.out.println("Choose any Operation: ");
			System.out.println("1- Signin");
			System.out.println("2- Signup");
			System.out.println("3- Exit");
			Scanner sc=new Scanner(System.in);
			op=sc.nextInt();
			
			switch(op)
			{
			case 1:
				if(x.SignIn(UA,Current))
					{
						boolean Logout=false;
						while(!Logout) 
						{
							System.out.println("Choose any Operation: ");
							//System.out.println("1- Edit Profile");
							System.out.println("1- Search Item");
							System.out.println("2- Create Post");
							System.out.println("3- Logout");
							op=sc.nextInt();
							switch(op)
							{
							/*case 1:
								Boolean editProfile = x.EditProfile(Current);
								break;*/
							case 1:
								System.out.println("Enter the name of the item : ");
								String Name;
								Name=sc.next();
								if(!x.SearchItem(Name, PA))
								{
									System.out.println("Item not found ");
								}
								break;
							case 2:
								Post p=new Post();
								Current.Print();
								y.CreatePost(p, Current, PA);
								break;
							case 3:
								Logout=true;
								break;
							}
						}
						
					}
				
				break;
			case 2:
				x.SignUp(UA);
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Please, Enter a valid choice.");
				break;
			}
		}
	}

}

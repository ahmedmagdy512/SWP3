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
	  public static UserAccess UA=new UserAccess();

	  public static PostAccess PA=new PostAccess();

	  public static ItemAccess IA=new ItemAccess();
	  public static void InitializeUsers(UserAccess U) throws IOException
	  {
		  BufferedReader in = new BufferedReader(new FileReader("Users.txt"));
		  User u=new User();
		  String line;
		  while((line = in.readLine()) != null)
		  {
		      String []attrs=line.split(Pattern.quote("$"));
		      u.setUserName(attrs[0]);
		      u.SetPassword(attrs[1]);
		      u.setEmail(attrs[2]);
		      u.setAge(Integer.parseInt(attrs[3]));
		      u.setAddress(attrs[4]);
		      u.setU(UA);
		      UA.U.add(u);
		      UA.U.get(UA.U.size()-1).Print();
		      System.out.println();
		  }
		  in.close();
	  }
	  @SuppressWarnings("deprecation")
	public static void InitializePosts(PostAccess P) throws IOException, ParseException
	  {
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
		      p.setDescription(attrs[4]);
		      String temp=attrs[5];
		      String[] Date=temp.split("-");
		      Date D = new Date(Integer.parseInt(Date[2]), Integer.parseInt(Date[1]), Integer.parseInt(Date[0]), Integer.parseInt(Date[3]), Integer.parseInt(Date[4]));
		      p.setPostDate(D);
		      Create.setU(UA); // creator info
		      Create.SetUserName(attrs[6]);
		      Create.SetPassword(attrs[7]);
		      Create.setEmail(attrs[8]);
		      int a=Integer.parseInt(attrs[9]);
		      Create.SetAge(a);
		      Create.SetAddress(attrs[10]);	// end of creator info	
		      p.setCreate(Create);
		      It.setCan_have(Create);
		      It.setContains(p);
		      p.setIt(It);
		      PA.SavePost(p);
		      p.Print();
		      System.out.println();
		  }
		  in.close();
	  }
	  public static void InitializeItems(ItemAccess I) throws IOException
	  {
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
	  }
	public static void main(String[] args) throws IOException, ParseException
	{
		User Current=new User();
		InitializeUsers(UA);
		InitializePosts(PA);
		InitializeItems(IA);
		UserService x=new UserService();
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
							System.out.println("1- Edit Profile");
							System.out.println("2- Search Item");
							System.out.println("3- Create Post");
							System.out.println("4- Delete Post");
							System.out.println("5- Edit Post");
							System.out.println("6- View Post");
							System.out.println("7- Logout");
							op=sc.nextInt();
							switch(op)
							{
							case 1:
								Boolean editProfile = x.EditProfile(Current);
								break;
							case 2:
								System.out.println("Enter the name of the item : ");
								String Name;
								Name=sc.next();
								if(!x.SearchItem(Name, PA))
								{
									System.out.println("Item not found ");
								}
								break;
							case 3:
								Post p=new Post();
								//p.PostDate=
							case 4:
							case 5:
							case 6:
							case 7:
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

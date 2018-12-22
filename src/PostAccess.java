import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class PostAccess {
	private static final String PostDate = null;
	private static final String HolderName = null;
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

  @SuppressWarnings({ "deprecation", "deprecation", "deprecation" })
public  void SavePost(Post b,User Curr) throws IOException
  {	  
	  System.out.println("Enter Post Info: ");
	  Scanner in=new Scanner (System.in);
	  System.out.print("Title : "); String Tilte=in.nextLine(); b.SetTitle(Tilte);
	  System.out.print("Description : "); String Desc=in.nextLine(); b.SetDesc(Desc);
	  System.out.print("Date : "); String temp=in.nextLine();
	  
	  String[] Date=temp.split("-");
      Date PostDate = new Date(Integer.parseInt(Date[2]), Integer.parseInt(Date[1]), Integer.parseInt(Date[0]));
      b.SetDate(PostDate);
	  Item IT=new Item();
	  System.out.println("Enter Item Info: ");
	  System.out.print("Name : "); String Name=in.nextLine();
	  System.out.print("Category : "); String Categroy=in.nextLine();
	  System.out.print("HolderName : " + Curr.GetUserName());
	  IT.setName(Name);
	  IT.setHolderName(Curr.GetUserName());
	  IT.setCategory(Categroy);
	  IT.setContains(b);
	  IT.setCan_have(Curr);
      b.SetItem(IT);
	  System.out.println("Post "+b.GetTitle()+" is Added");
	  P.add(b);
	  BufferedWriter writer = new BufferedWriter(new FileWriter("Posts.txt",true));
	  writer.append(Name+"$"+Categroy+"$"+Curr.GetUserName()+"$"+Tilte+"$"+Desc+"$"+PostDate+"$"+Curr.GetEmail());
	  writer.append('\n');
	  writer.close();
	 }

  public void DeletePost() {
}

  public void UpdatePost() {
}

  public Boolean VerifyInfo() {
	return null;
}

}
import java.util.Date;
import java.util.Vector;

public class Post {

  public Item It;
  public String Title;
  public Date PostDate;
  public String Description;
  public User Create;
  public Item getIt() {
	return It;
}
  public Post() {
	  It=new Item();
	  Title="";
	  Description = "" ;
	  Create=new User();
  }
public void setIt(Item it) {
	It = it;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public Date getPostDate() {
	return PostDate;
}
public void setPostDate(Date postDate) {
	PostDate = postDate;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public User getCreate() {
	return Create;
}
public void setCreate(User create) {
	Create = create;
}

   
  public void Print()
  {
	  System.out.println(PostDate);
	  System.out.println("Title: "+Title);
	  It.Print();
	  System.out.println(Description);
	  System.out.println("User: "+Create.getUserName()+", "+Create.GetEmail());
  }
  public void SetItem(Item It) {
	  this.It=It;
  }

  public Item GetItem() {
  return It;
  }

  public void SetDate(Date D) {
	  this.PostDate=D;
  }

  public Date GetDate() {
  return PostDate;
  }

  public void SetTitle(String Title) {
	  this.Title=Title;
  }

  public String GetTitle() {
  return Title;
  }

  public void SetDesc(String Desc) {
	  this.Description=Desc;
  }

  public String GetDesc() {
  return Description;
  }

}
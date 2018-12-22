import java.io.IOException;
import java.util.Vector;

public class PostService {

  public void CreatePost(Post b,User Curr,PostAccess PA) throws IOException
  {
	  PA.SavePost(b,Curr);
  }
/*
  public Boolean DeletePost();

  public Post ViewPost();

  public Post EditPost();*/

}
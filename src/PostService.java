import java.util.Vector;

public interface PostService {

  public default void CreatePost(Post b,PostAccess PA)
  {
	PA.SavePost(b);
	  
  }

  public Boolean DeletePost();

  public Post ViewPost();

  public Post EditPost();

}
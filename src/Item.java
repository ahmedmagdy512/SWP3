public class Item  {

  public String Name;

  public String Category;

  public String HolderName;
  public ItemAccess ItAcc;
  public User can_have;
  public Post Contains;
  
  public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getCategory() {
	return Category;
}
public void setCategory(String category) {
	Category = category;
}
public String getHolderName() {
	return HolderName;
}
public void setHolderName(String holderName) {
	HolderName = holderName;
}
public ItemAccess getItAcc() {
	return ItAcc;
}
public void setItAcc(ItemAccess itAcc) {
	ItAcc = itAcc;
}
public User getCan_have() {
	return can_have;
}
public void setCan_have(User can_have) {
	this.can_have = can_have;
}
public Post getContains() {
	return Contains;
}
public void setContains(Post contains) {
	Contains = contains;
}
  public void Print()
  {
	  System.out.print("Item Info: ");
	  System.out.print("Name : "+Name+", ");
	  System.out.print("Category : "+Category+", ");
	  System.out.print("Holdername : "+HolderName+".\n");
  }

}
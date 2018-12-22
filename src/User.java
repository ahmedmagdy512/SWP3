import java.util.Scanner;
import java.util.Vector;

public class User {

  public String UserName;
  public  UserAccess U;
  public String Password;
  public String Email;
  public Integer Age;
  public String Address;
  public User(User u)
  {
	this.UserName=u.UserName;
	this.Password=u.Password;
	this.Email=u.Email;
	this.Age=u.Age;
	this.Address=u.Address;
  }
public User()
{
	
}
public  UserAccess getU() {
	return U;
}
public void setU(UserAccess u) {
	U = u;
}


public void SetUserName(String UserName) {
	this.UserName=UserName;
  }

  public String GetUserName() {
  return UserName;
  }

  public void SetPassword(String Password) {
	  this.Password=Password;

  }

  public String GetPassword() {
  return Password;
  }

  public void SetAge(Integer Age) {
	  this.Age=Age;
  }

  public Integer GetAge() {
  return Age;
  }

  public void SetEmail(String Email) {
  this.Email=Email;
  }

  public String GetEmail() {
  return Email;
  }

  public void SetAddress(String Address) {
	  this.Address=Address;
  }

  public String GetAddress() {
  return Address;
  }
  public void Print()
  {
	  System.out.println("User's Info : ");
	  System.out.print(this.UserName+", "+this.Password+", "+this.Email+", "+this.Address+", "+this.Age);
  }
}
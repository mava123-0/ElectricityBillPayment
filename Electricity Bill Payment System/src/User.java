import java.util.Scanner;

abstract class User {
	private String phoneno;
	private String password;
	private Customer cust_user;
	private Admin admin_user;
	
	//create account
	public void createAccount() {
		Scanner scanner=new Scanner(System.in);
		
		//Validate Phone Number
		int phflag=0;
		while(phflag==0) {
			System.out.println("\nEnter Phone Number");
			String input_phone=scanner.next();
			if((input_phone.charAt(0)=='6' || input_phone.charAt(0)=='7' || input_phone.charAt(0)=='8' || input_phone.charAt(0)=='9') && input_phone.length()==10) {
				this.phoneno=input_phone;
				phflag=1;
			}
			else {
				System.out.println("Invalid Phone Number");
			}
		}
		
		
		//Validate Password
		int pasflag=0;
		while (pasflag==0) {
			System.out.println("Enter Password (Minimum 4 charaters)");
			String input_password=scanner.next();
			if(input_password.length()>=4) {
				this.password=input_password;
				pasflag=1;
			}
			else {
				System.out.println("Password too Short");
			}
		}
		
	}
	
	//login
	public void login(){
		Scanner scanner=new Scanner(System.in);
		
		//verification
		System.out.println("Enter your Phone Number");
		String verify_phone=scanner.next();
		System.out.println("Enter your Password");
		String verify_password=scanner.next();
		if(this.phoneno==verify_phone) {
			if(this.password==verify_password) {
				System.out.println("Login Successful");
			}
			else {
				System.out.println("Invalid Password");
			}
		}
		else {
			System.out.println("Invalid Phone Number");
		}
	}
	
	//set
	public void setPhno(String phoneNo) {
		this.phoneno=phoneNo;
	}
	public String getPhNo() {
		return this.phoneno;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return this.password;
	}
}


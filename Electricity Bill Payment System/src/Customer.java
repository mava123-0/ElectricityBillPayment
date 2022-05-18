import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Customer extends User{
	static int cust_counter=0;
	private int cust_id;
	private String cust_fname;
	private String cust_lname;
	private String dob;
	private Address cust_address;
	private Connection cust_connection;
	private card cust_card;
	private UPI cust_upi;
	private Feedback cust_feedback;
	private Bill cust_bill=new Bill();

	public void custGetInput() {
		Scanner scanner=new Scanner(System.in);
		cust_counter++;
		this.cust_id=cust_counter;
		System.out.println("Enter Customer First Name");
		this.cust_fname=scanner.next();
		System.out.println("Enter Customer Last Name");
		this.cust_lname=scanner.next();
		
		//date of birth
		int dateflag=0;
		while(dateflag==0) {
			System.out.println("Enter Customer DOB (dd/mm/yyyy)");
			this.dob=scanner.next();
			DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
			Date BOD=null;
			df.setLenient(false);
			
			try {
				BOD=df.parse(dob);
				dateflag=1;
			}
			catch(Exception e){
				System.out.println("Invalid Date");
			}
		}
		
		
		//address
		int pinflag=0;
		int pincode=0;
		System.out.println("Enter Customer City");
		String city=scanner.next();
		while(pinflag==0) {
			System.out.println("Enter Customer Pincode");
			try {
				pincode=scanner.nextInt();
				if(99999<pincode && pincode<=999999) {
					pinflag=1;
				}
				else {
					System.out.println("Invalid Pincode\n");
				}
			}
			catch(Exception e) {
				System.out.println("Exception "+e+" has occurred!!");
				break;
			}
			
		}
		scanner.nextLine();
		System.out.println("Enter Customer Street Name");
		String street_name=scanner.nextLine();
		int house_no=-1;
		System.out.println("Enter Customer House No");
		try {
			house_no=scanner.nextInt();
		}
		catch(Exception e) {
			System.out.println("Exception "+e+" has occurred!!");
		}
		this.cust_address=new Address(city,pincode,street_name,house_no);
		
		//connection
		int metnoflag=0;
		int meter_no=0;
		while(metnoflag==0) {
			try {
			System.out.println("Enter  Customer Meter Number");
			meter_no=scanner.nextInt();
			if (9999999<meter_no && meter_no<=99999999) {
				metnoflag=1;
			}
			else {
				System.out.println("Invalid Meter Number");
			}
			}
			catch(Exception e) {
				System.out.println("Exception "+e+" has occurred!!");
				continue;
			}
		}
		int meter_reading=0;
		int flag_met_reading=0;
		while(flag_met_reading==0) {
			System.out.println("Enter  Customer Meter Reading");
			meter_reading=scanner.nextInt();
			if(meter_reading>0) {
				flag_met_reading=1;
			}
			else {
				System.out.println("Invalid Meter Reading");
			}
		}
		
		
		int connection_status=1;
		while(connection_status!=0 && connection_status!=1) {
			System.out.println("Invalid Connection Status");
			System.out.println("Enter  Customer Connection Status (0/1)");
			connection_status=scanner.nextInt();
		}
		this.cust_connection=new Connection( meter_no,  meter_reading, connection_status);
		
		//Payment
		int pay_choice=0;
		while(pay_choice==0) {
			System.out.println("Enter to add 1.Card Details 2.UPI Details");
			try {
			pay_choice=scanner.nextInt();
			}
			catch(Exception e) {
				System.out.println("Exception "+e+" has occurred!!");
			}
			//Card Payment Details
			if( pay_choice==1) {
				int cno_flag=0;
				String cardno="";
				while(cno_flag==0) {
					System.out.println("Enter Card Number");
					cardno=scanner.next();
					if(cardno.length()==16) {
						cno_flag=1;
					}
					
					else {
						System.out.println("Invalid Card Number\n");
					}
				}
				int cvv_flag=0;
				int cvv=0;
				while(cvv_flag==0) {
					System.out.println("Enter CVV");
					cvv=scanner.nextInt();
					if(99<cvv && cvv<=999) {
						cvv_flag=1;
					}
					else {
						System.out.println("Invalid CVV");
					}
				}
				
				String expiry="";		
				int dateflag1=0;
				while(dateflag1==0) {
					System.out.println("Enter Expiry Date (dd/mm/yyyy)");
					expiry=scanner.next();
					DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
					Date BOD=null;
					df.setLenient(false);
					
					try {
						BOD=df.parse(expiry);
						dateflag1=1;
					}
					catch(Exception e){
						System.out.println("Invalid Date");
					}
				}
				this.cust_card=new card(cardno,cvv,expiry);
			}
			
			//UPI Payment Details
			else if (pay_choice==2){
				System.out.println("Enter UPI Id");
				String upi_accountname=scanner.next();
				
				String upi_phonenumber="";
				int phflag1=0;
				while(phflag1==0) {
					System.out.println("Enter Phone Number");
					upi_phonenumber=scanner.next();
					if((upi_phonenumber.charAt(0)=='6' || upi_phonenumber.charAt(0)=='7' || upi_phonenumber.charAt(0)=='8' || upi_phonenumber.charAt(0)=='9') && upi_phonenumber.length()==10) {
						phflag1=1;
					}
					else {
						System.out.println("Invalid Phone Number");
					}
				};
				this.cust_upi=new UPI(upi_accountname,upi_phonenumber);
			}
			else {
				System.out.println("Invalid Input\n");
			}
		}
		
	}
	public void setCustId(int cust_id) {
		this.cust_id=cust_id;
	}
	public void setFname(String cust_fname) {
		this.cust_fname=cust_fname;
	}
	public void setLname(String cust_lname) {
		this.cust_lname=cust_lname;
	}
	public void setDOB(String dob) {
		this.dob=dob;
	}
	public void setAddress(String city,  int pincode,String street_name,int house_no) {
		this.cust_address=new Address(city,pincode,street_name,house_no);
	}
	public void setConnectionStatus(int x) {
		this.cust_connection.setConnection(x);
	}
	public void setCard(String cardno, int cvv, String expirydate) {	
		this.cust_card=new card(cardno,cvv,expirydate);
	}
	public void setUPI(String accountname , String phoneno) {
		this.cust_upi=new UPI( accountname, phoneno);
	}
	public void setFeedback(String feedback) {
		this.cust_feedback= new Feedback(feedback);
	}
	
	//Customer Bill
	public void setCustomerBill() {
		cust_bill.newBill(this);
	}
	public Bill getCustomerBill() {
		return cust_bill;
	}
	public void viewCustomerBill() {
		cust_bill.viewBill();
	}
	
	public int getCustId() {
		return this.cust_id;
	}
	public String getFname() {
		return this.cust_fname;
	}
	public String getLname() {
		return this.cust_lname;
	}
	
	public String getDOB() {
		return this.dob;
	}
	public Address getAddress() {
		return this.cust_address;
	}
	public Connection getConnection() {
		return this.cust_connection;
	}
	public card getCard() {
		return this.cust_card;
	}
	public UPI getUPI() {
		return this.cust_upi;
	}
}

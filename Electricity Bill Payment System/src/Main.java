import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Customer[] cust_arr=new Customer[100];
		Admin[] admin_arr=new Admin[100];
		int cust_count=-1;
		int admin_count=-1;
		Bill b1=new Bill();
		
		//Menu
		char ch='y';
		while (ch=='y') {
			int menu_in=-1;
			Scanner scanner=new Scanner(System.in);
			System.out.println("--------------------------------");
			System.out.println("Menu \n1.Register \n2.Login \n0.Exit");
			System.out.println("--------------------------------");
			try {
				menu_in=scanner.nextInt();
			}
			catch(Exception e) {
				System.out.println("Exception "+e+" occured!!");
				
			}
			switch(menu_in) {
			
				case 0: 
					ch='n';
					break;
					
				case 1: 
					System.out.println("\nRegister as \n1.Customer \n2.Admin \n0.Exit");
					int register_menu=-1;
					try {
					register_menu=scanner.nextInt();
					}
					catch(Exception e) {
						System.out.println("Exception "+e+" has occured!!\n");
						continue;
					}
					switch(register_menu) {
					
						case 1: {
							cust_count++;
							cust_arr[cust_count]=new Customer();
							cust_arr[cust_count].createAccount();
							cust_arr[cust_count].custGetInput();
							System.out.println("\nAccount Created!!\n");
							break;
						}
						
						case 2:
							admin_count++;
							admin_arr[admin_count]=new Admin();
							admin_arr[admin_count].createAccount();
							System.out.println("\nAccount Created!!\n");
							break;
							
						case 0:
							break;
						default:
							System.out.println("Invalid Input");
							break;
					}
					break;
				case 2:
							System.out.println("\nEnter Phone Number:");
							String login_phone=scanner.next();
							System.out.println("Enter Password: ");
							String login_password=scanner.next();
							System.out.println("\nChoose:\n1.Customer \n2.Admin");
							int login_choose=scanner.nextInt();
							switch(login_choose) {
							
							case 1:
								//Customer Login 
								//i is customer obj number in array
								int i=0;
								int flag_phno=0;
								int flag_pass=0;
								for (int ij=0;ij<(cust_arr.length);ij++){
									if(cust_arr[ij]==null) {
										break;
									}
									else {
									if(login_phone.equalsIgnoreCase(cust_arr[ij].getPhNo())) {
										flag_phno=1;
										if(login_password.equalsIgnoreCase(cust_arr[ij].getPassword())) {
											flag_pass=1;
											System.out.println("Login Successful");
											i=ij;
											break;
										}
									}
									}
								}
								if(flag_phno==0) {
									System.out.println("Invalid Credentials");
								}
								else if(flag_phno==1 && flag_pass==0) {
									System.out.println("Invalid Password");
								}
								else if(flag_phno==1 && flag_pass==1) {
											char log_ch='y';
											while(log_ch=='y') {
												System.out.println("\n--------------------------------");
												System.out.println("Menu \n1.View Profile \n2.Change Card Details \n3.Change UPI Details \n4.Give Feedback \n5.View Bill \n6.Pay Bill \n7.View Announcements \n8.Log Out");
												System.out.println("--------------------------------");
												int cust_menu=scanner.nextInt();
												switch(cust_menu) {
												
													case 1:
														//View Profile
														System.out.println("\n--------------------------------");
														System.out.println("Id: "+cust_arr[i].getCustId());
														System.out.println("Meter Number: "+cust_arr[i].getConnection().getMeterNo());
														System.out.println("\nName: "+cust_arr[i].getFname()+" "+cust_arr[i].getLname());
														System.out.println("Date Of Birth: "+cust_arr[i].getDOB());
														System.out.println("Phone Number: "+cust_arr[i].getPhNo());
														System.out.println("\nHouse No: "+cust_arr[i].getAddress().getHouseNo());
														System.out.println("Street Name: "+cust_arr[i].getAddress().getStreetName());
														System.out.println("City: "+cust_arr[i].getAddress().getCity());
														System.out.println("Pincode: "+cust_arr[i].getAddress().getPincode());
														System.out.println("--------------------------------");
														break;
														
													case 2:
														
														//Card Details
														int cno_flag=0;
														String cardno="";
														while(cno_flag==0) {
															System.out.println("\nEnter Card Number");
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
														cust_arr[i].setCard(cardno, cvv, expiry);
														break;
													
													case 3:
														//UPI Details
														System.out.println("\nEnter UPI Id");
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
														cust_arr[i].setUPI(upi_accountname,upi_phonenumber);
														break;
														
													case 4:
														//Give Feedback
														scanner.nextLine();
														System.out.println("\nEnter Feeback");
														String cus_feedback=scanner.nextLine();
														cust_arr[i].setFeedback(cus_feedback);
														System.out.println("Thank You for your Feedback");
														break;
													
													case 5:
														//View Bills
														
														if(cust_arr[i].getCustomerBill()==null) {
															System.out.println("No Bills");
														}
														else {
															cust_arr[i].viewCustomerBill();
														}
														break;
													case 6:
														if(cust_arr[i].getCustomerBill()==null) {
															System.out.println("No Bills");
														}
														else {
															cust_arr[i].getCustomerBill().payBill();
														}
														break;
													case 7:
														//View Announcements 
														Announcement.viewAnnouncement();
														break;
													case 8:
														log_ch='n';
														break;
													default: 
														System.out.println("Invalid Input");
														break;
												}
											}
										}
							break;
							
							case 2 :
								//Admin Login
								int admin_i=0;
								int admin_flag_phno=0;
								int admin_flag_pass=0;
								for (int ik=0;ik<(admin_arr.length);ik++){
									if(admin_arr[ik]==null) {
										break;
									}
									else {
									if(login_phone.equalsIgnoreCase(admin_arr[ik].getPhNo())) {
										admin_flag_phno=1;
										if(login_password.equalsIgnoreCase(admin_arr[ik].getPassword())) {
											admin_flag_pass=1;
											admin_i=ik;
											System.out.println("Login Successful");
											break;
										}
									}
									}
								}
								if(admin_flag_phno==0) {
									System.out.println("Invalid Credentials");
								}
								else if(admin_flag_phno==1 && admin_flag_pass==0) {
									System.out.println("Invalid Password");
								}
								else if (admin_flag_phno==1 && admin_flag_pass==1) {
											char log_ch='y';
											while(log_ch=='y') {
												System.out.println("\n--------------------------------");
												System.out.println("Menu \n1.View Profile \n2.Create Bill \n3.View Customers \n4.View Feedback \n5.Create Announcement \n6.Update Customer Connection \n7.Set Current Price \n8.Log Out");
												System.out.println("--------------------------------");
												int admin_menu=scanner.nextInt();
												switch(admin_menu) {
												
													case 1:
														//Admin Profile
														System.out.println("\nId: "+admin_arr[admin_i].getAdminId());
														System.out.println("Name: "+admin_arr[admin_i].getAdminName());
														System.out.println("Phone Number: "+admin_arr[admin_i].getPhNo());
														break;
													case 2:
														//Create Bill
														
														if(cust_arr==null) {
															System.out.println("No Customers Found");
														}
														
														else {
															System.out.println("\nEnter Customer Id: ");
															int cust_topay=scanner.nextInt();
															int bill_flag=0;
															for (int j=0;j<cust_arr.length;j++) {
																if(cust_arr[j]==null) {
																	break;
																}
																else {
																	if(cust_topay==cust_arr[j].getCustId()) {
																		cust_arr[j].getCustomerBill().newBill(cust_arr[j]);
																		bill_flag=1;
																		break;
																	}
																}
															}
															if(bill_flag==0) {
																System.out.println("No Customer Found");
															}
														}
														break;
													case 3:
														//View Customers
														if(cust_arr.length==0) {
															System.out.println("\nNo Users Found");
														}
														else {
															for (int k=0;k<cust_arr.length;k++) {
																if(cust_arr[k]==null) {
																	break;
																}
																else {
																	System.out.println("\nCustomer Id: "+cust_arr[k].getCustId());
																	System.out.println("Customer Name: "+cust_arr[k].getFname()+" "+cust_arr[k].getLname());
																	System.out.println("Meter No: "+cust_arr[k].getConnection().getMeterNo());
																}
															}
														}
														break;
													case 4:
														//View Feedbacks
														Feedback.viewFeedback();
														break;
													case 5:
														//Create Announcements
														scanner.nextLine(); 
														System.out.println("Enter the Announcement");
														String announcement=scanner.nextLine();
														Announcement a1=new Announcement(announcement);
														break;
													case 6:
														//Update Customer Connection Status
														if(cust_arr==null) {
															System.out.println("No Customers Found");
														}
														else {
															System.out.println("Enter the Customer Id");
															int admin_cust_conn=scanner.nextInt();
															for (int p=0;p<cust_arr.length;p++) {
																if(cust_arr[p]==null) {
																	break;
																}
																else {
																	if(admin_cust_conn==cust_arr[p].getCustId()) {
																		cust_arr[p].getCustomerBill().viewBill();
																		System.out.println("\nEnter the Connection Status to be set (0/1): ");
																		int admin_conn_status=scanner.nextInt();
																		if(admin_conn_status==0) {
																			cust_arr[p].setConnectionStatus(admin_conn_status);
																			System.out.println("\nCustomer Connection Terminated");
																		}
																		else if(admin_conn_status==1) {
																			cust_arr[p].setConnectionStatus(admin_conn_status);
																			System.out.println("\nCustomer Connection Continued");
																		}
																		else {
																			System.out.println("\nInvalid Connection Status");
																		}
																	}
																}
															}
														}
														break;
													case 7:
														System.out.println("Enter the new Current Rate: ");
														float price=scanner.nextFloat();
														Bill.setCurrentRate(price);
														break;
													case 8:
														log_ch='n';
														break;
													default:
														System.out.println("\nInvalid Admin Menu Input");
												}
											}
								}
								break;
							default:
								System.out.println("Invalid Input");
								break;
							}
							break;
				default:
					System.out.println("Invalid Input");
					break;
			}
		}
	}
}
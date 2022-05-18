import java.util.Scanner;

public class Admin extends User{
	static int admin_counter=0;
	private int admin_id;
	private String admin_name;
	Announcement admin_announcement;
	private String announcement_content;
	
	Admin(){
		Scanner scanner=new Scanner(System.in);
		admin_counter++;
		this.admin_id=admin_counter;
		System.out.println("Enter Admin Name");
		this.admin_name=scanner.next();
	}
	
	public int getAdminId() {
		return this.admin_id;
	}
	
	public String getAdminName() {
		return this.admin_name;
	}
	
	//announcement
	public void createAnnouncement() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Announcement Content");
		this.announcement_content=scanner.next();
		Announcement admin_announcement=new Announcement(this.announcement_content);
	}
	public String viewAnnouncement() {
		return this.announcement_content;
	}
	
	//Change Customer Connection Status
	public void chanegeCustomerConnection(Customer cust) {
		Scanner scanner=new Scanner(System.in);
		int value=scanner.nextInt();
		cust.setConnectionStatus(value);
	}
}

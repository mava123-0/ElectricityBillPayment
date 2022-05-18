import java.util.Scanner;

public class Bill{
	private static int BillCounter=1101;
	private int BillId;
	private float Amount;
	private int prev_reading;
	private int current_reading;
	static float current_rate;
	private int  units_utilized;
	private String due_date;
	private String Bill_Status;
	Customer bill_cust;
	public void newBill(Customer bill_cust){
		Scanner scanner=new Scanner(System.in);
		this.BillId=BillCounter;
		BillCounter++;
		System.out.println("Enter the Units Utilized by Customer");
		this.units_utilized=scanner.nextInt();
		this.bill_cust=bill_cust;
		this.current_reading=bill_cust.getConnection().getMeterReading();
		this.prev_reading=this.current_reading-this.units_utilized;
		System.out.println("Enter the Due Date for the Bill");
		this.due_date=scanner.next();
		this.Bill_Status="Unpaid";
		this.Amount=(this.units_utilized*current_rate);
	}
	public void viewBill() {
		System.out.println("\n--------------------------------");
		System.out.println("Bill Id: "+this.BillId);
		System.out.println("Due Date: "+this.due_date);
		System.out.println("Customer Id: "+this.bill_cust.getCustId()+"\n");
		System.out.println("Previous Month Meter Reading: "+this.prev_reading);
		System.out.println("Current  Meter Reading: "+this.current_reading+"\n");
		System.out.println("Electricity Rate: Rs."+current_rate);
		System.out.println("Units Utilized: "+this.units_utilized);
		System.out.println("Due Date: "+this.due_date);
		System.out.println("Amount Due: Rs."+this.Amount);
		System.out.println("Bill Status: "+this.Bill_Status);
		System.out.println("--------------------------------");
	}
	public void paidbillStatus() {
		this.Bill_Status="Paid";
	}
	public static void setCurrentRate(float rate) {
		current_rate=rate;
	}
	public float getCurrentRate() {
		return current_rate;
	}
	public float getAmount() {
		return this.Amount;
	}
	public int getBillId() {
		return this.BillId;
	}
	public void payBill() {
		if(Bill_Status=="Unpaid") {
			System.out.println("Enter Mode of Payment\n1.Card\n2.UPI");
			Scanner scanner=new Scanner(System.in);
			int int_mode=scanner.nextInt();
			if(int_mode==1) {
				this.bill_cust.getCard().paybill(this);
			}
			else if (int_mode==2){
				this.bill_cust.getUPI().paybill(this);
			}
			else {
				System.out.println("Invalid Input");
			}
		}
	}
}
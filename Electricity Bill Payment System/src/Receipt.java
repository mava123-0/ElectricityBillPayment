import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.text.DateFormat;

public class Receipt {
	private static int ReceiptCounter=101;
	Bill recBill;
	private int Receipt_Id;
	private String mode;
	private String rec_date;
	
	Receipt(Bill rec_bill,String mode){
		this.Receipt_Id=ReceiptCounter;
		this.recBill=rec_bill;
		ReceiptCounter++;
		this.mode=mode;
		
		//Date Format
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.rec_date=String.format(dateFormat.format(date));
		this.recBill=rec_bill;
		viewReceipt();
	}
	
	public void viewReceipt() {
		System.out.println("\n");
		System.out.println("--------------------------------");
		System.out.println("Receipt Id: "+this.Receipt_Id);
		System.out.println("Mode of Payment: "+this.mode);
		System.out.println("Date and Time of Payment: "+this.rec_date+"\n");
		System.out.println("Bill Id: "+this.recBill.getBillId());
		System.out.println("Customer Id: "+this.recBill.bill_cust.getCustId());
		System.out.println("Customer Name: "+this.recBill.bill_cust.getFname()+" "+this.recBill.bill_cust.getLname());
		System.out.println("Customer Phone: "+this.recBill.bill_cust.getPhNo()+"\n");
		System.out.println("Amount Paid: Rs."+this.recBill.getAmount());
		System.out.println("--------------------------------");
	}
}

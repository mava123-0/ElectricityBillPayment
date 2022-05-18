public class UPI implements payment{
	private String accountName;
	private String phoneno;
	Bill pay_bill;
	Receipt pay_rec;
	
	UPI(String accountName,String phoneno) {
		this.phoneno=phoneno;
		this.accountName=accountName;
	}
	
	public String getUpiName() {
		return this.accountName;
	}
	
	public String getUpiPhno() {
		return this.phoneno;
	}
	public void paybill(Bill b1) {
		System.out.println("\nRs."+b1.getAmount()+" Paid for Bill #"+b1.getBillId()+" through Account:"+this.accountName+"\n");
		String mode="Card";
		b1.paidbillStatus();
		this.pay_rec=new Receipt(b1,mode);
	}
}

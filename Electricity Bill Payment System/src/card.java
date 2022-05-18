public class card implements payment {
	private String cardNo;
	private int CVV;
	private String expiry;
	Bill pay_bill;
	Receipt pay_rec;
	
	card(String cardNo,int CVV,String expiry) {
		this.cardNo = cardNo;
		this.CVV = CVV;
		this.expiry = expiry;
	}
	
	public String getcardNo() {
		return this.cardNo;
	}
	
	public int getCVV() {
		return this.CVV;
	}
	public String getexpiry() {
		return this.expiry;
	}
	public void paybill(Bill x) {
		System.out.println("\nRs."+x.getAmount()+" Paid for Bill #"+x.getBillId()+"\n");
		x.paidbillStatus();
		String mode="Card";
		this.pay_rec=new Receipt(x,mode);
	}
}
	


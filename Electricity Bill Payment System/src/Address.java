public class Address {
	private String city;
	private int pincode;
	private String street_name;
	private int house_no;
	Address (String city, int pincode, String street_name, int house_no){
		this.city=city;
		if(99999<pincode && pincode<=999999) {
			this.pincode=pincode;
		}
		else {
			System.out.println("Invalid Pincode");
		}
		this.street_name=street_name;
		this.house_no=house_no;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public void setPincode(int pincode) {
		if(99999<pincode && pincode<=999999) {
			this.pincode=pincode;
		}
		else {
			System.out.println("Invalid Pincode");
		}
	}
	public void setStreetName(String street_name) {
		this.street_name=street_name;
	}
	public void setHouseNo(int house_no) {
		this.house_no=house_no;
	}
	public String getCity() {
		return this.city;
	}
	public int getPincode() {
		return this.pincode;
	}
	public String getStreetName() {
		return this.street_name;
	}
	public int getHouseNo() {
		return this.house_no;
	}
}

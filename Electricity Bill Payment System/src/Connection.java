
public class Connection {
	private int meter_no;
	private int meter_reading;
	private int connection_status;
	Connection(int meter_no, int meter_reading,int connection_status) {
		if (9999999<meter_no && meter_no<=99999999) {
			this.meter_no=meter_no;
		}
		else {
			System.out.println("Invalid Meter Number");
		}
		this.meter_reading=meter_reading;
		if(connection_status==0 || connection_status==1) {
			this.connection_status=connection_status;
		}
		else {
			System.out.println("Invalid Connection Status (0/1)");
		}
	}
	public void setConnection (int connection_status) {
		this.connection_status=connection_status;
	}
	public int getConnection () {
		return this.connection_status;
	}
	public int getMeterNo() {
		return this.meter_no;
	}
	public int getMeterReading() {
		return this.meter_reading;
	}
}

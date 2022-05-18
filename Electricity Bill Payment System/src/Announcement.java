import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;   
import java.text.DateFormat;

public class Announcement {
	private String ann_content;
	private String ann_date;
	static ArrayList<String> Announcement_Array = new ArrayList<String>();
	
	Announcement(String content){
		this.ann_content=content;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		this.ann_date=String.format(dateFormat.format(date));
		
		Announcement_Array.add(this.ann_date);
		Announcement_Array.add(this.ann_content);
	}
	public static void viewAnnouncement() {
		int arr_size=Announcement_Array.size();
		if(arr_size==0) {
			System.out.println("No Announcements");
		}
		else if (arr_size>0) {
			for(int i=0;i<arr_size;i+=2) {
				System.out.println(Announcement_Array.get(i)+" "+Announcement_Array.get(i+1));
			}
		}
	}
}

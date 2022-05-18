import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;   
import java.text.DateFormat;

public class Feedback {
	private String Feedback_Content;
	static ArrayList<String> Feedback_Array = new ArrayList<String>();
	private String Feedback_Date;
	
	Feedback(){}
	
	Feedback(String Feedback_Content){
		this.Feedback_Content=Feedback_Content;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		this.Feedback_Date=String.format(dateFormat.format(date));
		
		
		Feedback_Array.add(this.Feedback_Date);
		Feedback_Array.add(this.Feedback_Content);
	}
	public static void viewFeedback() {
		int arr_size=Feedback_Array.size();
		if(arr_size==0) {
			System.out.println("No Feedbacks");
		}
		else if (arr_size>0) {
			for(int i=0;i<arr_size;i+=2) {
				System.out.println(Feedback_Array.get(i)+" "+Feedback_Array.get(i+1));
			}
		}
	}
}

package calender;

import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CalenderUtils {
	/**
     * {year:1990,months:[month:1, days:[{day:1,message:aa},{day:2,message:bb}]}
     */
    public static JSONObject getCalenderData() {
        JSONObject jsonObject = new JSONObject();

        Calendar calendar = Calendar.getInstance();
        String year=String.valueOf(calendar.get(Calendar.YEAR));
        try {
            jsonObject.put("year",year);
            JSONArray months = new JSONArray();
            for (int i = 0; i < 12; i ++) {
                JSONObject month = new JSONObject();
                month.put("month", i + 1);
                calendar.set(Calendar.MONTH,i);
                int daysCount = calendar.getActualMaximum(Calendar.DATE);
                JSONArray days = new JSONArray();
                for (int j = 1; j <= daysCount; j ++) {
                    JSONObject day = new JSONObject();
                    day.put("day",j);
                    day.put("message",j+"D");
                    days.put(day);
                }
                month.put("days", days);
                months.put(month);
            }
            jsonObject.put("moths", months);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    
    
    public static void main(String[] args) {
    	JSONObject jsonObject = getCalenderData();
    	System.out.println(jsonObject.toString());
	}
    
    
}

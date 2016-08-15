package test1;

import org.json.JSONObject;

public class Test1 {
	public static void main(String[] args) {
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("a", "b");
			System.out.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

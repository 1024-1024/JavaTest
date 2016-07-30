package mystatic;

public class MyStatic {
	
	public static String para = "aaaa";
	
	static {
		System.out.println(para);
		System.out.println("bbbb");
	}
	
	{
		System.out.println("ccc");
	}
	
	public static void main(String[] args) {
		
	}
}

package method;

public class TestStatic extends FinalClass{

	public static String str1;
	public static String str2;
	public String username;
	
	public static void main(String[] args) {
		TestStatic t1 = new TestStatic();
		TestStatic.str1 ="002B";
		System.out.println(t1.getCode());
		System.out.println(t1.getStr1());
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
		
		TestStatic t2 = new TestStatic();
		System.out.println(t2.getCode());
		System.out.println(t2.getStr1());
		
		System.out.println(t2.test1());
		
	}

	public static String test1() {
		return name;
	}
	
	
	
	
	
	
	public static String getStr1() {
		return str1;
	}

	public static void setStr1(String str1) {
		TestStatic.str1 = str1;
	}

	public static String getStr2() {
		return str2;
	}

	public static void setStr2(String str2) {
		TestStatic.str2 = str2;
	}

}

package practice;

public class SingleTonTest {
	private static SingleTonTest singleton;
	private SingleTonTest(String name) {
		System.out.println(name);
	}
	public void add(int a,int b) {
		System.out.println(a+b);	
	}
	public static SingleTonTest accessClass() {
		singleton=new SingleTonTest("Tyss");
		return singleton;
	}

}

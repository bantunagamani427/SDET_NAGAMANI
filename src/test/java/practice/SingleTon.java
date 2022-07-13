package practice;

public class SingleTon {
private static SingleTon singleton;
private SingleTon(String name) {
	System.out.println(name);
}
public void add(int a,int b) {
System.out.println(a+b);	
}
public static SingleTon accessClass() {
singleton=new SingleTon("Tyss");
return singleton;
}
	
}

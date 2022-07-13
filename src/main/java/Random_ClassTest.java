import java.util.Random;

import com.github.javafaker.Faker;

public class Random_ClassTest {

	public static void main(String[] args) {
Faker faker=new Faker();
Random random=new Random();
int number=random.nextInt(100);
System.out.println(number);
String mainname ="mamababy";
//String name=faker.name().firstName();
String suffix="@gamil.com";
String emailID=mainname+number+suffix;
System.out.println(emailID);
System.out.println("*********");
String company="mamababy";
String companyname=faker.company().profession();
String wipro=company+" "+companyname;
System.out.println(wipro);
	}

}

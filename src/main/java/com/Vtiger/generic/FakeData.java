package com.Vtiger.generic;

import java.util.Random;

import com.github.javafaker.Faker;

/**
 * @author reamer
 * @Description :This class is going to create fake data which is required for test execution.
 * 
 */

public class FakeData {
Faker faker=new Faker();	
/**
 * 	@author reamer
 * @ Description : This method is going to create random first name
 * @ return String Type of Random name
 */
public String firstname() {
return faker.name().firstName();	
}
/**
 * @author reamer
 * @return 
 * @ Description : This method is going to create random last name
 * @return String type of Random name
 */
public String lastname() {
return	faker.name().lastName();
}
/**
 * @author reamer
 * @ Description : This method is going to create random organization name
 * @return String type of Random organization name
 */
public String orgname() {
	return faker.company().name();
}

/**
 * @author reamer
 *@Description :This class is going to  generate random number
 *return integer type of number
 */
Random random=new Random();
 int number=random.nextInt(1000);
}

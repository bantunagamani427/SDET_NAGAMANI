package com.Vtiger.generic;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

/**
 * @author reamer
 * @Description :This class is going to create fake data which is required for test execution.
 * 
 */
public class Faker1 {

	@Test
	public void faker()
	{
      Faker faker = new Faker();
		System.out.println(faker.name().firstName());

		System.out.println(faker.name().lastName());

		System.out.println(faker.phoneNumber().cellPhone());

		System.out.println(faker.address().fullAddress());

		System.out.println(faker.company().industry());
		System.out.println(faker.name().firstName());
		System.out.println(faker.company().name());
		}}
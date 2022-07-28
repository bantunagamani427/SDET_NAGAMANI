package YT_Listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
@Test
public void loginByEmail() {
	System.out.println("login by Email");
	Assert.assertEquals("naga", "naga");//true
}

@Test
public void loginByFacebook() {
	System.out.println("login by facebook");
	Assert.assertEquals("naga", "mani");
}
}

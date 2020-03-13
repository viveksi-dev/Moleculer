package molecular;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelloWorld_Main extends HelloWorld{
	
	

	@Test
	public void Molecular() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("GreeterService"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("ExecuteButton"))).click();
		Thread.sleep(3000);
		String Moleculertxt = driver.findElement(By.xpath(prop.getProperty("HelloMoleculerText"))).getText();
		System.out.println(Moleculertxt);
		if(Moleculertxt.equalsIgnoreCase("Hello Moleculer")) {
			System.out.println("Successfully Found the text:" +"       "  +"Printing text in the output:"+ "     " +Moleculertxt);
		}else {
			System.out.println("Text not found");
		}
	}
}

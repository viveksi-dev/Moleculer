package molecular;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelloWorld_Main extends HelloWorld{
	
	

	@Test
	public void Molecular() {
		driver.findElement(By.xpath(prop.getProperty("GreeterService"))).click();
		driver.findElement(By.xpath(prop.getProperty("ExecuteButton"))).click();
		String Moleculertxt = driver.findElement(By.xpath(prop.getProperty("HelloMoleculerText"))).getText();
		if(Moleculertxt.equalsIgnoreCase("Hello Moleculer")) {
			System.out.println("Successfully Found the texts" + "Printing text in the output" +Moleculertxt);
		}else {
			System.out.println("Text not found");
		}
	}
}

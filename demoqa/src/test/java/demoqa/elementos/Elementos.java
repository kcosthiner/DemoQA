package demoqa.elementos;

import org.openqa.selenium.By;

public class Elementos {
	
	public By userName = By.xpath("//input[@id = 'userName']");
	public By userEmail = By.xpath("//input[@id = 'userEmail']");
	public By currentAddress = By.xpath("//textarea[@id = 'currentAddress']");
	public By permAdress = By.xpath("//textarea[@id = 'permanentAddress']");
	public By btnSubmit = By.xpath("//button[@id = 'submit']");
	public By nameCapturado = By.id("name");
	public By menuElements = By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div/div[3]/h5");
	public By btnTextBox = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/span");
}

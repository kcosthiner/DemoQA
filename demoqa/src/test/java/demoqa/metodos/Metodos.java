package demoqa.metodos;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import demoqa.drivers.DriversFactory;

public class Metodos extends DriversFactory {
	
	 
	public void clicar(By elemento) {
	
		driver.findElement(elemento).click();
	}
	
	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);;
	}
	
	public void scroll(int n1, int  n2) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+n1+","+n2+")");
	}

	
	public void clicarPorTexto(String atributo, String texto) {
		driver.findElement(By.xpath("//"+atributo+ "[text() ='"+texto+"']"));
	}

	
	public void tirarEvidencia(String nomeEvidencia) {
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./evidencias/" +nomeEvidencia+".png" );
		
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void validarTexto(By elemento,String textoEsperado) {
		String textoCapturado = driver.findElement(elemento).getText();
		assertTrue(textoCapturado.contains(textoEsperado));	
	}
	
	public void fecharNavegador() {
		driver.quit();
	}
	
	

}

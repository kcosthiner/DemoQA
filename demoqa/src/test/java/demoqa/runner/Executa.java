package demoqa.runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import demoqa.drivers.DriversFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(

		// caminho das features - Documenta��o cucumber
		features = "src/test/resources/features",

		// informar qual package iremos implementar os testes
		glue = "demoqa.steps",

		// informar qual tag da documenta��o cucumber ser� executada
		tags = "@cadastro",

		// retirar caracteres especiais do console, para n�o ficar poluido
		monochrome = true,

		// quando usamos o valor TRUE ele n�o executa o teste, apenas valida
		// se existe algum cenario do arquivo feature sem implementacao
		// Quando � FALSE ele executa o teste normalmente
		dryRun = false,

		// Pretty serve para deixar a visualiza��o do console com padr�o do cucumber
		// html:target serve para criar um relat�rio de testes
		plugin = { "pretty", "html:target/cucumber-report.html" },

		// serve para deixar os nossos metodos sem _ no padrao java
		snippets = SnippetType.CAMELCASE

)

public class Executa extends DriversFactory {

	public static void abrirNavegador() {
		String url = "https://demoqa.com/";
		String navegador = "Chrome";

		if (navegador.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (navegador.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Digite chrome ou firefox");
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

	
	
}


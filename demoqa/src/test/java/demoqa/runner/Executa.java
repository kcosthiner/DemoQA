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

		// caminho das features - Documentação cucumber
		features = "src/test/resources/features",

		// informar qual package iremos implementar os testes
		glue = "demoqa.steps",

		// informar qual tag da documentação cucumber será executada
		tags = "@cadastro",

		// retirar caracteres especiais do console, para não ficar poluido
		monochrome = true,

		// quando usamos o valor TRUE ele não executa o teste, apenas valida
		// se existe algum cenario do arquivo feature sem implementacao
		// Quando é FALSE ele executa o teste normalmente
		dryRun = false,

		// Pretty serve para deixar a visualização do console com padrão do cucumber
		// html:target serve para criar um relatório de testes
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


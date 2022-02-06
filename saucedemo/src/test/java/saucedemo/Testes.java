// Pacotes
package saucedemo;

//Bibliotecas
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Classes
public class Testes {

		String url;
		WebDriver driver;
		
		@Before
		public void iniciar() {
			url = "https://www.saucedemo.com/";
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitto\\eclipse-workspace\\sensedata\\saucedemo\\drivers\\chrome\\98\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
			driver.manage().window().maximize();
		}
		
		@After
		public void finalizar() {
			driver.quit();
		}
		
		@Test
		public void checkout() {
			driver.get(url);
			
			//LOGIN
			driver.findElement(By.id("user-name")).clear();
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
				//screenshot LOGIN
			File login = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(login,new File("C:\\Users\\vitto\\eclipse-workspace\\sensedata\\saucedemo\\screenshots\\1-login.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}						
			driver.findElement(By.id("login-button")).click();
			
			//seleção de ORDENAÇÃO (Price (low to high))		
			WebElement selectElement = driver.findElement(By.cssSelector("select.product_sort_container"));
			Select selectObject = new Select(selectElement);
			selectObject.selectByVisibleText("Price (low to high)");
				//screenshot ORDENAÇÃO
			File ordena = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(ordena,new File("C:\\Users\\vitto\\eclipse-workspace\\sensedata\\saucedemo\\screenshots\\2-ordena.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//colocando itens no CARRINHO
			driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
			driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
				//screenshot CARRINHO
			File inserir = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(inserir,new File("C:\\Users\\vitto\\eclipse-workspace\\sensedata\\saucedemo\\screenshots\\3-inserir_carrinho.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//acessando CHECKOUT
			driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
			driver.findElement(By.id("checkout")).click();
				//screenshot CHECKOUT
			File checkout = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(checkout,new File("C:\\Users\\vitto\\eclipse-workspace\\sensedata\\saucedemo\\screenshots\\4-checkout.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//CHECKOUT: YOUR INFORMATION
			driver.findElement(By.id("first-name")).clear();
			driver.findElement(By.id("first-name")).sendKeys("Jose");
			driver.findElement(By.id("last-name")).clear();
			driver.findElement(By.id("last-name")).sendKeys("Silva");
			driver.findElement(By.id("postal-code")).clear();
			driver.findElement(By.id("postal-code")).sendKeys("01010000");
				//screenshot YOUT INFORMATION
			File info = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(info,new File("C:\\Users\\vitto\\eclipse-workspace\\sensedata\\saucedemo\\screenshots\\5-your_information.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver.findElement(By.id("continue")).click();
			
			//CHECKOUT: OVERVIEW
				//screenshot OVERVIEW
			File overview = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(overview,new File("C:\\Users\\vitto\\eclipse-workspace\\sensedata\\saucedemo\\screenshots\\6-overview.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver.findElement(By.id("finish")).click();
			//CHECKOUT: COMPLETE!
				//screenshot COMPLETE!
			File complete = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(complete,new File("C:\\Users\\vitto\\eclipse-workspace\\sensedata\\saucedemo\\screenshots\\7-complete.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver.findElement(By.id("back-to-products")).click();
			//screenshot RETORNO A LISTA DE PRODUTOS
			File retorno = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(retorno,new File("C:\\Users\\vitto\\eclipse-workspace\\sensedata\\saucedemo\\screenshots\\8-retorno_lista.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class LoginPage {

  WebDriver driver;
  public LoginPage (){
    PageFactory.initElements(Driver.getDriver(),this);
  }
  @FindBy(id = "prependedInput")
  WebElement userName;


  @FindBy(id = "prependedInput2")
  WebElement passWord;

  @FindBy(xpath = "//*[@class='btn btn-uppercase btn-primary pull-right']")
  WebElement login;

  @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]/a/span")
  WebElement fleet;

  @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span")
  WebElement vehicle;

  @FindAll(@FindBy(xpath = "//table/thead/tr/th"))
  List<WebElement> LisencePlate;



  @Test
  public void loginTest() throws InterruptedException{
    userName.sendKeys("storemanager61");
    Thread.sleep(1000);
    passWord.sendKeys("UserUser123");
    Thread.sleep(1000);
    login.click();
    String expectedTitle="Dashboard";
    if(expectedTitle.equals(Driver.getDriver().getTitle())){
     System.out.println("Successfully PASS");
   }else{
     System.out.println("FAILED");
    }
    System.out.println(Driver.getDriver().getTitle());

    Thread.sleep(2000);
    fleet.click();

    Thread.sleep(1000);
    vehicle.click();

    Thread.sleep(500);

    for (int i=0;i<8;i++) {
      String each= LisencePlate.get(i).getText();
      System.out.println(each);
    }

  }


}

package org.qa.test;

import com.qa.base.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AUTHAPITEST extends Base {
    Base testbase;
    String serviceurl;
    String apiurl;
    String url;
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        testbase= new Base();
        serviceurl= prop.getProperty("URL");
        apiurl=prop.getProperty("serviceURL");
        url=serviceurl+apiurl;
    }
@Test
    public void auth()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
        RequestSpecification request = RestAssured.given();
        Response response=  request.get();
        System.out.println("status code " +response.getStatusCode());
        System.out.println("msg " +response.body().asString());
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nisum\\Downloads\\chrome_driver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("http://ToolsQA:TestPassword@restapi.demoqa.com/authentication/CheckForAuthentication");
    }
}

package org.qa.test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.Base;
import com.qa.client.RestClient;
import com.qa.data.Users;
import groovy.json.JsonException;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PostApiTest extends Base {


    Base testbase;
    String serviceurl;
    String apiurl;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeMethod
    public void setup() {
        testbase= new Base();
        serviceurl= prop.getProperty("URL");
        apiurl=prop.getProperty("serviceURL");
        url=serviceurl+apiurl;
    }

@Test
    public void PostApiTest() throws IOException, JsonGenerationException, JsonMappingException, JsonException, JSONException {
    restClient= new RestClient();
    HashMap<String,String> headerMap= new HashMap<String, String>();
    headerMap.put("Content-Type","application/json");
    ObjectMapper mapper= new ObjectMapper();
   Users users =new Users("suma","QA");  //expected result

   //object into josn file
  mapper.writeValue(new File("E:\\09July\\rest\\src\\main\\java\\com.qa.data\\users.json"),users);

String userJsonString =mapper.writeValueAsString(users);
System.out.println(userJsonString);

    closeableHttpResponse=restClient.post(url,userJsonString,headerMap); //call the api
//validate the status code

  int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();


    Assert.assertEquals(statusCode,Base.RESPONSE_STATUS_CODE_201);

//validate the json response
   String responseString= EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");

    JSONObject responseJson=new JSONObject(responseString);
    System.out.println("The resopnse Of Api is " +responseJson);

    //json to java object
    Users userResobj=mapper.readValue(responseString,Users.class);  //actual user object

    System.out.println(userResobj);
    System.out.println(users.getJob().equals(userResobj.getJob()));
    System.out.println(users.getName().equals(userResobj.getName()));
    System.out.println(users.getid());
    System.out.println(users.getCreatedAt());

}

}

package com.qa.client;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    //GET Metod
    public void get(String url) throws ClientProtocolException, IOException, JSONException {
        CloseableHttpClient httpClient=HttpClients.createDefault();

        HttpGet httpget= new HttpGet(url); // return get request

        CloseableHttpResponse closeableHttpResponse =httpClient.execute(httpget);// hit the get url
       // int statusCode = CloseableHttpResponse.getStatusLine().getStatusCode();

       // System.out.println(statusCode);

        String  responsestring=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");

        JSONObject jsonObject=new JSONObject(responsestring);

        System.out.println("Resopnse JSON object " +jsonObject);

        Header[] headerarray=closeableHttpResponse.getAllHeaders();

        HashMap<String,String> allheaders=new HashMap<String, String>();

        for(Header  header:headerarray)
        {
            allheaders.put(header.getName(),header.getValue());
        }
        System.out.println("headers are" +allheaders);

    }
    //post method
    public CloseableHttpResponse post(String url,String entityString,HashMap<String,String> headermap) throws ClientProtocolException, IOException
    {
        CloseableHttpClient httpClient=HttpClients.createDefault();
        HttpPost httppost= new HttpPost(url);
        httppost.setEntity(new StringEntity(entityString));  //define the payload

        //Headers
        for(Map.Entry<String,String> entry:headermap.entrySet()){

            httppost.addHeader(entry.getKey(),entry.getValue());
        }

         CloseableHttpResponse closeableHttpResponse=httpClient.execute(httppost);
        return closeableHttpResponse;



    }

}

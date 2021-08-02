package com.example.corona_pro_map.publicData;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
public class ApiExplore {

    @GetMapping("/jsonapi")
    public String callApiWithJson(){
        StringBuffer result = new StringBuffer();
        try {
            String apiUrl = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?" +
                    "serviceKey=e182mugN8iX8RG8gO0xgR57jVZsKUJlJFs6sQT7dNszOQKQvePyRcJL1tODm2TBycA%2FI0obauEDEOkA6XinByA%3D%3D" +
                    "&numOfRows=10" +
                    "&pageNo=4";
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String returnLine;
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = XML.toJSONObject(result.toString());

        System.out.println("jsonObject.toString() = " + jsonObject.toString());

        return jsonObject.toString();
    }

}
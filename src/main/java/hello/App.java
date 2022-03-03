package hello;

import hello.http.HttpApache;
import hello.http.HttpWebClient;
import hello.http.httpClient.HttpPut;

public class App {
    public static void main(String[] args)
    {
        System.out.println("----------------app------------------");
//       HttpClientRequest.getSync();

//        HttpWebClient.get();
//        HttpApache.get();
        String data = "{\n  \"Id\": 12345,\n  \"Customer\": \"John Smith\",\n  \"Quantity\": 1,\n  \"Price\": 10.00\n}";

        HttpPut.put(data);
        System.out.println("----------------app end------------------");
    }


}

//https://www.geeksforgeeks.org/mapping-csv-to-javabeans-using-opencsv/



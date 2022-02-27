package hello;

import hello.http.HttpApache;
import hello.http.HttpWebClient;
import hello.http.httpClient.HttpPut;

public class App {
    public static void main(String[] args) throws Exception
    {
        System.out.println("----------------app------------------");
//       HttpClientRequest.getSync();

//        HttpWebClient.get();
//        HttpApache.get();

        HttpPut.process();
        System.out.println("----------------app end------------------");
    }


}

//https://www.geeksforgeeks.org/mapping-csv-to-javabeans-using-opencsv/



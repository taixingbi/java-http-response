package hello;


import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws Exception
    {
        System.out.println("----------------app------------------");
        HttpResponseService.getSync();
        System.out.println("----------------app end------------------");
    }


}

//https://www.geeksforgeeks.org/mapping-csv-to-javabeans-using-opencsv/



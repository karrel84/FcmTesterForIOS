package kr.co.karrel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class FcmPushTest {

    // Method to send Notifications from server to client end.

    public final static String AUTH_KEY_FCM = "AAAA_-6rjag:APA91bGMkjYIrTMbSg8_05IBs7JTT2Oq-M6pkVXksMd3ej5ArNSPROC5FsranYO3qUJdbvC2jUZtqLMhjuacLfqT2uhe-eDWe46TB-9jSJrR4IFzWqYd3rHwAe7b-yKvy-igdBd4eLAT";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    // userDeviceIdKey is the device id you will query from your database

	public static void pushFCMNotification(String token, String message)
            throws Exception {
        String authKey = AUTH_KEY_FCM; // You FCM AUTH key
        String FMCurl = API_URL_FCM;

        URL url = new URL(FMCurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + authKey);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        JSONObject info = new JSONObject();

        info.put("body", message); // Notification body

        json.put("notification", info);
        json.put("to", token); // deviceID
        
        try(OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "UTF-8")){
            wr.write(json.toString());
            wr.flush();
        }catch(Exception e){
        }

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        conn.disconnect();
    }


}
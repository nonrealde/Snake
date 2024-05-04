import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Scoreboard {
    public static String name = "Default";
    final static String POST_URL = "https://dev.nonreal.de/snake/write_data.php";
    final static String GET_URL = "https://dev.nonreal.de/snake/read_data.php";
    public static void sendScore(String name, int score) {
        String hostname = "Unknown";
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }
        
        Map < String, String > formData = new HashMap < > ();
        formData.put("name", name);
        formData.put("score", Integer.toString(score));
        formData.put("ident", hostname);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(POST_URL))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(HttpRequest.BodyPublishers.ofString(formatData(formData)))
            .build();
        CompletableFuture < HttpResponse < String >> futureResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        try {
            HttpResponse < String > response = futureResponse.get();
            System.out.println(response);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public static String formatData(Map < String, String > formData) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry < String, String > singleEntry: formData.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(singleEntry.getKey(), StandardCharsets.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(singleEntry.getValue(), StandardCharsets.UTF_8));
        }
        return sb.toString();
    }
}
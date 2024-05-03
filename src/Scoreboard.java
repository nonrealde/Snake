import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Scoreboard {

    @SuppressWarnings("deprecation")
    public static void sendScore(String name, int score) throws IOException {
        // URL url = new URL("https://dev.nonreal.de/snake/write_data.php");
        // URLConnection con = url.openConnection();
        // HttpURLConnection http = (HttpURLConnection) con;
        // http.setRequestMethod("POST");
        // http.setDoOutput(true);

        Map <String, String> arguments = new HashMap < > ();
        arguments.put("name", name);
        arguments.put("score", Integer.toString(score));
        StringJoiner sj = new StringJoiner("&");
        for (Map.Entry < String, String > entry: arguments.entrySet()) {
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
            byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            // http.setFixedLengthStreamingMode(length);
            // http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            // http.connect();
            // try (OutputStream os = http.getOutputStream()) {
            //     os.write(out);
            // }
        }
    }
        public static void sendScore2(String name, int score) throws IOException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dev.nonreal.de/snake/write_data.php"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
            Map <String, String> arguments = new HashMap < > ();
            arguments.put("name", name);
            arguments.put("score", Integer.toString(score));
            StringJoiner sj = new StringJoiner("&");
            for (Map.Entry < String, String > entry: arguments.entrySet()) {
                sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
                byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
                int length = out.length;
    
            }
    }
}
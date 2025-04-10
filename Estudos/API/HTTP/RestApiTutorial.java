import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class RestApiTutorial {

  public static void main(String[] args) throws InterruptedException, URISyntaxException, IOException{
   HttpClient client = HttpClient.newHttpClient();
   HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://viacep.com.br/ws/01001000/json/")).GET().build();
    
   HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

   
  
   
  }
}
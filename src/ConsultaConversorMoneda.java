import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversorMoneda {

    // URL Conversion de monedas + clave
    Dotenv dotenv = Dotenv.load();
    String url = "https://v6.exchangerate-api.com/v6/";
    String clave = dotenv.get("API_KEY");

    // Creando cliente HTTP
    HttpClient cliente = HttpClient.newHttpClient();

    public String obtenerTasa(String base, String target) throws IOException, InterruptedException {

        // Creando http request

        String urlFinal = url + clave + "/pair/" + base + "/" + target;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlFinal))
                .build();

        // Creando http response
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}

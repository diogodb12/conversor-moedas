import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoedas {
    private String json;

    public String getJson() {
        return json;
    }

    public void consultarApi(String moedaBase, String moedaAConverter) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/b7d659e97a52ceca2841089e/pair/" + moedaBase + "/" + moedaAConverter))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            this.json = response.body();
        } catch (Exception e) {
            System.out.println("Não foi possível consultar a API por um motivo desconhecido");
        }
    }

    public double taxaDeConversao(){

        JsonElement elemento = JsonParser.parseString(this.json);
        JsonObject objectRoot = elemento.getAsJsonObject();

        double taxa = objectRoot.get("conversion_rate").getAsDouble();

        return taxa;
    }
}



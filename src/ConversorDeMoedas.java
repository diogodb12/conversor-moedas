import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorDeMoedas {
    private String moedaBase;
    private String moedaAConverter;
    private double cotacao;

    public ConversorDeMoedas(){
    }

    public ConversorDeMoedas(Cotacao cotacao){
        this.moedaBase = cotacao.base_code();
        this.moedaAConverter = cotacao.target_code();
        this.cotacao = cotacao.conversion_rate();
    }

    public Cotacao consultarApi(String moedaBase, String moedaAConverter) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/b7d659e97a52ceca2841089e/pair/" + moedaBase + "/" + moedaAConverter))
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Cotacao.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível converter com essas moedas");
        }
    }

    public void chamarApi(String moedaBase, String moedaAConverter){
        Scanner valor = new Scanner(System.in);
        System.out.print("Digite o valor a ser convertido: ");
        double valorMoeda = valor.nextDouble();

        try {
            Cotacao novaCotacao = consultarApi(moedaBase, moedaAConverter);
            this.cotacao = novaCotacao.conversion_rate();
            double valorConvertido = converterMoeda(valorMoeda);
            System.out.println("Valor convertido: " + valorConvertido);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando o programa");
        }
    }

    public double converterMoeda(double valor){
        return valor * this.cotacao;
    }

}



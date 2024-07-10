import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiReader {

    //ele precisa me devolver a classe comman executor preenchida,
    // logo após de preencher a classe ApiBuffer com vários tipos de construtores

   public ApiFilter readApi(String currencyToBeConverted) throws IOException, InterruptedException {
       //opção aqui para, a partir do comando, fazer um request para a API

       // usarei CommandReader para me dizer qual é a currencyToBeConverted,e a qual é a targetCurrency

       String address;
       address = "https://v6.exchangerate-api.com/v6/"
               + "2a4b6f8d01a537d9f151bd4f" + "/latest/"
               + currencyToBeConverted;

       HttpResponse<String> response;

       HttpClient client = HttpClient.newHttpClient();

       HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();

       response = client.send(request, HttpResponse.BodyHandlers.ofString());

       //uma string chamada json que tem os conteúdos do arquivo json gerado pelo respose.body()

       // Será usada para fazer as classes nesse código a partir da API escolhida. O client.send,
       // que nos RETORNA uma classe abstrata chamada HttpClient, que retorna uma String
       //com o conteúdo no formato Json com o método body().

       String json = response.body();


       //printa a String do arquivo Json no terminal
       System.out.println("/n" + json);

       //coloquei um arquivo jar chamado json nesse projeto para conseguir usar a classe Gson,
       // que é capaz de converter um arquivo em Json (tem que ser uma String) para classes em Java,
       //o qye é essencial para que o código consiga fazer algo efetivo com as APIs usadas.

       Gson gson = new GsonBuilder().create();

       ApiFilter myApiFilter = gson.fromJson(json, ApiFilter.class);

       System.out.println("O filtro de API pegou:");
       System.out.println(myApiFilter);

       return myApiFilter;

       /*
        //Gson gson = new Gson();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy
                .UPPER_CAMEL_CASE)
                .create();

        //método que pega uma String em Json e converte na minha classe Titulo (porque eu preemchi com essa classe)
        TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);

        System.out.println(meuTituloOMDB);
        */


       //TODO: escolher qual vai ser o tipo de preennchimento de buffer usado.
       // Provavelmente vou precisar de mais de uma classe de ApiBuffer para cada caso de leitura de Api
       // OOOU eu simplesmente faço uma sobrecarga de construtores na classe ApiBuffer para cada caso
   }
}


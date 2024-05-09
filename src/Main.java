import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Qual o CEP que vc gostaria de buscar? ");
        var leitura = new Scanner(System.in);
        String buscaCep = leitura.nextLine();
        System.out.println(buscaCep);

        ConsultaCEP consultaCEP = new ConsultaCEP();
        try {
            Endereco novoEndereco = consultaCEP.busEndereco(buscaCep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }


    }
}
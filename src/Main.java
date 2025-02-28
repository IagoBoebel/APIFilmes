import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, NoSuchAlgorithmException, URISyntaxException {

        // Conecta a api
        TheMovieAPI api = new TheMovieAPI();




        // Faz a request e converte a resposta para uma string de JSON
        String jsonResponse = api.getBody();
        // Cria o regex e o matcher para tratar o json
        TheMOVIEParser parser = new TheMOVIEParser(jsonResponse);
        // Separate o json em um lista de movies
        ArrayList<Movie> movies = parser.parse();

        Collections.sort(movies, Comparator.comparing(Content::year));

        // Cria um printwriter para mostrar os filmes
        PrintWriter writer = new PrintWriter(System.out, true);
        // Cria um gerador para criar a pagina html e passa o writer para fazer o print
        HTMLGenerator gerador = new HTMLGenerator(writer);
        // Gera a pagina html a partir da lista tratada de json
        gerador.generateHTML(movies);
        writer.close();



    }


}
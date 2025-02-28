import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TheMovieAPI implements APIClient {

    private URI uri = URI.create("https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1&region=Brazil");
    private String apiToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNWI1ODQyN2QxMGI3MmEwNzFmNmQyYmZiMDA1NzlmYSIsIm5iZiI6MTczOTk4MDI2OC41ODYsInN1YiI6IjY3YjVmZGVjZDI4ZTg3ZTBlNWUzZGI5MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.2lXkfPClxo9Nx3kNlvxLLCgiuIVjnP0wnSu34LFQV9I";
    private HttpClient client;

    public TheMovieAPI() {
        this.client = HttpClient.newBuilder().build();
    }

    public HttpRequest APIRequest() {
        return HttpRequest.newBuilder()
                .uri(uri)
                .header("accept", "application/json")
                .header("Authorization", apiToken)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
    }

    public String response(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}

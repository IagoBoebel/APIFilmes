import java.io.IOException;
import java.net.http.HttpRequest;
import java.security.NoSuchAlgorithmException;

public interface APIClient {
    HttpRequest APIRequest() throws NoSuchAlgorithmException;
    String response(HttpRequest request) throws IOException, InterruptedException;

    public default String getBody() throws IOException, InterruptedException, NoSuchAlgorithmException {
        return response(APIRequest());
    }
}

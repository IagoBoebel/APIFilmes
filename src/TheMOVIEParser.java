import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheMOVIEParser implements JSONParser {

    private String regex = "\"original_title\"\\s*:\\s*\"([^\"]+)\".*?\"poster_path\"\\s*:\\s*\"([^\"]+)\".*?\"vote_average\"\\s*:\\s*([0-9.]+).*?\"release_date\"\\s*:\\s*\"(\\d{4})";
    private Pattern pattern;
    private Matcher matcher;
    private ArrayList<Movie> movies;

    public TheMOVIEParser(String json) {
        this.pattern = Pattern.compile(regex);
        this.matcher = pattern.matcher(json);

    }

    public ArrayList<Movie> parse() {
        this.movies = new ArrayList<Movie>();
        while (this.matcher.find()) {
            Movie movie = new Movie();
            movie.setName(this.matcher.group(MovieAtributes.NAME.getValor()));
            movie.setPosterURL(this.matcher.group(MovieAtributes.POSTER_URL.getValor()));
            movie.setYear(Integer.parseInt(this.matcher.group(MovieAtributes.YEAR.getValor())));
            movie.setNota(Double.parseDouble(this.matcher.group(MovieAtributes.NOTA.getValor())));
            movies.add(movie);
        }
        return movies;
    }

}

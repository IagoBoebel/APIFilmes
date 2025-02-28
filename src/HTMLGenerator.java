import java.io.PrintWriter;
import java.util.ArrayList;

public class HTMLGenerator {

    private PrintWriter printWriter;

    public HTMLGenerator(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void generateHTML(ArrayList<Movie> movies) {
        for(Movie movie : movies) {
            generateTitle(movie);
            generatePoster(movie);
            generateYear(movie);
            generateRating(movie);
            printWriter.println();
        }
    }

    public String generateTitle(Movie movie) {
        return printWriter.printf("<h1> %s <h/1> \n", movie.name()).toString();
    }

    public String generatePoster(Movie movie) {
        return printWriter.printf("<img src=\"%s\" alt=\"Movie Poster\"> \n", movie.posterURL()).toString();
    }

    public String generateYear(Movie movie) {
        return printWriter.printf("<h2> Year: %d </h2> \n", movie.year()).toString();
    }

    public String generateRating(Movie movie) {
        return printWriter.printf("<h2> Rate: %.2f </h2> \n", movie.nota()).toString();
    }

}

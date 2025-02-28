public class Movie implements Content, Comparable<Content> {
    private String name;
    private Double nota;
    private Integer year;
    private String posterURL;

    public Movie(){}

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double nota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer year() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String posterURL() {
        return posterURL;
    }

    public void setPosterURL(String URL) {
        this.posterURL = URL;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", nota=" + nota +
                ", year=" + year +
                ", URL='" + posterURL + '\'' +
                '}';
    }

    @Override
    public int compareTo(Content content) {
        return this.nota.compareTo(content.nota());

    }

}

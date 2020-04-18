package pl.edu.pwsztar.domain.dto;
import java.util.List;

public class FileDto {

    private List<MovieDto> movieList;

    public FileDto(List<MovieDto> movieList){
        this.movieList = movieList;
    }

    public List<MovieDto> getMovieList(){
        return movieList;
    }
}
package pl.edu.pwsztar.domain.dto;

import java.util.List;

public class FileDto {

    private List<MovieDto> movieList;

    public FileDto() {

    }

    public FileDto(Builder builder) {
        this.movieList = builder.movieList;
    }

    public List<MovieDto> getMovieList() {
        return movieList;
    }

    public static final class Builder {
        private List<MovieDto> movieList;

        public Builder() {

        }

        public Builder(FileDto copy) {
            this.movieList = copy.movieList;
        }

        public FileDto.Builder movieList(List<MovieDto> movieList) {
            this.movieList = movieList;
            return this;
        }

        public FileDto build() {
            return new FileDto(this);
        }
    }
}
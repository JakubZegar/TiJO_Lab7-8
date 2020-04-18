package pl.edu.pwsztar.domain.mapper;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.converter.Converter;
import pl.edu.pwsztar.domain.dto.FileDto;
import pl.edu.pwsztar.domain.dto.MovieDto;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class FileMapper implements Converter<FileDto, InputStreamResource> {

    @Override
    public InputStreamResource convert(FileDto from) {

        InputStream stream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;

        List<MovieDto> sortedMovieDtoList = from.getMovieList()
                .stream()
                .sorted(Comparator.comparing(MovieDto::getYear).reversed())
                .collect(Collectors.toList());

        FileDto sortedMovies = new FileDto(sortedMovieDtoList);

        try {
            file = File.createTempFile("tmp", ".txt");
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert fileOutputStream != null;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

        for(MovieDto movie : sortedMovies.getMovieList()){
            try {
                bufferedWriter.write(movie.getYear() + " " + movie.getTitle());
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            bufferedWriter.close();

            fileOutputStream.flush();
            fileOutputStream.close();

            stream = new FileInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert stream != null;
        return new InputStreamResource(stream);
    }
}

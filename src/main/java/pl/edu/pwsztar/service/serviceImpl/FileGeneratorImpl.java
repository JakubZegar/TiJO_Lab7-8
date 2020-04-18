package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.converter.Converter;
import pl.edu.pwsztar.domain.dto.FileDto;
import pl.edu.pwsztar.domain.files.FileGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.edu.pwsztar.service.MovieService;

@Service
public class FileGeneratorImpl implements FileGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileGeneratorImpl.class);

    private final Converter<FileDto, InputStreamResource> fileMapper;
    private final MovieService movieService;

    @Autowired
    public FileGeneratorImpl(Converter<FileDto, InputStreamResource> fileMapper,
                             MovieService movieService) {
        this.fileMapper = fileMapper;
        this.movieService = movieService;
    }

    @Override
    public InputStreamResource toTxt() {
        FileDto fileDto = new FileDto.Builder()
                .movieList(movieService.findAll())
                .build();
        return fileMapper.convert(fileDto);
    }
}
package pl.edu.pwsztar.domain.dto;

import java.io.Serializable;

public class MovieCounterDto implements Serializable {
    private Long counter;

    public MovieCounterDto() {
        counter = 0L;
    }

    public MovieCounterDto(Builder builder) {
        this.counter = builder.counter;
    }

    public Long getCounter() {
        return counter;
    }

    public static final class Builder {
        private Long counter;

        public Builder() {
            this.counter = 0L;
        }

        public Builder(MovieCounterDto copy) {
            this.counter = copy.counter;
        }

        public MovieCounterDto.Builder counter(Long counter) {
            this.counter = counter;
            return this;
        }

        public MovieCounterDto build() {
            return new MovieCounterDto(this);
        }
    }
}
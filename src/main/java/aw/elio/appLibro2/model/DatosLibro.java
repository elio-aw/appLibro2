package aw.elio.appLibro2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibro(
        String title,
        List<DatosAutor> authors,
        List<String> languages,
        int download_count
) {
}

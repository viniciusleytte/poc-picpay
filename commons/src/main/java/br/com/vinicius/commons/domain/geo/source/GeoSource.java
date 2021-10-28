package br.com.vinicius.commons.domain.geo.source;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lat",
        "lng"
})
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
public class GeoSource implements Serializable {
    private final static long serialVersionUID = 8736350875401926234L;

    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lng")
    private String lng;

}

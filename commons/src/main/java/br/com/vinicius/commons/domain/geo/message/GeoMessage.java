package br.com.vinicius.commons.domain.geo.message;

import br.com.vinicius.commons.domain.geo.source.GeoSource;
import br.com.vinicius.commons.domain.identifiable.Identifiable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lat",
        "lng"
})
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GeoMessage extends Identifiable implements Serializable {
    private final static long serialVersionUID = 8736350875401926234L;

    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lng")
    private String lng;

    public GeoMessage(GeoSource geoSource) {
        super();
        this.id = UUID.randomUUID();
        this.lat = geoSource.getLat();
        this.lng = geoSource.getLng();
    }
}

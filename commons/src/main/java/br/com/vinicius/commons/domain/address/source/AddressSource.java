package br.com.vinicius.commons.domain.address.source;

import br.com.vinicius.commons.domain.geo.source.GeoSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "street",
        "suite",
        "city",
        "zipcode",
        "geo"
})
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
public class AddressSource implements Serializable {
    private final static long serialVersionUID = 5168135112321546049L;

    @JsonProperty("street")
    private String street;
    @JsonProperty("suite")
    private String suite;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("geo")
    private GeoSource geo;
}

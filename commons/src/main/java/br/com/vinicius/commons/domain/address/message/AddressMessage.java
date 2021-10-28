package br.com.vinicius.commons.domain.address.message;

import br.com.vinicius.commons.domain.address.source.AddressSource;
import br.com.vinicius.commons.domain.geo.message.GeoMessage;
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
        "street",
        "suite",
        "city",
        "zipcode",
        "geo"
})
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddressMessage extends Identifiable implements Serializable {
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
    private GeoMessage geo;

    public AddressMessage(AddressSource addressSource) {
        super();
        this.id = UUID.randomUUID();
        this.street = addressSource.getStreet();
        this.suite = addressSource.getSuite();
        this.city = addressSource.getCity();
        this.zipcode = addressSource.getZipcode();
        this.geo = new GeoMessage(addressSource.getGeo());
    }
}

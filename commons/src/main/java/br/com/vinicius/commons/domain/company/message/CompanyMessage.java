package br.com.vinicius.commons.domain.company.message;

import br.com.vinicius.commons.domain.company.source.CompanySource;
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
        "name",
        "catchPhrase",
        "bs"
})
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CompanyMessage extends Identifiable implements Serializable {
    private final static long serialVersionUID = -2905879615401922904L;

    @JsonProperty("name")
    private String name;
    @JsonProperty("catchPhrase")
    private String catchPhrase;
    @JsonProperty("bs")
    private String bs;

    public CompanyMessage(CompanySource company) {
        super();
        this.id = UUID.randomUUID();
        this.name = company.getName();
        this.catchPhrase = company.getCatchPhrase();
        this.bs = company.getBs();
    }
}

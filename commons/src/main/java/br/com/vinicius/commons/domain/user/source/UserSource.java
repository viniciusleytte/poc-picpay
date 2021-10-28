package br.com.vinicius.commons.domain.user.source;

import br.com.vinicius.commons.domain.address.source.AddressSource;
import br.com.vinicius.commons.domain.company.source.CompanySource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "username",
        "email",
        "address",
        "phone",
        "website",
        "company"
})
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
public class UserSource implements Serializable {
    private final static long serialVersionUID = 4019714903290740740L;

    @JsonProperty("name")
    private String name;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private AddressSource address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("website")
    private String website;
    @JsonProperty("company")
    private CompanySource company;

}

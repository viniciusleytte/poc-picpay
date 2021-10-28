package br.com.vinicius.commons.domain.user.message;

import br.com.vinicius.commons.domain.address.message.AddressMessage;
import br.com.vinicius.commons.domain.company.message.CompanyMessage;
import br.com.vinicius.commons.domain.identifiable.Identifiable;
import br.com.vinicius.commons.domain.user.source.UserSource;
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
@EqualsAndHashCode(callSuper = true)
public class UserMessage extends Identifiable implements Serializable {
    private final static long serialVersionUID = 4019714903290740740L;

    @JsonProperty("name")
    private String name;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private AddressMessage address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("website")
    private String website;
    @JsonProperty("company")
    private CompanyMessage company;

    public UserMessage(UserSource userSource) {
        super();
        this.id = UUID.randomUUID();
        this.name = userSource.getName();
        this.username = userSource.getName();
        this.email = userSource.getName();
        this.address = new AddressMessage(userSource.getAddress());
        this.phone = userSource.getName();
        this.website = userSource.getName();
        this.company = new CompanyMessage(userSource.getCompany());
    }
}

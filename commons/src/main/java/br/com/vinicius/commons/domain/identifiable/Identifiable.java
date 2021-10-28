package br.com.vinicius.commons.domain.identifiable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id"
})
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
public abstract class Identifiable implements Serializable {
    @JsonProperty("id")
    protected UUID id;
}

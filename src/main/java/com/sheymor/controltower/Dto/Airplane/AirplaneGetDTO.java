package com.sheymor.controltower.Dto.Airplane;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AirplaneGetDTO(
        String code,
        String airportCode,
        String airportName,
        String airportCity,
        String airportCountry
) {

}

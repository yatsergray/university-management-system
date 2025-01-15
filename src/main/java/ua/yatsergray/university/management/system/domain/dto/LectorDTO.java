package ua.yatsergray.university.management.system.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LectorDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    @JsonProperty("degree")
    private DegreeDTO degreeDTO;

    @Override
    public String toString() {
        return "LectorDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", degreeDTO=" + degreeDTO +
                '}';
    }
}

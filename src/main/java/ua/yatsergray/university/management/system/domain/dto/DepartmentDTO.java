package ua.yatsergray.university.management.system.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentDTO {
    private UUID id;
    private String name;

    @JsonProperty("head")
    private LectorDTO headDTO;

    @JsonProperty("lectors")
    @Builder.Default
    private List<LectorDTO> lectorDTOList = new ArrayList<>();

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headLectorDTO=" + headDTO +
                ", lectorDTOList=" + lectorDTOList +
                '}';
    }
}

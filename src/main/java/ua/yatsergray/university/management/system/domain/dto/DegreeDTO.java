package ua.yatsergray.university.management.system.domain.dto;

import lombok.*;
import ua.yatsergray.university.management.system.domain.type.DegreeType;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DegreeDTO {
    private UUID id;
    private String name;
    private DegreeType type;

    @Override
    public String toString() {
        return "DegreeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}

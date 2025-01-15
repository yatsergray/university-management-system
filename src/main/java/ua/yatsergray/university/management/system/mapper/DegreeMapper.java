package ua.yatsergray.university.management.system.mapper;

import org.mapstruct.Mapper;
import ua.yatsergray.university.management.system.domain.dto.DegreeDTO;
import ua.yatsergray.university.management.system.domain.entity.Degree;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DegreeMapper {

    DegreeDTO mapToDegreeDTO(Degree degree);

    List<DegreeDTO> mapAllToDegreeDTOList(List<Degree> degrees);
}

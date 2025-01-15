package ua.yatsergray.university.management.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.yatsergray.university.management.system.domain.dto.LectorDTO;
import ua.yatsergray.university.management.system.domain.entity.Lector;

import java.util.List;

@Mapper(componentModel = "spring", uses = DegreeMapper.class)
public interface LectorMapper {

    @Mapping(source = "degree", target = "degreeDTO")
    LectorDTO mapToLectorDTO(Lector lector);

    List<LectorDTO> mapAllToLectorDTOList(List<Lector> lectors);
}

package ua.yatsergray.university.management.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.yatsergray.university.management.system.domain.dto.DepartmentDTO;
import ua.yatsergray.university.management.system.domain.entity.Department;

import java.util.List;

@Mapper(componentModel = "spring", uses = LectorMapper.class)
public interface DepartmentMapper {

    @Mapping(source = "head", target = "headDTO")
    @Mapping(source = "lectors", target = "lectorDTOList")
    DepartmentDTO mapToDepartmentDTO(Department department);

    List<DepartmentDTO> mapAllToDepartmentDTOList(List<Department> departments);
}

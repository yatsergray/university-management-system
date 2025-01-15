package ua.yatsergray.university.management.system.service;

import ua.yatsergray.university.management.system.domain.dto.LectorDTO;
import ua.yatsergray.university.management.system.domain.type.DegreeType;

import java.util.List;
import java.util.Optional;

public interface LectorService {

    Optional<LectorDTO> getHeadByDepartmentName(String departmentName);

    List<LectorDTO> getAllByDegreeTypeAndDepartmentName(DegreeType lectorDegreeType, String departmentName);

    List<LectorDTO> getAllLectorsByNameTemplate(String lectorNameTemplate);
}

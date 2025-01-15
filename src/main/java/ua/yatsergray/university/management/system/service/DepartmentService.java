package ua.yatsergray.university.management.system.service;

import ua.yatsergray.university.management.system.domain.dto.DepartmentDTO;

import java.util.Optional;

public interface DepartmentService {

    Optional<DepartmentDTO> getDepartmentByName(String departmentName);
}

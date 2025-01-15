package ua.yatsergray.university.management.system.service;

import ua.yatsergray.university.management.system.domain.dto.LectorDTO;

import java.util.List;

public interface LectorService {

    List<LectorDTO> getAllLectorsByNameTemplate(String lectorNameTemplate);
}

package ua.yatsergray.university.management.system.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yatsergray.university.management.system.domain.dto.LectorDTO;
import ua.yatsergray.university.management.system.domain.type.DegreeType;
import ua.yatsergray.university.management.system.mapper.LectorMapper;
import ua.yatsergray.university.management.system.repository.LectorRepository;
import ua.yatsergray.university.management.system.service.LectorService;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class LectorServiceImpl implements LectorService {
    private final LectorMapper lectorMapper;
    private final LectorRepository lectorRepository;

    @Autowired
    public LectorServiceImpl(LectorMapper lectorMapper, LectorRepository lectorRepository) {
        this.lectorMapper = lectorMapper;
        this.lectorRepository = lectorRepository;
    }

    @Override
    public Optional<LectorDTO> getHeadByDepartmentName(String departmentName) {
        return lectorRepository.findHeadByDepartmentName(departmentName).map(lectorMapper::mapToLectorDTO);
    }

    @Override
    public List<LectorDTO> getAllByDegreeTypeAndDepartmentName(DegreeType lectorDegreeType, String departmentName) {
        return lectorMapper.mapAllToLectorDTOList(lectorRepository.findAllByDegreeTypeAndDepartmentName(lectorDegreeType, departmentName));
    }

    @Override
    public List<LectorDTO> getAllLectorsByNameTemplate(String lectorNameTemplate) {
        return lectorMapper.mapAllToLectorDTOList(lectorRepository.findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(lectorNameTemplate, lectorNameTemplate));
    }
}

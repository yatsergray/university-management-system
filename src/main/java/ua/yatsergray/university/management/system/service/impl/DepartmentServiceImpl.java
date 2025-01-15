package ua.yatsergray.university.management.system.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yatsergray.university.management.system.domain.dto.DepartmentDTO;
import ua.yatsergray.university.management.system.mapper.DepartmentMapper;
import ua.yatsergray.university.management.system.repository.DepartmentRepository;
import ua.yatsergray.university.management.system.service.DepartmentService;

import java.util.Optional;

@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper, DepartmentRepository departmentRepository) {
        this.departmentMapper = departmentMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Optional<DepartmentDTO> getDepartmentByName(String departmentName) {
        return departmentRepository.findByName(departmentName).map(departmentMapper::mapToDepartmentDTO);
    }
}

package ua.yatsergray.university.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.yatsergray.university.management.system.domain.entity.Degree;

import java.util.UUID;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, UUID> {
}

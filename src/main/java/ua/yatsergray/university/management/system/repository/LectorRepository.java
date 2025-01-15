package ua.yatsergray.university.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.yatsergray.university.management.system.domain.entity.Lector;
import ua.yatsergray.university.management.system.domain.type.DegreeType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LectorRepository extends JpaRepository<Lector, UUID> {

    @Query(value = """
            SELECT l.id, l.first_name, l.last_name, l.salary, l.degree_id
            FROM lectors l
                JOIN department_lectors dl ON dl.lector_id = l.id
                JOIN departments dp ON dp.id = dl.department_id
            WHERE dp.name LIKE %:departmentName%
                AND dp.head_id = l.id
            """, nativeQuery = true)
    Optional<Lector> findHeadByDepartmentName(@Param("departmentName") String departmentName);

    @Query(value = """
            SELECT l.id, l.first_name, l.last_name, l.salary, l.degree_id
            FROM departments dp
                JOIN department_lectors dl ON dl.department_id = dp.id
                JOIN lectors l ON l.id = dl.lector_id
                JOIN degrees dg ON dg.id = l.degree_id
            WHERE dp.name LIKE %:departmentName%
                AND dg.type LIKE %:degreeType%
            """, nativeQuery = true)
    List<Lector> findAllByDegreeTypeAndDepartmentName(@Param("degreeType") DegreeType degreeType, @Param("departmentName") String departmentName);

    List<Lector> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
}

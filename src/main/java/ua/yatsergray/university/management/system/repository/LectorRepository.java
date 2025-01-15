package ua.yatsergray.university.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.yatsergray.university.management.system.domain.entity.Lector;

import java.util.List;
import java.util.UUID;

@Repository
public interface LectorRepository extends JpaRepository<Lector, UUID> {

    List<Lector> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
}

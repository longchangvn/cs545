package cs545.labs.lab5.repository;

import cs545.labs.lab5.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,String> {
}

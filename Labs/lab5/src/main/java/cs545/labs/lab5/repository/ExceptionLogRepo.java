package cs545.labs.lab5.repository;

import cs545.labs.lab5.domain.ExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionLogRepo extends JpaRepository<ExceptionLog, Long> {
}

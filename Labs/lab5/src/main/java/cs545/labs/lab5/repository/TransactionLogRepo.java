package cs545.labs.lab5.repository;

import cs545.labs.lab5.domain.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLogRepo extends JpaRepository<TransactionLog, Long> {
}

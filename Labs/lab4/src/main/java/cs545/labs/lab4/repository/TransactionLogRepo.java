package cs545.labs.lab4.repository;

import cs545.labs.lab4.domain.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLogRepo extends JpaRepository<TransactionLog, Long> {
}

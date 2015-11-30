package developertest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditMessageRepository extends CrudRepository<AuditMessage, Long>{
}

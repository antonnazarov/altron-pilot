package bs2.metrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bs2.metrics.entity.MetricTransaction;

/**
 * The Metric Transaction repository for all general operations on DB.
 * 
 * @author Anton Nazarov
 * @since 09/07/2019
 */
@Repository
public interface TransactionRepository extends JpaRepository<MetricTransaction, Long> {

}

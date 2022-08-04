package sen.vol.deposit.repository;

import org.springframework.data.repository.CrudRepository;
import sen.vol.deposit.entity.Deposit;

public interface DepositRepository extends CrudRepository<Deposit, Long> {
}

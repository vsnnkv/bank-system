package sen.vol.account.repository;

import org.springframework.data.repository.CrudRepository;
import sen.vol.account.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
}

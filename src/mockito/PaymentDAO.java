package mockito;

import java.sql.SQLException;

/**
 * Created by Кристина on 10.03.2016.
 */
public interface PaymentDAO {

    void transferPayment(final Account from, final Account to,
                         final int amount) throws Exception;

    void updateAccounts(Account from, Account to, int amount) throws Exception;
}

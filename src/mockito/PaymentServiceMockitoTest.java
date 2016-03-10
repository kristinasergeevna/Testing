package mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Created by Кристина on 10.03.2016.
 */
@PrepareForTest(PaymentService.class)
@RunWith(PowerMockRunner.class)
public class PaymentServiceMockitoTest {
    public static class StubPaymentDAO implements PaymentDAO {

        @Override
        public void transferPayment(Account from, Account to, int amount) throws SQLException, ClassNotFoundException {
            System.out.println("Hello world");
        }

        @Override
        public void updateAccounts(Account from, Account to, int amount) throws Exception {
            System.out.println("Update Accounts");
        }
    }
    @Test
    public void test1() throws Exception {

        PaymentService service = new PaymentService();

        URL urlMockito= PowerMockito.mock(URL.class);
        whenNew(URL.class).withAnyArguments().thenReturn(urlMockito);

        HttpURLConnection urlConMockito=PowerMockito.mock(HttpURLConnection.class);
        when(urlConMockito.getResponseCode()).thenReturn(200);
        when(urlMockito.openConnection()).thenReturn(urlConMockito);

        Account account1 = new Account();
        account1.setName("John");
        account1.setMail("John.Smith@gmail.com");
        account1.setBalance(100);
        Account account2 = new Account();
        account2.setName("Mike");
        account2.setMail("Mike.Tester@gmail.com");
        account2.setBalance(100);

        service.setPaymentDAOImpl(new StubPaymentDAO());
        service.sendPayment(account1, account2, 100);

    }
@Test(expected = IllegalStateException.class)
    public void test2() throws Exception {

    PaymentService service = new PaymentService();

    URL urlMockito= PowerMockito.mock(URL.class);
    whenNew(URL.class).withAnyArguments().thenReturn(urlMockito);

    HttpURLConnection urlConMockito=PowerMockito.mock(HttpURLConnection.class);
    when(urlConMockito.getResponseCode()).thenReturn(505);
    when(urlMockito.openConnection()).thenReturn(urlConMockito);

    Account account1 = new Account();
    account1.setName("John");
    account1.setMail("John.Smith@gmail.com");
    account1.setBalance(100);
    Account account2 = new Account();
    account2.setName("Mike");
    account2.setMail("Mike.Tester@gmail.com");
    account2.setBalance(100);

    service.setPaymentDAOImpl(new StubPaymentDAO());
    service.sendPayment(account1, account2, 100);
}
    @Test
    public void test3() throws Exception {

            PaymentService service = new PaymentService();

            URL urlMockito= PowerMockito.mock(URL.class);
            whenNew(URL.class).withAnyArguments().thenReturn(urlMockito);

            HttpURLConnection urlConMockito=PowerMockito.mock(HttpURLConnection.class);
            when(urlConMockito.getResponseCode()).thenReturn(200);
            when(urlMockito.openConnection()).thenReturn(urlConMockito);

            Account account1 = new Account();
            account1.setName("John");
            account1.setMail("John.Smith@gmail.com");
            account1.setBalance(100);
            Account account2 = new Account();
            account2.setName("Mike");
            account2.setMail("Mike.Tester@gmail.com");
            account2.setBalance(100);

            service.setPaymentDAOImpl(new StubPaymentDAO());
            service.sendPayment(account1, account2, 100);
        Mockito.verify(urlConMockito, Mockito.atLeast(2)).getResponseCode();
    }

}

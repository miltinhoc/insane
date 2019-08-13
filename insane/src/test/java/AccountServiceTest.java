import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.academiadecodigo.codezillas.insane.services.AccountService;

import java.util.List;

public class AccountServiceTest {



    public static void main(String[] args) {

        AccountService accountService = new AccountService();

        if (accountService.findById(2) != null){
            System.err.println("Bad configuration");
        }

        User user =  new User();

        user.setName("Teste name");
        user.setCountry("Portugal");
        user.setMainSkill("Drawing");
        user.setId(2);

        accountService.saveOrUpdate(user);

        User test = accountService.findById(2);
        System.out.println(test.getName());

        List<User> skillUser = accountService.findBySkill("Drawing");

        for (User useri : skillUser){
            System.out.println(useri.getName());
        }

    }

}

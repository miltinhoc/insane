import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.academiadecodigo.codezillas.insane.services.AccountService;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceTest {

    public static void main(String[] args) {

        AccountService accountService = new AccountService();

        if (accountService.findById(2) != null){
            System.err.println("Bad configuration");
        }

        User user =  new User();

        user.setFirstName("Teste name");
        user.setCountry("Portugal");
        user.setMainSkill("Drawing");
        user.setId(2);

        accountService.saveOrUpdate(user);

        List<User> list = new ArrayList<>(accountService.getAll());

        //System.out.println(list);

        for (User s :
                list) {
            System.out.println(s.getFirstName());
        }
        User test = accountService.findById(2);
        System.out.println(test.getFirstName());

        List<User> skillUser = accountService.findBySkill("Drawing");

        for (User useri : skillUser){
            System.out.println(useri.getFirstName());
        }

    }

}

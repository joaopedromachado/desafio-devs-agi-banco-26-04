import br.com.agi.devsagi.joao.*;
import br.com.agi.devsagi.joao.InsufficientFundsException;
import br.com.agi.devsagi.joao.MenuInteractionService;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        MenuInteractionService application = new MenuInteractionService();

        application.runApplication();
    }
}
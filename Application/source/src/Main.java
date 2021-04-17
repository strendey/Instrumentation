import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Account ACCOUNT_OLD_INSTANCE = new Account("Conta antiga", 1000);
        Account account = new Account("Conta variavel", 500D);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputUser = scanner.nextLine();
            if (inputUser.equalsIgnoreCase("create")) {
                account = new Account("Conta variavel", account.getBalance() + 100);
                System.out.println("Conta criada com sucesso.");
            } else if (inputUser.equalsIgnoreCase("oldinfo")) {
                System.out.println("Nome: " + ACCOUNT_OLD_INSTANCE.getName());
                System.out.println("Saldo: " + ACCOUNT_OLD_INSTANCE.getBalance());
            } else if (inputUser.equalsIgnoreCase("newinfo")) {
                System.out.println("Nome: " + account.getName());
                System.out.println("Saldo: " + account.getBalance());
            }
        }

    }

}

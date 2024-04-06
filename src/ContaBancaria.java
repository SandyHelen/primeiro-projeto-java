import java.util.Scanner;

public class ContaBancaria {
    static Scanner leitor = new Scanner(System.in);
    static Double saldo = (double) 0;
    static boolean encerrar = false;

    public static void main(String[] args) {

        String tipoConta = "";

        System.out.println("Digite seu nome para iniciar sua conta:");
        String nome = leitor.nextLine();
        System.out.println(String.format("Olá %s, escolha o seu tipo de conta: ", nome));
        System.out.println("""
                1 - Corrente
                2 - Poupança
                """);

        int opcaoConta = leitor.nextInt();

        while (opcaoConta != 1 && opcaoConta != 2){
            System.out.println("Opção inválida");
            System.out.println("Escolha o seu tipo de conta: ");
            System.out.println("""
                1 - Corrente
                2 - Poupança
                """);
            opcaoConta = leitor.nextInt();
        }

        if (opcaoConta == 1){
            tipoConta = "Corrente";
        } else if (opcaoConta == 2 ) {
            tipoConta = "Poupança";
        }

        System.out.println("""
                Sua conta foi criada com sucesso!
                Utilize o menu para realizar transações.
                """);

        System.out.println(String.format("Nome - %s", nome));
        System.out.println(String.format("Tipo de Conta - %s", tipoConta));
        System.out.println(String.format("Saldo - %.2f", saldo));

        while (encerrar == false){
            executarMenu();
        }
    }

    public static void verMenu(){

        System.out.println("""
                -------------------------
                MENU
                
                1 - Consultar saldo
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                """);
    }

    public static int selecionarMenu(){
        int opcaoMenu = leitor.nextInt();

        return opcaoMenu;
    }

    public static void executarMenu(){

        verMenu();

        switch (selecionarMenu()){
            case 1:
                System.out.println(String.format("Seu saldo é %.2f", saldo));
                break;
            case 2:
                System.out.println("Quanto você quer depositar?");
                Double deposito = (double) leitor.nextDouble();
                saldo += deposito;
                System.out.println("Depósito efetuado com sucesso.");
                break;
            case 3:
                System.out.println("Quanto você quer transferir?");
                Double transferencia = (double) leitor.nextDouble();

                if (transferencia > saldo){
                    System.out.println("Saldo insuficiente.");
                } else {
                    saldo -= transferencia;
                    System.out.println("Transferencia efetuada com sucesso.");
                }
                break;
            case 4:
                encerrar = true;
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}


import java.util.Scanner;
import java.util.Random;

// Jogo Advinhe o Número - Tamires Silva (GitHub: tamiresborota)
public class Main {

    public static void main(String[] args) {
        displayMainMenu(); // Exibe o menu principal
    }

    public static void displayMainMenu() {
        Scanner inputScanner = new Scanner(System.in);

        // Exibe o cabeçalho do jogo
        System.out.println("=========================================");
        System.out.println("   Bem-vindo ao Advinhe o Número!   ");
        System.out.println("=========================================");
        System.out.println("   🎮 1. Começar o Jogo               🎮 ");
        System.out.println("   🚪 2. Sair                         🚪 ");
        System.out.println("=========================================");

        int choice;
        do {
            System.out.print("Escolha uma opção: ");
            choice = inputScanner.nextInt();

            switch (choice) {
                case 1:
                    chooseGameMode(); // Inicia a seleção do modo de jogo
                    break;
                case 2:
                    System.out.println("Até a próxima! Obrigado por jogar. 😊");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha 1 para começar ou 2 para sair.");
            }
        } while (choice != 2);

        inputScanner.close();
    }

    public static void chooseGameMode() {
        Scanner inputScanner = new Scanner(System.in);

        // Exibe as opções de modo de jogo
        System.out.println("=========================================");
        System.out.println("   Escolha o modo de jogo:              ");
        System.out.println("=========================================");
        System.out.println("   🎮 1. Modo Fácil (1-10)             🎮 ");
        System.out.println("   🎮 2. Modo Médio (1-50)             🎮 ");
        System.out.println("   🎮 3. Modo Difícil (1-100)          🎮 ");
        System.out.println("=========================================");

        int modeChoice;
        do {
            System.out.print("Escolha o modo de jogo ou 0 para voltar: ");
            modeChoice = inputScanner.nextInt();

            switch (modeChoice) {
                case 1:
                    playGame(1, 10, 1);  // Modo Fácil
                    break;
                case 2:
                    playGame(1, 50, 2);  // Modo Médio
                    break;
                case 3:
                    playGame(1, 100, 3);  // Modo Difícil
                    break;
                case 0:
                    displayMainMenu(); // Volta para o menu principal
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha 1, 2, 3 ou 0 para voltar.");
            }
        } while (modeChoice != 0);

        inputScanner.close();
    }

    public static void playGame(int minNumber, int maxNumber, int scoreWeight) {
        Random random = new Random();
        Scanner inputScanner = new Scanner(System.in);
        int score = 0;

        while (true) {
            int secretNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            System.out.println("=========================================");
            System.out.println("   Adivinhe o número que estou pensando   ");
            System.out.println("   (" + minNumber + "-" + maxNumber + ") ou digite 'sair' para voltar    ");
            System.out.println("   ao menu principal:                    ");
            System.out.println("=========================================");

            String input = inputScanner.next().toLowerCase(); // Converter entrada para minúsculas

            if (input.equals("sair")) {
                break;
            }

            try {
                int guessedNumber = Integer.parseInt(input);
                if (guessedNumber < minNumber || guessedNumber > maxNumber) {
                    System.out.println("Número fora do intervalo permitido!");
                    continue;
                }
                if (guessedNumber == secretNumber) {
                    System.out.println("Parabéns! Você acertou! 🎉");
                    System.out.println("Eu pensei no número " + secretNumber);
                    score += scoreWeight;
                } else {
                    System.out.println("Você errou! 😞");
                    System.out.println("Eu pensei no número " + secretNumber);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número ou 'sair'.");
            }
        }

        // Exibe a pontuação final e informações adicionais
        System.out.println("=========================================");
        System.out.println("Pontuação final: " + score);
        System.out.println("========================================+");
        System.out.println("Este jogo foi desenvolvido por Tamires Silva (GitHub: tamiresborota)");
        System.out.println("A ideia do jogo surgiu de um exercício da faculdade e foi evoluída com funcionalidades para torná-lo mais interessante.");
    }
}

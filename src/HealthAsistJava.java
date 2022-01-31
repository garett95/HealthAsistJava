import java.util.Scanner;

public class Sprint1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        System.out.println("Здравствуйте! Добро пожаловать в приложение Счётчик калорий!");

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                processingInputSteps(scanner, stepTracker);
            } else if (userInput == 2) {
                stepTracker.showMonthStats(checkInputMonth(scanner));
            } else if (userInput == 3) {
                processingChangeDayGoal(scanner, stepTracker);
            } else if (userInput == 0) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введена неверная команда");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите необходимое действие:");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Посмотреть статистику за месяц");
        System.out.println("3 - Установить цель по количеству шагов за день");
        System.out.println("0 - Выйти из приложения");
    }

    public static void processingInputSteps(Scanner scanner, StepTracker stepTracker) {
        int month = checkInputMonth(scanner);
        System.out.println("Введите день " + month + "-го месяца от 1 до 30:");
        int day = scanner.nextInt();
        while ((day < 1) || (day > 30)) {
            System.out.println("Введено неверное значение");
            day = scanner.nextInt();
        }
        System.out.println("Введите количество шагов за сегодня:");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Введено неверное значение");
            steps = scanner.nextInt();
        }
        stepTracker.saveInputSteps(month, day, steps);
    }

    public static void processingChangeDayGoal(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Введите целевое значение по количеству шагов в день:");
        int newGoal = scanner.nextInt();
        while (newGoal < 0) {
            System.out.println("Введено неверное значение");
            newGoal = scanner.nextInt();
        }
        System.out.println("Поставлена новая цель - " +
                stepTracker.changeStepsDayGoal(newGoal) + " шагов в день");
    }

    public static int checkInputMonth(Scanner scanner){
        System.out.println("Введите порядковый номер месяца от 1 до 12:");
        int month = scanner.nextInt();
        while ((month < 1) || (month > 12)) {
            System.out.println("Введено неверное значение");
            month = scanner.nextInt();
        }
        return month;
    }
}



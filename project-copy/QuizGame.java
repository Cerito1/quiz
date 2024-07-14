import java.util.Scanner;

public class QuizGame {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] programmingQuestions = {
            "Какой метод используется для запуска программы в Java?",
            "Какой ключевое слово используется для создания объекта?",
            "Как называется процесс скрытия реализации и отображения функционала?",
            "Какое ключевое слово используется для наследования класса?",
            "Какой оператор используется для сравнения значений в Java?"
    };
    private static String[] programmingAnswers = {"main", "new", "инкапсуляция", "extends", "=="};

    private static String[] mathQuestions = {
            "Чему равен корень из 144?",
            "Как называется многоугольник с 8 сторонами?",
            "Чему равна сумма углов треугольника?",
            "Как называется число π (пи)?",
            "Чему равен факториал числа 5?"
    };
    private static String[] mathAnswers = {"12", "восьмиугольник", "180", "3.14", "120"};

    private static String[] physicsQuestions = {
            "Кто сформулировал законы движения?",
            "Что изучает термодинамика?",
            "Как называется сила, противоположная движению объекта в жидкости?",
            "Какое устройство используется для измерения силы?",
            "Чему равна скорость света в вакууме?"
    };
    private static String[] physicsAnswers = {"Ньютон", "теплоту", "сопротивление", "динамометр", "299792458"};

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру-викторину!");
        int score = 0;

        System.out.println("Категория: Программирование");
        score += askQuestions(programmingQuestions, programmingAnswers);

        System.out.println("Категория: Математика");
        score += askQuestions(mathQuestions, mathAnswers);

        System.out.println("Категория: Физика");
        score += askQuestions(physicsQuestions, physicsAnswers);

        System.out.println("Ваш итоговый счёт: " + score + " из 15");
    }

    private static int askQuestions(String[] questions, String[] answers) {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Вопрос " + (i + 1) + ": " + questions[i]);
            String userAnswer = scanner.nextLine().trim().toLowerCase();
            if (userAnswer.equals(answers[i].toLowerCase())) {
                System.out.println("Правильно!");
                score++;
            } else {
                System.out.println("Неправильно. Правильный ответ: " + answers[i]);
            }
        }
        return score;
    }
}

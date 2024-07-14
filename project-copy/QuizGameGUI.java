import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGameGUI extends JFrame implements ActionListener {
    private String[] programmingQuestions = {
            "Какой метод используется для запуска программы в Java?",
            "Какое ключевое слово используется для создания объекта?",
            "Как называется процесс скрытия реализации и отображения функционала?",
            "Какое ключевое слово используется для наследования класса?",
            "Какой оператор используется для сравнения значений в Java?"
    };
    private String[] programmingAnswers = {"main", "new", "инкапсуляция", "extends", "=="};

    private String[] mathQuestions = {
            "Чему равен корень из 144?",
            "Как называется многоугольник с 8 сторонами?",
            "Чему равна сумма углов треугольника?",
            "Как называется число π (пи)?",
            "Чему равен факториал числа 5?"
    };
    private String[] mathAnswers = {"12", "восьмиугольник", "180", "3.14", "120"};

    private String[] physicsQuestions = {
            "Кто сформулировал законы движения?",
            "Что изучает термодинамика?",
            "Как называется сила, противоположная движению объекта в жидкости?",
            "Какое устройство используется для измерения силы?",
            "Чему равна скорость света в вакууме?"
    };
    private String[] physicsAnswers = {"Ньютон", "теплоту", "сопротивление", "динамометр", "299792458"};

    private String[][] questions = {programmingQuestions, mathQuestions, physicsQuestions};
    private String[][] answers = {programmingAnswers, mathAnswers, physicsAnswers};
    private String[] categories = {"Программирование", "Математика", "Физика"};

    private int score = 0;
    private int questionIndex = 0;
    private int categoryIndex = 0;

    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;
    private JButton nextButton;
    private JLabel scoreLabel;
    private JLabel categoryLabel;

    public QuizGameGUI() {
        setTitle("Викторина");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BorderLayout());

        categoryLabel = new JLabel("Категория: " + categories[categoryIndex], JLabel.CENTER);
        questionLabel = new JLabel(questions[categoryIndex][questionIndex], JLabel.CENTER);
        answerField = new JTextField();
        submitButton = new JButton("Ответить");
        nextButton = new JButton("Следующий вопрос");
        nextButton.setEnabled(false);

        submitButton.addActionListener(this);
        nextButton.addActionListener(this);

        questionPanel.add(categoryLabel, BorderLayout.NORTH);
        questionPanel.add(questionLabel, BorderLayout.CENTER);
        questionPanel.add(answerField, BorderLayout.SOUTH);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 2));
        controlPanel.add(submitButton);
        controlPanel.add(nextButton);

        scoreLabel = new JLabel("Счёт: " + score, JLabel.CENTER);

        add(questionPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(scoreLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String userAnswer = answerField.getText().trim().toLowerCase();
            if (userAnswer.equals(answers[categoryIndex][questionIndex].toLowerCase())) {
                score++;
                scoreLabel.setText("Счёт: " + score);
                JOptionPane.showMessageDialog(this, "Правильно!", "Результат", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Неправильно. Правильный ответ: " + answers[categoryIndex][questionIndex], "Результат", JOptionPane.INFORMATION_MESSAGE);
            }
            submitButton.setEnabled(false);
            nextButton.setEnabled(true);
        } else if (e.getSource() == nextButton) {
            questionIndex++;
            if (questionIndex >= questions[categoryIndex].length) {
                questionIndex = 0;
                categoryIndex++;
                if (categoryIndex >= categories.length) {
                    JOptionPane.showMessageDialog(this, "Викторина закончена! Ваш итоговый счёт: " + score, "Итог", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                categoryLabel.setText("Категория: " + categories[categoryIndex]);
            }
            questionLabel.setText(questions[categoryIndex][questionIndex]);
            answerField.setText("");
            submitButton.setEnabled(true);
            nextButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new QuizGameGUI();
    }
}
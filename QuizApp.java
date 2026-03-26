import java.util.Scanner;

public class QuizApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "1. What is the capital of India?",
            "2. Which language is used for Android development?",
            "3. Who is known as the father of Java?",
            "4. What is 5 + 3?",
            "5. Which keyword is used to inherit a class in Java?"
        };

        String[][] options = {
            {"A. Mumbai", "B. Delhi", "C. Chennai", "D. Kolkata"},
            {"A. Python", "B. Java", "C. C++", "D. Swift"},
            {"A. James Gosling", "B. Dennis Ritchie", "C. Elon Musk", "D. Bill Gates"},
            {"A. 6", "B. 7", "C. 8", "D. 9"},
            {"A. this", "B. super", "C. extends", "D. implements"}
        };

        char[] answers = {'B', 'B', 'A', 'C', 'C'};

        int score = 0;

        System.out.println("===== QUIZ APPLICATION =====");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n" + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = sc.next().toUpperCase().charAt(0);

            if (userAnswer == answers[i]) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + answers[i]);
            }
        }

        System.out.println("\n===== RESULT =====");
        System.out.println("Your Score: " + score + "/" + questions.length);

        if (score == questions.length) {
            System.out.println("🎉 Excellent!");
        } else if (score >= 3) {
            System.out.println("👍 Good job!");
        } else {
            System.out.println("📘 Keep practicing!");
        }

        sc.close();
    }
}

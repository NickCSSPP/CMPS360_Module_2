package Swing;

import javax.swing.*;
import java.util.ArrayList;

public class survey {
    public static void main(String[] args) {
       String[]questions =
        {
            "How many players played well this season?\nA. 4 B. 7 C. 9",
            "How many points did Boswell score this season?\nA. 3 B. 40 C. 114",
            "How many penalties did the Steelers have in game 3 this season?\nA. 1 B. 3 C. 0"
        };

        char[] answers = {'C', 'C', 'B'};
        char ans = ' ';
        int x, correct = 0;
        String entry;
        boolean isCorrect;
        ArrayList<Integer> incorrect = new ArrayList<>();
        

        for (x = 0; x < questions.length; ++x)
        {
            isCorrect = false;
            int firstError = 0;
            while(!isCorrect)
            {
               isCorrect = true;
               entry = JOptionPane.showInputDialog(null, questions[x]);
                ans = entry.charAt(0);
                if(ans != 'A' && ans != 'B' && ans != 'C')
                {
                    isCorrect = false;
                    if (firstError == 0)
                    {
                        questions[x] = questions[x] + "\nYou must enter A, B, or C.";
                        firstError = 1;
                    }
                }
            }
            if (ans == answers[x])
            {
                ++correct;
                JOptionPane.showMessageDialog(null, "Correct!");
            }
            else {
                incorrect.add(x + 1);
                JOptionPane.showMessageDialog(null, "The correct answer is " + answers[x]);
            }
        }
        JOptionPane.showMessageDialog(null, "You received " + correct + " right and " + (questions.length - correct) + " wrong.\n" + "You answered the following questions wrong: " + incorrect);
    }  
}


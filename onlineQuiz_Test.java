import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    // create jFrame with radioButton and JButton
    OnlineTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Next");
        btnBookmark = new JButton("Bookmark");
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        // radioButton[0].setBounds(50, 80, 200, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookmark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    // handle all actions based on event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                btnBookmark.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct answers= " + count);
            System.exit(0);
        }
    }

    // SET Questions with options
    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Que1:  Which package contains the Random class??");
            radioButton[0].setText("java.util package");
            radioButton[1].setText("java.lang package");
            radioButton[2].setText("java.awt package");
            radioButton[3].setText("java.io package");
        }
        if (current == 1) {
            label.setText("Que2: Which of the following is an immediate subclass of the Panel class?");
            radioButton[0].setText("Applet class");
            radioButton[1].setText("Window class");
            radioButton[2].setText("Frame class");
            radioButton[3].setText("Dialog class");
        }
        if (current == 2) {
            label.setText("Que3: In which memory a String is stored, when we create a string using new operator?");
            radioButton[0].setText("Stack");
            radioButton[1].setText("String memory");
            radioButton[2].setText("Heap memory");
            radioButton[3].setText("Random Storage space");
        }
        if (current == 3) {
            label.setText("Que4:Which of this interface must contain a unique element? ");
            radioButton[0].setText("Set");
            radioButton[1].setText("List");
            radioButton[2].setText("Array");
            radioButton[3].setText("Collection");
        }
        if (current == 4) {
            label.setText("Que5: Which of the following interface is used to declare core methods in java?");
            radioButton[0].setText(" Set");
            radioButton[1].setText("EventListner");
            radioButton[2].setText("Collection");
            radioButton[3].setText("Comparator");
        }
        if (current == 5) {
            label.setText("Que6: Which of the following is true?");
            radioButton[0].setText("A class can extend more than one class.");
            radioButton[1].setText("A class can extend only one class but many interfaces ");
            radioButton[2].setText("An interface can implement many interfaces.");
            radioButton[3].setText("None of these");
        }
        if (current == 6) {
            label.setText("Que7: What will be the return type of a methods that not returns any value?");
            radioButton[0].setText("int ");
            radioButton[1].setText("void ");
            radioButton[2].setText("double");
            radioButton[3].setText("char");
        }
        if (current == 7) {
            label.setText("Que8:  In Which of the following package Exception class exit?");
            radioButton[0].setText("java.util");
            radioButton[1].setText("java.file");
            radioButton[2].setText("java.io");
            radioButton[3].setText("java.net");
        }
        if (current == 8) {
            label.setText("Que9: Which exception is thrown when divide by zero statement executes?");
            radioButton[0].setText("NumberFormatException");
            radioButton[1].setText("ArithimaticException");
            radioButton[2].setText("OutofBoundExeception");
            radioButton[3].setText("None of these");
        }
        if (current == 9) {
            label.setText("Que10: What are the uses of a Java Package?");
            radioButton[0].setText("A package contains ready-to-use classes written for a specific purpose.");
            radioButton[1].setText(
                    "Packages are easy to distribute your code. It is nothing but reusability. Instead of writing code afresh, you can take advantage of the existing classes of a package. Simply import it and use.");
            radioButton[2].setText(
                    "Packages help in maintaining the code easily. Each sub-package may be maintained for more specific purposes. You can reuse the class names in sub-packages or other packages without name clash.");
            radioButton[3].setText("All the above");
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 100; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 1200, 40);
    }

    // declare right answers.
    boolean check() {
        if (current == 0)
            return (radioButton[0].isSelected());
        if (current == 1)
            return (radioButton[0].isSelected());
        if (current == 2)
            return (radioButton[2].isSelected());
        if (current == 3)
            return (radioButton[0].isSelected());
        if (current == 4)
            return (radioButton[2].isSelected());
        if (current == 5)
            return (radioButton[2].isSelected());
        if (current == 6)
            return (radioButton[1].isSelected());
        if (current == 7)
            return (radioButton[3].isSelected());
        if (current == 8)
            return (radioButton[1].isSelected());
        if (current == 9)
            return (radioButton[3].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new OnlineTest("Online Test App");
    }

}

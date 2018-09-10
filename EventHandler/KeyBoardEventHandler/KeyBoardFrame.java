import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardFrame extends JFrame implements KeyListener {
    private String line1 = ""; // first line of textarea
    private String line2 = ""; // second line of textarea
    private JTextArea textArea; // textarea to display output

    public KeyBoardFrame() {
        super("Demonstrating Keystroke Events");

        textArea = new JTextArea(10, 15); // sets up JTextArea
        textArea.setText("Press any key on the keyboard...");
        textArea.setEnabled(false); // disable textarea
        textArea.setDisabledTextColor(Color.BLACK); // sets text color
        add(textArea); // adds textarea to JFrame

        addKeyListener(this);
    }

    // handle press of any key
    public void keyPressed(KeyEvent e) {
        line1 = String.format("Key pressed: %s", KeyEvent.getKeyText(e.getKeyCode())); // shows pressed key
        setLine2(e); // sets output line2 and line3
    }

    // handle release of any key
    public void keyReleased(KeyEvent e) {
        line1 = String.format("Key released: %s", KeyEvent.getKeyText(e.getKeyCode())); // shows released key
        setLine2(e); // sets output line2 and line3
    }

    // handle press of an action key
    public void keyTyped(KeyEvent e) {
        line1 = String.format("Key typed: %s", e.getKeyChar());
        setLine2(e); // sets output line2 and line3
    }

    // sets second and third lines of output
    private void setLine2(KeyEvent e) {
        line2 = String.format("This key is %san action key", (e.isActionKey() ? "" : "not "));

        textArea.setText(String.format("%s\n%s\n", line1, line2));
    }
}

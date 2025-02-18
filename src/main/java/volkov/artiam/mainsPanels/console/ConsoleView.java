package volkov.artiam.mainsPanels.console;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ConsoleView extends JPanel{

	JTextArea textAreaRx = new JTextArea();
    JTextArea textAreaTx = new JTextArea();
    private JScrollPane scrollPaneRx = new JScrollPane(textAreaRx);
    private JScrollPane scrollPaneTx = new JScrollPane(textAreaTx);

    public ConsoleView() {

        setLayout(null);
        setSize(900, 70);
        setBackground(UIManager.getColor("Button.background"));
        setBackground(UIManager.getColor("Button.background"));
        setBorder(new EmptyBorder(0, 0, 0, 0));
  
        setTextAreaParams(textAreaRx);
        setTextAreaParams(textAreaTx);
      
        setScrollPaneParams(scrollPaneRx, 20, 0, 400, 50);
        setScrollPaneParams(scrollPaneTx, 470, 0, 400, 50);
      
        add(scrollPaneRx);
        add(scrollPaneTx);
    }

    
    public void setTextAreaParams(final JTextArea jta) {
        jta.setBackground(Color.WHITE);
    	jta.setBackground(UIManager.getColor("Button.background"));
    	jta.setBorder(null);
    	jta.setFont(new Font("Tahoma", Font.PLAIN, 12));
    	DefaultCaret caret = (DefaultCaret)jta.getCaret(); 
    	caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    	jta.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                	jta.setText("");
                }
            }
        });
        //jta.setText("  "  + "Default text");
        jta.setText("");
    }
    	
    public void setScrollPaneParams(JScrollPane scrollPane, int x, int y, int width, int height) {
    	scrollPane.setBounds(x, y, width, height);
    	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	scrollPane.setBackground(UIManager.getColor("Button.background"));
    	scrollPane.setBorder(null);
    	scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }
}

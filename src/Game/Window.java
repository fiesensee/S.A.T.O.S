package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.Document;

public class Window
        extends JPanel {

    private JTextField Input;
    public static JTextArea Output;
    private JLabel Title;
    private JScrollPane jScrollPane1;
    public static Timer DelayTimer = new Timer(1000, new TimerListener());
    public static boolean tryConnect = false;
    public static boolean scan = false;
    public static boolean tryCom = false;

    public Window() {
        initComponents();
        Output.setAutoscrolls(true);
    }

    private void initComponents() {
        this.Title = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        Output = new JTextArea();
        this.Input = new JTextField();

        setBackground(new Color(204, 204, 204));
        setOpaque(false);
        setLayout(new BorderLayout());

        this.Title.setBackground(new Color(0, 0, 0));
        this.Title.setForeground(new Color(51, 133, 19));
        this.Title.setHorizontalAlignment(0);
        this.Title.setText("<html><pre>   _____   ___    __________   _____<br>  / ___/  /   |  /_  __/ __ \\ / ___/<br>  \\__ \\  / /| |   / / / / / / \\__ \\ <br> ___/ / / ___ |_ / / / /_/ / ___/ / <br>/____(_)_/  |_(_)_(_)\\____(_)____/  </html>");
        this.Title.setVerticalAlignment(1);
        this.Title.setBorder(new SoftBevelBorder(0));
        this.Title.setFocusable(false);
        this.Title.setOpaque(true);
        add(this.Title, "North");
        this.Title.getAccessibleContext().setAccessibleName("Title");

        this.jScrollPane1.setHorizontalScrollBarPolicy(31);
        this.jScrollPane1.setVerticalScrollBarPolicy(21);

        Output.setEditable(false);
        Output.setBackground(new Color(0, 0, 0));
        Output.setColumns(20);
        Output.setFont(new Font("Rod", 0, 13));
        Output.setForeground(new Color(51, 133, 19));
        Output.setLineWrap(true);
        Output.setWrapStyleWord(true);
        Output.setRows(5);
        Output.setText("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Output.setAutoscrolls(false);
        Output.setBorder(null);
        Output.setCaretColor(new Color(51, 133, 19));
        Output.setCursor(new Cursor(0));
        Output.setFocusable(false);
        this.jScrollPane1.setViewportView(Output);

        add(this.jScrollPane1, "Center");

        this.Input.setBackground(new Color(0, 0, 0));
        this.Input.setForeground(new Color(51, 133, 19));
        this.Input.setAutoscrolls(false);
        this.Input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (tryConnect) {
                    Window.this.ConnectActionPerformed(evt);
                } else if (tryCom) {
                    Window.this.ComActionPerformed(evt);
                } else {
                    Window.this.InputActionPerformed(evt);
                }
            }
        });
        add(this.Input, "Last");
    }

    private void InputActionPerformed(ActionEvent evt) {
        int s = 0;
        String Text = this.Input.getText();
        this.Input.setText("");
        switch (Text) {
            case "scan":
                scan();
                break;
            case "test":
                printout("test");
                break;
            case "connect":
                connect();
                break;
            case "disconnect":
                disconnect();
                break;
            case "status":
                status();
                break;
            case "resetKey":
                Game.DecryptKey = 0x10;
                break;
            case "exit":
                System.exit(0);
                break;
            case "run":
                run();
                break;
            default:
                printout("unknown command");
        }
    }

    public static void scanStop() {
        DelayTimer.stop();
        printout("finished scanning");
    }

    public static void printSameLine(String Text) {
        Output.append(Text);
        Output.append(" ");
        Output.setCaretPosition(Output.getDocument().getLength() - 1);
    }

    public static void printout(String Text) {
        Output.append(Text);
        Output.append("\n");
        Output.setCaretPosition(Output.getDocument().getLength() - 1);
    }

    public void scan() {
        this.scan = true;
        printout("scanning...");
        DelayTimer.start();
    }

    public void connect() {
        Window.tryConnect = true;
        printSameLine("to:");

    }

    public void disconnect() {
        if (Game.connected) {
            Game.connected = false;
            if (Game.SatField[Game.connectTo].Com > 0){
                Game.SatField[Game.SatField[Game.connectTo].Com].setCom(0);
                Game.SatField[Game.connectTo].setCom(0);
            }
            Game.connectTo = 0;
            printout("disconnected");
        } else {
            printout("wasn't connected to anything");
        }
    }

    public void status() {
        if (Game.connected) {
            printout("currently connected to " + Game.SatField[Game.connectTo].toString());
            if (Game.SatField[Game.connectTo].Com > 0){
                printout("communicating with "+ Game.SatField[(Game.SatField[Game.connectTo].Com)].Name);
            }
        } else {
            printout("not connected to anything");
        }
    }

    public void run() {
        if (Game.connected) {
            if (Game.SatField[Game.connectTo].Com > 0)
                Game.SatField[Game.SatField[Game.connectTo].Com].SatFunction();
            else 
                Game.SatField[Game.connectTo].SatFunction();
        } else {
            printout("not connected to any satellite");
        }
    }

    public void ConnectActionPerformed(ActionEvent evt) {
        int i = 1;
        String sat = this.Input.getText();
        this.Input.setText("");
        while (i < Game.SatField.length ) {
            if (sat.equals(Game.SatField[i].Name)) {
                if (Game.SatField[i].Type.equals("ComSat")){
                    Game.connected = true;
                    Game.connectTo = Game.SatField[i].ID;
                    printout(sat);
                    printout("successfuly connected");
                    printout(Game.SatField[i].response);
                }
                else{
                    printout(sat);
                    printout("Satellite only sends: " + Game.undecryptedResponse);

                }
                break;
                    
            }
            i++;
            if (i == Game.SatField.length) {
                printout("no satellite found with this name");
            }
        }

        tryConnect = false;

    }

    public void ComActionPerformed(ActionEvent evt) {
        int i = 1;
        String sat = this.Input.getText();
        this.Input.setText("");
        while (i < Game.SatField.length) {
            if (sat.equals(Game.SatField[i].Name)) {
                if ((Game.SatField[i].Type.equals("DataSat"))||(Game.SatField[i].Type.equals("KryptoSat"))){
                    if(Game.DecryptKey == Game.SatField[i].cryptkey){
                        printout(sat);
                        Game.SatField[i].setCom(Game.connectTo);
                        Game.SatField[Game.connectTo].setCom(Game.SatField[i].ID);
                        printout("now communicating with " + Game.SatField[i].Name +". Satellite says:");
                        printout(Game.SatField[Game.SatField[Game.connectTo].Com].response);
                    }
                    else
                        printout("Satellite only sends: " + Game.undecryptedResponse);
                    
                    
            }
            else
                printout("not a valid satellite");
                
                break;
            }
            i++;
            if (i == Game.SatField.length) {
                printout("no satellite found with this name");
            }
        }

        tryCom = false;
    }

}

class TimerListener implements ActionListener {

    public static int i = 1;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Window.scan) {
            Window.printout(Game.SatField[i].Name);
            if (i == Game.SatField.length - 1) {
                i = -1;
                Window.scan = false;
                Window.scanStop();
            }
        }
        i += 1;
    }
}

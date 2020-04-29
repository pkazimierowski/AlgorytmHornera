package pl.patrykkazimierowski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class MainWindow extends JFrame implements ActionListener {

    private int widthWindow = UserScreen.getWidth() / 4;
    private int heightWindow = UserScreen.getHeight() / 4;

    private int stopienWielomianu;
    private int argumentWielomianu;
    private int wspolczynniki[];

    private JTextField TextFieldStopienWielomianu = new JTextField();
    private JTextField TextFieldArgumentWielomianu = new JTextField();

    private JLabel LabelStopienWielomianu = new JLabel("Stopien wielomianu:");
    private JLabel LabelArgumentWielomianu = new JLabel("Argument wielomianu:");

    private JButton ButtonOblicz = new JButton("Oblicz");
    private JButton ButtonTest = new JButton("Test");


    private JLabel LabelWynik = new JLabel();


    public MainWindow()
    {
        setTitle("Algorytm Hornera");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        //this.setSize(this.widthWindow, this.heightWindow);
        this.setSize(358, 360);
        this.initComponents();
    }

    private void initComponents()
    {
        Container kontener = this.getContentPane();
        kontener.setLayout(null);
        TextFieldStopienWielomianu.setSize(100,20);
        TextFieldStopienWielomianu.setLocation(140,0);

        TextFieldArgumentWielomianu.setSize(100,20);
        TextFieldArgumentWielomianu.setLocation(140,40);

        LabelStopienWielomianu.setSize(150,20);
        LabelStopienWielomianu.setLocation(10,0);

        LabelArgumentWielomianu.setSize(150,20);
        LabelArgumentWielomianu.setLocation(10,40);

        ButtonOblicz.setSize(100,20);
        ButtonOblicz.setLocation(140,80);
        ButtonOblicz.setActionCommand("oblicz");
        ButtonOblicz.addActionListener(this);

        ButtonTest.setSize(100,20);
        ButtonTest.setLocation(240,40);
        ButtonTest.setActionCommand("test");
        ButtonTest.addActionListener(this);

        LabelWynik.setSize(100,20);
        LabelWynik.setLocation(30,120);


        kontener.add(LabelStopienWielomianu);
        kontener.add(LabelArgumentWielomianu);

        kontener.add(TextFieldStopienWielomianu);
        kontener.add(TextFieldArgumentWielomianu);

        kontener.add(ButtonOblicz);
        //kontener.add(ButtonTest);
        kontener.add(LabelWynik);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println(action);

        if(action.equals("oblicz"))
        {
            if(Horner.textFieldIntSafeMode(TextFieldStopienWielomianu)
                    && Horner.textFieldIntSafeMode(TextFieldArgumentWielomianu))
            {
                stopienWielomianu = Integer.parseInt(TextFieldStopienWielomianu.getText());
                argumentWielomianu = Integer.parseInt(TextFieldArgumentWielomianu.getText());
                wspolczynniki = new int[stopienWielomianu + 1];

                String inputTemp;

                for (int i = 0; i <= stopienWielomianu; i++) {
                    wspolczynniki[i] = Horner.wspolczynnikSafeMode(stopienWielomianu - i);
                    //System.out.println(wspolczynniki[i]);
                }
                LabelWynik.setText("Wynik = " + Horner.obliczenia(wspolczynniki, stopienWielomianu, argumentWielomianu));
                this.paint(this.getGraphics());
            }else{
                JOptionPane.showMessageDialog(null,"Podales bledna wartosc sprobuj jeszcze raz");
            }
        }else if(action.equals("test"))
        {

        }
    }
}

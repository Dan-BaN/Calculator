package javacalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

public class UI implements ActionListener {

    private final JFrame frame;
    private final JPanel panel;
    private final JPanel panelSub1;
    private final JPanel panelSub2;
    private final JPanel panelSub3;
    private final JPanel panelSub4;
    private final JPanel panelSub5;
    private final JPanel panelSub6;
    private final JPanel panelSub7;
    private final JPanel panelSub8;

    private final JTextArea text;
    private final JButton but[],Add,minus,multiply,divide,
    equal,cancel,sqrt,square,onedivided,cos,sin,tan,powerof,log,rate,abs,Binary;

    private final calculatorrun cal;

    private final String[] buttonval = {"0","1","2","3","4","5","6","7","8","9"};

    private final Font font;
    private final Font textFont;

    public UI() throws IOException {
        frame = new JFrame("Calculator");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelSub1 = new JPanel(new FlowLayout());
        panelSub2 = new JPanel(new FlowLayout());
        panelSub3 = new JPanel(new FlowLayout());
        panelSub4 = new JPanel(new FlowLayout());
        panelSub5 = new JPanel(new FlowLayout());
        panelSub6 = new JPanel(new FlowLayout());
        panelSub7 = new JPanel(new FlowLayout());
        panelSub8 = new JPanel(new FlowLayout());

        font = new Font("Consolas", Font.PLAIN, 18);
        text = new JTextArea(1,30);
        textFont = new Font("Consolas",Font.BOLD,24);

        but = new JButton[10];
        for(int i=0; i<10; i++){
            but[i] = new JButton(String.valueOf(i));
        }

        Add = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        sqrt = new JButton("sqrt");
        square = new JButton("x*x");
        powerof = new JButton("x^y");
        rate = new JButton("x%");
        log = new JButton("log10(x)");
        cancel = new JButton("C");
        equal = new JButton("=");
        cos = new JButton("Cos");
        sin = new JButton("Sin");
        tan = new JButton("Tan");
        onedivided = new JButton("1/x");

        cal = new calculatorrun();

    }

    public void init(){
        frame.setSize(450,450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text.setFont(textFont);
        text.setEditable(false);

        for(int i=0; i<10; i++){
            but[i].setFont(font);
        }

        Add.setFont(font);
        minus.setFont(font);
        multiply.setFont(font);
        divide.setFont(font);
        equal.setFont(font);
        square.setFont(font);
        sqrt.setFont(font);
        sin.setFont(font);
        cos.setFont(font);
        tan.setFont(font);
        powerof.setFont(font);
        log.setFont(font);
        rate.setFont(font);
        cancel.setFont(font);

        panel.add(Box.createHorizontalStrut(100));
        panelSub1.add(text);
        panel.add(panelSub1);

        panelSub2.add(but[1]);
        panelSub2.add(but[2]);
        panelSub2.add(but[3]);
        panelSub2.add(Box.createHorizontalStrut(15));
        panelSub2.add(Add);
        panelSub2.add(minus);
        panelSub2.add(panelSub2);

        panelSub3.add(but[4]);
        panelSub3.add(but[5]);
        panelSub3.add(but[6]);
        panelSub3.add(Box.createHorizontalStrut(15));
        panelSub3.add(multiply);
        panelSub3.add(divide);
        panel.add(panelSub3);

        panelSub4.add(but[7]);
        panelSub4.add(but[8]);
        panelSub4.add(but[9]);
        panelSub4.add(Box.createHorizontalStrut(15));
        panelSub4.add(equal);
        panelSub4.add(cancel);
        panel.add(panelSub4);

        panelSub5.add(Box.createHorizontalStrut(92));
        panelSub5.add(but[0]);
        panelSub5.add(Box.createHorizontalStrut(210));
        panel.add(panelSub5);

        panelSub6.add(square);
        panelSub6.add(sqrt);
        panelSub6.add(divide);
        panelSub6.add(powerof);
        panel.add(panelSub6);

        panelSub7.add(cos);
        panelSub7.add(sin);
        panelSub7.add(tan);
        panel.add(panelSub7);

        panelSub8.add(log);
        panelSub8.add(rate);
        panel.add(panelSub8);

        for (int i=0; i<10; i++){
            but[i].addActionListener(this);
        }
        Add.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        square.addActionListener(this);
        sqrt.addActionListener(this);
        onedivided.addActionListener(this);
        cos.addActionListener(this);
        sin.addActionListener(this);
        tan.addActionListener(this);
        powerof.addActionListener(this);
        log.addActionListener(this);
        rate.addActionListener(this);

        equal.addActionListener(this);
        cancel.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        Double checkNum = null;

        for(int i = 0; i<10; i++){
            if(source == but[i]){
                text.replaceSelection(buttonval[i]);
                return;
            }
        }

        try{
            checkNum = Double.parseDouble(text.getText());
        }catch (NumberFormatException k){

        }

        if(checkNum != null || source == cancel){
            if(source == Add){
                writer(calculatorrun.calculateBi(calculator.Bioperatormodes.add, reader()));
                text.replaceSelection(Add.getText());

                if (source == butMinus) {
                    writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()));
                    text.replaceSelection(butMinus.getText());
                }

                if (source == butMultiply) {
                    writer(calc.calculateBi(Calculator.BiOperatorModes.multiply, reader()));
                    text.replaceSelection(butMultiply.getText());
                }

                if (source == butDivide) {
                    writer(calc.calculateBi(Calculator.BiOperatorModes.divide, reader()));
                    text.replaceSelection(butDivide.getText());
                }

                if (source == butxpowerofy) {
                    writer(calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, reader()));
                }

                if (source == butSquare) {
                    writer(calc.calculateMono(Calculator.MonoOperatorModes.square, reader()));
                }

                if (source == butSquareRoot)
                    writer(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, reader()));

                if (source == butOneDividedBy)
                    writer(calc.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, reader()));

                if (source == butCos)
                    writer(calc.calculateMono(Calculator.MonoOperatorModes.cos, reader()));

                if (source == butSin)
                    writer(calc.calculateMono(Calculator.MonoOperatorModes.sin, reader()));

                if (source == butTan)
                    writer(calc.calculateMono(Calculator.MonoOperatorModes.tan, reader()));

                if (source == butlog)
                    writer(calc.calculateMono(Calculator.MonoOperatorModes.log, reader()));

                if (source == butrate)
                    writer(calc.calculateMono(Calculator.MonoOperatorModes.rate, reader()));

                if (source == butabs)
                    writer(calc.calculateMono(Calculator.MonoOperatorModes.abs, reader()));

                if (source == butEqual)
                    writer(calc.calculateEqual(reader()));

                if (source == butCancel)
                    writer(calc.reset());

                if (source == butBinary)
                    parsetoBinary();
            }

            text.selectAll();
        }


    }
}

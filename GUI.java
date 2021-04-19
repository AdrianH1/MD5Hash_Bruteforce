import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    
    private static final long serialVersionUID = 1L;
    JPanel titlePanel;
    JPanel hashGeneratePanel;
    JPanel bruteforcePanel;
    JPanel resultPanel;
    JPanel errorPanel;

    JLabel mainTitle_lbl;
    JLabel enterKeyword_lbl;
    JLabel enterMd5_lbl;
    JLabel enterCharCount_lbl;
    JLabel numberOfAttempts_lbl;

    public static JTextField keywordCharCount_txtf;
    public static JTextField keywordInput_txtf;
    public static JTextField md5Output_txtf;
    public static JTextField md5Input_txtf;
    public static JTextField keywordOutput_txtf;
    public static JTextField numberOfAttempts_txtf;
    public static JTextField errorMessage_txtf;

    ButtonGroup radiogrp;
    public static JRadioButton lowercase_radio;
    public static JRadioButton uppercase_radio;
    public static JRadioButton bothcase_radio;

    JButton convertToMd5_btn;
    JButton convertToKeyword_btn;

    public GUI(){
        this.setLocation(400, 100);
        this.setSize(500, 500);        
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));

        //Title panel
        titlePanel = new JPanel();
        mainTitle_lbl = new JLabel("Bruteforce MD5 Hash");
        titlePanel.add(mainTitle_lbl);
        
        //Hash generator panel
        hashGeneratePanel = new JPanel();
        // hashGeneratePanel.setLayout(new BoxLayout(hashGeneratePanel, BoxLayout.X_AXIS));
        enterKeyword_lbl = new JLabel("Enter Keyword");
        keywordInput_txtf = new JTextField();
        keywordInput_txtf.setColumns(10);
        md5Output_txtf = new JTextField("Md5 Hash Output");
        md5Output_txtf.setColumns(21);
        md5Output_txtf.setForeground(Color.GRAY);
        md5Output_txtf.setEditable(false);
        convertToMd5_btn = new JButton("Convert to MD5");
        convertToMd5_btn.setActionCommand("convertToMd5");
        convertToMd5_btn.addActionListener(new ButtonActionListener());
        
        hashGeneratePanel.add(enterKeyword_lbl);
        hashGeneratePanel.add(keywordInput_txtf);
        hashGeneratePanel.add(md5Output_txtf);
        hashGeneratePanel.add(convertToMd5_btn);

        //Bruteforce entries panel
        bruteforcePanel = new JPanel();
        enterMd5_lbl = new JLabel("Enter Md5 Hash");
        md5Input_txtf = new JTextField();
        md5Input_txtf.setColumns(21);
        enterCharCount_lbl = new JLabel("Keyword character number:");
        keywordCharCount_txtf = new JTextField();
        keywordCharCount_txtf.setColumns(3);  
        
        lowercase_radio = new JRadioButton("lowercase");
        uppercase_radio = new JRadioButton("uppercase");
        bothcase_radio = new JRadioButton("lower & uppercase");
        radiogrp = new ButtonGroup();
        radiogrp.add(lowercase_radio);
        radiogrp.add(uppercase_radio);
        radiogrp.add(bothcase_radio);
        convertToKeyword_btn = new JButton("Convert to Keyword");
        convertToKeyword_btn.setActionCommand("convertToKeyword");
        convertToKeyword_btn.addActionListener(new ButtonActionListener());
        
        bruteforcePanel.add(enterMd5_lbl);
        bruteforcePanel.add(md5Input_txtf);
        bruteforcePanel.add(enterCharCount_lbl);
        bruteforcePanel.add(keywordCharCount_txtf);
        bruteforcePanel.add(lowercase_radio);
        bruteforcePanel.add(uppercase_radio);
        bruteforcePanel.add(bothcase_radio);
        bruteforcePanel.add(convertToKeyword_btn);

        //result Panel
        resultPanel = new JPanel();
        keywordOutput_txtf = new JTextField("Keyword Output");
        keywordOutput_txtf.setColumns(10);
        keywordOutput_txtf.setForeground(Color.GRAY);
        keywordOutput_txtf.setEditable(false);
        numberOfAttempts_lbl = new JLabel("Number of attempts");
        numberOfAttempts_txtf = new JTextField("#");
        numberOfAttempts_txtf.setColumns(5);
        numberOfAttempts_txtf.setForeground(Color.GRAY);
        numberOfAttempts_txtf.setEditable(false);

        resultPanel.add(keywordOutput_txtf);
        resultPanel.add(numberOfAttempts_lbl);
        resultPanel.add(numberOfAttempts_txtf);

        //Error Panel
        errorPanel = new JPanel();
        errorMessage_txtf = new JTextField("Errormessage");
        errorMessage_txtf.setColumns(20);
        errorMessage_txtf.setEditable(false);
        errorMessage_txtf.setVisible(false);

        errorPanel.add(errorMessage_txtf);


        //Add all panels to container
        mainContainer.add(titlePanel);
        mainContainer.add(hashGeneratePanel);
        mainContainer.add(bruteforcePanel);
        mainContainer.add(resultPanel);
        mainContainer.add(errorPanel);


        this.setVisible(true);
    }

}

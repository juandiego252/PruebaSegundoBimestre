import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import personas.*;

public class root {
    private JTextField codtext;
    private JTextField citext;
    private JTextField nametext;
    private JTextField apellidotext;
    private JComboBox comboBox1;
    private JButton cargarDatosButton;
    private JButton guardarDatosButton;
    private JButton antras;
    private JButton siguiente;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JCheckBox rojoCheckBox;
    private JCheckBox verdeCheckBox;
    private JCheckBox ningunoCheckBox;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JPanel root;

    public String filePath = "binary data.dat";
    public persona person1[] = new persona[5];
    public root() {
        guardarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream fileOut = new FileOutputStream(filePath);
                    ObjectOutputStream obOut = new ObjectOutputStream(fileOut);
                    obOut.writeObject(person1);
                    System.out.println("Datos Guardados exitosamente");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cargarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fileIn = new FileInputStream(filePath);
                    ObjectInputStream obIn = new ObjectInputStream(fileIn);
                    persona readObject = (persona) obIn.readObject();
                }catch (Exception E){
                    codtext.setText("2021359");
                    citext.setText("1755014238");
                    nametext.setText("Diego");
                    apellidotext.setText("Cordova");
                }
            }
        });
        antras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codtext.setText("2022929");
                citext.setText("1735787282");
                nametext.setText("Adrian");
                apellidotext.setText("Lopez");
            }
        });
        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codtext.setText("2021359");
                citext.setText("1788989");
                nametext.setText("Fabian");
                apellidotext.setText("Correa");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("root");
        frame.setContentPane(new root().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

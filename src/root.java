import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


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

    private List <persona> listadatosPersonas;
    private int posicionActual;
    public root() {
        listadatosPersonas = new ArrayList<>();
        posicionActual = 0;

        guardarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codtext.getText();
                String cedula = citext.getText();
                String nombre = nametext.getText();
                String apellido = apellidotext.getText();

                String zodiaco = comboBox1.getSelectedItem().toString();
                String anio = comboBox2.getSelectedItem().toString();
                String mes = comboBox3.getSelectedItem().toString();
                String dia = comboBox4.getSelectedItem().toString();

                boolean rojo = rojoCheckBox.isSelected();
                boolean verde = verdeCheckBox.isSelected();
                boolean ninguno = ningunoCheckBox.isSelected();

                boolean sicasado = siRadioButton.isSelected();
                boolean nocasado = noRadioButton.isSelected();

                persona datosPersonas = new persona(codigo,cedula,nombre,apellido,zodiaco,anio,mes,dia,rojo,verde,
                        ninguno,sicasado,nocasado);

                listadatosPersonas.add(datosPersonas);

                try {
                    FileOutputStream fileObj = new FileOutputStream("binarydata.dat");
                    ObjectOutputStream ObOut = new ObjectOutputStream(fileObj);

                    ObOut.writeObject(listadatosPersonas);

                    ObOut.close();
                    fileObj.close();

                    JOptionPane.showMessageDialog(root, "Datos guardados correctamente.", "Guardar Datos", JOptionPane.INFORMATION_MESSAGE);

                    codtext.setText("");
                    citext.setText("");
                    nametext.setText("");
                    apellidotext.setText("");

                    comboBox1.setSelectedIndex(0);
                    comboBox2.setSelectedIndex(0);
                    comboBox3.setSelectedIndex(0);
                    comboBox4.setSelectedIndex(0);

                    rojoCheckBox.setSelected(false);
                    verdeCheckBox.setSelected(false);
                    ningunoCheckBox.setSelected(false);

                    siRadioButton.setSelected(false);
                    noRadioButton.setSelected(false);

                } catch (IOException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(root, "Error al guardar los datos.", "Guardar Datos", JOptionPane.ERROR_MESSAGE);


                }

            }
        });
        cargarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fileIn = new FileInputStream("binarydata.dat");
                    ObjectInputStream ObIn = new ObjectInputStream(fileIn);

                    listadatosPersonas = (List<persona>) ObIn.readObject();

                    if (listadatosPersonas.isEmpty()){
                        JOptionPane.showMessageDialog(root, "No se encontraron datos guardados.", "Cargar Datos", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        cargarDatosPersona(posicionActual);
                        persona datosPersona = listadatosPersonas.get(0);

                        codtext.setText(datosPersona.getCodigo());
                        citext.setText(datosPersona.getCedula());
                        nametext.setText(datosPersona.getNombres());
                        apellidotext.setText(datosPersona.getApellidos());

                        comboBox1.setSelectedItem(datosPersona.getZodiaco());
                        comboBox2.setSelectedItem(datosPersona.getAnio());
                        comboBox3.setSelectedItem(datosPersona.getAnio());
                        comboBox4.setSelectedItem(datosPersona.getDia());

                        rojoCheckBox.setSelected(datosPersona.isRojo());
                        verdeCheckBox.setSelected(datosPersona.isVerde());
                        ningunoCheckBox.setSelected(datosPersona.isNinguno());

                        siRadioButton.setSelected(datosPersona.isSicasado());
                        noRadioButton.setSelected(datosPersona.isNocasado());
                        JOptionPane.showMessageDialog(root, "Datos cargados correctamente.", "Cargar Datos", JOptionPane.INFORMATION_MESSAGE);
                    }

                    ObIn.close();
                    fileIn.close();

                } catch (IOException  | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(root, "Error al cargar los datos.", "Cargar Datos", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listadatosPersonas.isEmpty()){
                    posicionActual++;
                    if (posicionActual >= listadatosPersonas.size()){
                        posicionActual = 0; // reiniciar la posicion actual
                    }
                    cargarDatosPersona(posicionActual);
                }
            }
        });
        antras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listadatosPersonas.isEmpty()){
                    posicionActual--;
                    if (posicionActual < 0){
                        posicionActual = listadatosPersonas.size() - 1; // retroceder al final si se alcanza el principo de la lista
                    }
                    cargarDatosPersona(posicionActual);
                }
            }
        });
    }

    private void cargarDatosPersona(int indice) {
        persona datosPersona = listadatosPersonas.get(indice);

        codtext.setText(datosPersona.getCodigo());
        citext.setText(datosPersona.getCedula());
        nametext.setText(datosPersona.getNombres());
        apellidotext.setText(datosPersona.getApellidos());

        comboBox1.setSelectedItem(datosPersona.getZodiaco());
        comboBox2.setSelectedItem(datosPersona.getAnio());
        comboBox3.setSelectedItem(datosPersona.getMes());
        comboBox4.setSelectedItem(datosPersona.getDia());

        rojoCheckBox.setSelected(datosPersona.isRojo());
        verdeCheckBox.setSelected(datosPersona.isVerde());
        ningunoCheckBox.setSelected(datosPersona.isNinguno());

        siRadioButton.setSelected(datosPersona.isSicasado());
        noRadioButton.setSelected(datosPersona.isNocasado());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("root");
        frame.setContentPane(new root().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
};

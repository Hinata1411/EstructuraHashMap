import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.io.File;


//Creamos una clase pública llamada RegistrodeVacunasGUI para la interfaz gráfica
//y esta clase hereda de la clase JFrame
public class RegistrodeVacunasGUI extends JFrame {

    private HashMap<String, RegistrodeVacuna> registros;
    private JTextField campoCui;
    private JTextArea Resultado;

    //Constructor
    public RegistrodeVacunasGUI(){
        super("Vacunas");
        registros = new HashMap<>();
        cargarRegistrosDesdeArchivotxt();
        JLabel etiquetaCui = new JLabel("CUI:");
        campoCui = new JTextField(12);
        JButton botonBuscar = new JButton("Buscar");
        Resultado = new JTextArea(12, 35);
        Resultado.setEditable(false);

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarRegistroEnArchivotxt();
            }
        });

       JPanel panelP = new JPanel();
       panelP.setLayout(new BorderLayout());
       panelP.add(etiquetaCui, BorderLayout.WEST);
       panelP.add(campoCui, BorderLayout.CENTER);
       panelP.add(botonBuscar, BorderLayout.EAST);

       JScrollPane scrollPane = new JScrollPane(Resultado);
       getContentPane().add(panelP, BorderLayout.NORTH);
       getContentPane().add(scrollPane, BorderLayout.CENTER);

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(400, 400);
       setLocationRelativeTo(null);
       setVisible(true);
    }


    private void cargarRegistrosDesdeArchivotxt() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("registros.dat"))){
            registros = (HashMap<String, RegistrodeVacuna>) ois.readObject();

        }catch (FileNotFoundException e){
            System.out.println("No Se encontró el archivo en los registros. Intente de nuevo.");

        }catch (IOException| ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void guardarRegistrosEnArchivotxt(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("registros.dat"))){
            oos.writeObject(registros);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void buscarRegistroEnArchivotxt(){
        String cuiBuscar = campoCui.getText().trim();
        RegistrodeVacuna registro = registros.get(cuiBuscar);
        if (registro != null){
           Resultado.setText(registro.toString());
        } else {
            Resultado.setText("No se encontró ningún registro con ese CUI.");
        }
    }




}
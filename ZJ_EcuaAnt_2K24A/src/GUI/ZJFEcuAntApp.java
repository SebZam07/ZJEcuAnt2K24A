package GUI;

import javax.swing.*;

import BL.Entities.X;
import BL.Entities.XX;
import BL.Entities.XY;
import BL.Entities.ZJGenoAlimento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ZJFEcuAntApp extends  JFrame {
    public static void main(String[] args) {
        // Inicializa la aplicación
        System.out.println("Aplicación Iniciada");
        // Resto del código para iniciar la GUI
    }
    public void EcuAntApp (){
        customerControls();
    }

    public void customerControls() {

        setTitle("ZJEcuAnt 2K24A");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        //Panle superior con la imagen y el titulo
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel imgLabel = new JLabel(new ImageIcon("src\\GUI\\Resource\\Logo.png"));
        JLabel titleLabel = new JLabel("HORMIGUERO VIRTUAL", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial",Font.BOLD,16));
        topPanel.add(imgLabel, BorderLayout.NORTH);
        topPanel.add(titleLabel, BorderLayout.SOUTH);

        //Panel de Grilla
        String[] columnNames = {"RegNro","TipoHormiga", "Ubicacion","Sexo","IngestaNativa","GenoAlimento","Estado"};
        Object[][] data = new Object[8][7];
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        //Panel para los combos
        JPanel comboPanel = new JPanel();
        // String[] genoOptions = {"X","XX","XY"};
        // JComboBox<String> genoCombo = new JComboBox<>(genoOptions);

//----------------------------------------------------------------------------------------------------

        ArrayList<ZJGenoAlimento> lstGenoAlimento = new ArrayList<>();
        lstGenoAlimento.add(new X());
        lstGenoAlimento.add(new XX());
        lstGenoAlimento.add(new XY());

        JComboBox <ZJGenoAlimento> genoCombo = new JComboBox<> (lstGenoAlimento.toArray(new ZJGenoAlimento[0]));        
        // genoCombo.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         ZJGenoAlimento a = (ZJGenoAlimento) genoCombo.getSelectedItem();
        //         if (a != null) {
        //             System.out.println("ID SELECCIONADO", + a.getClass());
                    
        //         }
        //     }

        // });  
        
        String[] ingestaOptions = {"Carnivoros","Herbivoro","Omnivoro","Insectivoro","Nectarivoros"};
        JComboBox<String> ingestaCombo = new JComboBox<>(ingestaOptions);
        comboPanel.add(genoCombo);
        comboPanel.add(ingestaCombo);
        
        //Panel para los botones

        JPanel buttonPanel = new JPanel(new GridLayout(1,4,5,5));
        JButton createButton = new JButton("Crear Larva");
        JButton feedButton = new JButton("Aliemtar");
        JButton deleButton = new JButton("Eliminar");
        JButton saveButton = new JButton("Guardar");
        buttonPanel.add(createButton);
        buttonPanel.add(feedButton);
        buttonPanel.add(deleButton);
        buttonPanel.add(saveButton);

        //Panel combinado para lso combos y botones
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(comboPanel, BorderLayout.SOUTH);

        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel programLabel = new JLabel("PROGRAMACION II");
        JLabel cedulaLabel = new JLabel("1755614227");
        JLabel namesLabel = new JLabel("Nombres: Zambrano Jhojan");

        statusBar.add(programLabel);
        statusBar.add(new JLabel(" | "));
        statusBar.add(cedulaLabel);
        statusBar.add(new JLabel(" | "));
        statusBar.add(namesLabel);
        //mainPanel.add(statusBar, BorderLayout.NORTH);
        
        //Añadir los paneles al frame principal
        add(topPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.NORTH);

        //Mostrar la ventana
        setVisible(true);

    }
}

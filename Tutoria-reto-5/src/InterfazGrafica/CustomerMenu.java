
package InterfazGrafica;

import connector.MyJDBC;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class CustomerMenu extends JFrame{
    
    public JPanel CRUDPanel;
    private JButton crearButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;
    private MyJDBC myJDBC;
    
    public CustomerMenu(MyJDBC myJDBC){
        CRUDPanel = new JPanel();
        CRUDPanel.setLayout(null);
        
        crearButton = new JButton();
        crearButton.setText("Crear cliente");
        crearButton.setBounds(20, 20, 150, 50);
        
        readButton = new JButton();
        readButton.setText("Listar clientes");
        readButton.setBounds(20, 70,150 ,50);
        
        updateButton = new JButton();
        updateButton.setText("Actualizar cliente");
        updateButton.setBounds(20, 120, 150, 50);
        
        deleteButton = new JButton();
        deleteButton.setText("Borrar cliente");
        deleteButton.setBounds(20, 160, 150, 50);
        
        CRUDPanel.add(crearButton);
        CRUDPanel.add(readButton);
        CRUDPanel.add(updateButton);
        CRUDPanel.add(deleteButton);
        
        setContentPane(CRUDPanel);
        setTitle("CRUD");
        setSize(250, 300);
        setLocation(350, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
        readButton.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent actionEvent){
           ListarCliente listar = new ListarCliente(myJDBC);
       } 
    });
    }
    
    
    
}

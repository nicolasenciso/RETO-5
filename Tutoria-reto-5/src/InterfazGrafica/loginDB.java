
package InterfazGrafica;

import javax.swing.*;
import connector.MyJDBC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class loginDB extends JFrame{
    
    public JTextField userField;
    public JButton btnVerificar;
    public JLabel lblName;
    public JLabel lblPassword;
    public JCheckBox showCheckBox;
    public JPasswordField passwordField;
    public JLabel lblTitle;
    public JTextField nameDBField;
    public JLabel lblTabla;
    public JPanel loginPanel;
    
    protected MyJDBC myJDBC;
    
    public loginDB(){
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        
        btnVerificar = new JButton();
        btnVerificar.setText("LOGIN");
        btnVerificar.setBounds(190, 210, 100, 30);
        
        lblName = new JLabel();
        lblName.setBounds(180, 0, 150, 30);
        lblName.setText("Ingrese usuario:");
        
        userField = new JTextField();
        userField.setBounds(190, 25, 100, 30);
        
        lblTabla = new JLabel();
        lblTabla.setBounds(180, 60, 150, 30);
        lblTabla.setText("Ingrese nombre DB:");
        
        nameDBField = new JTextField();
        nameDBField.setBounds(190, 85, 100, 30);
        
        lblPassword = new JLabel();
        lblPassword.setBounds(180, 115, 180, 30);
        lblPassword.setText("Ingrese contraseña:");
        
        passwordField = new JPasswordField();
        passwordField.setBounds(190, 145, 100, 30);
        
        showCheckBox = new JCheckBox();
        showCheckBox.setBounds(290, 145, 100, 30);
        
        
        loginPanel.add(btnVerificar);
        loginPanel.add(lblName);
        loginPanel.add(userField);
        loginPanel.add(lblTabla);
        loginPanel.add(nameDBField);
        loginPanel.add(lblPassword);
        loginPanel.add(passwordField);
        loginPanel.add(showCheckBox);
        
        setContentPane(loginPanel);
        setTitle("Mi programa tienda");
        setSize(480, 300);
        setLocation(350,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
        showCheckBox.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent actionEvent){
               MostrarPassword();
           } 
        });
        
        btnVerificar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                btnVerificarAction();
            }
        });
        
    }
    
    public void btnVerificarAction(){
        String salida = "";
        if(!userField.getText().equals("") &&
                !passwordField.getText().equals("") &&
                !nameDBField.getText().equals("")){
            
            myJDBC = new MyJDBC(nameDBField.getText(),
                                userField.getText(),
                                passwordField.getText());
            
            if(myJDBC.ConnectionMyDB()){
                System.out.println("BASE DE DATOS CONECTADA");
                JOptionPane.showMessageDialog(null, "BIENVENIDO !!");
                CustomerMenu menucliente = new CustomerMenu(myJDBC);
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo conectar a la DB", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }else{
            salida = "Error de campos";
            JOptionPane.showMessageDialog(null, "Falta un campo por completar", "Error", JOptionPane.YES_NO_OPTION);
        }
    }
    
    public void MostrarPassword(){
        if(showCheckBox.isSelected()){
            passwordField.setEchoChar((char)0);
        }else{
            passwordField.setEchoChar('\u25cf');
        }
    }
    
}

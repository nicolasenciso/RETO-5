
package InterfazGrafica;
import connector.MyJDBC;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ListarCliente extends JFrame{
    private JTable table1;
    private JButton btnContinuar;
    private JPanel readPanel;
    private MyJDBC myJDBC;
    private DefaultTableModel model;
    
    protected String [] Header;
    private Vector<String[]> listaFila;
    protected String[][] datosTabla;
    
    public ListarCliente(MyJDBC myJDBC){
        this.myJDBC = myJDBC;
        Header = new String[]{"ID", "Nombre", "Telefono"};
        datosTabla = new String[][]{};
        
        readPanel = new JPanel();
        readPanel.setLayout(null);
        table1 = new JTable();
        
        table1.setBounds(0, 10, 750, 250);
        
        btnContinuar = new JButton();
        btnContinuar.setText("CONTINUAR");
        btnContinuar.setBounds(560, 260, 160, 40);
        
        readPanel.add(btnContinuar);
        readPanel.add(table1);
        
        setContentPane(readPanel);
        setTitle("clientes");
        setSize(750, 340);
        setLocation(350, 200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
        if(Tabla()){
            JOptionPane.showMessageDialog(null, "DATOS LISTADOS CORRECTAMENTE", "Mensaje", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Error al leer los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        btnContinuar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent actionEvent) {
               (SwingUtilities.getWindowAncestor(readPanel)).dispose();
           }
        });
        
        
    }
    
    public boolean Tabla(){
        boolean salida = false;
        try{
            listaFila = myJDBC.READ("SELECT * FROM persona;");
            datosTabla = new String[listaFila.size()][Header.length];
            
            for(int i = 0; i < listaFila.size(); i++){
                for(int j = 0; j < Header.length; j++){
                    datosTabla[i][j] = String.valueOf(listaFila.get(i)[j]);
                }
            }
            
            model = new DefaultTableModel(datosTabla, Header);
            table1.setModel(model);
            salida = true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return salida;
    }
    
}

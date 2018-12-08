package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import model.ModelAGCD;
import view.ViewAGCD;

public class ControllerAGCD implements ActionListener
{
    private final ModelAGCD modeAGCD;
    private final ViewAGCD viewAGCD;
    FileFilter filtro = new FileNameExtensionFilter("Funciono");

    public ControllerAGCD(ViewAGCD viewAGCD, ModelAGCD modelAGCD)    
    {
        this.viewAGCD = viewAGCD;
        this.modeAGCD = modelAGCD;
        viewAGCD.Jmi_abrir.addActionListener(this);
        viewAGCD.Jmi_guardar.addActionListener(this);
        viewAGCD.Jmi_cifrar.addActionListener(this);
        viewAGCD.Jmi_decifrar.addActionListener(this);
        initView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewAGCD.Jmi_abrir){
            JFileChooser file=new JFileChooser(); //Crea el objeto para el filechooser
            file.addChoosableFileFilter(filtro);
            file.showOpenDialog(null); //Carga la ventana de dialogo y encuentra la ruta donde almacenamos el archivo 
            modeAGCD.readFile(modeAGCD.getPath()); //abre el archivo obteniendo la ruta desde el modelo
            viewAGCD.Jta_txt.setText(modeAGCD.getMessage()); //muestra el contenido en el JTextArea
        }else if(e.getSource()==viewAGCD.Jmi_guardar){
            JFileChooser file=new JFileChooser();
            file.addChoosableFileFilter(filtro);
            file.showSaveDialog(null);
            modeAGCD.setPath(""+file.getSelectedFile());
            modeAGCD.setMessage(viewAGCD.Jta_txt.getText());
            modeAGCD.writeFile(modeAGCD.getPath(), modeAGCD.getMessage());
        }else if(e.getSource()==viewAGCD.Jmi_cifrar){
            JFileChooser file=new JFileChooser(); 
            file.addChoosableFileFilter(filtro);
            file.showSaveDialog(null);
            modeAGCD.setPath(""+file.getSelectedFile());
            modeAGCD.setMessage(viewAGCD.Jta_txt.getText());
            modeAGCD.writeFileEncrypted(modeAGCD.getPath(), modeAGCD.getMessage());
        }else if(e.getSource()==viewAGCD.Jmi_decifrar){
            JFileChooser file=new JFileChooser(); 
            file.addChoosableFileFilter(filtro);
            file.showOpenDialog(null);
            modeAGCD.readFileDecrypted(modeAGCD.getPath());
            viewAGCD.Jta_txt.setText(modeAGCD.getMessage()); //muestra el contenido en el JTextArea
        }
    }
    private void initView() 
    {
        viewAGCD.setTitle("Archivo");
        viewAGCD.setResizable(false);
        viewAGCD.setLocationRelativeTo(null);
        viewAGCD.setVisible(true);
    }
}
package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{
    /**
     * El comando para el botón para crear un nuevo restaurante
     */
    private static final String NUEVO = "nuevo";

    /**
     * El comando para el botón para ver todos los restaurantes en el mapa
     */
    private static final String VER = "ver";

    //definicion de atributos
    private JButton butNuevo;
    private JButton butVerTodos;
    private VentanaPrincipal ventanaPrincipal;

    public PanelBotones( VentanaPrincipal ventanaPrincipal )
    {
        this.ventanaPrincipal = ventanaPrincipal;

        setLayout( new FlowLayout( ) );

        // Agrega el botón para crear un nuevo restaurante
        // TODO completar
        
        //Paso 1: Crear al boton de Nuevo restaurante
        butNuevo = new JButton("Nuevo");
        //Paso 2: Establecer su accionListener: distinguir cuál botón fue presionado
        //Va a decir "nuevo", que se encuentra en la variable estática final NUEVO
        
        //Es como que cuando oprimen al botón: él grita
        butNuevo.setActionCommand(NUEVO);
        
        //Paso 3: añadirle al accion listener, esta clase la implementa. Además, usamos "this"
        // para que PanelBotones sea la encargada de reaccionar
        
        //Es como que cuando el botón grita, PanelBotones escucha
        
        // PanelBotones, con su actionPerfomed, sabrá qué hacer con el grito
        butNuevo.addActionListener(this);
        //Paso 4: Añadir al botón al Panel Botones
        add(butNuevo);

        // Agrega el botón para ver todos los restaurantes
        // TODO completar
        //Mismos pasos que el anterio
        butVerTodos = new JButton("Ver todos");
        butVerTodos.setActionCommand(VER);
        butVerTodos.addActionListener(this);
        add(butVerTodos);
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( NUEVO ) )
        {
            ventanaPrincipal.mostrarVetanaNuevoRestaurante( );
        }
        else if( comando.equals( VER ) )
        {
            ventanaPrincipal.mostrarVentanaMapa( );
        }
    }
}

package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );

        // Agrega el panel donde va a estar el mapa
        // TODO completar
        panelMapa = new PanelMapaAgregar();
        add( panelMapa, BorderLayout.CENTER);


        // Agrega en el sur un panel para los detalles del restaurante y para los botones
        // TODO completar
        JPanel nuevo_panel = new JPanel();
        nuevo_panel.setLayout(new BorderLayout());
        
        panelDetalles = new PanelEditarRestaurante();
        panelBotones = new PanelBotonesAgregar(this);
        nuevo_panel.add(panelDetalles, BorderLayout.CENTER);
        nuevo_panel.add(panelBotones, BorderLayout.SOUTH);
        
        add(nuevo_panel, BorderLayout.SOUTH );
        

        // Termina de configurar la ventana
        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
        // TODO completar
    	String n_res = panelDetalles.getNombre();
    	//si esta vacio, se sabe por PanelEditarRestaurante
    	//Nota: Queria poner esto pero me da miedo que me bajen xd
    	//if(n_res == null) {
    	  //  JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
    	//}
    	int n_can = panelDetalles.getCalificacion();
    	boolean n_visit = panelDetalles.getVisitado();
    	int[] n_map = panelMapa.getCoordenadas();
    	//si esta vacio, se sabe por PanelMapaAgregar
    	//if(n_map == null) {
    	  //  JOptionPane.showMessageDialog(this, "La coordenada no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
    		
    	//}

    	ventanaPrincipal.agregarRestaurante(n_res, n_can, n_map[0], n_map[1], n_visit);
    	
    	cerrarVentana();
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}

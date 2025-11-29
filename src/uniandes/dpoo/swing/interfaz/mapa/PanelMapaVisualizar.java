package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    /**
     * La etiqueta donde se dibuja el mapa y se hacen las señales de los restaurantes
     */
    private JLabel labMapa;

    /**
     * La lista de restaurantes que se están dibujando en el mapa
     */
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar( )
    {
        this.labMapa = new JLabel( new ImageIcon( "./imagenes/mapa.png" ) );
        labMapa.setBorder( new LineBorder( Color.DARK_GRAY ) );
        add( labMapa, BorderLayout.CENTER );
    }

    @Override
    public void paint( Graphics g )
    {
        super.paint( g );
        Graphics2D g2d = ( Graphics2D )g;
        
     // TODO completar y hacer que se vean los nombres de todos los restaurantes en el mapa
        // Paso 1: Color del punto del restaurante
        g2d.setColor(Color.RED);
        for(Restaurante r: restaurantes) {
        	int x = r.getX();
        	int y = r.getY();
        	
        	//Paso 2: Dibujar el punto
        	int radio = 10;
        	g2d.fillOval(x-radio/2, y-radio/2, radio, radio);
        	
        	//Paso 3: Dibujar el nombre all lado
        	g2d.setColor(Color.RED);
        	Font font = new Font("Arial", Font.BOLD, 16); // tamaño 16, le ponemos una fuente
        	g2d.setFont(font);
        	g2d.drawString(r.getNombre(), x+8, y-8);
        	
        	//Vlver al color del punto
        	g2d.setColor(Color.RED);
        }
        
    }

    /**
     * Actualiza la lista de restaurantes y llama al método repaint() para que se actualice el mapa
     * @param nuevosRestaurantes
     */
    public void actualizarMapa( List<Restaurante> nuevosRestaurantes )
    {
        if( restaurantes != null )
        {
            this.restaurantes.clear( );
            this.restaurantes.addAll( nuevosRestaurantes );
        }
        else
        {
            this.restaurantes = nuevosRestaurantes;
        }
        repaint( );
    }
}

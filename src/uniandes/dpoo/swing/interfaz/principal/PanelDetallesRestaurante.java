package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    /**
     * La etiqueta donde se muestra el nombre de un restaurante
     */
    private JLabel labNombre;

    /**
     * La etiqueta donde se muestra la calificación de un restaurante, usando imágenes de estrellas
     */
    private JLabel labCalificacion;

    /**
     * Un checkbox en el que se muestra si un restaurante fue visitado o no
     */
    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante( )
    {
        // Configura la etiqueta para el nombre
        // TODO completar el constructor
    	//Paso 1: Crear el nuevo JLabel, para el nombre del restaurante
    	//Para cada uno vamos a tener un panel
    	JPanel filaNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	JLabel texto_nom = new JLabel("Nombre: ");
    	labNombre = new JLabel();
    	filaNombre.add(texto_nom);
    	filaNombre.add(labNombre);

        // Configura la etiqueta para la calificación
        // TODO completar el constructor
    	//Paso 2: Crear el nuevo JLabel, para las estrellas
    	//Creamos un panel
    	JPanel filaCalif = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	JLabel texto_cal = new JLabel("Calificación: ");
    	labCalificacion = new JLabel();
    	filaCalif.add(texto_cal);
    	filaCalif.add(labCalificacion);

        // Configura el checkbox para indicar si ya se visitaó o no el restaurante
        // TODO completar el constructor
    	//Paso 3: Crear el checkbox
    	JPanel filaVisitado = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	JLabel texto_visit = new JLabel("Visitado: ");
    	chkVisitado = new JCheckBox();
    	filaVisitado.add(texto_visit);
    	filaVisitado.add(chkVisitado);

        // Organiza los elementos en la venta
        // TODO completar el constructo
    	//Paso: Crear la grilla desde 0 
    	//Establecemos el Layout: Dividmos al panel en una grilla de 3 x1
    	//Va a acomodar todo lo que agregemos con add()
    	//Layout: Organizador automático de componentes dentro de un contenedor
    	//En nuestro caso, el contenedor es JPanel.
    	//Nos ayuda a definir cómo se van a acomodar los elementos en el Panel
    	// Es un organizador
    	//Al usar setLayout() le decimos: "ahora organiza los componentes ASÍ:" (como una grilla)
    	//El tipo por defecto de Layout es FlowLayout(), el cual pone las cosas como si fuera texto de un libro
    	setLayout(new GridLayout(3,1));
    	
    	//Paso: Agregar elementos a la grilla,al panel, el Layout se encargara de organizarlos
    	add(filaNombre);
    	add(filaCalif);
    	add(filaVisitado);
    }

    /**
     * Actualiza los datos mostrados del restaurante, indicando los valores por separado.
     * @param nombre
     * @param calificacion
     * @param visitado
     */
    private void actualizarRestaurante( String nombre, int calificacion, boolean visitado )
    {
     // TODO completar actualizarRestaurante
    //Paso 1: Actualizar el label de labNombre
    	labNombre.setText(nombre);
    //Paso 2: actualizar la calificacion (usando la funcion de abajo)
    	labCalificacion.setIcon(buscarIconoCalificacion(calificacion));
    //Paso 3: actualizar el checkbox
    	chkVisitado.setSelected(visitado);
    }

    /**
     * Actualiza los datos que se muestran de un restaurante
     * @param r El restaurante que se debe mostrar
     */
    public void actualizarRestaurante( Restaurante r )
    {
        this.actualizarRestaurante( r.getNombre( ), r.getCalificacion( ), r.isVisitado( ) );
    }

    /**
     * Dada una calificación, retorna una imagen para utilizar en la etiqueta que muestra la calificación
     * @param calificacion La calificación del restaurante, que debe ser un numero entre 1 y 5.
     * @return Una imagen a la que corresponde la calificación
     */
    private ImageIcon buscarIconoCalificacion( int calificacion )
    {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon( imagen );
    }
}

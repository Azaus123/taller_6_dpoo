package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {
        // Crea el campo para el nombre con una etiqueta al frente
        // TODO completar
    	//Paso 1: Crear el campo, pero tambien al label con el texto
    	JLabel labNombre = new JLabel("Nombre: ");
    	txtNombre = new JTextField();
    	txtNombre.setColumns(15); //para que se vea de 15

        // Crea el selector para la calificación con una etiqueta al frente
        // TODO completar
    	//Paso 2: Crear al combo box, pero también su label
    	JLabel labCalificacion = new JLabel("Calificación: ");
    	cbbCalificacion = new JComboBox<String>();
    	//Paso: Agregarle las opciones
    	//Como son calificamos, ponemos de 1 a 5
    	cbbCalificacion.addItem("1");
    	cbbCalificacion.addItem("2");
    	cbbCalificacion.addItem("3");
    	cbbCalificacion.addItem("4");
    	cbbCalificacion.addItem("5");

        // Crea el selector para indicar si ya ha sido visitado, con una etiqueta al frente
        // TODO completar
    	//Paso 3: Crear al otro combo box de visitados, pero tambien el label 
    	JLabel labVisitado = new JLabel("Visitado: "); 
    	cbbVisitado = new JComboBox<String>();
    	//Paso: Agregar las opciones
    	//Como es o no visitado, ponemos "Sí" o "No"
    	cbbVisitado.addItem("Sí");
    	cbbVisitado.addItem("No");

        // Agregar todos los elementos al panel
        // TODO completar
    	//En la imagen queremos que quede como en la pantalla anterior: como en una grilla 3 x 1
    	
    	//Así, toca crear FlowLayout dentro de cada parte de la grilla 
    	setLayout(new GridLayout(3,1));
    	
    	//AGREGAR PANELES
    	
    	//Parte 1: Nombres
    	JPanel filaNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	filaNombre.add(labNombre);
    	filaNombre.add(txtNombre);
    	add(filaNombre);
    	
    	//Parte 2: Calificaciones
    	JPanel filacalificaciones = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	filacalificaciones.add(labCalificacion);
    	filacalificaciones.add(cbbCalificacion);
    	add(filacalificaciones);
    	
    	//Parte 3: Visitado
        JPanel filaVisitado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaVisitado.add(labVisitado);
        filaVisitado.add(cbbVisitado);
        add(filaVisitado);


    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado( )
    {
    	//Analogo a getCalificacion
    	Boolean retorno = false;
        String visit = (String) cbbVisitado.getSelectedItem();
        if (visit.equals("Sí")){
        	retorno = true;
        }
        return retorno;
    }

    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre( )
    {
        // TODO completar
    	String nomb = txtNombre.getText();
    	//EXTRA: En caso que sea vacio, lo voy a desactivar porque me da miedo que salga mal
    	 //if (nomb.isEmpty())
    	   // {
    	     //   return null;
    	    //}
        return nomb;
    }
}

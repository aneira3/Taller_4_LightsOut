package modelo_interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;


public class interfaz_juego  extends JFrame{
	
	private PanelSuperior superior;
	
	private PanelInferior inferior;
	
	private PanelOpciones opciones;
	
	private PanelTabla tabla;
	
	private Tablero funciones_tablero;
	
	private String nombreUsuario;
	
	private int numeroJugadas;
	
	private Top10 TOP10;
	
	private DialogoTOP10 dialogo;
	

	
	
	
	
	
	public interfaz_juego() {
		setTitle("Lights Out");
		setSize( 600, 700 );
		setLocationRelativeTo( null );
		setResizable( false );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	
		setLayout(new BorderLayout() );
		superior = new PanelSuperior(this);
		add(superior,BorderLayout.NORTH);
		inferior = new PanelInferior();
		add(inferior, BorderLayout.SOUTH);
		opciones = new PanelOpciones(this);
		tabla = new PanelTabla(this);
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
		centro.add(tabla);
		centro.add(opciones, BorderLayout.EAST);
		add(centro, BorderLayout.CENTER);
		this.TOP10 = new Top10();
		TOP10.cargarRecords();
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent e)
		{
		try {
			TOP10.salvarRecords();
		} catch (FileNotFoundException | UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		}
		});
		
	}
	

	public void crear_Tablero() {
		int tamaño = superior.getTamaño();
		int dificultad = superior.getDificultad();
		this.nombreUsuario = inferior.get_jugador();
		if ((tamaño!=0) && (dificultad != 0) && (nombreUsuario != null))
		{
		this.funciones_tablero = new Tablero(tamaño);
		funciones_tablero.desordenar(tamaño);
		tabla.prueba(funciones_tablero);
		inferior.set_jugadas(funciones_tablero.darJugadas());
		}
		
		else {
			JDialog aviso = new JDialog();
			aviso.setSize(850, 100);
			aviso.setTitle("Recordatorio");
			JLabel textoAviso = new JLabel("Recuerde que para crear un juego debe elegir el tamaño, la dificultad y colocar su nombre de usuario en el recuadro derecho inferior.");
			aviso.add(textoAviso);
			aviso.setResizable(false);
			aviso.setLocationRelativeTo(this);
			aviso.setModal(true);
			aviso.setVisible(true);
			//crear mensaje de alerta
		}
		
		
		
	}
	
	public Tablero hacer_jugada(int x, int y) {
		if (funciones_tablero!=null) {
			
			funciones_tablero.jugar(x, y);
			inferior.set_jugadas(funciones_tablero.darJugadas()); 
			this.numeroJugadas = funciones_tablero.darJugadas();
			return funciones_tablero;
		}
		return null;
	}
	
	public void cambiar_jugador() {
		inferior.cambiar_jugador();
	}
	
	public void reiniciar_juego() {
		if (funciones_tablero!=null) {
		funciones_tablero.reiniciar();
		inferior.set_jugadas(funciones_tablero.darJugadas());
		tabla.reiniciar(funciones_tablero);
		}
		
	}
	
	
	public void terminarJuego() {
		int puntaje = funciones_tablero.calcularPuntaje();
		TOP10.agregarRegistro(nombreUsuario, puntaje);
		JDialog ganar = new JDialog();
		ganar.setLocationRelativeTo(this);
		ganar.setSize(550, 100);
		ganar.setLayout(new BorderLayout());
		JLabel textoganar = new JLabel("Usuario: " + nombreUsuario + "   Puntaje: " + Integer.toString(puntaje) + "    Congratulaciones! Ganaste el juego. Juega otra partida.");
		ganar.add(textoganar, BorderLayout.CENTER);
		ganar.setResizable(false);
		ganar.setModal(true);
		ganar.setVisible(true);
		crear_Tablero();
		
		
	}
	
	public void mostrarTOP10() {
		new DialogoTOP10(this,TOP10.darRegistros());
		
	}
	
	
	public static void main( String[] pArgs )
	
	{
		FlatLightLaf.install();
		try
		{
			// Unifica la interfaz para Mac y para Windows.
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

			interfaz_juego interfaz = new interfaz_juego( );
			interfaz.setVisible( true );
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}

}
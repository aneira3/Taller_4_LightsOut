package modelo_interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener{
	
	private JButton nuevo,reiniciar, top10, cambiarJugador;
	
	private interfaz_juego interfaz;
	
	public final static String NUEVO = "Nuevo";
	
	public final static String REINICIAR = "Reiniciar";
	
	public final static String TOP10 = "Top10";
	
	public final static String CAMBIAR_JUGADOR = "Cambiar jugador";
	
	
	public PanelOpciones(interfaz_juego Interfaz) {
		interfaz = Interfaz;
		
		setLayout(new GridLayout(4,1,10,10));
		
		nuevo = new JButton("NUEVO");
		nuevo.setBackground(Color.GRAY);
		nuevo.setActionCommand(NUEVO);
		nuevo.addActionListener(this);
		
		reiniciar = new JButton("REINICIAR");
		reiniciar.setBackground(Color.GRAY);
		reiniciar.setActionCommand(REINICIAR);
		reiniciar.addActionListener(this);
		
		top10 = new JButton("TOP 10");
		top10.setBackground(Color.GRAY);
		top10.setActionCommand(TOP10);
		top10.addActionListener(this);
		
		cambiarJugador = new JButton("CAMBIAR JUGADOR");
		cambiarJugador.setBackground(Color.GRAY);
		cambiarJugador.setActionCommand(CAMBIAR_JUGADOR);
		cambiarJugador.addActionListener(this);
		
		add(nuevo);
		add(reiniciar);
		add(top10);
		add(cambiarJugador);
	
	}
	
	
	public void actionPerformed(ActionEvent event) {
		String comando = event.getActionCommand();
		if (comando.equals(NUEVO)) {
			interfaz.crear_Tablero();
			
		}
		
		else if(comando.equals(CAMBIAR_JUGADOR)) {
			interfaz.cambiar_jugador();
		}
		
		else if (comando.equals(REINICIAR)) {
			interfaz.reiniciar_juego();
		}
		
		else if (comando.equals(TOP10)) {
			interfaz.mostrarTOP10();
		}
		
	}
	

}

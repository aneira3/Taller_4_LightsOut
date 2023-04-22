package modelo_interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInferior extends JPanel {
	
	private JLabel txtJugadas;
	
	private JLabel txtJugador;
	
	private JTextField contadorJugadas;
	
	private JTextField nombreJugador;
	
	
	
	public PanelInferior() {
		setLayout(new GridLayout(1,1));
		txtJugadas = new JLabel("Jugadas: ");
		txtJugador = new JLabel("Jugador: ");
		contadorJugadas = new JTextField();
		contadorJugadas.setEditable(false);
		nombreJugador = new JTextField();
		nombreJugador.setEditable(true);
		nombreJugador.setText("Ingrese su usuario");
		nombreJugador.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e) {
		        if (nombreJugador.getText().equals("Ingrese su usuario")) {
		            nombreJugador.setText("");
		            nombreJugador.setForeground(Color.BLACK);
		        }
		    }

		   
		    public void focusLost(FocusEvent e) {
		        if (nombreJugador.getText().isEmpty()) {
		            nombreJugador.setForeground(Color.GRAY);
		            nombreJugador.setText("Ingrese su usuario");
		        }
		    }
		});
		add(txtJugadas);
		add(contadorJugadas);
		add(txtJugador);
		add(nombreJugador);
		
		
		
	}
	
	
	public void cambiar_jugador() {
		nombreJugador.setText("Ingrese su usuario");
	}
	
	public void set_jugadas(int numero) {
		contadorJugadas.setText(Integer.toString(numero));
	}
	
	public String get_jugador() {
		if (nombreJugador.getText().equals("Ingrese su usuario")) {
			return null;
		}
		return nombreJugador.getText();
	}
	


}

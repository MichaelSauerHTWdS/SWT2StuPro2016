package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import run.Manager;
import tui.MenuesTUI;

public class PlayerInfo extends JPanel implements UpdateAble {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton konto;
	JButton playerName;

	Manager manager;

	public PlayerInfo(Manager manager) {
		this.manager = manager;

		this.setLayout(new FlowLayout());

		playerName = new JButton();
		playerName.setText(manager.actPlayer.getName());
		;
		playerName.setToolTipText("Name des Aktiven Spielers. Klicken um ErfolgsMenue des Spielers Zu öffen");
		this.add(playerName);

		konto = new JButton();
		konto.setText("Konto Stand: " + manager.actPlayer.getKontostand() + " Mark");
		this.add(konto);
	}

	@Override
	public void update() {
		MenuesTUI.println("Updateing PlayerInfo");
		this.playerName.setText(this.manager.actPlayer.getName());
		MenuesTUI.println("Button Name: " + this.playerName.getText());
		this.konto.setText("Konto Stand: " + manager.actPlayer.getKontostand() + " Mark");
		MenuesTUI.println("Button Konto: " + this.konto.getText());
	}
}

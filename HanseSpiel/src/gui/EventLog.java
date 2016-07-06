package gui;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import objekt.Stadt;
import player.Player;
import run.Manager;
import schiff.Schiff;

public class EventLog extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EventLog(Manager manager) {
		JTextArea log = new JTextArea();
		log.setEditable(false);
		this.add(log);

		this.showPlayerLog(manager.actPlayer, log);

	}

	private void showPlayerLog(Player player, JTextArea log) {
		log.setText("");
		log.append("------------------- Event Log -------------------\n");
		for (Schiff s : player.schiffe) {
			log.append("-----------------------------------------------\n");
			if (s.getTravelTime() == 0) {
				log.append("Schiffs Log von  -> " + s.getName() + " liegt in " + ((Stadt) s.getPosition()).getName()
						+ "\n");
			} else {
				log.append("Schiffs Log von  -> " + s.getName() + " fährt nach " + s.getTarget().getName() + "\n");
				log.append("Dauer noch : " + s.getTravelTime() + "\n");
				// s.removeShip();
			}
			for (String logs : s.eventLog) {
				log.append("		" + logs + "\n");
			}
			s.eventLog.clear();

		}
		log.append("-----------------------------------------------\n");
	}

}

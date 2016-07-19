package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import run.Manager;
import tui.MenuesTUI;

public class CreateGUI extends JFrame implements UpdateAble {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name = "MainFrame";

	private Manager manager;

	public CreateGUI(Manager manager) {
		this.setName(name);
		this.setTitle(name);
		this.manager = manager;
		this.setSize(300, 150);
		this.setBackground(Color.BLUE);
	}

	public void fill() {
		this.setLayout(new BorderLayout());
		PlayerInfo playerInfo = new PlayerInfo(this.manager);
		this.add(playerInfo, BorderLayout.NORTH);

		EventLog eventLog = new EventLog(this.manager);
		this.add(eventLog, BorderLayout.EAST);

		JPanel worldMap = new JPanel();
		worldMap.setBackground(Color.GREEN);
		this.add(worldMap, BorderLayout.CENTER);

	}

	@Override
	public void update() {
		for (Component c : this.getContentPane().getComponents()) {
			if (c instanceof UpdateAble) {
				MenuesTUI.println("UpdateAble ->");
				((UpdateAble) c).update();
			}
		}

	}
}

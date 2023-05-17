package chessGUI;

import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;

public class Player {
	private String name;
	private String color;
	private boolean isTurn;
	private Timer timer;
	private JLabel timerLabel;
	private int timeRemaining; // in seconds
	private int initialTime;

	public Player(String name, String color, String initialTime) {
		this.name = name;
		this.color = color;
		this.isTurn = false;
		this.timeRemaining = 60 * Integer.parseInt(initialTime);
		this.initialTime = Integer.parseInt(initialTime);
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public void startTimer() {
		if (timer == null) {
			timer = new Timer(1000, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (timeRemaining > 0) {
						timeRemaining--;
						updateTimerLabel();
					} else {
						stopTimer();
					
					}
				}
			});
			timer.start();
		}
	}

	public void stopTimer() {
		if (timer != null) {
			timer.stop();
			timer = null;
		}
	}

	private void updateTimerLabel() {
		int minutes = timeRemaining / 60;
		int seconds = timeRemaining % 60;
		DecimalFormat formatter = new DecimalFormat("00");
		String formattedTime = formatter.format(minutes) + ":" + formatter.format(seconds);
		timerLabel.setText(formattedTime);
		
		double percentage = (double) timeRemaining / (60 * initialTime) * 100;
	    if (percentage <= 20) {
	        timerLabel.setForeground(Color.RED);
	    } else if (percentage <= 40) {
	        timerLabel.setForeground(Color.YELLOW);
	    } else if (percentage <= 60) {
	        timerLabel.setForeground(Color.ORANGE);
	    } else {
	        timerLabel.setForeground(Color.GREEN);
	    }

	}

	public void createTimer(JLabel timerLabel) {
		this.timerLabel = timerLabel;
		updateTimerLabel();
	}
	
	 public boolean isTimeEnded() {
	        return timeRemaining <= 0;
	    }
}
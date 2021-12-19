package com.example.progws21a5.factories;

import com.example.progws21a5.button.ContinueGameButton;
import com.example.progws21a5.button.SaveGameButton;
import com.example.progws21a5.button.button;
import com.example.progws21a5.button.exitButton;
import com.example.progws21a5.button.loadGameButton;
import com.example.progws21a5.button.musicButton;
import com.example.progws21a5.button.newGameButton;

public class buttonFactory {

	private static buttonFactory btnFactory;

	private buttonFactory() {

	}

	public static buttonFactory getButtonFactory() {

		if (btnFactory == null) {
			return btnFactory = new buttonFactory();
		}

		return btnFactory;
	}

	public button getButton(String type) {

		return switch (type) {
			case "Load Game" -> new loadGameButton();
			case "Exit" -> new exitButton();
			case "New Game" -> new newGameButton();
			case "save" -> new SaveGameButton();
			case "music" -> new musicButton();
			default -> null;
		};


	}

}

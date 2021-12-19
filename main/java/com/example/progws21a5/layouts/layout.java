package com.example.progws21a5.layouts;

import com.example.progws21a5.Controller.eventHandler;
import com.example.progws21a5.factories.buttonFactory;
import com.example.progws21a5.factories.imageFactory;
import javafx.scene.Scene;

public abstract class layout {
	protected double windowHeight;
	protected double windowWidth;
	protected Scene scene;
	protected buttonFactory factory;
	protected imageFactory imgFactory;
	public eventHandler handler = eventHandler.getInstance();
	public layout(double height, double width) {
		windowHeight = height;
		windowWidth = width;
		factory = buttonFactory.getButtonFactory();
		imgFactory = imageFactory.getImageFactory();
	}

	public Scene getScene() {
		return scene;
	}
}

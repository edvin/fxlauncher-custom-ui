package com.example.launcherui;

import fxlauncher.FXManifest;
import fxlauncher.UIProvider;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomLauncherUI implements UIProvider {
	private ProgressBar progressBar;
	private Stage stage;

	public void init(Stage stage) {
		this.stage = stage;
		stage.getScene().getStylesheets().add(getClass().getResource("/launcherstyles.css").toExternalForm());
	}

	public Parent createLoader() {
		stage.setTitle("Acme Inc");

		VBox root = new VBox(10);
		root.getStyleClass().add("loader");
		root.setPadding(new Insets(20));

		Label booting = new Label("Starting Up");
		booting.getStyleClass().add("h1");

		Label wait = new Label("Please wait...");

		root.getChildren().addAll(booting, wait);

		return root;
	}

	public Parent createUpdater(FXManifest manifest) {
		stage.setTitle("Updating...");

		VBox root = new VBox(10);
		root.setPadding(new Insets(20));
		root.getStyleClass().add("updater");

		Label title = new Label(manifest.updateText);
		title.getStyleClass().add("h1");

		progressBar = new ProgressBar();

		root.getChildren().addAll(title, progressBar);


		return root;
	}

	public void updateProgress(double progress) {
		progressBar.setProgress(progress);
	}

}

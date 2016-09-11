package com.example.launcherui.tests;

import com.example.launcherui.CustomLauncherUI;
import fxlauncher.FXManifest;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestUpdatingUI extends Application {
	public void start(Stage stage) throws Exception {
		StackPane root = new StackPane();
		stage.setScene(new Scene(root));

		CustomLauncherUI ui = new CustomLauncherUI();
		ui.init(stage);

		ui.createLoader();

		Parent updater = ui.createUpdater(new FXManifest());
		root.getChildren().addAll(updater);

		stage.show();
	}
}

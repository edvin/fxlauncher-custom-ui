package com.example.launcherui.tests;

import com.example.launcherui.CustomLauncherUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestLoaderUI extends Application {
	public void start(Stage stage) throws Exception {
		StackPane root = new StackPane();
		stage.setScene(new Scene(root));

		CustomLauncherUI ui = new CustomLauncherUI();
		ui.init(stage);

		Parent updater = ui.createLoader();
		root.getChildren().addAll(updater);

		stage.show();
	}
}

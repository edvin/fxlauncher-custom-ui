package com.example.launcherui.tests;

import com.example.launcherui.CustomLauncherUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestLoadingUI extends Application {
	public void start(Stage primaryStage) throws Exception {
		StackPane root = new StackPane();
		primaryStage.setScene(new Scene(root));

		CustomLauncherUI ui = new CustomLauncherUI();
		ui.init(primaryStage);

		Parent updater = ui.createLoader();
		root.getChildren().addAll(updater);

		primaryStage.show();
	}
}

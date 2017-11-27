package Menu;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import Game.Game;
import Player.KeyManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public class Menu extends Application implements Runnable {
	private Thread thread;
	private Game game;
	private KeyManager input;
	public static boolean running = false;
	private Parent createContent() {
		Pane root = new Pane();
		game = new Game();
		input = new KeyManager();
		root.setPrefSize(1920, 1080);
		
		File file = new File("res/img/maxresdefault.jpg"); // image
		Image image = new Image(file.toURI().toString());
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(1920);
		imageView.setFitHeight(1080);
		root.getChildren().add(imageView);
		imageView.setVisible(true);
		
		Title title = new Title("Audio Dodger");
		Title title2 = new Title("Credits");
		Title title3 = new Title("About");
		Title Optitle = new Title("Options");
		title.setTranslateX(770);
		title.setTranslateY(260);
		title.setOpacity(0.8);
		title2.setTranslateX(770);
		title2.setTranslateY(260);
		title2.setOpacity(0.8);
		title3.setTranslateX(875);
		title3.setTranslateY(260);
		title3.setOpacity(0.8);
		Optitle.setTranslateX(875);
		Optitle.setTranslateY(260);
		Optitle.setOpacity(0.8);
		
		MenuItem Lres = new MenuItem("1920 x 1080");
		MenuItem Mres = new MenuItem("1080 x 720");
		MenuItem Sres = new MenuItem("720 x 510");
		MenuItem opback = new MenuItem("Back");
		MenuBox SizeOp = new MenuBox(
				Lres,
				Mres,
				Sres,
				opback
				);
		SizeOp.setTranslateX(775);
		SizeOp.setTranslateY(400);
		MenuItem Font = new MenuItem("Font");
		MenuItem Res = new MenuItem("Resolution");
		MenuItem Back = new MenuItem("Back");
		MenuBox OptionPane = new MenuBox(
				Font,
				Res,
				Back);
		OptionPane.setTranslateX(775);
		OptionPane.setTranslateY(400);
		
		MenuItem Quit = new MenuItem("QUIT");
		MenuItem3 Quit2 = new MenuItem3("Quit");
		MenuItem3 Resume = new MenuItem3("Resume");
		MenuItem3 Options = new MenuItem3("Options");
		MenuBox3 PauseMenu = new MenuBox3(
				Resume,
				Options,
				Quit2
				);
		PauseMenu.setTranslateX(875);
		PauseMenu.setTranslateY(300);
		MenuItem3 Pause = new MenuItem3("Pause");
		MenuBox3 Esc = new MenuBox3(
				Pause
				);
		
		MenuItem GameDesign = new MenuItem("Game Design");
		MenuItem SoundUse = new MenuItem("Music and Images");
		MenuBox Creds2 = new MenuBox(
				GameDesign,
				SoundUse
				);
		Creds2.setTranslateX(380);
		Creds2.setTranslateY(400);
		
		MenuItem2 Desc = new MenuItem2("Audio Dodger is a bullethell game where you must dodge around an audio visualiser");
		MenuItem2 AboutBack = new MenuItem2("BACK");
		MenuBox2 AboutBox = new MenuBox2(
				Desc,
				AboutBack
				);
		AboutBox.setTranslateX(300);
		AboutBox.setTranslateY(400);
		MenuItem CredBack = new MenuItem("BACK");
		MenuItem GameDes = new MenuItem("HalfWire Games");
		MenuItem Sound = new MenuItem("We don't own the music"); 
		MenuItem Picture = new MenuItem("We don't own the pictures");
		MenuItem Sound2 = new MenuItem("All rights to their owners");
		MenuBox Creds = new MenuBox(
				GameDes,
				Sound,
				Picture,
				Sound2,
				CredBack
				);
		Creds.setTranslateX(775);
		Creds.setTranslateY(400);
		
		MenuItem Credits = new MenuItem("CREDITS");
		MenuItem Play = new MenuItem("PLAY");
		MenuItem About = new MenuItem("ABOUT");
		MenuItem MOptions = new MenuItem("OPTIONS");
		
		MenuBox vbox = new MenuBox(
				Play, 
				About, 
				Credits,
				MOptions,
				Quit);
		vbox.setTranslateX(775);
		vbox.setTranslateY(400);

		Credits.setOnMouseClicked(event ->{
				root.getChildren().removeAll(vbox, title);
				root.getChildren().addAll(title2, Creds, Creds2);
		});
		
		CredBack.setOnMouseClicked(event -> {
			root.getChildren().removeAll(Creds2, Creds, title2);
			root.getChildren().addAll(title, vbox);
		});
		
		About.setOnMouseClicked(event -> {
			root.getChildren().removeAll(title, vbox);
			root.getChildren().addAll(AboutBox, title3);
		});
		
		AboutBack.setOnMouseClicked(event -> {
			root.getChildren().addAll(title, vbox);
			root.getChildren().removeAll(title3, AboutBox);
		});
		
		Play.setOnMouseClicked(event ->{
			root.getChildren().add(Esc);
			root.getChildren().removeAll(vbox, title);
			imageView.setVisible(false);
		});
		
		Quit.setOnMouseClicked(event -> {
			System.exit(0);
		});
		Quit2.setOnMouseClicked(event -> {
			System.exit(0);
		});
		
		Pause.setOnMouseClicked(event ->{
			root.getChildren().addAll(PauseMenu);
		});
		
		Resume.setOnMouseClicked(event -> {
			root.getChildren().remove(PauseMenu);
		});
		
		MOptions.setOnMouseClicked(event -> {
			root.getChildren().removeAll(title, vbox);
			root.getChildren().addAll(OptionPane, Optitle);
		});
		
		Back.setOnMouseClicked(event -> {
			root.getChildren().removeAll(OptionPane, Optitle);
			root.getChildren().addAll(title, vbox);
		});
		
		Res.setOnMouseClicked(event -> {
			root.getChildren().remove(OptionPane);
			root.getChildren().add(SizeOp);
		});
		
		Lres.setOnMouseClicked(event -> {
			root.setScaleX(1);
			root.setScaleY(1);
		});
		Mres.setOnMouseClicked(event -> {
			root.setScaleX(0.75);
			root.setScaleY(0.65);
		});
		Sres.setOnMouseClicked(event -> {
			root.setScaleX(0.5);
			root.setScaleY(0.5);
		});
		opback.setOnMouseClicked(event -> {
			root.getChildren().remove(SizeOp);
			root.getChildren().add(OptionPane);
		});
		
		root.getChildren().addAll(title, vbox);

		return root;

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(createContent());
		primaryStage.setTitle("Audio Dodger");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private static class Title extends StackPane // Title for Menu 1
	{
		public Title(String name) {
			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Serif", FontWeight.SEMI_BOLD, 70));
			setAlignment(Pos.CENTER);
			getChildren().addAll(text);

		}
	}

	private static class Title2 extends StackPane // Title for Menu 1
	{
		public Title2(String name) {

			Text text2 = new Text(name);
			text2.setFill(Color.WHITE);
			text2.setFont(Font.font("Serif", FontWeight.SEMI_BOLD, 70));
			setAlignment(Pos.CENTER);
			getChildren().addAll(text2);

		}
	}

	private static class MenuBox extends VBox // Menu 1 VBox
	{
		public MenuBox(MenuItem... items) {
			for (MenuItem item : items) {
				getChildren().addAll(left2(), Right2(), createSeparator(), Right(), left(), item);
			}
		}

		private Line createSeparator() {
			Line sep = new Line();
			sep.setEndX(400);
			sep.setEndY(0);// separator line
			sep.setScaleY(2);
			sep.setStroke(Color.CRIMSON);
			return sep;
		}
		private Line left() {
			Line lef = new Line();
			lef.setEndX(0);
			lef.setEndY(10);
			lef.setScaleX(2);
			lef.setStroke(Color.ALICEBLUE);
			return lef;
		}
		private Line left2() {
			Line lef = new Line();
			lef.setEndX(0);
			lef.setEndY(-10);
			lef.setScaleX(2);
			lef.setStroke(Color.ALICEBLUE);
			return lef;
		}
		private Line Right() {
			Line lef = new Line();
			lef.setEndX(200);
			lef.setEndY(10);
			lef.setScaleX(2);
			lef.setStroke(Color.BLACK);
			return lef;
		}
		private Line Right2() {
			Line lef = new Line();
			lef.setEndX(200);
			lef.setEndY(-10);
			lef.setScaleX(2);
			lef.setStroke(Color.BLACK);
			return lef;
		}
	}

	public static class MenuItem extends StackPane // Menu 1
	{
		public MenuItem(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 10, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.DARKRED), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.DARKRED) });
			LinearGradient gradient2 = new LinearGradient(0, 0, 10, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.SLATEGRAY), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.SLATEGRAY) });
			Rectangle bg = new Rectangle(400, 60); // rectangle size
			bg.setOpacity(0.6);
			bg.setFill(gradient2);
			Text text = new Text(name);
			text.setFill(Color.DARKGREY);
			text.setFont(Font.font("Serif", FontWeight.SEMI_BOLD, 40));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);

			setOnMouseEntered(event -> {
				bg.setFill(gradient);
				text.setFill(Color.WHITE);
			});

			setOnMouseExited(event -> {
				bg.setFill(gradient2);
				text.setFill(Color.DARKGREY);
			});

			setOnMousePressed(event -> {
				bg.setFill(Color.DARKRED);
			});

			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});

		}
	}
	private static class MenuBox2 extends VBox // Menu 1 VBox
	{
		public MenuBox2(MenuItem2... items) {
			for (MenuItem2 item : items) {
				getChildren().addAll(left2(), Right2(), createSeparator(), Right(), left(), item);
			}
		}

		private Line createSeparator() {
			Line sep = new Line();
			sep.setEndX(1350);
			sep.setEndY(0);// separator line
			sep.setScaleY(2);
			sep.setStroke(Color.CRIMSON);
			return sep;
		}
		private Line left() {
			Line lef = new Line();
			lef.setEndX(0);
			lef.setEndY(10);
			lef.setScaleX(2);
			lef.setStroke(Color.ALICEBLUE);
			return lef;
		}
		private Line left2() {
			Line lef = new Line();
			lef.setEndX(0);
			lef.setEndY(-10);
			lef.setScaleX(2);
			lef.setStroke(Color.ALICEBLUE);
			return lef;
		}
		private Line Right() {
			Line lef = new Line();
			lef.setEndX(675);
			lef.setEndY(10);
			lef.setScaleX(2);
			lef.setStroke(Color.BLACK);
			return lef;
		}
		private Line Right2() {
			Line lef = new Line();
			lef.setEndX(675);
			lef.setEndY(-10);
			lef.setScaleX(2);
			lef.setStroke(Color.BLACK);
			return lef;
		}
	}

	public static class MenuItem2 extends StackPane // Menu 1
	{
		public MenuItem2(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 10, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.DARKRED), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.DARKRED) });
			LinearGradient gradient2 = new LinearGradient(0, 0, 10, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.SLATEGRAY), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.SLATEGRAY) });
			Rectangle bg = new Rectangle(1350, 60); // rectangle size
			bg.setOpacity(0.6);
			bg.setFill(gradient2);
			Text text = new Text(name);
			text.setFill(Color.DARKGREY);
			text.setFont(Font.font("Serif", FontWeight.SEMI_BOLD, 40));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);

			setOnMouseEntered(event -> {
				bg.setFill(gradient);
				text.setFill(Color.WHITE);
			});

			setOnMouseExited(event -> {
				bg.setFill(gradient2);
				text.setFill(Color.DARKGREY);
			});

			setOnMousePressed(event -> {
				bg.setFill(Color.DARKRED);
			});

			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});

		}
	}
	private static class MenuBox3 extends VBox // Menu 1 VBox
	{
		public MenuBox3(MenuItem3... items) {
			for (MenuItem3 item : items) {
				getChildren().addAll(item);
			}
		}
	}

	public static class MenuItem3 extends StackPane // Menu 1
	{
		public MenuItem3(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 10, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.DARKRED), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.DARKRED) });
			LinearGradient gradient2 = new LinearGradient(0, 0, 10, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.SLATEGRAY), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.SLATEGRAY) });
			Rectangle bg = new Rectangle(200, 60); // rectangle size
			bg.setOpacity(0.6);
			bg.setFill(gradient);
			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Serif", FontWeight.SEMI_BOLD, 40));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);

			setOnMouseEntered(event -> {
				bg.setFill(gradient2);
				text.setFill(Color.DARKGREY);
			});

			setOnMouseExited(event -> {
				bg.setFill(gradient);
				text.setFill(Color.WHITE);
			});

			setOnMousePressed(event -> {
				bg.setFill(Color.DARKRED);
			});

			setOnMouseReleased(event -> {
				bg.setFill(gradient2);
			});

		}
	}
	private void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		
		launch(args);
	}

	public void run() {
		
	}
	private void tick() {
		game.tick(input.key);

	}

}
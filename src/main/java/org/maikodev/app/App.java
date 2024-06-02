package org.maikodev.app;

import org.maikodev.app.view.MazeForm;

import java.awt.*;

public final class App {
    App() {
        appFrame = new MazeForm(MINIMUM_APP_DIMENSIONS, USER_SCREEN_DIMENSIONS);
        appConfig = new AppConfig(appFrame.getRows(), appFrame.getColumns());
    }

    public static void main(String[] args) {
        App pathApp = new App();
    }

    private MazeForm appFrame;
    private AppConfig appConfig;
    private static final int MINIMUM_APP_WIDTH = 800;
    private static final int MINIMUM_APP_HEIGHT = 600;

    private static final Dimension MINIMUM_APP_DIMENSIONS = new Dimension(MINIMUM_APP_WIDTH, MINIMUM_APP_HEIGHT);
    private static final Dimension USER_SCREEN_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();
}

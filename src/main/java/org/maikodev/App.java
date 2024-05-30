package org.maikodev;

import java.awt.*;

public class App {
    App() {
        applicationFrame = new MazeForm(MINIMUM_APP_DIMENSIONS, USER_SCREEN_DIMENSIONS);
    }

    public static void main(String[] args) {
        App pathApp = new App();
    }



    private MazeForm applicationFrame;
    private static final int MINIMUM_APP_WIDTH = 800;
    private static final int MINIMUM_APP_HEIGHT = 600;

    private static final Dimension MINIMUM_APP_DIMENSIONS = new Dimension(MINIMUM_APP_WIDTH, MINIMUM_APP_HEIGHT);
    private static final Dimension USER_SCREEN_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();
}

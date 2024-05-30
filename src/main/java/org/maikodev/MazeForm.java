package org.maikodev;

import javax.swing.*;
import java.awt.*;

public class MazeForm extends JFrame {
    public MazeForm(Dimension frameDimensions, Dimension screenDimensions) {
        Point centerPoint = new Point(screenDimensions.width / 2 - frameDimensions.width / 2, screenDimensions.height / 2 - frameDimensions.height / 2);

//        solveButton.addActionListener(new ButtonListener());

        add(formPanel);

        setTitle("Maze Solver");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(centerPoint);
        setSize(frameDimensions);
        setMinimumSize(frameDimensions);
        setVisible(true);
    }

    private void InitForm() {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        algorithmSelection = new JComboBox(AlgorithmType.values());
        columnSpinner = new JSpinner(new SpinnerNumberModel(10, 10, 50, 1));
        rowSpinner = new JSpinner(new SpinnerNumberModel(10, 10, 50, 1));
    }

    private JPanel formPanel;
    private JButton generateButton;
    private JButton solveButton;
    private JPanel mazePanel;
    private JPanel optionPanel;
    private JSpinner rowSpinner;
    private JComboBox algorithmSelection;
    private JSpinner columnSpinner;
    private JButton clearButton;
    private JSlider timescaleSlider;
    private JButton placeStartButton;
    private JButton placeEndButton;
}

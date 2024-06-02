package org.maikodev;

import org.maikodev.interfaces.IObservable;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionListener;

public class MazeForm extends JFrame implements IObservable {
    public MazeForm(Dimension frameDimensions, Dimension screenDimensions) {
        Point centerPoint = new Point(screenDimensions.width / 2 - frameDimensions.width / 2, screenDimensions.height / 2 - frameDimensions.height / 2);

//      solveButton.addActionListener(new ButtonListener());

        add(formPanel);

        setTitle("Maze Solver");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(centerPoint);
        setSize(frameDimensions);
        setMinimumSize(frameDimensions);
        setVisible(true);
    }

    @Override
    public void addActionListener(ActionListener listener) {
        listenerList.add(ActionListener.class, listener);
    }

    @Override
    public void removeActionListener(ActionListener listener) {
        listenerList.remove(ActionListener.class, listener);
    }

    public ActionListener[] getActionListeners() {
        return listenerList.getListeners(ActionListener.class);
    }

    public int getRows() {
        return (int)rowSpinner.getValue();
    }

    public int getColumns() {
        return (int)columnSpinner.getValue();
    }

    private void InitForm() {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        algorithmSelection = new JComboBox(AlgorithmType.values());
        columnSpinner = new JSpinner(new SpinnerNumberModel(10, 10, 50, 1));
        rowSpinner = new JSpinner(new SpinnerNumberModel(10, 10, 50, 1));
    }

    private EventListenerList listenerList;

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

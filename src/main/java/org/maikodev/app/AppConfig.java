package org.maikodev;

import java.awt.*;

public class AppConfig {
    public AppConfig(int simulationMaxRows, int simulationMaxColumns, Point simulationStartPoint, Point simulationEndPoint, double simulationRate, AlgorithmType solverAlgorithm) {
        this.simulationMaxRows = simulationMaxRows;
        this.simulationMaxColumns = simulationMaxColumns;
        this.simulationStartPoint = simulationStartPoint;
        this.simulationEndPoint = simulationEndPoint;
        this.simulationRate = simulationRate;
        this.solverAlgorithm = solverAlgorithm;
    }

    public AppConfig(int simulationMaxRows, int simulationMaxColumns) {
        this.simulationMaxRows = simulationMaxRows;
        this.simulationMaxColumns = simulationMaxColumns;

        simulationStartPoint = null;
        simulationEndPoint = null;

        // Target FPS 60 //
        simulationRate = 0.01666;
        solverAlgorithm = AlgorithmType.AStar;
    }

    public int simulationMaxRows;
    public int simulationMaxColumns;
    public Point simulationStartPoint;
    public Point simulationEndPoint;
    public double simulationRate;
    public AlgorithmType solverAlgorithm;
}

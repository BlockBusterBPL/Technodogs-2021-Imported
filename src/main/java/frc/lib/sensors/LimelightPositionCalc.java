// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib.sensors;

/** Add your docs here. */
public class LimelightPositionCalc {
    private Limelight limelight;
    private double lensHeight;
    private double lensElevation;
    private double targetHeight;

    public LimelightPositionCalc(Limelight limelight, double lensHeight, double lensElevation, double targetHeight) {
        this.limelight = limelight;
        this.lensHeight = lensHeight;
        this.lensElevation = lensElevation;
    }

    public double calculate() {
        double lensToTarget = limelight.getVerticalOffset();
        double distance = (targetHeight-lensHeight) / Math.tan(Math.toRadians(lensElevation)+Math.toRadians(lensToTarget));
        return distance;
    }
}

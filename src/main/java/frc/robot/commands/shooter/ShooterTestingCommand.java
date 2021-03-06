// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterTestingCommand extends CommandBase {
  /** Creates a new ShooterTestingCommand. */

  private final ShooterSubsystem mShooterSubsystem;

  private final XboxController operatorController = new XboxController(Constants.OperatorControl.operatorControllerPort);

  public ShooterTestingCommand(ShooterSubsystem shooterSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.mShooterSubsystem = shooterSubsystem;
    this.addRequirements(mShooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("Shooter Setpoint", 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double shotspeed = SmartDashboard.getNumber("Shooter Setpoint", 0);
    if (operatorController.getRightTriggerAxis() > 0.2) {
      mShooterSubsystem.spinToSpeed(shotspeed);
    } else {
      mShooterSubsystem.shoot(0, 0, 0);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mShooterSubsystem.shoot(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

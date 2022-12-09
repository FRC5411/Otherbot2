package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
//import frc.robot.subsystems.sim.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CircleCommand extends CommandBase {
  private double m_radius;
  private double m_speed;
  private DriveSubsystem m_drivesubsystem;


  public CircleCommand(double radius, double speed, DriveSubsystem subsystem) {
    m_radius = radius;
    m_speed = speed;
    m_drivesubsystem = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    m_drivesubsystem.circle_mode(m_radius, m_speed);
  }

  @Override
  public void execute() {
    m_drivesubsystem.circle_mode(m_radius, m_speed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
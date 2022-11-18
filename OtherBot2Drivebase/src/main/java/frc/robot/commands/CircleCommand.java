package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CircleCommand extends CommandBase {
  private double m_radius;
  private double m_speed;
  private Timer m_timer;
  private DriveSubsystem m_drivesubsystem;


  public CircleCommand(double radius, double speed, Timer timer, DriveSubsystem subsystem) {
    m_radius = radius;
    m_speed = speed;
    m_timer = timer;
    m_drivesubsystem = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    m_timer.start();
    m_drivesubsystem.circle_mode(m_radius, m_speed, m_timer);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}

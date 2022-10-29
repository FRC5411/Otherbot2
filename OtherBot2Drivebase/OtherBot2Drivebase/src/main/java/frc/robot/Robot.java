package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_teleopCommand;
  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {}
  
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    m_teleopCommand = m_robotContainer.getarcadecommand();
    m_teleopCommand.schedule();
  }

  @Override
  public void teleopPeriodic() {}
}
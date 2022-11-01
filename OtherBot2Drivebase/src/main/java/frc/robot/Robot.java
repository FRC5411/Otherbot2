package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class Robot extends TimedRobot {
  private Command m_DriveCommand;
  private Command m_IntakeCommand;
  private ParallelCommandGroup m_ParellelCommand;
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
    m_DriveCommand = m_robotContainer.getarcadecommand();
    m_IntakeCommand = m_robotContainer.getintakecommand();
    m_ParellelCommand = new ParallelCommandGroup(m_DriveCommand, m_IntakeCommand);
    m_ParellelCommand.schedule();
  }

  @Override
  public void teleopPeriodic() {}
}
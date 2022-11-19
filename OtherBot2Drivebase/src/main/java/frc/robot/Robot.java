package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  RobotContainer m_robotContainer;
  Command m_AutoCommand;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    m_AutoCommand = m_robotContainer.getAutoCommand();
    if(m_AutoCommand != null) {
      m_AutoCommand.schedule();
    }
  }
  
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if(m_AutoCommand != null) {
      m_AutoCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}
}
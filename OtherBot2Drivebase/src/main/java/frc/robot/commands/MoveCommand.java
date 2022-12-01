 package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.sim.DriveSubsystem;
 
public class MoveCommand extends CommandBase {
  double m_speed;
  double m_time;
  DriveSubsystem m_drive;
  public MoveCommand(double speed, double time, DriveSubsystem drive) {
    m_speed = speed;
    m_time = time;
    m_drive = drive;
    addRequirements(drive);
  }
 
  @Override
  public void initialize() {
    m_drive.MoveForward(m_speed, m_time);
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

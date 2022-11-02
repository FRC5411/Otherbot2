package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private double m_speed;
  private double m_rotation;
  private DriveSubsystem m_drive;
//Messed up on the local and "gloabal" variables of the class
  public ArcadeCommand(DriveSubsystem drive, double speed, double rotation) {
    m_speed = speed;
    m_rotation = rotation;
    m_drive = drive;
    addRequirements(drive);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_drive.arcade_mode(m_speed, m_rotation);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.arcade_mode(0,0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
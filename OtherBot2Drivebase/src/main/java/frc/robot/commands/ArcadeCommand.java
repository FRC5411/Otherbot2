package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private double m_speed;
  private double m_rotation;
  private DriveSubsystem m_drive;

  public ArcadeCommand(DriveSubsystem m_drive, double m_speed, double m_rotation) {
    addRequirements(m_drive);
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
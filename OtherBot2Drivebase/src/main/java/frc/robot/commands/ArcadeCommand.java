package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
//import frc.robot.subsystems.sim.DriveSubsystem;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private DoubleSupplier m_speed;
  private DoubleSupplier m_rotation;
  private DriveSubsystem m_drive;
//Messed up on the local and "gloabal" variables of the class
  public ArcadeCommand(DoubleSupplier speed, DoubleSupplier rotation, DriveSubsystem drive) {
    m_speed = speed;
    m_rotation = rotation;
    m_drive = drive;
    addRequirements(drive);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_drive.arcade_mode(m_speed.getAsDouble(), m_rotation.getAsDouble());
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
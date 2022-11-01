package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private double inspeed;
    private double outspeed;
    private IntakeSubsystem m_intake;
  
    public IntakeCommand(IntakeSubsystem m_intake, double inspeed, double outspeed) {
      addRequirements(m_intake);
    }
  
    @Override
    public void initialize() {}
  
    @Override
    public void execute() {
      m_intake.intake(inspeed, outspeed);
    }
  
    @Override
    public void end(boolean interrupted) {
      m_intake.intake(0,0);
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }
  
}

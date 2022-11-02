package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private double m_inspeed;
    private double m_outspeed;
    private IntakeSubsystem m_intake;
//Messed up on the local and "gloabal" variables of the class
    public IntakeCommand(IntakeSubsystem intake, double inspeed, double outspeed) {
      m_inspeed = inspeed;
      m_outspeed = outspeed;
      m_intake = intake;
      addRequirements(intake);
    }
  
    @Override
    public void initialize() {}
  
    @Override
    public void execute() {
      m_intake.intake(m_inspeed, m_outspeed);
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

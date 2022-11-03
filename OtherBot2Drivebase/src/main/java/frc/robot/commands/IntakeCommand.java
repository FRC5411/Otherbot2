package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

//Messed up on the local and "gloabal" variables of the class
    public IntakeCommand(double inspeed, double outspeed, IntakeSubsystem intake) {
      addRequirements(intake);
    }
  
    @Override
    public void initialize() {}
  
    @Override
    public void execute() {}
  
    @Override
    public void end(boolean interrupted) {}
  
    @Override
    public boolean isFinished() {
      return false;
    }
}

package frc.robot.subsystems.sim;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
  private PWMSparkMax RightIntake;
  private PWMSparkMax VertIntake;

  public IntakeSubsystem() {
    RightIntake = new PWMSparkMax(6);
    VertIntake = new PWMSparkMax(7);
  }

  public void intake() {
    RightIntake.set(1);
  }

  public void outtake() {
    RightIntake.set(-1);
  }

  public void notake() {
    RightIntake.set(0);
  }

  public void uptake(){
    VertIntake.set(1);
  }

  public void downtake(){
    VertIntake.set(-1);
  }

  public void novertake(){
    VertIntake.set(0);
  }


  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
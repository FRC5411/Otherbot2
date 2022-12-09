package frc.robot.subsystems.sim;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
  private PWMSparkMax RightIntake;
  private PWMSparkMax RVertIntake;
  private PWMSparkMax LVertIntake;
  private MotorControllerGroup Upper;

  public IntakeSubsystem() {
    RightIntake = new PWMSparkMax(6);
    RVertIntake = new PWMSparkMax(7);
    LVertIntake = new PWMSparkMax(8);
    Upper = new MotorControllerGroup(RVertIntake, LVertIntake);
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
    Upper.set(1);
  }

  public void downtake(){
    Upper.set(-1);
  }

  public void novertake(){
    Upper.set(0);
  }


  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
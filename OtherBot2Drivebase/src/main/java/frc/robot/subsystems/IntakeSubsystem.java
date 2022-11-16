package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeSubsystem extends SubsystemBase{
  private WPI_TalonSRX RightIntake;
  private WPI_TalonSRX VertIntake;

  public IntakeSubsystem() {
    RightIntake = new WPI_TalonSRX(6);
    VertIntake = new WPI_TalonSRX(7);
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
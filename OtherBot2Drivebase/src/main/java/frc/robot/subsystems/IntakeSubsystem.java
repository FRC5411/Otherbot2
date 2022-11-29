package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeSubsystem extends SubsystemBase{
  private PWMSparkMax RightIntake;
  private PWMSparkMax VertIntake;

  public IntakeSubsystem() {
    RightIntake = new PWMSparkMax(6);
    VertIntake = new PWMSparkMax(7);

//    RightIntake.setNeutralMode(NeutralMode.Brake);
//    VertIntake.setNeutralMode(NeutralMode.Brake);
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
package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class IntakeSubsystem extends SubsystemBase{
  private WPI_TalonSRX RightIntake;
  private WPI_TalonSRX RVertIntake;
  private WPI_TalonSRX LVertIntake;

  public IntakeSubsystem() {
    RightIntake = new WPI_TalonSRX(6);
    RVertIntake = new WPI_TalonSRX(17);
    LVertIntake = new WPI_TalonSRX(16);

    LVertIntake.follow(RVertIntake);
    LVertIntake.setInverted(true);
    RightIntake.setNeutralMode(NeutralMode.Brake);
    LVertIntake.setNeutralMode(NeutralMode.Brake);
    RVertIntake.setNeutralMode(NeutralMode.Brake);
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
    RVertIntake.set(0.5);
  }

  public void downtake(){
    RVertIntake.set(-0.5);
  }

  public void novertake(){
    RVertIntake.set(0);
  }

  public void intakedance(double time, double speed) {

  }

  public void runfortime() {}
  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
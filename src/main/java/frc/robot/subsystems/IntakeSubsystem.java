package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class IntakeSubsystem extends SubsystemBase{
  private WPI_VictorSPX RightIntake;
  private WPI_VictorSPX RVertIntake;
  private WPI_VictorSPX LVertIntake;

  public IntakeSubsystem() {
    RightIntake = new WPI_VictorSPX(6);
    RVertIntake = new WPI_VictorSPX(7);
    LVertIntake = new WPI_VictorSPX(8);

    LVertIntake.follow(RVertIntake);
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
    RVertIntake.set(1);
  }

  public void downtake(){
    RVertIntake.set(-1);
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
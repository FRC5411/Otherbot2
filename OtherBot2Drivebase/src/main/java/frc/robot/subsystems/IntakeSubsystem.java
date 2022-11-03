package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeSubsystem extends SubsystemBase{
  private WPI_TalonSRX LeftIntake;
  private WPI_TalonSRX RightIntake;
  
  public IntakeSubsystem() {
    LeftIntake = new WPI_TalonSRX(5);
    RightIntake = new WPI_TalonSRX(6);
    LeftIntake.follow(RightIntake);
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


  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
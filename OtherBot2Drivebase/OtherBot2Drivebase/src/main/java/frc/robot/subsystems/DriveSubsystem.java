package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSubsystem extends SubsystemBase {

  private WPI_TalonSRX LeftFront;
  private WPI_TalonSRX LeftBack;
  private WPI_TalonSRX RightFront;
  private WPI_TalonSRX RightBack;
  public DifferentialDrive m_robotdrive;
  public DriveSubsystem() {
    LeftFront = new WPI_TalonSRX(4);
    LeftBack = new WPI_TalonSRX(2);
    RightFront = new WPI_TalonSRX(3);
    RightBack =  new WPI_TalonSRX(1);

    LeftBack.follow(LeftFront);
    RightBack.follow(RightFront);

    LeftBack.setInverted(true);

    m_robotdrive = new DifferentialDrive(LeftBack,RightBack);
  }

  public void arcade_mode(double speed, double rotation) {
    m_robotdrive.arcadeDrive(speed, rotation);
  }


  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
//Bailey88!
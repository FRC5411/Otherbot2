package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveSubsystem extends SubsystemBase {

  private WPI_VictorSPX LeftFront;
  private WPI_VictorSPX LeftBack;
  private WPI_VictorSPX RightFront;
  private WPI_VictorSPX RightBack;
  public DifferentialDrive m_robotdrive;
  
  public DriveSubsystem() {
    LeftFront  = new WPI_VictorSPX(11);
    LeftBack   = new WPI_VictorSPX(13);
    RightFront = new WPI_VictorSPX(10);
    RightBack  = new WPI_VictorSPX(12);

    LeftFront.setNeutralMode(NeutralMode.Brake);
    LeftBack.setNeutralMode(NeutralMode.Brake);
    RightFront.setNeutralMode(NeutralMode.Brake);
    RightBack.setNeutralMode(NeutralMode.Brake);

    LeftBack.follow(LeftFront);
    RightBack.follow(RightFront);
    LeftBack.setInverted(true);

    m_robotdrive = new DifferentialDrive(LeftBack,RightBack);
  }

  public void arcade_mode(double speed, double rotation) {
    m_robotdrive.arcadeDrive(speed, -rotation, true);
  }


  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
//Bailey88!
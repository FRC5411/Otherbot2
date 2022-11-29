package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
/*import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;*/

public class DriveSubsystem extends SubsystemBase {

  private PWMSparkMax LeftFront;
  private PWMSparkMax LeftBack;
  private PWMSparkMax RightFront;
  private PWMSparkMax RightBack;
  MotorControllerGroup Left;
  MotorControllerGroup Right;
  private DifferentialDrive m_robotdrive;
  
  public DriveSubsystem() {
    LeftFront  = new PWMSparkMax(11);
    LeftBack   = new PWMSparkMax(13);
    RightFront = new PWMSparkMax(10);
    RightBack  = new PWMSparkMax(12);
/*
    LeftFront.setNeutralMode(NeutralMode.Brake);
    LeftBack.setNeutralMode(NeutralMode.Brake);
    RightFront.setNeutralMode(NeutralMode.Brake);
    RightBack.setNeutralMode(NeutralMode.Brake);

    LeftBack.follow(LeftFront);
    RightBack.follow(RightFront);*/
    Left = new MotorControllerGroup(LeftFront, LeftBack);
    Right = new MotorControllerGroup(RightFront, RightBack);
    LeftBack.setInverted(true);
    LeftFront.setInverted(true);

    m_robotdrive = new DifferentialDrive(Left, Right);
  }

  public void arcade_mode(double speed, double rotation) {
    m_robotdrive.arcadeDrive(speed, -rotation, true);
  }

  public void circle_mode(double radius, double speed) {
    double IPM = (4 * 5330 * speed)/ 60;
    double DPI = 2 * Math.PI;
    double basec = Math.PI/2;
    double circumfrence = DPI* radius;
    double circinch = circumfrence/12;
    double time = circinch/IPM;
    double period = DPI * time;
    double rotation  = (basec / period)/DPI;
    Timer timer = new Timer();
    timer.start();
    while(timer.get() < time){
      m_robotdrive.arcadeDrive(speed, rotation);
    }
    m_robotdrive.arcadeDrive(0, 0);
  }



  public void MoveForward(double speed, double time) {
    Timer timer = new Timer();
    timer.start();
    while(timer.get() < time) {
      m_robotdrive.arcadeDrive(speed, 0);
    }
    m_robotdrive.arcadeDrive(0, 0);
  }


  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
//Bailey88!
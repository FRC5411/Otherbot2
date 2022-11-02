package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.ArcadeCommand;
import frc.robot.commands.IntakeCommand;

public class RobotContainer {
  private DriveSubsystem m_driveSubsystem;
  private IntakeSubsystem m_IntakeSubsystem;
  private ArcadeCommand m_telearcade;
  private IntakeCommand m_teleintake;
  private XboxController m_controller;
  private double LY_Axis;
  private double RX_Axis;
  private double A;
  private double B;

  public RobotContainer() {
    configureButtonBindings();
    m_controller = new XboxController(0);
    LY_Axis = m_controller.getLeftY();
    RX_Axis = m_controller.getRightX();
    A = A_inspeed();
    B = B_outspeed();

    m_telearcade = new ArcadeCommand(m_driveSubsystem, LY_Axis, RX_Axis);
    m_teleintake = new IntakeCommand(m_IntakeSubsystem, A, B);
  }

  public Command getarcadecommand() {
    return m_telearcade;
  }

  public Command getintakecommand() {
    return m_teleintake;
  }
//Inproper logic for coding the input should affect the return value
  public double A_inspeed() {
    double ipositive = 1;
    double zero = 0;
    if (m_controller.getAButton() == true)
      return ipositive;
    return zero;
  }
  
  public double B_outspeed() {
    double opositive = 1;
    double zero = 0;
    if (m_controller.getBButton() == true)
      return opositive;
    return zero;
  }

  private void configureButtonBindings() {}
}
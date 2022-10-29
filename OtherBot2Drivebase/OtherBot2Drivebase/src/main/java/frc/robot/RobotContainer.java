package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.ArcadeCommand;
import java.lang.Math;

/**
 * 
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
  private DriveSubsystem m_driveSubsystem;
  private ArcadeCommand m_telearcade;
  private XboxController m_controller;
  private double m_speed;
  private double m_rotation;
  private double LY_Axis;
  private double RX_Axis;
  private double sign;
  private double magnitude;

  public RobotContainer() {
    configureButtonBindings();
    m_controller = new XboxController(0);
    LY_Axis = m_controller.getLeftY();
    RX_Axis = m_controller.getRawAxis(4);

    sign = Math.abs(LY_Axis)/LY_Axis;
    magnitude = Math.sqrt(Math.pow(LY_Axis, 2) + Math.pow(RX_Axis, 2));

    m_speed = sign * magnitude;
    m_rotation = Math.atan2(LY_Axis, RX_Axis)/3.14;
    m_telearcade = new ArcadeCommand(m_driveSubsystem, m_speed, m_rotation);
  }

  public Command getarcadecommand() {
    return m_telearcade;
  }


  private void configureButtonBindings() {}


/*  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
//  }*/
}
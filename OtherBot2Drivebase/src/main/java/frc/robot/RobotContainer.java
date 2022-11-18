package frc.robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.ArcadeCommand;
import frc.robot.commands.CircleCommand;

public class RobotContainer {
  private DriveSubsystem m_driveSubsystem;
  private IntakeSubsystem m_IntakeSubsystem;
  private XboxController m_controller;
  private JoystickButton RT;
  private JoystickButton LT;
  private POVButton DDown;
  private POVButton DUp;
  private Timer m_timer;
  private CircleCommand CircularCommand;

  public RobotContainer() {
    m_controller = new XboxController(0);
    RT = new JoystickButton(m_controller, XboxController.Button.kRightBumper.value);
    LT = new JoystickButton(m_controller, XboxController.Button.kLeftBumper.value);
    DDown = new POVButton(m_controller, 0);
    DUp = new POVButton(m_controller, 180);

    m_driveSubsystem = new DriveSubsystem();
    m_IntakeSubsystem = new IntakeSubsystem();
  
    m_driveSubsystem.setDefaultCommand(new ArcadeCommand(
      () -> m_controller.getLeftY(),
      () -> m_controller.getRightX(),
      m_driveSubsystem));
    configureButtonBindings();


    CircleCommand CircularCommand = new CircleCommand(5, 0.4, m_timer, m_driveSubsystem);
  }

  private void configureButtonBindings() {
    //Intake and outake
    RT.whenPressed(new InstantCommand(m_IntakeSubsystem::intake, m_IntakeSubsystem));
    RT.whenReleased(new InstantCommand(m_IntakeSubsystem::notake, m_IntakeSubsystem));
    LT.whenPressed(new InstantCommand(m_IntakeSubsystem::outtake, m_IntakeSubsystem));
    LT.whenReleased(new InstantCommand(m_IntakeSubsystem::notake, m_IntakeSubsystem));
    
    //Moving the intake up and down
    DUp.whenPressed(new InstantCommand(m_IntakeSubsystem::uptake, m_IntakeSubsystem));
    DUp.whenReleased(new InstantCommand(m_IntakeSubsystem::novertake, m_IntakeSubsystem));
    DDown.whenPressed(new InstantCommand(m_IntakeSubsystem::downtake, m_IntakeSubsystem));
    DDown.whenReleased(new InstantCommand(m_IntakeSubsystem::novertake, m_IntakeSubsystem));
  }

  public Command getCircularCommand() {
    return CircularCommand;
  }
}
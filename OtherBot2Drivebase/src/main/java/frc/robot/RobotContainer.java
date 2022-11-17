package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.ArcadeCommand;

public class RobotContainer {
  private DriveSubsystem m_driveSubsystem;
  private IntakeSubsystem m_IntakeSubsystem;
  private XboxController m_controller;
  private JoystickButton RT;
  private JoystickButton LT;
  private POVButton DDown;
  private POVButton DUp;

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
}
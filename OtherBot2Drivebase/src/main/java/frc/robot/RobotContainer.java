package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.ArcadeCommand;

public class RobotContainer {
  private DriveSubsystem m_driveSubsystem;
  private IntakeSubsystem m_IntakeSubsystem;
  private XboxController m_controller;
  private JoystickButton A;
  private JoystickButton B;

  public RobotContainer() {
    m_controller = new XboxController(0);
    A = new JoystickButton(m_controller, XboxController.Button.kA.value);
    B = new JoystickButton(m_controller, XboxController.Button.kB.value);


    m_driveSubsystem = new DriveSubsystem();
    m_IntakeSubsystem = new IntakeSubsystem();
  
    m_driveSubsystem.setDefaultCommand(new ArcadeCommand(
      () -> m_controller.getRightY(),
      () -> m_controller.getLeftX(),
      m_driveSubsystem
    ));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    A.whenPressed(new InstantCommand(m_IntakeSubsystem::intake, m_IntakeSubsystem));
    A.whenReleased(new InstantCommand(m_IntakeSubsystem::notake, m_IntakeSubsystem));
    B.whenPressed(new InstantCommand(m_IntakeSubsystem::outtake, m_IntakeSubsystem));
    B.whenReleased(new InstantCommand(m_IntakeSubsystem::notake, m_IntakeSubsystem));
  }
}
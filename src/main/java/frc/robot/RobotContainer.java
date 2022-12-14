package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
//import frc.robot.subsystems.sim.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
//import frc.robot.subsystems.sim.IntakeSubsystem;
import frc.robot.commands.ArcadeCommand;
import frc.robot.commands.CircleCommand;
import frc.robot.commands.MoveCommand;

public class RobotContainer {
  private DriveSubsystem m_driveSubsystem;
  private IntakeSubsystem m_IntakeSubsystem;
  private XboxController m_controller;
  private JoystickButton intakeInButton;
  private JoystickButton intakeOutButton;
  private JoystickButton intakeUpButton;
  private JoystickButton intakeDownButton;
  private SequentialCommandGroup ComplexCiruclarCommand;
  private CircleCommand CircularCommand;
  private SendableChooser<Command> m_autochooser;
  private MoveCommand DefaultAuto;

  public RobotContainer() {
    m_controller = new XboxController(0);
    intakeOutButton = new JoystickButton(m_controller, XboxController.Button.kB.value);
    intakeInButton = new JoystickButton(m_controller, XboxController.Button.kX.value);
    intakeUpButton = new JoystickButton(m_controller, XboxController.Button.kY.value);
    intakeDownButton = new JoystickButton(m_controller, XboxController.Button.kA.value);

    m_driveSubsystem = new DriveSubsystem();
    m_IntakeSubsystem = new IntakeSubsystem();

    m_autochooser = new SendableChooser<>();
    DefaultAuto = new MoveCommand(1, 20, m_driveSubsystem);
    CircularCommand = new CircleCommand(6, 1, m_driveSubsystem);
    ComplexCiruclarCommand = new SequentialCommandGroup(new CircleCommand(6, 1, m_driveSubsystem),
    new CircleCommand(5, 1, m_driveSubsystem), new CircleCommand(4, 1, m_driveSubsystem),
    new CircleCommand(3, 1, m_driveSubsystem), new CircleCommand(2, 1, m_driveSubsystem),
    new CircleCommand(1, 1, m_driveSubsystem));
  
    m_driveSubsystem.setDefaultCommand(new ArcadeCommand(
      () -> m_controller.getLeftY(),
      () -> m_controller.getRightX(),
      m_driveSubsystem));
    configureButtonBindings();


    Shuffleboard.getTab("Anonyomous").add("Auto Dashboard", m_autochooser);    
    m_autochooser.setDefaultOption("Move", DefaultAuto);
    m_autochooser.addOption("Circle", CircularCommand);
    m_autochooser.addOption("Encompass Circle", ComplexCiruclarCommand);
  }

  private void configureButtonBindings() {
    //Intake and outake
    intakeInButton.whenPressed(new InstantCommand(m_IntakeSubsystem::intake, m_IntakeSubsystem));
    intakeInButton.whenReleased(new InstantCommand(m_IntakeSubsystem::notake, m_IntakeSubsystem));
    intakeOutButton.whenPressed(new InstantCommand(m_IntakeSubsystem::outtake, m_IntakeSubsystem));
    intakeOutButton.whenReleased(new InstantCommand(m_IntakeSubsystem::notake, m_IntakeSubsystem));
    
    //Moving the intake up and down
    intakeUpButton.whenPressed(new InstantCommand(m_IntakeSubsystem::uptake, m_IntakeSubsystem));
    intakeUpButton.whenReleased(new InstantCommand(m_IntakeSubsystem::novertake, m_IntakeSubsystem));
    intakeUpButton.whenPressed(new InstantCommand(m_IntakeSubsystem::downtake, m_IntakeSubsystem));
    intakeUpButton.whenReleased(new InstantCommand(m_IntakeSubsystem::novertake, m_IntakeSubsystem));
  }

  public Command getAutoCommand() {
    return m_autochooser.getSelected();
  }
}
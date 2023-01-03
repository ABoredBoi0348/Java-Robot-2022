package frc.robot.commands.drive;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Robot;

public class DriveStraight extends PIDCommand{
    private final double distance;
    


    public DriveStraight(double distance){
        addRequirements(Robot.drivebase);

        super(new PIDCotroller(0.1,0,0), 
        () -> Robot.getDrivebase().getLeftEncoderDistance() - Robot.getDriveBase().getLeftEncoderDistance(), 
         0,
        (output) -> Robot.getDrivebase.arcadeDrive(speed,output),
        Robot.getDrivebase());
        getController().enableContinuousInput(-180, 180);
        getController().setTolerance(5,0);
        this.distance = distance;


              
        
    }

    public void initialize()
    {
        Robot.getDriveBase().resetEncoders();
        Robot.getNavx().reset();
    }
            
    @Override
    public void isFinished(){
        return Robot.Drivebase().getAverageEncoderDistance()>= distance && getController().atSetpoint();
    }

}

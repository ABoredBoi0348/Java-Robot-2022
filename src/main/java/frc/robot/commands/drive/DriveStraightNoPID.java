package frc.robot.commands.drive;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;


public class DriveStraightNoPID extends CommandBase{
    private final int speed;
    private final double time;
    private final double distance;
    private final Timer timer = new Timer();

    public DriveStraightNoPID(int s, double t, double d) {
        this.speed = s;
        this.time = t;
        this.distance = d;

        addRequirements(Robot.drivebase);

    }
    @Override
    public void initialize(){
        timer.start();
    }

    @Override
    public void execute() {
        Robot.drivebase.drive(speed,speed);
    }

    @Override
    public void end(boolean i){
        timer.reset();
        Robot.drivebase.drive(0,0);
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= time;
    }
}

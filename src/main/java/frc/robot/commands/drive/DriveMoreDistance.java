package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveMoreDistance extends CommandBase {
    
    private final double distance;
    private final int speed;


    public DriveMoreDistance(int d, int s) {

        this.distance = d;
        this.speed = s;
        addRequirements(Robot.drivebase);

    }

    

}

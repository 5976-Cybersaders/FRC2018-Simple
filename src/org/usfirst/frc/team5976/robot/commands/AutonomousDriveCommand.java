package org.usfirst.frc.team5976.robot.commands;

import org.usfirst.frc.team5976.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDriveCommand extends CommandGroup {
	public AutonomousDriveCommand(DriveTrain driveTrain) {
		addSequential(new EncoderInitCommand(driveTrain));
//		addSequential(new EncoderDriveStraight(driveTrain, 18.8495*1));
		addSequential(new EncoderTurnCommand(driveTrain, -90));
	}
}

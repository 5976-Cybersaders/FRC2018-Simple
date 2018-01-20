package org.usfirst.frc.team5976.robot.commands;

import org.usfirst.frc.team5976.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDriveCommand extends CommandGroup {
	public AutonomousDriveCommand(DriveTrain driveTrain) {
		addSequential(new EncoderInit(driveTrain));
		addSequential(new EncoderDriveStraight(driveTrain, 18.8495*10));
		//addSequential(new EncoderTurnCommand(driveTrain, -90));
	}
}

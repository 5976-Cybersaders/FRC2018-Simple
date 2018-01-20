package org.usfirst.frc.team5976.robot.commands;

import org.usfirst.frc.team5976.robot.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

public abstract class AbstractEncoderDriveCommand extends Command {
	protected DriveTrain driveTrain;
	protected WPI_TalonSRX leftMaster, leftSlave, rightMaster, rightSlave;
	protected double ticks;
	protected int stableCount;
	protected int printCounter = 1, printInterval = 1;
	private double previousError;
	private long t0 = 0;
	protected int allowableError = 10;
	private double currentError;

	// Wheel Values
	private final int STABLE_COUNT_STOP = 20;
	private final int DIAMETER = 6;
	// private final double revsPerSecond = 1.6;

	public AbstractEncoderDriveCommand(DriveTrain driveTrain) {
		this.driveTrain = driveTrain;
		leftMaster = driveTrain.getLeftMaster();
		leftSlave = driveTrain.getLeftSlave();
		rightMaster = driveTrain.getRightMaster();
		rightSlave = driveTrain.getRightSlave();

		ticks = 0;
		stableCount = 0;
		previousError = 9999999;
		requires(driveTrain);
	}

	@Override
	protected void initialize() {
		stableCount = 0;
		previousError = 1000000;

		report(driveTrain.getLeftMaster());
		report(driveTrain.getLeftSlave());
		report(driveTrain.getRightMaster());
		report(driveTrain.getRightSlave());

		t0 = System.currentTimeMillis();
	}

	protected void report(WPI_TalonSRX talon) {
		ReportHelper.report(talon, this);
	}

	protected void reportExecute(WPI_TalonSRX talon, String side, int pdpPort) {
		ReportHelper.reportExecute(talon, side, driveTrain.getPDP(), pdpPort, stableCount, currentError);
	}

	protected double toTicks(double inches) {
		return inches / (Math.PI * DIAMETER) * 4096;
	}

	@Override
	protected boolean isFinished() {
		currentError = (Math.abs(leftMaster.getClosedLoopError(0)) + Math.abs(rightMaster.getClosedLoopError(0))) / 2;
		if ((currentError <= allowableError && previousError > allowableError)) {
			System.out.println("Crossed into allowable error zone after stable count: " + stableCount);
		}
		else if (currentError > allowableError && previousError <= allowableError) {
			System.out.println("Crossed out of allowable error zone stable count: " + stableCount + " Previous: " + previousError + " current: " + currentError);
		}
		previousError = currentError;
		if (currentError <= allowableError /*&& Math.abs(previousError - currentError) < allowableError*/) {
			stableCount++;
			if (stableCount >= STABLE_COUNT_STOP) {
				System.out.println("Stopping. Stable count = " + stableCount + " Left: "
						+ Math.abs(leftMaster.getClosedLoopError(0)) + " Right: " + Math.abs(rightMaster.getClosedLoopError(0)));
				return true;
			}
		} else {
			// if (System.currentTimeMillis() - t0 >= getTimeOut()) {
			// return true;
			// }
			stableCount = 0;
		}
		return false;
	}

	protected void end() {
		System.out.println("END " + this);
	}

	protected void interrupted() {
		end();
	}
	/*
	 * protected double getTimeOut(){ double targetRevs =
	 * (Math.abs(leftMaster.getSetpoint()) + Math.abs(rightMaster.getSetpoint()))/2;
	 * return targetRevs*revsPerSecond*1000; }
	 */
}

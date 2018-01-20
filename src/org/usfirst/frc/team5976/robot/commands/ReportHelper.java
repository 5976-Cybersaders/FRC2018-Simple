package org.usfirst.frc.team5976.robot.commands;

import java.text.DecimalFormat;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReportHelper {
	private static DecimalFormat formatter = new DecimalFormat("#.000000");

	public static void reportExecute(WPI_TalonSRX talon, String side, PowerDistributionPanel pdp, int pdpPort,
			int stableCount, double avgError) {
		double set = talon.getClosedLoopTarget(0);
		double pos = talon.getSelectedSensorPosition(0);
		int clErr = talon.getClosedLoopError(0);
		double voltage = talon.getMotorOutputVoltage();

		System.out.println(side + " Set: " + formatter.format(set) +
		// Gets the current status of the Talon (usually a sensor value).
				"\tPos: " + formatter.format(pos) +
				// Get the current difference between the setpoint and the sensor value.
				"\tCLErr: " + clErr +

				" Count: " + stableCount + " Avg Error: " + avgError + " Voltage: " + formatter.format(voltage));

	}
	// public static void reportExecute(WPI_TalonSRX talon, String side,
	// PowerDistributionPanel pdp, int pdpPort,
	// int stableCount, double avgError) {
	// double set = talon.getClosedLoopTarget();
	// double pos = talon.get();
	// int clErr = talon.getClosedLoopError();
	// int encPos = talon.getEncPosition();
	// double err = talon.getError();
	// double posRev = talon.getPosition();
	// double voltage = talon.getOutputVoltage();
	//
	// System.out.println(side + " Set: " + formatter.format(set) +
	// // Gets the current status of the Talon (usually a sensor value).
	// "\tPos: " + formatter.format(pos) +
	// // Get the current difference between the setpoint and the sensor value.
	// "\tCLErr: " + clErr +
	// // Get the current encoder position, regardless of whether it is the current
	// // feedback device.
	// " Enc Pos: " + encPos +
	// // Returns the difference between the setpoint and the current position.
	// " Err: " + formatter.format(err) +
	// // When using analog sensors, 0 units corresponds to 0V, 1023 units
	// corresponds
	// // to 3.3V When using an analog encoder
	// // (wrapping around 1023 to 0 is possible) the units are still 3.3V per 1023
	// // units.
	// " Pos(in revs): " + formatter.format(posRev) +
	// " Count: " + stableCount +
	// " Avg Error: " + avgError +
	// " Voltage: " + formatter.format(voltage));
	// SmartDashboard.putNumber(side + " Current", pdp.getCurrent(pdpPort));
	// }

	public static void report(WPI_TalonSRX talon, Command command) {
		System.out.println("INIT " + command);
		System.out.println("Control Mode: " + talon.getControlMode());
		System.out.println("Device ID" + talon.getDeviceID());
		// System.out.println("Closed Loop Ramp Rate" + talon.getCloseLoopRampRate());
		// System.out.println("Source Type " + talon.getPIDSourceType());
		System.out.println("Inverted: " + talon.getInverted());
		// System.out.println("PID Values: " + talon.getP() + " " + talon.getI() + " " +
		// talon.getD());
		System.out.println("Position: " + talon.getSelectedSensorPosition(0));
		System.out.println("Closed Loop Target: " + talon.getClosedLoopTarget(0));
		System.out.println("Closed Loop Error: " + talon.getClosedLoopError(0));
		System.out.println();
	}
}

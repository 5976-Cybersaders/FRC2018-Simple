package org.usfirst.frc.team5976.robot;

public class SmartDashboardMap {
	// Encoder
	public static final SmartValue kPFL = new SmartValue("P-Value FL", 0.21);
	public static final SmartValue kIFL = new SmartValue("I-Value FL", 0);
	public static final SmartValue kDFL = new SmartValue("D-Value FL", 0);
	public static final SmartValue kPFR = new SmartValue("P-Value FR", 0.04);
	public static final SmartValue kIFR = new SmartValue("I-Value FR", 0);
	public static final SmartValue kDFR = new SmartValue("D-Value FR", 0);
	public static final SmartValue kPRL = new SmartValue("P-Value RL", 0.18);
	public static final SmartValue kIRL = new SmartValue("I-Value RL", 0);
	public static final SmartValue kDRL = new SmartValue("D-Value RL", 0);
	public static final SmartValue kPRR = new SmartValue("P-Value RR", 0.035);
	public static final SmartValue kIRR = new SmartValue("I-Value RR", 0);
	public static final SmartValue kDRR = new SmartValue("D-Value RR", 0);
	public static final SmartValue ALLOWABLE_ERROR = new SmartValue("Allowable Error", 100);

	// Talon
	public static final SmartValue PEAK_VOLTAGE = new SmartValue("Peak Voltage", 3.5);
	public static final SmartValue NOMINAL_VOLTAGE = new SmartValue("Nominal Voltage", 2.2);
	public static final SmartValue RAMP_RATE = new SmartValue("Ramp Rate", 0);
	// public static final SmartValue RAMP_RATE_R = new SmartValue("Ramp Rate
	// Right")

	// Drive Straight Command Group
	public static final SmartValue DRIVE_DISTANCE_1 = new SmartValue("DD 1", 18.8495);
	public static final SmartValue DRIVE_DISTANCE_2 = new SmartValue("DD 2", -18.8495);
	public static final SmartValue TIME = new SmartValue("Tiem", 500);

	// Turn
	public static final SmartValue ANGLE = new SmartValue("Angle", 90);

	public static final SmartValue POSITION = new SmartValue("Position", 0);
	
	public static void reportAll() {
		report(kPFL);
		report(kIFL);
		report(kDFL);
		report(kPFR);
		report(kIFR);
		report(kDFR);
		report(kPRL);
		report(kIRL);
		report(kDRL);
		report(kPRR);
		report(kIRR);
		report(kDRR);
		report(ALLOWABLE_ERROR);
		report(DRIVE_DISTANCE_1);
		report(DRIVE_DISTANCE_2);
		report(PEAK_VOLTAGE);
		report(NOMINAL_VOLTAGE);
	}

	private static void report(SmartValue variable) {
		System.out.println(variable.getKey() + ": " + variable.getDouble());
	}
}

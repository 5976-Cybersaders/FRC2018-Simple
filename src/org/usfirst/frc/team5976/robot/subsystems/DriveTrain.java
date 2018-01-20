package org.usfirst.frc.team5976.robot.subsystems;

import org.usfirst.frc.team5976.robot.OI;
import org.usfirst.frc.team5976.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private DifferentialDrive robotDrive;
	public WPI_TalonSRX leftMaster, leftSlave, rightMaster, rightSlave;
	private PowerDistributionPanel pdp;
	private OI oi;
	
	public DriveTrain(OI oi) {
		super();
		System.out.println("START INIT DriveTrain");
		leftMaster = new WPI_TalonSRX(RobotMap.LEFT_MASTER);
		leftSlave = new WPI_TalonSRX(RobotMap.LEFT_SLAVE);
		rightMaster = new WPI_TalonSRX(RobotMap.RIGHT_MASTER);
		rightSlave = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE);
		pdp = new PowerDistributionPanel();
		this.oi = oi;
//		Master motors should always be the motor in front
		//robotDrive = new DifferentialDrive(leftMaster, rightMaster);
		System.out.println("END INIT DriveTrain");
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void updateDefaultCommandForNonTeleOp() {
		//If you see an error like "Output not updated often" change this value
		//robotDrive.setExpiration(MotorSafety.DEFAULT_SAFETY_EXPIRATION);
		setDefaultCommand(null);
	}
	
	public void updateDefaultCommandForTeleOp() {
		//If you see an error like "Output not updated often" change this value
		//robotDrive.setExpiration(MotorSafety.DEFAULT_SAFETY_EXPIRATION);
		//setDefaultCommand(new TeleOpTankDrive(getOI().getDriveController(), this));
	}
		
	public DifferentialDrive getRobotDrive() {
		return robotDrive;
	}

	public WPI_TalonSRX getLeftMaster() {
		return leftMaster;
	}

	public WPI_TalonSRX getRightMaster() {
		return rightMaster;
	}
	
	public WPI_TalonSRX getLeftSlave() {
		return leftSlave;
	}

	public WPI_TalonSRX getRightSlave() {
		return rightSlave;
	}
	
	public PowerDistributionPanel getPDP() {
		return pdp;
	}
	
	public OI getOI() {
		return oi;
	}
}

package org.usfirst.frc.team5976.robot.commands;

import org.usfirst.frc.team5976.robot.RobotMap;
import org.usfirst.frc.team5976.robot.SmartDashboardMap;
import org.usfirst.frc.team5976.robot.SmartValue;
import org.usfirst.frc.team5976.robot.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EncoderTurnCommand extends AbstractEncoderDriveCommand {
		private double angle;
		private SmartValue smartValue;
		
		public EncoderTurnCommand (DriveTrain driveTrain, double angle){
			super(driveTrain);
			this.angle = angle;
			
		}
		
		public EncoderTurnCommand (DriveTrain driveTrain, SmartValue smartValue){
			super(driveTrain);
			this.smartValue = smartValue;
			
		}
		
		protected void initialize() {
			super.initialize();
			if (smartValue != null)
				angle = smartValue.getDouble();
			ticks = toTicks(angle);
			allowableError = (int)SmartDashboardMap.ALLOWABLE_ERROR.getDouble();
//			if (ticks > 0) {
//				//TODO:
//				leftMaster.selectProfileSlot(0, 0);
//				rightMaster.selectProfileSlot(1, 0);
//			}
//			else {
//				leftMaster.selectProfileSlot(1, 0);
//				rightMaster.selectProfileSlot(0, 0);
//			}
			System.out.println("Starting command drive turn angle " + angle + " ticks " + ticks);
			leftMaster.set(ControlMode.Position, 0);
			rightMaster.set(ControlMode.Position, 0);
			report(leftMaster);
			report(rightMaster);
			report(leftSlave);
			report(rightSlave);
			
		}
		
		protected void execute() {
			SmartDashboard.putNumber("Left Revolutions", leftMaster.getSelectedSensorPosition(0));
			SmartDashboard.putNumber("Right Revolutions", rightMaster.getSelectedSensorPosition(0));
			leftMaster.set(ControlMode.Position, ticks);
			leftSlave.follow(leftMaster);
			rightMaster.set(ControlMode.Position, -ticks);
			rightSlave.follow(rightMaster);

			if (printCounter == printInterval) {
				reportExecute(leftMaster, "Left Master", RobotMap.LEFT_MASTER_PDP);
				// reportExecute(leftSlave, "Left Slave", RobotMap.LEFT_SLAVE_PDP);
				reportExecute(rightMaster, "Right Master", RobotMap.RIGHT_MASTER_PDP);
				// reportExecute(rightSlave, "Right Slave", RobotMap.RIGHT_SLAVE_PDP);
				System.out.println();
				printCounter = 0;
			} else {
				printCounter++;
			}

		}
		
		protected double toTicks(double angle){
			return super.toTicks((angle/360)*(RobotMap.TURN_DIAMETER*Math.PI));
		}
		
		
}

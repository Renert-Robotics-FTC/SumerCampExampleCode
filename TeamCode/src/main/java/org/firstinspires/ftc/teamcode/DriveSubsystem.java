package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem {

    private DcMotor BL;
    private DcMotor BR;
    private DcMotor FL;
    private DcMotor FR;

    public DriveSubsystem(HardwareMap hardwareMap) {

        BL = hardwareMap.get(DcMotor.class, "BL");
        BR = hardwareMap.get(DcMotor.class, "BR");
        FL = hardwareMap.get(DcMotor.class, "FL");
        FR = hardwareMap.get(DcMotor.class, "FR");

        // Reverse motors if needed
        FL.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);
    }


    public void drive(double forward, double strafe, double turn, boolean slowMode) {

        double speed = slowMode ? 0.25 : 1.0;

        double flPower = (forward + strafe + turn) * speed;
        double frPower = (forward - strafe - turn) * speed;
        double blPower = (forward - strafe + turn) * speed;
        double brPower = (forward + strafe - turn) * speed;

        FL.setPower(flPower);
        FR.setPower(frPower);
        BL.setPower(blPower);
        BR.setPower(brPower);
    }
    }
}
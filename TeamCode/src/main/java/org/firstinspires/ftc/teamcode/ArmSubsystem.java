package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArmSubsystem {

    private DcMotor armMotor;

    // PID Variables
    private double target = 0;
    private final double kP = 0.005;

    public ArmSubsystem(HardwareMap hardwareMap) {

        armMotor = hardwareMap.get(DcMotor.class, "arm");

        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setTarget(double newTarget) {
        target = newTarget;
    }

    public void update() {

        double position = armMotor.getCurrentPosition();

        double error = target - position;

        double power = error * kP;

        // Prevent excessive power
        power = Math.max(-1.0, Math.min(power, 1.0));

        armMotor.setPower(power);
    }

    public double getTarget() {
        return target;
    }

    public int getPosition() {
        return armMotor.getCurrentPosition();
    }
}
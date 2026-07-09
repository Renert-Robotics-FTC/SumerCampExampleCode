package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArmSubsystem {

    public ArmSubsystem(HardwareMap hardwareMap) {

        arm = hardwareMap.get(DcMotor.class, "arm");

        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        armPID = new PIDController(
                0.01,
                0,
                0.0005
        );
    }

    public void RunMotor() {
        arm.setPower(1);
    }

    public void StopMotor() {
        arm.setPower(0);
    }

    public class PIDController {

        private double kP;
        private double kI;
        private double kD;

        private double integral = 0;
        private double lastError = 0;
        private long lastTime = System.nanoTime();

        public PIDController(double p, double i, double d) {
            kP = p;
            kI = i;
            kD = d;
        }

        public double calculate(double target, double current) {

            double error = target - current;

            long currentTime = System.nanoTime();
            double dt = (currentTime - lastTime) / 1e9;
            lastTime = currentTime;

            integral += error * dt;

            double derivative = 0;
            if (dt > 0) {
                derivative = (error - lastError) / dt;
            }

            lastError = error;

            return (kP * error)
                    + (kI * integral)
                    + (kD * derivative);
        }

        public void reset() {
            integral = 0;
            lastError = 0;
            lastTime = System.nanoTime();
        }
    }

    private DcMotor arm;

    PIDController armPID;

    int targetPosition = 500;

    public void update() {
        int current = arm.getCurrentPosition();

        double power = armPID.calculate(targetPosition, current);

        power = Math.max(-1, Math.min(1, power));

        arm.setPower(power);
    }

    public int getCurrentPosition() {
        return arm.getCurrentPosition();
    }

    public double getPower() {
        return arm.getPower();
    }

    public int getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(int target) {
        targetPosition = target;
    }
}

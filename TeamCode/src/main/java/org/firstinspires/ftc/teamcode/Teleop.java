package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        ArmSubsystem arm = new ArmSubsystem(hardwareMap);
        DriveSubsystem chassis = new DriveSubsystem(hardwareMap);
        ClawSubsystem claw = new ClawSubsystem(hardwareMap);

        telemetry.addLine("Ready!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // Preset Positions

            if (gamepad1.a)
                arm.setTarget(0);

            if (gamepad1.b)
                arm.setTarget(170);

            if (gamepad1.y)
                arm.setTarget(90);


            if (gamepad1.x) {
                claw.CloseClaw();
            } else {
                claw.OpenClaw();
            }


            chassis.updateInputs(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            // Run the PID every loop
            arm.update();
            chassis.update();

            // Telemetry
            telemetry.addData("Target", arm.getTarget());
            telemetry.addData("Position", arm.getPosition());

            telemetry.update();
        }
    }
}
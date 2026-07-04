package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        ArmSubsystem arm = new ArmSubsystem(hardwareMap);

        telemetry.addLine("Ready!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // Preset Positions
            if (gamepad2.a)
                arm.setTarget(0);

            if (gamepad2.b)
                arm.setTarget(500);

            if (gamepad2.y)
                arm.setTarget(1000);

            // Run the PID every loop
            arm.update();

            // Telemetry
            telemetry.addData("Target", arm.getTarget());
            telemetry.addData("Position", arm.getPosition());

            telemetry.update();
        }
    }
}
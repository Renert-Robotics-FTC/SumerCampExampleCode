package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        ExampleSubsystem Subsystem = new ExampleSubsystem(hardwareMap);
        ArmSubsystem Armsubsystem = new ArmSubsystem(hardwareMap);


        telemetry.addLine("Ready!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // Preset Positions
            if (gamepad1.a) {
                Armsubsystem.setTargetPosition(0);
            }

            if (gamepad1.b) {
                Armsubsystem.setTargetPosition(500);
            }

            if (gamepad1.y) {
                Armsubsystem.setTargetPosition(1000);
            }

            // Run the PID every loop

            // Telemetry

            Armsubsystem.update();

            telemetry.addData("Target", Armsubsystem.getTargetPosition());
            telemetry.addData("Current", Armsubsystem.getCurrentPosition());
            telemetry.addData("Power", Armsubsystem.getPower());
            telemetry.update();


            telemetry.update();
        }
    }
}

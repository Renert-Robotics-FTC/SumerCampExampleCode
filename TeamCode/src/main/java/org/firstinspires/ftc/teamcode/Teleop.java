package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOp")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {

        ExampleSubsystem Subsystem = new ExampleSubsystem(hardwareMap);


        telemetry.addLine("Ready!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            // Preset Positions








            // Run the PID every loop
            Subsystem.RunMotor();


            // Telemetry


            telemetry.update();
        }
    }
}
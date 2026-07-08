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








            // Run the PID every loop
            arm.RunMotor();


            // Telemetry


            telemetry.update();
        }
    }
}
//'boredom'
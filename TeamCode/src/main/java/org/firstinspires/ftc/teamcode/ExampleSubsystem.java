package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ExampleSubsystem {

    private DcMotor motor;

    // PID Variables


    public ExampleSubsystem(HardwareMap hardwareMap) {

        motor = hardwareMap.get(DcMotor.class, "motor");


    }

    public void RunMotor() {
        motor.setPower(1);
    }

}
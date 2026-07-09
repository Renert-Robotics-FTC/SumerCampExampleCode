package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ExampleSubsystem {

    private DcMotor Motor;

    // PID Variables


    public ExampleSubsystem(HardwareMap hardwareMap) {

        Motor = hardwareMap.get(DcMotor.class, "motor");


    }

    public void RunMotor() {
        Motor.setPower(1);
    }

}
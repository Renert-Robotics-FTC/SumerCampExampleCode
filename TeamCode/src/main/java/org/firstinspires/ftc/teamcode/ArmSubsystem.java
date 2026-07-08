package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArmSubsystem {

    private DcMotor armMotor;

    // PID Variables


    public ArmSubsystem(HardwareMap hardwareMap) {

        armMotor = hardwareMap.get(DcMotor.class, "arm");


    }

    public void RunMotor() {
        armMotor.setPower(1);
    }

}
package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArmSubsystem {

    private DcMotor Motor;

    public ArmSubsystem(HardwareMap hardwareMap) {

        Motor = hardwareMap.get(DcMotor.class, "motor");


    }

    public void RunMotor() {
        Motor.setPower(1);
    }

    public void StopMotor() {
        Motor.setPower(0);
    }

}

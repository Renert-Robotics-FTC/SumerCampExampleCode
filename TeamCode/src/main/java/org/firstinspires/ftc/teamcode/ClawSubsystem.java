package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class ClawSubsystem {
    private Servo claw;


    public ClawSubsystem(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "claw" );
    }

    public void OpenClaw(){
        claw.setPosition(0.5);
    }

    public void CloseClaw(){
        claw.setPosition(1);
    }


}

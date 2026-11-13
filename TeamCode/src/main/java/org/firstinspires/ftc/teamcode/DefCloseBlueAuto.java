package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.robotcore.external.navigation.UnnormalizedAngleUnit;

import java.util.ArrayList;
import java.util.List;

@Autonomous(name="DefCloseBlueAuto", group="Linear OpMode")

public class DefCloseBlueAuto extends LinearOpMode{

    private DcMotor FL = null;
    private DcMotor BL = null;
    private DcMotor FR = null;
    private DcMotor BR = null;
    private DcMotor INTAKE = null;
    private DcMotor TRANSFER = null;
    private DcMotorEx LAUNCHER = null;


    double FL_power = .5;
    double FR_power = .5;
    double BR_power = .5;
    double BL_power = .5;

    public double getFL_power(){return FL_power;}
    public double getFR_power(){return FR_power;}
    public double getBR_power(){return BR_power;}
    public double getBL_power(){return BL_power;}

    public void setFL_power(double power){FL_power = power;}
    public void setFR_power(double power){FR_power = power;}
    public void setBR_power(double power){BR_power = power;}
    public void setBL_power(double power){BL_power = power;}

    public void resetMotorVarPower(){
        setFL_power(0);
        setFR_power(0);
        setBR_power(0);
        setBL_power(0);
    }

    @Override
    // Init function
    public void runOpMode() {
        // Map Wheel Motors from the driver station
        FL = hardwareMap.get(DcMotor.class, "front_left_drive");
        BL = hardwareMap.get(DcMotor.class, "back_left_drive");
        FR = hardwareMap.get(DcMotor.class, "front_right_drive");
        BR = hardwareMap.get(DcMotor.class, "back_right_drive");

        // ########################################################################################
        // !!!            IMPORTANT Drive Information. Test your motor directions.            !!!!!
        // ########################################################################################
        // Most robots need the motors on one side to be reversed to drive forward.
        // The motor reversals shown here are for a "direct drive" robot (the wheels turn the same direction as the motor shaft)
        // If your robot has additional gear reductions or uses a right-angled drive, it's important to ensure
        // that your motors are turning in the correct direction.  So, start out with the reversals here, BUT
        // when you first test your robot, push the left joystick forward and observe the direction the wheels turn.
        // Reverse the direction (flip FORWARD <-> REVERSE ) of any wheel that runs backward
        // Keep testing until ALL the wheels move the robot forward when you push the left joystick forward.
        FL.setDirection(DcMotor.Direction.FORWARD);
        BL.setDirection(DcMotor.Direction.FORWARD);
        FR.setDirection(DcMotor.Direction.REVERSE);
        BR.setDirection(DcMotor.Direction.REVERSE);

        // Add brakes to each wheel motor
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Map Misc
        //LAUNCHER = hardwareMap.get(DcMotorEx.class, "launcher");
        //INTAKE = hardwareMap.get(DcMotor.class, "intakeMotor");
        //TRANSFER = hardwareMap.get(DcMotor.class, "transfer");

        //LAUNCHER.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //LAUNCHER.setVelocityPIDFCoefficients(30.0, 0, 1.0, 12.0);//P is correction of the motor F is to hold the speed


        // Wait for user to press run on DS
        waitForStart();

        setPower();
        sleep(500);
        setPowerToZero();
        //LAUNCHER.setVelocity(-launcherVelocity);

        // testRun();

    }


    public void setPower(){
        FL.setPower(getFL_power());
        FR.setPower(getFR_power());
        BL.setPower(getBL_power());
        BR.setPower(getBR_power());
    }

    public void setPowerToZero(){
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
    }

}

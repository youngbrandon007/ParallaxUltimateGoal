package org.firstinspires.ftc.teamcode.ProjectChipotle;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class chipotleBot extends LinearOpMode {

    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;

    DcMotor collector;

    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.get(DcMotor.class, "lf");
        leftBack = hardwareMap.get(DcMotor.class, "lb");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        rightBack = hardwareMap.get(DcMotor.class, "rb");

        collector = hardwareMap.get(DcMotor.class, "cm");

        waitForStart();

        while(opModeIsActive()){
            leftFront.setPower(-gamepad1.left_stick_y);
            leftBack.setPower(-gamepad1.left_stick_y);
            rightFront.setPower(gamepad1.right_stick_y);
            rightBack.setPower(gamepad1.right_stick_y);
            collector.setPower(gamepad1.left_trigger - gamepad1.right_trigger);

            telemetry.addData("left", gamepad1.left_stick_y);
            telemetry.addData("right", gamepad1.right_stick_y);
            telemetry.update();
        }
    }
}

@file:JvmName("Constants")
package org.firstinspires.ftc.teamcode.pedro

import com.pedropathing.follower.Follower
import com.pedropathing.revhub.drivetrains.MecanumConfig
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap

@JvmField
val drivetrainConfig = MecanumConfig {
    it.frontLeftName.set("leftFrontMotor")
    it.frontRightName.set("rightFrontMotor")
    it.backLeftName.set("leftRearMotor")
    it.backRightName.set("rightRearMotor")
    it.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE)
    it.frontRightDirection.set(DcMotorSimple.Direction.REVERSE)
    it.backLeftDirection.set(DcMotorSimple.Direction.REVERSE)
    it.backRightDirection.set(DcMotorSimple.Direction.REVERSE)
}

fun create(h: HardwareMap): Follower? {
    // return new Follower(Drivetrain, Localizer, Foresight);
    return null
}
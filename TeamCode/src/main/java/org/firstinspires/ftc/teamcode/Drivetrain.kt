package org.firstinspires.ftc.teamcode

import com.pedropathing.ivy.Command
import dev.nextftc.control.drive.DriveInput
import dev.nextftc.control.drive.MecanumKinematics
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism

class Drivetrain : Mechanism {
    val frontLeft = NextMotor("front_left_motor")
    val frontRight = NextMotor("front_right_motor")
    val backLeft = NextMotor("back_left_motor")
    val backRight = NextMotor("back_right_motor")

    val kinematics = MecanumKinematics()

    fun drive(x: () -> Double, y: () -> Double, rot: () -> Double): Command = infinite {
        val input = DriveInput(x(), y(), rot())

        val powers = kinematics.calculate(input)

        frontLeft.throttle = powers.frontLeft
        frontRight.throttle = powers.frontRight
        backLeft.throttle = powers.backLeft
        backRight.throttle = powers.backRight
    }
}
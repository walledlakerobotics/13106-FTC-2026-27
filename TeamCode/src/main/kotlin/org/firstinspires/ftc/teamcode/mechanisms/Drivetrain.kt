package org.firstinspires.ftc.teamcode.mechanisms

import com.pedropathing.ivy.Command
import dev.nextftc.control.drive.DriveInput
import dev.nextftc.control.drive.MecanumKinematics
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.triggers.CommandGamepad

class Drivetrain : Mechanism {
    val frontLeft = NextMotor("front_left_motor")
    val frontRight = NextMotor("front_right_motor")
    val backLeft = NextMotor("back_left_motor")
    val backRight = NextMotor("back_right_motor")

    val kinematics = MecanumKinematics(1.1)

    fun drive(x: () -> Double, y: () -> Double, rot: () -> Double): Command = infinite {
        val input = DriveInput(x(), y(), rot())

        val powers = kinematics.calculate(input)

        frontLeft.throttle = powers.frontLeft
        frontRight.throttle = powers.frontRight
        backLeft.throttle = powers.backLeft
        backRight.throttle = powers.backRight
    }

    fun driveByDefault(gamepad: CommandGamepad) {
        defaultCommand = drive(
            { -gamepad.leftStickY.value },
            { -gamepad.leftStickX.value },
            { -gamepad.rightStickX.value }
        )
    }

    override var defaultCommand = super.defaultCommand
        private set
}
package org.firstinspires.ftc.teamcode.mechanisms

import com.pedropathing.ivy.Command
import dev.nextftc.control.drive.DriveInput
import dev.nextftc.control.drive.MecanumKinematics
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.triggers.CommandGamepad
import dev.nextftc.units.volts

val NOMINAL_VOLTAGE = 12.0.volts

class Drivetrain : Mechanism {
    val frontLeft = NextMotor("front_left")
    val frontRight = NextMotor("front_right")
    val backLeft = NextMotor("back_left")
    val backRight = NextMotor("back_right")

    init {
        frontRight.direction = NextMotor.Direction.REVERSE
        frontLeft.direction = NextMotor.Direction.REVERSE
        backRight.direction = NextMotor.Direction.REVERSE
        backLeft.direction = NextMotor.Direction.REVERSE
    }

    val kinematics = MecanumKinematics(1.1)

    fun drive(x: () -> Double, y: () -> Double, rot: () -> Double): Command = infinite {
        val input = DriveInput(x(), y(), rot())

        val powers = kinematics.calculate(input)

        frontLeft.voltage = NOMINAL_VOLTAGE * powers.frontLeft
        frontRight.voltage = NOMINAL_VOLTAGE * powers.frontRight
        backLeft.voltage = NOMINAL_VOLTAGE * powers.backLeft
        backRight.voltage = NOMINAL_VOLTAGE * powers.backRight
    }

    fun driveByDefault(gamepad: CommandGamepad) {
        defaultCommand = drive(
            { -gamepad.leftStickY.value },
            { gamepad.leftStickX.value },
            { gamepad.rightStickX.value }
        )
    }

    override var defaultCommand = super.defaultCommand
        private set
}
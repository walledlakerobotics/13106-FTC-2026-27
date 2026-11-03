package org.firstinspires.ftc.teamcode.mechanisms

import com.pedropathing.ivy.Command
import dev.nextftc.control.drive.DriveInput
import dev.nextftc.control.drive.MecanumKinematics
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.triggers.CommandGamepad
import org.firstinspires.ftc.teamcode.NOMINAL_VOLTAGE

class Drivetrain : Mechanism {
    val frontLeft = NextMotor("leftFrontMotor")
    val frontRight = NextMotor("rightFrontMotor")
    val backLeft = NextMotor("leftRearMotor")
    val backRight = NextMotor("rightRearMotor")

    init {
        frontRight.direction = NextMotor.Direction.REVERSE
        frontLeft.direction = NextMotor.Direction.REVERSE
        backRight.direction = NextMotor.Direction.REVERSE
        backLeft.direction = NextMotor.Direction.REVERSE

        frontRight.zeroPowerBehavior = NextMotor.ZeroPowerBehavior.BRAKE
        frontLeft.zeroPowerBehavior = NextMotor.ZeroPowerBehavior.BRAKE
        backRight.zeroPowerBehavior = NextMotor.ZeroPowerBehavior.BRAKE
        backLeft.zeroPowerBehavior = NextMotor.ZeroPowerBehavior.BRAKE
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
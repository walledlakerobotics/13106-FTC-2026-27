package org.firstinspires.ftc.teamcode.mechanisms

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import dev.nextftc.units.volts

class Intake : Mechanism {
    private val intakeMotor = NextMotor("intakeMotor")

    init {
        intakeMotor.direction = NextMotor.Direction.REVERSE
        intakeMotor.zeroPowerBehavior = NextMotor.ZeroPowerBehavior.BRAKE
    }

    val run
        get() = instant { intakeMotor.voltage = 12.0.volts }
            .setDone { false }
            .setEnd { intakeMotor.voltage = 0.0.volts }!!
}
package org.firstinspires.ftc.teamcode.mechanisms

import dev.nextftc.hardware.actuators.NextCRServo
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism

class Gate : Mechanism {
    val gateServo = NextCRServo("gateServo")

    init {
        gateServo.direction = NextMotor.Direction.REVERSE
    }

    val run
        get() = instant { gateServo.power = 1.0 }
            .setDone { false }
            .setEnd { gateServo.power = 0.0 }!!
}
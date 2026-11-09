package org.firstinspires.ftc.teamcode.mechanisms

import com.pedropathing.ivy.Command
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import dev.nextftc.units.RadiansPerSecond
import dev.nextftc.units.rotationsPerMinute
import dev.nextftc.units.rotationsPerSecond
import dev.nextftc.units.volts

class Launcher : Mechanism {
    private val launcherMotor = NextMotor("launchMotor")

    init {
        launcherMotor.velocityConstants.apply {
            kP = 0.1
            kI = 0.0
            kD = 0.0
            kS = 0.0
            kV = 12.0 / (6000.0.rotationsPerMinute.into(RadiansPerSecond))
            kA = 0.0
        }

        launcherMotor.direction = NextMotor.Direction.REVERSE
        launcherMotor.zeroPowerBehavior = NextMotor.ZeroPowerBehavior.FLOAT
    }

    val run: Command
        get() = instant { launcherMotor.voltage = 6.0.volts }
            .setDone { false }
            .setEnd { launcherMotor.voltage = 0.0.volts }
}
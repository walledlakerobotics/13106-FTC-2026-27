package org.firstinspires.ftc.teamcode

import dev.nextftc.robot.NextRobot
import org.firstinspires.ftc.teamcode.mechanisms.Drivetrain

class Robot : NextRobot {
    val drivetrain = Drivetrain()

    override val mechanisms = setOf(drivetrain)
}
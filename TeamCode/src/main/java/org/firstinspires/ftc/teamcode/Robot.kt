package org.firstinspires.ftc.teamcode

import dev.nextftc.robot.NextRobot

class Robot : NextRobot {
    val drivetrain = Drivetrain()

    override val mechanisms = setOf(drivetrain)
}
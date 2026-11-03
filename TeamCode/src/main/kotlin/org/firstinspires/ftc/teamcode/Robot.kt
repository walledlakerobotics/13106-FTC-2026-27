package org.firstinspires.ftc.teamcode

import dev.nextftc.robot.NextRobot
import org.firstinspires.ftc.teamcode.mechanisms.Drivetrain
import org.firstinspires.ftc.teamcode.mechanisms.Gate
import org.firstinspires.ftc.teamcode.mechanisms.Intake
import org.firstinspires.ftc.teamcode.mechanisms.Launcher

class Robot : NextRobot {
    val drivetrain = Drivetrain()
    val launcher = Launcher()
    val intake = Intake()
    val gate = Gate()

    override val mechanisms = setOf(drivetrain, launcher, intake, gate)
}
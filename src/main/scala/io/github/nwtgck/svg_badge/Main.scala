package io.github.nwtgck.svg_badge

import java.io.{File, PrintWriter}

import scala.xml.Elem

object Main {

  def main(args: Array[String]): Unit = {
    args match {
      case Array(subject, status, color) =>
        writeFile(s"./${subject}-${status}.svg", SvgBadgeMaker.smartGenerate(subjectText = subject, statusText = status, badgeColor = color))
      case _                  =>
        System.err.println("""Usage: sbt "runMain io.github.nwtgck.svg_badge.Main" <subject:String> <status:String> <color:String> """)
        System.exit(1)
    }
  }

  def writeFile(outPath: String, svg: Elem): Unit = {
    val fileWriter = new PrintWriter(new File(outPath))
    fileWriter.println(svg)
    fileWriter.close()
  }

  def examples(): Unit = {
    // [license|MIT]
    writeFile("./output-svg/license-mit.svg", SvgBadgeMaker.generate(width= 78, subjectWidth= 47, subjectText = "license", statusText = "MIT", badgeColor = "#007ec6"))
    // [build|passing]
    writeFile("./output-svg/build-passing.svg", SvgBadgeMaker.generate(width = 90, subjectWidth = 40, subjectText = "build", statusText = "passing", badgeColor = "#6c3"))
    // [build|failing]
    writeFile("./output-svg/build-failing.svg", SvgBadgeMaker.generate(width = 90, subjectWidth = 40, subjectText = "build", statusText = "failing", badgeColor = "#e05d44"))
    // [coverage|91%]
    writeFile("./output-svg/coverage-91%.svg", SvgBadgeMaker.generate(width = 110, subjectWidth = 60, subjectText = "coverage", statusText = "91%", badgeColor = "#97CA00"))
    // [developer|Pythonista]
    writeFile("./output-svg/developer-pythonista.svg", SvgBadgeMaker.generate(width = 140, subjectWidth = 65, subjectText = "developer", statusText = "Pythonista", badgeColor = "#eac210"))
    // [developer|Rubyist]
    writeFile("./output-svg/developer-rubyist.svg", SvgBadgeMaker.generate(width = 120, subjectWidth = 65, subjectText = "developer", statusText = "Rubyist", badgeColor = "#cc342d"))
    // [developer|Haskeller]
    writeFile("./output-svg/developer-haskeller.svg", SvgBadgeMaker.generate(width = 130, subjectWidth = 70, subjectText = "developer", statusText = "Haskeller", badgeColor = "#8f4e8b"))
    // [creator|YouTuber]
    writeFile("./output-svg/creator-youtuber.svg", SvgBadgeMaker.generate(width = 115, subjectWidth = 50, subjectText = "creator", statusText = "YouTuber", badgeColor = "#ff0000"))
  }
}

package io.github.nwtgck.svg_badge

import java.io.{File, PrintWriter}

import scala.xml.Elem

object Main {

  def main(args: Array[String]): Unit = {
    args match {
      case Array(subject, status, color) =>
        writeFile(s"./${subject}-${status}.svg", SvgBadgeMaker.smartGenerate(headName = subject, tailName = status, badgeColor = color))
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
    writeFile("./output-svg/license-mit.svg", SvgBadgeMaker.generate(width= 78, headWidth= 47, headName = "license", tailName = "MIT", badgeColor = "#007ec6"))
    // [build|passing]
    writeFile("./output-svg/build-passing.svg", SvgBadgeMaker.generate(width = 90, headWidth = 40, headName = "build", tailName = "passing", badgeColor = "#6c3"))
    // [build|failing]
    writeFile("./output-svg/build-failing.svg", SvgBadgeMaker.generate(width = 90, headWidth = 40, headName = "build", tailName = "failing", badgeColor = "#e05d44"))
    // [coverage|91%]
    writeFile("./output-svg/coverage-91%.svg", SvgBadgeMaker.generate(width = 110, headWidth = 60, headName = "coverage", tailName = "91%", badgeColor = "#97CA00"))
    // [developer|Pythonista]
    writeFile("./output-svg/developer-pythonista.svg", SvgBadgeMaker.generate(width = 140, headWidth = 65, headName = "developer", tailName = "Pythonista", badgeColor = "#eac210"))
    // [developer|Rubyist]
    writeFile("./output-svg/developer-rubyist.svg", SvgBadgeMaker.generate(width = 120, headWidth = 65, headName = "developer", tailName = "Rubyist", badgeColor = "#cc342d"))
    // [developer|Haskeller]
    writeFile("./output-svg/developer-haskeller.svg", SvgBadgeMaker.generate(width = 130, headWidth = 70, headName = "developer", tailName = "Haskeller", badgeColor = "#8f4e8b"))
    // [creator|YouTuber]
    writeFile("./output-svg/creator-youtuber.svg", SvgBadgeMaker.generate(width = 115, headWidth = 50, headName = "creator", tailName = "YouTuber", badgeColor = "#ff0000"))
  }
}

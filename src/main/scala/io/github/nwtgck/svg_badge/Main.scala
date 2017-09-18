package io.github.nwtgck.svg_badge

import java.io.{File, PrintWriter}

import scala.xml.Elem

object Main {

  def writeFile(outPath: String, svg: Elem): Unit = {
    val fileWriter = new PrintWriter(new File(outPath))
    fileWriter.println(svg)
    fileWriter.close()
  }

  def main(args: Array[String]): Unit = {

    val svg: Elem = SvgBadgeMaker.generate()

    writeFile("./output-svg/mit-license.svg", SvgBadgeMaker.generate())
    writeFile("./output-svg/out.svg", SvgBadgeMaker.generate(width = 90, headWidth = 40, headName = "build", tailName = "passing", badgeColor = "#6c3"))

  }
}

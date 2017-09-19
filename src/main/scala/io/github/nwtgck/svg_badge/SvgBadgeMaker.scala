package io.github.nwtgck.svg_badge

import scala.xml.Elem

object SvgBadgeMaker {

  /**
    * Generate SVG element considering the length of text
    * @param subjectText
    * @param statusText
    * @param badgeColor
    * @return
    */
  def smartGenerate(subjectText: String, statusText: String, badgeColor: String): Elem = {
    val subjectWidth : Int     = textToWidth(subjectText)
    val width        : Int     = textToWidth(subjectText+statusText)
    generate(width = width, subjectWidth=subjectWidth, subjectText=subjectText, statusText=statusText, badgeColor=badgeColor)
  }

  /**
    * Generate SVG element
    * @param width
    * @param subjectWidth
    * @param subjectText
    * @param statusText
    * @param badgeColor
    * @return
    */
  def generate(width: Int, subjectWidth: Int, subjectText: String, statusText: String, badgeColor: String): Elem = { // TODO Change badgeColor better type

    val height      : Int    = 20
    val statusWidth : Int    = width - subjectWidth
    val subjectX    : Double = subjectWidth.toDouble / 2
    val statusX     : Double = subjectWidth + statusWidth.toDouble / 2

    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width={s"$width"} height={s"$height"}>
      <linearGradient id="b" x2="0" y2="100%">
        <stop offset="0" stop-color="#bbb" stop-opacity=".1" />
        <stop offset="1" stop-opacity=".1" />
      </linearGradient>
      <clipPath id="a">
        <rect width={s"$width"} height={s"$height"} rx="3" fill="#fff" />
      </clipPath>
      <g clip-path="url(#a)">
        <path fill="#555" d={s"M0 0h${subjectWidth}v${height}H0z"} />
        <path fill={badgeColor} d={s"M${subjectWidth} 0h${statusWidth}v${height}H${subjectWidth}z"} />
        <path fill="url(#b)" d={s"M0 0h${width}v${height}H0z"} />
      </g>
      <g fill="#fff" text-anchor="middle" font-family="DejaVu Sans,Verdana,Geneva,sans-serif" font-size="11">
        <text x={s"$subjectX"} y="15" fill="#010101" fill-opacity=".3">{subjectText}</text>
        <text x={s"$subjectX"} y="14">{subjectText}</text>
        <text x={s"$statusX"} y="15" fill="#010101" fill-opacity=".3">{statusText}</text>
        <text x={s"$statusX"} y="14">{statusText}</text>
      </g>
    </svg>
  }

  private def textToWidth(text: String): Int = {
    text.map(e => if(e.isLower) 7 else if(e.isUpper) 10 else 8 ).sum
  }
}

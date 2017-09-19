package io.github.nwtgck.svg_badge

import scala.xml.Elem

object SvgBadgeMaker {
  def generate(width: Int, headWidth: Int, headName: String, tailName: String, badgeColor: String): Elem = { // TODO Change badgeColor better type

    val height    : Int    = 20
    val tailWidth : Int    = width - headWidth
    val headX     : Double = headWidth.toDouble / 2
    val tailX     : Double = headWidth + tailWidth.toDouble / 2

    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width={s"$width"} height={s"$height"}>
      <linearGradient id="b" x2="0" y2="100%">
        <stop offset="0" stop-color="#bbb" stop-opacity=".1" />
        <stop offset="1" stop-opacity=".1" />
      </linearGradient>
      <clipPath id="a">
        <rect width={s"$width"} height={s"$height"} rx="3" fill="#fff" />
      </clipPath>
      <g clip-path="url(#a)">
        <path fill="#555" d={s"M0 0h${headWidth}v${height}H0z"} />
        <path fill={badgeColor} d={s"M${headWidth} 0h${tailWidth}v${height}H${headWidth}z"} />
        <path fill="url(#b)" d={s"M0 0h${width}v${height}H0z"} />
      </g>
      <g fill="#fff" text-anchor="middle" font-family="DejaVu Sans,Verdana,Geneva,sans-serif" font-size="11">
        <text x={s"$headX"} y="15" fill="#010101" fill-opacity=".3">{headName}</text>
        <text x={s"$headX"} y="14">{headName}</text>
        <text x={s"$tailX"} y="15" fill="#010101" fill-opacity=".3">{tailName}</text>
        <text x={s"$tailX"} y="14">{tailName}</text>
      </g>
    </svg>
  }
}

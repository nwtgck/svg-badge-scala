import scala.xml.Elem

object Main {
  def main(args: Array[String]): Unit = {

    val mitSvg: Elem = <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="78" height="20">
      <linearGradient id="b" x2="0" y2="100%">
        <stop offset="0" stop-color="#bbb" stop-opacity=".1" />
        <stop offset="1" stop-opacity=".1" />
      </linearGradient>
      <clipPath id="a">
        <rect width="78" height="20" rx="3" fill="#fff" />
      </clipPath>
      <g clip-path="url(#a)">
        <path fill="#555" d="M0 0h47v20H0z" />
        <path fill="#007ec6" d="M47 0h31v20H47z" />
        <path fill="url(#b)" d="M0 0h78v20H0z" />
      </g>
      <g fill="#fff" text-anchor="start" font-family="DejaVu Sans,Verdana,Geneva,sans-serif" font-size="11">
        <text x="23.5" y="15" fill="#010101" fill-opacity=".3">license</text>
        <text x="23.5" y="14">license</text>
        <text x="61.5" y="15" fill="#010101" fill-opacity=".3">MIT</text>
        <text x="61.5" y="14">MIT</text>
      </g>
    </svg>


    // Print MIT licence SVG
    println(mitSvg)
  }
}

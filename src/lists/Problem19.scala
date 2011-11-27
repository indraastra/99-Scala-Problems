package lists

/**
 * Rotate a list N places to the left.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem19 {

  def rotate[A]( n: Int, l: List[A] ): List[A] = {
    var m = n % l.length
    if (m == 0) l
    else {
      val split_index = if (m > 0) m else (m + l.length)
      val (l1, l2) = Problem17.split( split_index, l )
      l2 ++ l1
    }
  }

  def main( args: Array[String] ): Unit = {
    val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    assert( rotate(3, ls) == List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c) )
    assert( rotate(-2, ls) == List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i) )
    println( "all passed!" )
  }
}

// vim: set ts=4 sw=4 et:

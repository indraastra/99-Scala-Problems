package lists

/**
 * Extract a slice from a list.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem18 {

  def slice1[A]( m: Int, n: Int, l: List[A] ): List[A] = {
    if ( m == 0 && n == 0 ) Nil
    else if ( m == 0 ) ( l.head :: slice1( m, n - 1, l.tail ) )
    else ( slice1( m - 1, n - 1, l.tail ) )
  }

  def slice2[A]( m: Int, n: Int, l: List[A] ): List[A] = (m, n) match {
    case (0, 0) => Nil
    case (0, b) => ( l.head :: slice2( 0, b - 1, l.tail ) )
    case (a, b) => ( slice2( a - 1, b - 1, l.tail ) )
  }

  def main( args: Array[String] ): Unit = {
    val solutions = List( slice1[Symbol] _, slice2[Symbol] _ )
    for ( fn <- solutions ) {
      assert( fn( 3, 7, List( 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k ) ) ==
        List( 'd, 'e, 'f, 'g ) )
      assert( fn( 3, 4, List( 'a, 'b, 'c, 'd ) ) ==
        List( 'd ) )
    }
    println( "all passed!" )
  }
}
// vim: set ts=4 sw=4 et:

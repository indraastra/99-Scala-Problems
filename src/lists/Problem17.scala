package lists

/**
 * Split a list into two parts.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem17 {

  def split[A]( n: Int, l: List[A] ): ( List[A], List[A] ) = {
    l.splitAt( n )
  }

  def main( args: Array[String] ): Unit = {
    assert( split( 3, List( 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k ) ) ==
      ( List( 'a, 'b, 'c ), List( 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k ) ) )
    println( "all passed!" )
  }
}
// vim: set ts=4 sw=4 et:

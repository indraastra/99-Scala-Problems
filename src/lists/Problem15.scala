package lists

/**
 * Duplicate the elements of a list a given number of times.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem15 {

  def duplicateN_1[A]( n: Int, l: List[A] ): List[A] = {
    Problem12.decode( l.map( ( n, _ ) ) )
  }

  def duplicateN_2[A]( n: Int, l: List[A] ): List[A] = {
    l.flatMap { Problem12.repeat( _, n ) }
  }

  def main( args: Array[String] ): Unit = {
    val solutions = List( duplicateN_1[Symbol] _, duplicateN_2[Symbol] _ )
    for ( fn <- solutions ) {
      assert( fn( 3, List( 'a, 'b, 'c, 'c, 'd ) ) ==
        List( 'a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd ) )
    }
    println( "all passed!" )
  }
}

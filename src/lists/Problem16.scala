package lists

/**
 * Drop every Nth element from a list.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem16 {

  def drop1[A]( n: Int, l: List[A] ): List[A] = {
    def _drop( _m: Int, _l: List[A] ): List[A] = _l match {
      case Nil => Nil
      case _head :: _tail => {
        if ( _m == 0 ) _drop( n, _l.tail )
        else _l.head :: _drop( _m - 1, _l.tail )
      }
    }
    _drop( n, l )
  }

  def drop2[A]( n: Int, l: List[A] ): List[A] = {
    l.flatMap { Problem12.repeat( _, n ) }
  }

  def main( args: Array[String] ): Unit = {
    val solutions = List( drop1[Symbol] _ )
    for ( fn <- solutions ) {
      assert( fn( 3, List( 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k ) ) ==
        List( 'a, 'b, 'd, 'e, 'g, 'h, 'j, 'k ) )
    }
    println( "all passed!" )
  }
}
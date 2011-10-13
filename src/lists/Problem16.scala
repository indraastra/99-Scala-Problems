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
        if ( _m <= 1 ) _drop( n, _tail )
        else _head :: _drop( _m - 1, _tail )
      }
    }
    _drop( n, l )
  }

  def drop2[A]( n: Int, l: List[A] ): List[A] = {
    def isSkippable(pair : (A, Int)) : Boolean = ( ( pair._2 + 1 ) % n ) == 0 
    l.zipWithIndex.filterNot( isSkippable ).unzip._1
  }

  def main( args: Array[String] ): Unit = {
    val solutions = List( drop1[Symbol] _, drop2[Symbol] _ )
    for ( fn <- solutions ) {
      assert( fn( 3, List( 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k ) ) ==
        List( 'a, 'b, 'd, 'e, 'g, 'h, 'j, 'k ) )
    }
    println( "all passed!" )
  }
}
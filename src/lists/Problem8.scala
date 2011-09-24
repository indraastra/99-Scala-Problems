package lists

/**
 * Eliminate consecutive duplicates of list elements.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem8 {

  def compress1[A]( l: List[A] ): List[A] = {
    def compressIter[A]( _prev: A, _l: List[A] ): List[A] = _l match {
      case Nil               => _prev :: Nil
      case `_prev` :: _lRest => compressIter( _prev, _lRest )
      case _new :: _lRest    => _prev :: compressIter( _new, _lRest )
    }
    if ( l.length <= 1 ) l
    else compressIter( l.head, l.tail )
  }

  def compress2[A]( l: List[A] ): List[A] = ( l :\ List[A]() ) {
    ( x, xs ) => if ( !xs.isEmpty && x == xs.head ) xs else ( x :: xs )
  }

  def main( args: Array[String] ) {
    // TODO(vtalwar): investigate why compress1 _ is of type (List[Nothing]) => List[Nothing]
    val solutions = List( compress1[Symbol] _, compress2[Symbol] _ )
    for ( fn <- solutions ) {
      assert(
        fn( List( 'a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e ) ) ==
          List( 'a, 'b, 'c, 'a, 'd, 'e ), "uniform list" )
    }
    println( "all passed!" )
  }
}

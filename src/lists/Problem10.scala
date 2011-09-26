package lists

/**
 * Run-length encoding of a list.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem10 {

  def encode1[A]( l: List[A] ): List[( Int, A )] = ( l :\ List[( Int, A )]() ) {
    ( x, xs ) =>
      if ( !xs.isEmpty && x == xs.head._2 ) {
        val pair = xs.head
        ( ( pair._1 + 1 ), pair._2 ) :: xs.tail
      } else {
        ( 1, x ) :: xs
      }
  }

  def encode2[A]( l: List[A] ): List[( Int, A )] = {
    if ( l.isEmpty ) List()
    else {
      val ( same, rest ) = l.span( _ == l.head )
      ( same.length, same.head ) :: encode2( rest )
    }
  }

  def encode3[A]( l: List[A] ): List[( Int, A )] = {
    Problem9.pack( l ).map( s => ( s.length, s.head ) )
  }

  def main( args: Array[String] ): Unit = {
    val solutions = List( encode1[Symbol] _, encode2[Symbol] _, encode3[Symbol] _ )
    for ( fn <- solutions ) {
      assert(
        fn( List( 'a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e ) ) ==
          List( ( 4, 'a ), ( 1, 'b ), ( 2, 'c ), ( 2, 'a ), ( 1, 'd ), ( 4, 'e ) ) )
      println( "all passed!" )
    }
  }
}
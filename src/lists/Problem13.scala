package lists

/**
 * Run-length encoding of a list (direct solution).
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem13 {

  def encodeDirect[A]( l : List[A] ) : List[( Int, A )] = ( l :\ List[( Int, A )]() ) {
    ( x, xs ) ⇒
      if ( !xs.isEmpty && x == xs.head._2 )
        ( xs.head._1 + 1, x ) :: xs.tail
      else
        ( 1, x ) :: xs
  }

  def main( args : Array[String] ) : Unit = {
    assert( encodeDirect( List( 'a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e ) ) ==
      List( ( 4, 'a ), ( 1, 'b ), ( 2, 'c ), ( 2, 'a ), ( 1, 'd ), ( 4, 'e ) ) )
    println( "all passed!" )
  }
}
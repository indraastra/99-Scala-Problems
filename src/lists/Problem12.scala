package lists

/**
 * Decode a run-length encoded list.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem12 {

  def repeat[A]( e : A, n : Int ) : List[A] = {
    if ( n == 0 ) Nil
    else e :: repeat( e, n - 1 )
  }

  def decode[A]( l : List[( Int, A )] ) : List[A] = {
    l.flatMap { pair ⇒ repeat( pair._2, pair._1 ) }
  }

  def main( args : Array[String] ) : Unit = {
    assert(
      decode( List( ( 4, 'a ), ( 1, 'b ), ( 2, 'c ), ( 2, 'a ), ( 1, 'd ), ( 4, 'e ) ) ) ==
        List( 'a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e ) )
    println( "all passed!" )
  }
}
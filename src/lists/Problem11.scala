package lists

import scala.Either

/**
 * Modified run-length encoding.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem11 {

  def encodeModified1[A]( l : List[A] ) : List[Any] = {
    Problem9.pack( l ).map {
      s ⇒
        if ( s.length == 1 ) s.head
        else ( s.length, s.head )
    }
  }

  // This is the type-safe version, not so easy to test generically.
  def encodeModified2[A]( l : List[A] ) : List[Either[A, ( Int, A )]] = {
    Problem9.pack( l ).map {
      s ⇒
        if ( s.length == 1 ) Left( s.head )
        else Right( ( s.length, s.head ) )
    }
  }

  def main( args : Array[String] ) : Unit = {
    assert(
      encodeModified1( List( 'a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e ) ) ==
        List( ( 4, 'a ), 'b, ( 2, 'c ), ( 2, 'a ), 'd, ( 4, 'e ) ) )
    assert(
      encodeModified2( List( 'a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e ) ) ==
        List( Right( ( 4, 'a ) ), Left( 'b ), Right( ( 2, 'c ) ),
          Right( ( 2, 'a ) ), Left( 'd ), Right( ( 4, 'e ) ) ) )
    println( "all passed!" )
  }
}
package lists

/**
 * Find out whether a list is a palindrome.
 *
 * @author rawlatv@gmail.com (Vishal Talwar)
 */
object Problem6 {

  def isPalindrome1[A]( l : List[A] ) : Boolean = {
    val matches = for {
      i <- 0 to (l.length / 2)
      matched = l(i) == l(l.length - i - 1)
    } yield matched
    matches.forall(x => x)
  }

  def isPalindrome2[A]( l : List[A] ) : Boolean = {
    (0 to (l.length / 2)).forall(x => l(x) == l(l.length - x - 1))
  }

  def isPalindrome3[A]( l : List[A] ) : Boolean = {
    lists.Problem5.reverse(l) == l
  }

  def main( args : Array[String] ) {
    val fns = List(isPalindrome1 _, isPalindrome2 _, isPalindrome3 _)
    for (fn <- fns) {
      assert( fn( List( 0 ) ) == true, "integer list" )
      assert( fn( List( 1.1, 2.2 ) ) == false, "float list" )
      assert( fn( List( "foo", "bar", "foo" ) ) == true, "string list" )
    }
    println( "all passed!" )
  }
}

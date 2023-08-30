(ns learn-clojure.basics)

; Primitive data types

"String"

\a \b \newline

; Long
1

; Double
1.3

; Big Integer
10000N

; Big Decimal
12222.3M

; Exponents
2e3
; => 8

; Ratio
2/3

; Numbers are automatically promoted if they overflow

; boolean
true false

; nil means nothing or falsey
nil

; SEQUENCES & COLLECTIONS

; list
()

; lists are evaluated as function calls
(inc 1)

; quote yields the unevaluated form
(quote (1 2))
'(1 2) ; the ' symbols represents quote too
; => (1 2)

; lists and sequences are printed the same way
(seq '(1 2 3))
; => (1 2 3)

; symbols are resolved
inc
; => #object[clojure.core$inc]

; to create an unresolved symbol, just put a single quote before it
foo
;; => Exception: Unable to resolve symbol foo

'foo
;; => foo

; vectors
[ 1 2 3 4]

; Clojure compares by identity and by value. A vector with elements matching a sequence is equal to it.
(= [1 2 3] '(1 2 3))
;; => true

; maps
{"Language" "Clojure"
 "Version" 1.5
 "Author" "Rich Hickey"}

; Keywords are shorthand identifiers that do not need to be declared. Keywords begin with a colon.
:keyword

;; Keywords are often used as keys in hashmaps; similar to fields in an object.
{:language "Clojure"
 :version 1.5
 :author "Rich Hickey"}

;; keywords can be namespaced
:timothy .example/rect

; sets
#{1 2 3}

;; collections can be nested
{[1 2] {:name "diamond" :type :treasure}
 [3 4] {:name "dragon" :type :monster}}
;; this is a map where the keys are vectors and the values are maps

;; define a variable with 'def'
(def x 12)

;; To represent values that changes over time, you can use an atom.
(def a (atom 1)) ;; a is an atom with value 1
(swap! a inc) ;; swap the atom var with inc func
@a ;; @ means 'deref', so deref a to really be (inc 1). Deref means to evaluate.
;; => 2

;; let is similar to def except it exists within a scope
(let [x 1]
  (inc x))
;; => 2
;; within this scope let x = 1

;; Vars can be changed, but you should almost never modify them directly. 
;; Instead Clojure provides local bindings, atoms, refs and agents for managing change.

;; Destructuring aka binding forms
;; Destructuring is providing a literal data structure containing symbols 
;; that get bound to the respective parts of a value with a matching structure.
(let [[x y] [1 2]]
  (+ x y))
;; => 3

;; regex
;; Regular expressions are written as #"pattern"

(re-seq #"\w+" "the quick brown fox")
;; => ("the" "quick" "brown" "fox")

;; types
(type false)
; java.lang.Boolean

; Clojure uses Java's object types for booleans, strings and numbers.
; Use `class` to inspect them.
(class 1) ; Integer literals are java.lang.Long by default

; If you want to create a literal list of data, use ' to stop it from
; being evaluated
'(+ 1 2) ; => (+ 1 2)

; Lists are linked-list data structures, while Vectors are array-backed.
; Vectors and Lists are java classes too!
(class [1 2 3]); => clojure.lang.PersistentVector
(class '(1 2 3)); => clojure.lang.PersistentList


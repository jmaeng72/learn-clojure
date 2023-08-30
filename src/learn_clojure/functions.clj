(ns learn-clojure.functions)

; apply explodes a seqable data structure so it can be passed to a function that expects a rest parameter. 
; For example, max takes any number of arguments and returns the greatest of all the arguments. 
; Here’s how you’d find the greatest number
(max 0 1 2)
; => 2

; But what if you want to find the greatest element of a vector? You can’t just pass the vector to max
(max [0 1 2])

; because max returns the greatest of all the arguments passed to it, and in this case you’re only passing it a vector 
; containing all the numbers you want to compare, rather than passing in the numbers as separate arguments. 
; apply is perfect for this situation
(apply max [0 1 2])
; => 2

; partial takes a function and any number of arguments. It then returns a new function. 
; When you call the returned function, 
; it calls the original function with the original arguments you supplied it along with the new arguments.
(def add10 (partial + 10))
(add10 3)
; => 13

(add10 5)
; => 15

(def add-missing-elements
  (partial conj ["water" "earth" "air"]))

(add-missing-elements "unobtainium" "adamantium")
; => ["water" "earth" "air" "unobtainium" "adamantium"]

; In general, you want to use partials when you find you’re repeating the same combination of function and arguments in many different contexts.

;; anonymous functions
(fn [x]
  (inc x)
  1)
;; => 2

;; you can also use anon funcs using a let form
(let 
 [f (fn [x]
      (inc x))]
  (f 2))
;; => 3

;; you can also create anon func with #
#(inc %) ;; % means parameter of anon func, but it is not as readable


;; anon func
(#(println "Hello" %1 ". How are you" %2) "Jane" "today")

(def increment (fn [x] (+ x 1)))

(defn increment_set
  []
  (map increment [1 2 3]))

(def pet_to_human {:cat 5 :dog 7 :fish 10})

(defn get_human_age
  [pet_age pet_type]
  (* pet_age  (get pet_to_human pet_type)))
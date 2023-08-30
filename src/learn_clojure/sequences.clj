(ns learn-clojure.sequences)

(defn seqx
  []
  (def colors (seq ["red" "green" "blue"]))
  (println colors)                                          ;(red green blue)
  ; cons used to append element to beginning of sequence
  (println (cons "yellow" colors))                          ;(yellow red green blue)
  (println (cons colors "yellow"))                          ;((red green blue) y e l l o w) -- yellow is broken up into sequence of individual chars
  ; conj -- keeps structure and appends elem to structure
  (println (conj colors "yellow"))                          ; (yellow red green blue)
  (println (conj ["red" "green" "blue"] "yellow"))          ; [red green blue yellow]
  (println (concat colors (seq ["black" "white"])))         ; (red green blue black white)
  (println (distinct (seq [1 2 3 1 2 3])))                  ; (1 2 3)
  (println (reverse colors))                                ; (blue green red)
  (println (first colors))                                  ; red
  (println (rest colors))                                   ; (green blue)
  (println (last colors))                                   ; blue
  (println (sort colors)))                                   ; (blue green red)



(defn titleize
  [topic]
  (str topic " forever!"))

(comment
  "map is a function that call a function to every element in a sequence")

(map titleize ["Hamsters" "Ragnarok"])
; => ("Hamsters forever!" "Ragnarok forever!")

(map titleize '("Girls" "Books"))
; => ("Girls forever!" "Books forever!")

(map titleize #{"Sets" "Blanks"})
; => ("Sets forever!" "Blanks forever!")

(map #(titleize (second %)) {:uncomfortable-thing "Winking"})
; => ("Winking forever!")

;; sequence

(seq '(1 2 3))
; => (1 2 3)

(seq #{1 2 3})
; => (1 2 3)

; seq always returns a vlue that looks and behaves like a list

; turn seq back into map
(into {} (seq {:a 1 :b 2 :c 3}))
; => {:a 1, :c 3, :b 2}

; map can also take in multiple collections as arguments and collections of functions too

(map str ["a" "b" "c"] ["A" "B" "C"])
; => ("aA" "bB" "cC")

(list (str "a" "A") (str "b" "B") (str "c" "C"))


(def human-consumption   [8.1 7.3 6.6 5.0])
(def critter-consumption [0.0 0.2 0.3 1.1])
(defn unify-diet-data
  [human critter]
  {:human human
   :critter critter})

(map unify-diet-data human-consumption critter-consumption)
; => ({:human 8.1, :critter 0.0}
; {:human 7.3, :critter 0.2}
; {:human 6.6, :critter 0.3}
; {:human 5.0, :critter 1.1})

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

; reduce processes each element in sequence rolling them up to build a singular result, whilst a map processes each element in sequence to create new elements in a sequence
; (reduce f coll) or (reduce f val coll)

; reduce can be used to transform a map’s values, producing a new map with the same keys but with updated values
(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10}) ; treats the argument {:max 30 :min 10} as a sequence of vectors, like ([:max 30] [:min 10])
; => {:max 31, :min 11}

; assoc [map key val] => derives a new map from given map by associating the given key with the given value

; maps, lists, vectors, they are all treated like sequences so a map to clojure is just a vector of pairs -- that is why they can be matched up and used in the same types of funcs

; reduce can also be used to filter out keys from a map based on their value

(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:human 4.1
         :critter 3.9})
; => {:human 4.1}

; Whenever you want to derive a new value from a seqable data structure, reduce will usually be able to do what you need


; take, drop
; (take number sequence) => return first n elems in sequence
; (drop number sequence) => returns returns sequence with first n elements removed

(take 3 [1 2 3 4 5 6 7 8 9 10])
; => (1 2 3)

(drop 3 [1 2 3 4 5 6 7 8 9 10])
; => (4 5 6 7 8 9 10)

;take-while and drop-while
; takes a predicate function (funcs whose return vals are truthy or falsity) to determine when to stop taking or dropping in the sequence and will not go further

(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(take-while #(< (:month %) 3) food-journal)
; take while the month value < 3 is true
; => ({:month 1 :day 1 :human 5.3 :critter 2.3}
; {:month 1 :day 2 :human 5.1 :critter 2.0}
; {:month 2 :day 1 :human 4.9 :critter 2.1}
; {:month 2 :day 2 :human 5.0 :critter 2.5})

; if the list was out of order, it would return up to the first element where the month < 3 and no further

(drop-while #(< (:month %) 3) food-journal)
; drop while the month value < 3 is true
; => ({:month 3 :day 1 :human 4.2 :critter 3.3}
; {:month 3 :day 2 :human 4.0 :critter 3.8}
; {:month 4 :day 1 :human 3.7 :critter 3.9}
; {:month 4 :day 2 :human 3.7 :critter 3.6})


; filter and some
; Use filter to return all elements of a sequence that test true for a predicate function.

(filter #(< (:human %) 5) food-journal)
; => ({:month 2 :day 1 :human 4.9 :critter 2.1}
; {:month 3 :day 1 :human 4.2 :critter 3.3}
; {:month 3 :day 2 :human 4.0 :critter 3.8}
; {:month 4 :day 1 :human 3.7 :critter 3.9}
; {:month 4 :day 2 :human 3.7 :critter 3.6})

; difference between filter and take-while
; take-while can be more efficient in this example, because the list is ORDERED and it will return data we want without
; examining any of the data we won't need. Because it is essentially a while loop. filter processes all the data before returning.

; some function, takes in a predicate func and returns a value
; used to determine if any elem in sequence is true for the following function
(some #(> (:critter %) 5) food-journal)
; => nil

(some #(> (:critter %) 3) food-journal)
; => true

(some #(and (> (:critter %) 3) %) food-journal)
; => {:month 3 :day 1 :human 4.2 :critter 3.3}

; sort and sort-by

; sort in asc order
(sort [3 1 2])
; => (1 2 3)

; sort-by is more complicated sorting. a
; allows you to apply a function (sometimes called a key function) to the elements of a sequence and use the values it returns to determine the sort order.
(sort-by count ["aaa" "c" "bb"])
; => ("c" "bb" "aaa")

; concat: appends members of one sequence to the end of another
(concat [1 2] [3 4])
; => (1 2 3 4)

; many funcs, like map and filter, return lazy sequences to save time (not actually implementing the func action until it has to)

; infinite sequences
(concat (take 8 (repeat "na")) ["Batman!"])
; => ("na" "na" "na" "na" "na" "na" "na" "na" "Batman!")

(take 3 (repeatedly (fn [] (rand-int 10))))
; => (1 4 0)

(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

(take 10 (even-numbers))
; => (0 2 4 6 8 10 12 14 16 18)
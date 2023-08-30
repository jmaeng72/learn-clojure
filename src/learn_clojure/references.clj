(ns learn-clojure.references)

; references encapsulate data that we can change, but they are coordinated changes
; we can affect changes in these datatypes under certain conditions

; transactions - set of operations we perform on datatype where all operations succeed or none do

(defn refs
  []
  (def amount (ref 100))
  (println @amount)
  ; update amount ref in one transaction
  ; dosync starts transaction
  (dosync
    (ref-set amount 110)
    (println @amount)) ; 110

  (dosync
    (alter amount inc) ; 111
    (println @amount)))




(refs)
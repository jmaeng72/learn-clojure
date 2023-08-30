(ns learn-clojure.destructuring)

; how extract info from existing data structs

(defn destruct
  []
  (def myVect [1 2 3 4])

  ; extract elements to vars
  (let [[a b c] myVect] (println a b c))                    ; 1 2 3

  ; get two vars and the rest as a list
  (let [[a b & rest] myVect] (println a b rest))            ; 1 2 (3 4)

  (def myMap {'name "Jane" 'lastname "Lee"})

  (let [{a 'name b 'lastname} myMap] (println a b))         ; Jane Lee

  (let [{a 'name b 'lastname c 'doesnotexist} myMap] (println a b c)) ; Jane Lee nil
  )

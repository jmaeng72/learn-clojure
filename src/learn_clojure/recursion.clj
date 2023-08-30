(ns learn-clojure.recursion)

;; recursive sum func
(defn rec-sum
  ([vals]
   (rec-sum vals 0))
  ([vals accumulated-sum]
   (if (empty? vals)
     accumulated-sum
     (rec-sum (rest vals) (+ (first vals) accumulated-sum)))))


(println (rec-sum [1 2 3 4]))
;; => 10

(println "-------")
(println (rec-sum [1 2 3 4] 10))
;; => 20

;; you'll want to use recur instead though in general, because regular recursion takes a lot of memory space
(defn sum
  ([vals]
   (sum vals 0))
  ([vals accumulating-total]
   (if (empty? vals)
     accumulating-total
     (recur (rest vals) (+ (first vals) accumulating-total)))))



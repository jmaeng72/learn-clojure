(ns learn-clojure.loops)

(defn loopx
  []
  (println "\nloopx:")
  (loop [x 0]
    (when (< x 10)
      (println x)
      (recur (inc x)))))


(loopx)

(defn dotimesx
  []
  (println "\ndotimesx:")
  (dotimes [x 10]
           (println x)))


(dotimesx)

(defn whiledox
  [count]
  (println "\nwhiledox")
  (def x (atom 0))
  (while (< @x count)
    (do
      (println @x)
      (swap! x inc))))


(whiledox 10)

(defn doseqx
  [seq]
  (println "doseqx")
  (doseq [x seq]
    (println (inc x))))



(doseqx [1 2 3 4 5])
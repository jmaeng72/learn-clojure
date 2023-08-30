(ns learn-clojure.conditionals)

(defn condif
  []
  (println "\nCondif:")
  (if (= 5 5)
    (println "equals")
    (println "not equal")))


(defn condifdo
  []
  (println "Condifdo:")
  (if (= 5 5)
    (do (println "Equal first statement")
        (println "Equal second statement"))
    (do (println "Not equal first statement")
        (println "second statement"))
    ))

(defn condcond
  [amount]
  (cond
    (< amount 0) (println "this is negative amt -- not allowed")
    (< amount 100) (println "this is less than 100")
    (< amount 200) (println "this is less than 200")
    :else (println "could not match with anything")))

(condcond 150)
(ns learn-clojure.exceptions)

(defn exceptionx
  [x]
  (try
    (inc x)
    (catch ClassCastException e (println "caught class cast exception:" (.getMessage e)))
    (catch Exception e (println "caught generic exception:" (.getMessage e)))
    (finally (println "cleanup and move on"))
    )
  )

(exceptionx "hello")
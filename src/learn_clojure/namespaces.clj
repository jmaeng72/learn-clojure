(ns learn-clojure.namespaces
  (:require [clojure.string :refer [capitalize]]))

(defn -main
  []
  ;(println (clojure.string/capitalize "hello"))) ; (:require [clojure.string])
  (println (capitalize "hello")))

(-main)


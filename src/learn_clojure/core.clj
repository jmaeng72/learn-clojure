(ns learn-clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot!")
  
  (if false
    "was true"
    "was false")
  
  (if true
    (do (println "this was true") 
        "this was a do statement")) 
  
  (defn test
    [& input]
    (println "hiiii"))
  
  (test "a" "b" "c")
)



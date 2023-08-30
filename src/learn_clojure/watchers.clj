(ns learn-clojure.watchers)

; watchers allow us to attach functions to datatypes
(defn watch
  []
  (def x (atom 5))
  ; we can watch for state changes
  (add-watch x :x_watcher
             (fn [key atom old_state new_state]
               (println "key:" key)
               (println "atom:" atom)
               (println "old state: " old_state)
               (println "new state: " new_state)))
  (reset! x 10)
  (remove-watch x :x_watcher)
  (reset! x 15))

(watch)
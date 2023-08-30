(ns learn-clojure.training)

(def message "greetings")

(println message)

(let 
 [message "well hello there"] 
  (println message))

(println message)

(def m {
        :greeting "good morning"
        :tone "happy"})

;; this doesn't work because of error
;; (let [[greeting tone] m]
;;   (prn greeting tone))

;; this is the right way to do it... why?
;; :keys is a special keyword that takes keys of a map and maps its values to the variable names
(let [{:keys [greeting tone]} m]
  (prn greeting tone))
;; => "good morning" "happy"

(defn hi [{:keys [greeting tone]}]
  (str greeting " - " tone))

(hi m)
;; => "good morning - happy"

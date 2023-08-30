(ns learn-clojure.agents)

; agents can be used to update a value
; they are similar to atoms, but atoms allow us to change their data in synchronous way, agents allow the change asynchronously

(defn agentsx
  []
  (def amount (agent 100))
  (println @amount)
  (send amount inc) ; will inc 100 > 101, but because it's asynchronous, the system did not wait long enough to get that change
  (println @amount) ; which is why this still prints 100
  (println "some time must pass")
  (println @amount) ; now this is 101

  (send amount inc)
  (await-for 1000 amount) ; wait for 1 sec
  (println @amount); now this is 102
  (println (agent-error amount))

  (println "end of func"))


(agentsx)



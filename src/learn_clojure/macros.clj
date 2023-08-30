(ns learn-clojure.macros)

; will expand macro and show the true underlying expression that the code runs
(macroexpand-1 '(when true (println "hello")))
; => (if true (do (println "hello")))


(ns learn-clojure.collections)

; All of Clojure’s core data structures—vectors, maps, lists, and sets—take part in both abstractions.
; The sequence abstraction is about operating on members individually, whereas the collection abstraction is about the data structure as a whole. 

; into
(map identity {:sunlight-reaction "Glitter!"})
; => ([:sunlight-reaction "Glitter!"])

(into {} (map identity {:sunlight-reaction "Glitter!"}))
; => {:sunlight-reaction "Glitter!"}

; argument for into doesn't always have to be empty. When it isn't, it becomes a transformatin and concat
(into {:favorite-emotion "gloomy"} [[:sunlight-reaction "Glitter!"]])
; => {:favorite-emotion "gloomy" :sunlight-reaction "Glitter!"}

(into ["cherry"] '("pine" "spruce"))
; => ["cherry" "pine" "spruce"]

; conj also adds elements to a collection, but differently than into, because its arguments are added directly, not combined
(conj [0] [1])
; => [0 [1]]

(into [0] [1])
; => [0 1]

(conj [0] 1)
; => [0 1]


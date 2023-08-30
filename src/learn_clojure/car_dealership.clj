(ns learn-clojure.car-dealership)

(defstruct car :model :price)
(def bmw (struct-map car :model "BMW" :price 60000))
(def ferrari (struct-map car :model "FERRARI" :price 100000))
(def fiat (struct-map car :model "FIAT" :price 20000))
(def cars [bmw ferrari fiat])

(def budget 50000)

(defn coupon-validity
  [budget-code]

  (if (= budget-code "20OFF")
    (do
      (println "coupon is valid")
      (doseq [c cars]
        ;(println "current car" c)
        (let [{price :price model :model} c]
          (do
            (def discounted-price (- price (* 0.20 price)))
            (if (< discounted-price budget)
              (println model " : " discounted-price)
              )
            )
          )
        )
      )
    ; else
    (do
      (println "coupon is not valid")
      (doseq [c cars]
        (let [{price :price model :model} c]
          (do
            (if (< price budget)
              (println model ":" price)
              )
            )
          )
        )
      )
    )
  )

(coupon-validity "20OFF")
(coupon-validity "INVALIDCOUPON")
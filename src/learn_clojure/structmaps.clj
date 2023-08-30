(ns learn-clojure.structmaps
  (:import (clojure.lang IPersistentList)))

; structmaps, like all clojure datatypes, are immutable

(defn Pets
  []
  ; create a struct of what 'pet' is
  (defstruct pet :PetType :PetName)
  ; create a new struct map with key and value
  (def myPet (struct pet "dog" "Bones"))
  (println myPet)                                           ; {:PetType dog, :PetName Bones}

  ; another way to create a struct map with key and value
  (def otherPet (struct-map pet :PetType "cat" :PetName "Solar")) ;
  (println otherPet)                                        ; {:PetType cat, :PetName Solar}

  ;
  (println (:PetType myPet))                                ; dog
  (println (:PetName otherPet))                             ; Solar

  (def newPet (assoc myPet :PetName "Rosie"))
  (println newPet)                                          ; {:PetType dog, :PetName Rosie}

  ; adding new key to create new map from existing map
  (def newOtherPet (assoc otherPet :PetAge 10))
  (println newOtherPet)                                     ;{:PetType cat, :PetName Solar, :PetAge 10}
  )

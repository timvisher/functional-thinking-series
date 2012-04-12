;; def product = { x, y -> return x * y }

;; def quadrate = product.curry(4)
;; def octate = product.curry(8) 

;; println "4x4: ${quadrate.call(4)}"
;; println "5x8: ${octate(5)}"

(ns product-currying.core)

(def quadrate (partial * 4))

(def octate (partial * 8))

;; def volume = { h, w, l -> return h * w * l }
;; def area = volume.curry(1)
;; def lengthPA = volume.curry(1, 1) //partial application
;; def lengthC = volume.curry(1).curry(1) // currying

;; println "The volume of the 2x3x4 rectangular solid is ${volume(2, 3, 4)}"
;; println "The area of the 3x4 rectangle is ${area(3, 4)}"
;; println "The length of the 6 line is ${lengthPA(6)}"
;; println "The length of the 6 line via curried function is ${lengthC(6)}"
(defn volume [h w l]
  (* h w l))

(def area (partial volume 1))

(def length-full-partial (partial volume 1 1))
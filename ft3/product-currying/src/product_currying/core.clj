;; def product = { x, y -> return x * y }

;; def quadrate = product.curry(4)
;; def octate = product.curry(8) 

;; println "4x4: ${quadrate.call(4)}"
;; println "5x8: ${octate(5)}"

(ns product-currying.core)

(def quadrate (partial * 4))

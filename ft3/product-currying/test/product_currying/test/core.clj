(ns product-currying.test.core
  (:use [product-currying.core])
  (:use [clojure.test]))

(deftest product-of-3-and-4-is-12
  (is (= 12 (quadrate 3))))

(deftest product-of-3-and-8-is-24
  (is (= 24 (octate 3))))

(deftest volume-of-rectange-2-by-3-by-4-is-24
  (is (= 24 (volume 2 3 4))))

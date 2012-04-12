(ns product-currying.test.core
  (:use [product-currying.core])
  (:use [clojure.test]))

(deftest product-of-3-and-4-is-12
  (is (= 12 (quadrate 3))))

(deftest product-of-3-and-8-is-24
  (is (= 24 (octate 3))))

(deftest volume-of-rectange-2-by-3-by-4-is-24
  (is (= 24 (volume 2 3 4))))

(deftest area-of-3-by-4-rectangle-is-12
  (is (= 12 (area 3 4))))

(deftest the-length-of-the-6-line-by-full-partial-is-6
  (is (= 6 (length-full-partial 6))))

(deftest the-length-of-the-6-line-by-double-partial-is-6
  (is (= 6 (length-double-partial 6))))

(deftest product-of-2-and-32-is-64
  (is (= 64 (thirty-twoer 2))))

(deftest increment-of-7-is-8
  (is (= 8 (increment 7))))

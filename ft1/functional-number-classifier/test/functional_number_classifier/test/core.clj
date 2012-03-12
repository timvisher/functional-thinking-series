(ns functional-number-classifier.test.core
  (:use [functional-number-classifier.core])
  (:use [clojure.test]))

(deftest six-is-perfect-number
  (is (= :perfect (classify 6))))

(deftest two-is-a-deficient-number
  (is (= :deficient (classify 2))))

(deftest twelve-is-an-abundant-number
  (is (= :abundant (classify 12))))

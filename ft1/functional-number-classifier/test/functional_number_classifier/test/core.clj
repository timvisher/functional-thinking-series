(ns functional-number-classifier.test.core
  (:use [functional-number-classifier.core])
  (:use [clojure.test]))

(deftest six-is-perfect-number
  (is (= :perfect (classify 6))))

(deftest two-is-a-deficient-number
  (is (= :deficient (classify 2))))

(deftest twelve-is-an-abundant-number
  (is (= :abundant (classify 12))))

(deftest factors-for-six-correct
  (is (= [1 2 3 6] (factors 6))))

(deftest twenty-eight-is-a-perfect-number
  (is (= :perfect (classify 28))))

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

(deftest factors-less-than-six-correct
  (is (= [1 2 3] (proper-factors 6))))

(deftest twenty-eight-is-a-perfect-number
  (is (= :perfect (classify 28))))

(deftest twenty-eight-is-an-optimized-perfect-number
  (is (= :perfect (classify aliquot-sum-optimized 28))))

(deftest aliquot-sum-for-six-is-six
  (is (= 6 (aliquot-sum 6))))

(deftest aliquot-sum-for-ten-is-eight
  (is (= 8 (aliquot-sum 10))))

(deftest aliquot-sum-for-twenty-for-is-thirty-six
  (is (= 36 (aliquot-sum 24))))

(deftest can-explicitly-pass-factor-sum-function
  (is (= :abundant (classify aliquot-sum 12))))

(deftest optimized-aliquot-sum-for-twelve-is-sixteen
  (is (= 16 (aliquot-sum-optimized 12))))

(deftest classifying-twelve-by-optimized-aliquote-sum-returns-abundant
  (is (= :abundant (classify aliquot-sum-optimized 12))))

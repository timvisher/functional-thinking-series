;; package com.nealford.conf.ft.numberclassifier

;; object NumberClassifier {

;;   def isFactor(number: Int, potentialFactor: Int) =
;;     number % potentialFactor == 0

;;   def factors(number: Int) =
;;     (1 to number) filter (number % _ == 0)

;;   def sum(factors: Seq[Int]) =
;;     factors.foldLeft(0)(_ + _)

;;   def isPerfect(number: Int) =
;;     sum(factors(number)) - number == number

;;   def isAbundant(number: Int) =
;;     sum(factors(number)) - number > number

;;   def isDeficient(number: Int) =
;;     sum(factors(number)) - number < number
;; }

(ns functional-number-classifier.core)

(defn factors [number]
  (filter #(integer? (/ number %)) (range 1 (+ 1 number))))

(defn proper-factors [number]
  (filter (partial > number) (factors number)))

(defn aliquot-sum [number]
  (reduce + (proper-factors number)))

(defn aliquot-sum-optimized [number]
  (let [factors-of-square-root(factors (+ 1 (Math/round (Math/sqrt number))))
        symmetrical-factors (map (partial / number) factors-of-square-root)
        proper-factors (filter (partial > number) (into factors-of-square-root symmetrical-factors))]
    (reduce + proper-factors)))

(defn classify-using [factor-sum-function number]
  (cond (= (factor-sum-function number) number) :perfect
        (< (factor-sum-function number) number) :deficient
        :default :abundant))

(defn classify
  ([number] (classify-using aliquot-sum number))
  ([factor-sum-function number] (classify-using factor-sum-function number)))

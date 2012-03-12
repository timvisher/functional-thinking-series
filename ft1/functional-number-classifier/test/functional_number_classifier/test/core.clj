(ns functional-number-classifier.test.core
  (:use [functional-number-classifier.core])
  (:use [clojure.test]))

(deftest six-is-perfect-number
  (is (= :perfect (classify 6))))

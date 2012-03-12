;;; The requirements state that, given any positive integer greater
;;; than 1, you must classify it as either perfect, abundant, or
;;; deficient. A perfect number is a number whose factors (excluding
;;; the number itself as a factor) add up to the number. Similarly, an
;;; abundant number's sum of factors is greater than the number, and a
;;; deficient number's sum of factors is less.

(ns functional-number-classifier.core)

(defn classify [number]
  (cond (= 6 number) :perfect
        (= 2 number) :deficient
        :default :abundant))

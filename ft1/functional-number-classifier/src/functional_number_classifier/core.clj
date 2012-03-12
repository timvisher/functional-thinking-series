;;; The requirements state that, given any positive integer greater
;;; than 1, you must classify it as either perfect, abundant, or
;;; deficient. A perfect number is a number whose factors (excluding
;;; the number itself as a factor) add up to the number. Similarly, an
;;; abundant number's sum of factors is greater than the number, and a
;;; deficient number's sum of factors is less.

(ns functional-number-classifier.core)

(defn factors [number]
  (filter #(integer? (/ number %)) (range 1 (+ 1 number))))

(defn factors-less-than-number [number]
  (filter (partial > number) (factors number)))

(defn classify [number]
  (cond (= (reduce + (factors-less-than-number number)) number) :perfect
        (< (reduce + (factors-less-than-number number)) number) :deficient
        :default :abundant))

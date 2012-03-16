;;; The requirements state that, given any positive integer greater
;;; than 1, you must classify it as either perfect, abundant, or
;;; deficient. A perfect number is a number whose factors (excluding
;;; the number itself as a factor) add up to the number. Similarly, an
;;; abundant number's sum of factors is greater than the number, and a
;;; deficient number's sum of factors is less.

(ns functional-number-classifier.core)

(defn factors [number]
  (filter #(integer? (/ number %)) (range 1 (+ 1 number))))

(defn proper-factors [number]
  (filter (partial > number) (factors number)))

(defn aliquot-sum [number]
  (reduce + (proper-factors number)))

(defn classify [number]
  (cond (= (aliquot-sum number) number) :perfect
        (< (aliquot-sum number) number) :deficient
        :default :abundant))

(comment
  (time (classify 30))                  ;"Elapsed time: 0.734451 msecs"
  (time (classify 3000))                ;"Elapsed time: 7.135265 msecs"
  (time (classify 300000))              ;"Elapsed time: 276.859209 msecs"
  )

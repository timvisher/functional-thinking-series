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

(defn aliquot-sum-optimized [number]
  (let [factors-of-square-root (filter (partial #(= 0 (rem %1 %2)) number) (range 1 (+ 1 (Math/round (Math/sqrt number)))))
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

(comment
  (time (classify 30))                                        ;"Elapsed time: 0.734451 msecs"
  (time (classify 3000))                                      ;"Elapsed time: 7.135265 msecs"
  (time (classify 300000))                                    ;"Elapsed time: 276.859209 msecs"
  (time (classify aliquot-sum-optimized 30))                  ;"Elapsed time: 0.225448 msecs"
  (time (classify aliquot-sum-optimized 3000))                ;"Elapsed time: 1.435098 msecs"
  (time (classify aliquot-sum-optimized 300000))              ;"Elapsed time: 1.212165 msecs"
  )

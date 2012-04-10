;;; http://www.ibm.com/developerworks/java/library/j-ft3/index.html
(ns functional-number-classifier.core)

(defn factor? [number potential-factor]
  (integer? (/ number potential-factor)))

(defn factors [number]
  (filter (partial factor? number) (range 1 (+ 1 number))))

(defn aliquot-sum [number]
  (let [factors-of-square-root (filter (partial factor? number) (range 1 (+ 1 (Math/round (Math/sqrt number)))))
        symmetrical-factors (map (partial / number) factors-of-square-root)
        proper-factors (filter (partial > number) (distinct (into factors-of-square-root symmetrical-factors)))]
    (reduce + proper-factors)))

(defn classify-using [factor-sum-function number]
  (cond (= (factor-sum-function number) number) :perfect
        (< (factor-sum-function number) number) :deficient
        :default :abundant))

(defn classify
  ([number] (classify-using aliquot-sum number))
  ([factor-sum-function number] (classify-using factor-sum-function number)))

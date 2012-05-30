(ns beans.test.functional
  (:require [clojure.test :refer :all]
            [beans.core :refer :all]))

(def test-map (address "hypercritical" [{:number 55 :name "by"}] "podcast" "dot" "com"))

(deftest it-supports-key-lookup
  (is (= "hypercritical" (:name test-map)))
  (is (= 55 ((comp :number first :streets) test-map))))

(deftest it-supports-deriving-new-a-new-value
  (is (= "the talk show" (:name (assoc test-map :name "the talk show"))))
  ;; And yet it should not modify the original entry
  (is (= "hypercritical (:name test-map")))

(deftest it-is-a-plain-map
  (is (instance? java.util.Map test-map)))

;;; And now I can redefine a field to be a computation:

(def lookup {"hypercritical" "john siracusa" "the talk show" "john gruber"})

(with-redefs [address #(let [a {:name (get lookup %1)
                                :streets %2
                                :city %3
                                :state %4
                                :zip %5}]
                         a)]
  (let [redef-test-map (apply address (vals test-map))]
   (deftest it-can-redefine-storage-and-computation
     (is (= "john siracusa" (:name redef-test-map)))
     (is (= "john siracusa" (:name (assoc test-map :name (get lookup "hypercritical"))))))))

(deftest it-can-do-tricky-things-like-named-paramaters
  (is (= "hypercritical" (:name (named-address :streets [{:number 55 :name "by"}]
                                               :name "hypercritical"
                                               :city "podcast"
                                               :zip "com"
                                               :state "dot")))))

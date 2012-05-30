(ns beans.test.hash-map
  (:require [clojure.test :refer :all]
            [beans.core :refer :all]))

(def test-map {:name "hypercritical" :address {:number 55 :street "by" :city "podcast"}})

(deftest it-supports-key-lookup
  (is (= "hypercritical" (:name test-map)))
  (is (= 55 ((comp :number :address) test-map))))

(deftest it-supports-deriving-new-a-new-value
  (is (= "the talk show" (:name (assoc test-map :name "the talk show"))))
  ;; And yet it should not modify the original entry
  (is (= "hypercritical (:name test-map")))

(deftest it-is-a-plain-map
  (is (instance? java.util.Map test-map)))

;;; But I can't redefine it's data members centrally. For instance, if
;;; name should now be a key lookup of some kind, I can't redefine
;;; that for everyone, because everyone is constructing their own.

(def lookup {"hypercritical" "john siracusa" "the talk show" "john gruber"})

(deftest unable-to-redefine-storage-and-computation
  (is (= "hypercritical" (:name test-map)))
  (is (= "john siracusa" (:name (assoc test-map :name (get lookup "hypercritical"))))))
